
var cookie = null;
var cookieName = "ssid";
$(function () {
	readCookie();
	if(cookie == null) {
		cookie = generateRandomString();
		setCookie(cookie);
	}
	console.log(cookie);
});

function readCookie () {
	var cookies = document.cookie;
	if(cookies != "" && cookies != null) {
		cookie = cookies.split("=")[1];
	}
}

function generateRandomString () {
	var randomString = "";
	for(var i=0; i<5; i++) {
		randomString += Math.random().toString(36).substr(2);
	}
	return randomString;
}

function setCookie (c) {
	document.cookie = cookieName + "=" + c + ";";
}

var seats = {};
var hall = {};

function drawCinemaHall (hallData) {
	getSeatData(hallData);
	createCinemaScreen();
	createSeats();
	adjustToScreen();
	makeCinemaHallVisible();
	updatePriceBox();
}

function getSeatData (hallData) {
	hall = { width: hallData.width, length: hallData.length };
	for(var i in hallData.seats) {
		var seat = hallData.seats[i];
		seats[seat.id] = {
			isOccupied: seat.occupied,
			isBlocked: seat.blocked,
			x: seat.x,
			y: seat.y,
			category: seat.category.category,
			row: seat.row,
			number: seat.number,
			defaultPrice: seat.price.defaultPrice / 100,
			reducedPrice: seat.price.reducedPrice / 100
		};
	}
}

function createCinemaScreen () {
	var screen = "<div class='screen bg-dark'>Leinwand</div>";
	$('#cinemaHall').append(screen);
}

function createSeats () {
	var template = "<div id='{seatID}' class='seat {classes}' style='left: {posx}%; top: {posy}%;' data-toggle='tooltip' data-placement='top' title='{tooltip}' category='{category}' row='{row}' number='{number}'></div>";
	
	for(var id in seats) {
		var cur = template;
		cur = cur.replace("{seatID}", id);
		cur = cur.replace("{classes}", (seats[id].isOccupied || seats[id].isBlocked ? "occupied" : "available"));
		cur = cur.replace("{posx}", (100 * seats[id].x) / (hall.width + 20));
		cur = cur.replace("{posy}", (100 * seats[id].y) / (hall.length + 20));
		cur = cur.replace("{tooltip}", "Reihe: " + seats[id].row + ", Platz: " + seats[id].number + " (" + seats[id].category + ")\n" + showPrice(seats[id].defaultPrice) + " € (ermäßigt: " + showPrice(seats[id].reducedPrice) + " €)");
		cur = cur.replace("{category}",seats[id].category);
		cur = cur.replace("{row}",seats[id].row);
		cur = cur.replace("{number}",seats[id].number);
		$('#cinemaHall').append(cur);
	}
	
	$(function () {
		$('.seat').on('click', function () {
			if($(this).hasClass("available")) {
				var seatId = $(this).attr("id");
				if($(this).hasClass("selected")) {
					removeSeatFromSelection(seatId, this);
				}
				else {
					addSeatToSelection(seatId, this);
				}
			}
		});
		
		$('.seat').mouseenter(function () {
			if($(this).hasClass("available")) {
				$(this).addClass("hovering");
				$('.seat').mouseleave(function () {
					$(this).removeClass("hovering");
				});
			}
		});
	});
}

function adjustToScreen() {
	maxDivWidth = $("div.container").width();
	maxDivHeight = Math.max(300, Math.min($(window).height() - $("main").offset().top, window.screen.height * 2 / 3));

	var divWidth = maxDivWidth;
	var divHeight = (hall.length * divWidth) / hall.width;
	if(divHeight > maxDivHeight) {
		divHeight = maxDivHeight;
		divWidth = (hall.width * divHeight) / hall.length;
	}
	
	var seatSize = (20 * divWidth) / hall.width;
	
	$("#cinemaHall").width(divWidth+"px");
	$("#cinemaHall").height(divHeight+"px");
	$(".seat").width(seatSize+"px");
	$(".seat").height(seatSize+"px");
	
	// additional hardcoded settings for some seats
	$("#351").width(seatSize*2+"px");
	$("#352").width(seatSize*2+"px");
}

function makeCinemaHallVisible() {
	$("#cinemaHall").css("display","block");
	$(".price-box").css("display","block");
}

$(window).on('resize', () => {
	adjustToScreen();
});

/* Selection + price calculation */
var selection = {};
var numberOfTickets = { pn: 0, pe: 0, ln: 0, le: 0,
                        p: 0, l: 0};
