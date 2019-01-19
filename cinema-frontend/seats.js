/* TODO's
 * - pass selected seats (reduced/default) to next site
 * - colors, text
 * - get JSON from API
 */

var seats = {};
var hall = {};

$(document).ready(function () {
	getData();
	createCinemaScreen();
	createSeats();
	adjustToScreen();
	makeCinemaHallVisible();
	updatePriceBox();
});

function getData () {
	var width = 15;
	var length = 10;
	for(var y=0; y<length; y++) {
		for(var x=0; x<width; x++) {
			seats[y*width+x] = {
			    isOccupied: false,
				isBlocked: false,
			    x: 25*x + 10 + (x > 3 ? 10 : 0) + (x > 10 ? 10 : 0),
				y: 25*y + 70 + (y > 6 ? 10 : 0),
				category: (y > 6 ? "Loge" : "Parkett"),
				row: y,
				number: x,
				defaultPrice: (y > 6 ? 10 : 8),
				reducedPrice: (y > 6 ?  8 : 6)};
		}
	}
	[2,3,41,42,43,44,52,53,90,91,94,95,96,107,108,111,112,129,139,148,149].forEach( (s) => {
		seats[s].isOccupied = true;
	});
	
	hall = { width: width*25+15,
	         length: length*25+65 };
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
					$(this).removeClass("selected");
					removeSeatFromSelection(seatId);
				}
				else {
					$(this).addClass("selected");
					addSeatToSelection(seatId);
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
function addSeatToSelection (seatId) {
	selection[seatId] = true;
	numberOfTickets[getCategoryOfSeat(seatId)] += 1;
	updatePriceBox();
}

function removeSeatFromSelection (seatId) {
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
});

/* Tooltips */
$(function () {
	$('[data-toggle="tooltip"]').tooltip()
})