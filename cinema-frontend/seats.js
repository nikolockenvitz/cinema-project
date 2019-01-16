/* TODO's
 * - storing selected seats, price calculation
 * - colors, text
 * - get JSON from API
 */

var seats = [];
var hall = {};

$(document).ready(function () {
	getData();
	createCinemaScreen();
	createSeats();
	adjustToScreen();
	makeCinemaHallVisible();
});

function getData () {
	var width = 15;
	var length = 10;
	for(var y=0; y<length; y++) {
		for(var x=0; x<width; x++) {
			seats.push({id: y*length+x,
			            classes: (Math.random() < 0.8 ? "available" : "occupied"),
			            posx: 25*x + 10 + (x > 3 ? 10 : 0) + (x > 10 ? 10 : 0),
						posy: 25*y + 70 + (y > 6 ? 10 : 0),
						category: (y > 6 ? "Loge" : "Parkett"),
						row: y,
						number: x});
		}
	}
	
	hall = { width: width*25+15,
	         length: length*25+65 };
}

function createCinemaScreen () {
	var screen = "<div class='screen bg-dark'>Leinwand</div>";
	$('#cinemaHall').append(screen);
}

function createSeats () {
	var template = "<div id='{seatID}' class='seat {classes}' style='left: {posx}%; top: {posy}%;' data-toggle='tooltip' data-placement='top' title='{tooltip}' category='{category}' row='{row}' number='{number}'></div>";
	
	for(var i=0; i<seats.length; i++) {
		var cur = template;
		cur = cur.replace("{seatID}",seats[i].id);
		cur = cur.replace("{classes}",seats[i].classes);
		cur = cur.replace("{posx}", (100 * seats[i].posx) / (hall.width + 20));
		cur = cur.replace("{posy}", (100 * seats[i].posy) / (hall.length + 20));
		cur = cur.replace("{tooltip}", "Reihe: " + seats[i].row + ", Platz: " + seats[i].number + " (" + seats[i].category + ")");
		cur = cur.replace("{category}",seats[i].category);
		cur = cur.replace("{row}",seats[i].row);
		cur = cur.replace("{number}",seats[i].number);
		$('#cinemaHall').append(cur);
	}
	
	$(function () {
		$('.seat').on('click', function () {
			if($(this).hasClass("available")) {
				if($(this).hasClass("selected")) {
					$(this).removeClass("selected");
				}
				else {
					$(this).addClass("selected");
				}
				console.log($(this).attr("category") + " Reihe " + $(this).attr("row") + " Platz " + $(this).attr("number"));
				// TODO
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
	maxDivHeight = $(document).height() * 2 / 3;
	
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
}

$(window).on('resize', () => {
	adjustToScreen();
});