function addSeatToSelection (seatId, seatObj) {
	// prepare data for ajax
	var block = {show: {id: urlparameters.get("id")},
				 seat: {id: seatId},
				 sessiontoken: cookie};
	
	// send ajax
	var data = "block=" + JSON.stringify(block);
	$.ajax({
	  type: "POST",
	  url: "http://localhost:8080/cinema-data/reservation/block",
	  data: data,
	  contentType: "application/json; charset=utf-8",
	  success: (data) => processBlockingResult(data, seatId, seatObj),
	  error: function (xhr,status,error){
		console.log(xhr, status, error);
		processBlockingResult(null, seatId, seatObj);
	  }
	});
}

function processBlockingResult (data, seatId, seatObj) {
	if(data != null) {
		var seatIdResponse = data.seat.id;
		$(seatObj).addClass("selected");
		selection[seatIdResponse] = true;
		numberOfTickets[getCategoryOfSeat(seatIdResponse)] += 1;
		updatePriceBox();
	} else {
		console.log(seats);
		console.log(seatId);
		seats[seatId].isBlocked = true;
		$(seatObj).removeClass("available hovering");
		$(seatObj).addClass("occupied");
	}
}

function removeSeatFromSelection (seatId, seatObj) {
	// TODO: inform backend to remove blocking
	$(seatObj).removeClass("selected");
	delete selection[seatId];
	numberOfTickets[getCategoryOfSeat(seatId)] -= 1;
	updatePriceBox();
}

function getCategoryOfSeat (seatId) {
	switch(seats[seatId].category) {
		case "Parkett":
			return "p";
		case "Loge":
			return "l";
	}
}

function updatePriceBox () {
	// checks and calculations
	var categories = ["pn","pe","ln","le"];
	for(var i=0;i<categories.length;i++) {
		c = categories[i];
		numberOfTickets[c] = Math.max(0, Math.min(numberOfTickets[c], numberOfTickets[c.charAt(0)]));
	}
	numberOfTickets["pn"] = numberOfTickets["p"] - numberOfTickets["pe"];
	numberOfTickets["ln"] = numberOfTickets["l"] - numberOfTickets["le"];
	
	var price = 0;
	var temp = jQuery.extend(true, {}, numberOfTickets);
	for(var seatId in selection) {
		if(temp[getCategoryOfSeat(seatId)+"e"] > 0) {
			price += seats[seatId].reducedPrice;
			temp[getCategoryOfSeat(seatId)+"e"] -= 1;
		} else {
			price += seats[seatId].defaultPrice;
		}
	}
	
	
	// adjust frontend
	$("#pn").text(numberOfTickets["pn"]);
	$("#pe").text(numberOfTickets["pe"]);
	$("#ln").text(numberOfTickets["ln"]);
	$("#le").text(numberOfTickets["le"]);
	
	$("#box-default").css("display","block");
	$("#box-price").css("display","none");
	if(numberOfTickets["p"] == 0) {
		$("#box-parkett").css("display","none");
	} else {
		$("#box-parkett").css("display","block");
		$("#box-default").css("display","none");
		$("#box-price").css("display","block");
	}
	if(numberOfTickets["l"] == 0) {
		$("#box-loge").css("display","none");
	} else {
		$("#box-loge").css("display","block");
		$("#box-default").css("display","none");
		$("#box-price").css("display","block");
	}
	
	$("#price").text(showPrice(price));
}

function showPrice (price) {
	return price.toFixed(2).replace(".",",");
}

$(function () {
	$('.btn-seat-select').on('click', function () {
		var idButton = $(this).attr("id");
		numberOfTickets[idButton.substr(0,2)] += (idButton.charAt(2) == "+" ? 1 : -1);
		numberOfTickets[idButton.charAt(0)+(idButton.charAt(1)=="n"?"e":"n")] += (idButton.charAt(2) == "+" ? -1 : 1);
		updatePriceBox();
	});
	
	$('#button-purchase').on('click', function () {
		var urlSeatsP = "";
		var urlSeatsL = "";
		for(var seatId in selection) {
			if(getCategoryOfSeat(seatId) == "p")
				urlSeatsP += seatId + ",";
			else
				urlSeatsL += seatId + ",";
		}
		urlSeatsP = urlSeatsP.substr(0, urlSeatsP.length-1);
		urlSeatsL = urlSeatsL.substr(0, urlSeatsL.length-1);
		
		var urlPrice = numberOfTickets["pn"];
		urlPrice += "," + numberOfTickets["pe"];
		urlPrice += "," + numberOfTickets["ln"];
		urlPrice += "," + numberOfTickets["le"];
		
		var url = "./bezahlen.html";
		url += "?id=" + urlparameters.get("id");
		url += "&sp=" + urlSeatsP;
		url += "&sl=" + urlSeatsL;
		url += "&p=" + urlPrice;
		url += "&preis=" + $("#price").text();
		window.location.href = url;
	});
});

/* Tooltips */
$(function () {
	$('[data-toggle="tooltip"]').tooltip()
})