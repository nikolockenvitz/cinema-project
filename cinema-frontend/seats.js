/* TODO's
 * - relative positioning -> calculate percentages from coordinates
 * - storing selected seats, price calculation
 * - colors, text
 * - get JSON from API
 */

var seats = [];

$(document).ready(function () {
	getData();
	createScreen();
	createSeats();	
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
}

function createScreen () {
	var screen = "<div class='screen bg-dark'>Leinwand</div>";
	$('#cinemaHall').append(screen);
}

function createSeats () {
	var template = "<div id='{seatID}' class='seat {classes}' style='left: {posx}px; top: {posy}px;' data-toggle='tooltip' data-placement='top' title='{tooltip}' category='{category}' row='{row}' number='{number}'></div>";

	var maxx = 0;
	var maxy = 0;
	for(var i=0; i<seats.length; i++) {
		var cur = template;
		cur = cur.replace("{seatID}",seats[i].id);
		cur = cur.replace("{classes}",seats[i].classes);
		cur = cur.replace("{posx}",seats[i].posx);
		cur = cur.replace("{posy}",seats[i].posy);
		cur = cur.replace("{tooltip}", "Reihe: " + seats[i].row + ", Platz: " + seats[i].number + " (" + seats[i].category + ")");
		cur = cur.replace("{category}",seats[i].category);
		cur = cur.replace("{row}",seats[i].row);
		cur = cur.replace("{number}",seats[i].number);
		$('#cinemaHall').append(cur);
		
		maxx = Math.max(maxx, seats[i].posx);
		maxy = Math.max(maxy, seats[i].posy);
	}
	
	$('#cinemaHall').width((maxx+12)+"px");
	$('#cinemaHall').height((maxy+12)+"px");

	
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

$(window).on('resize', () => {
	console.log($("#cinemaHall").width());
	// TODO: update
});