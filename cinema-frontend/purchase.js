var currentShow = null;
var cookie = null;

function readCookie () {
	var cookies = document.cookie;
	if(cookies != "" && cookies != null) {
		cookie = cookies.split("=")[1];
	}
	if(cookie == null) {
		cookie = sessionStorage.getItem("ssid");
	}
}

$(function () {
	readCookie();
	
	$('#agb').on('click', function () {
		$("#button-purchase").prop("disabled", !$(this).is(":checked"));
	});
	
	$('#button-purchase').on('click', function () {
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		var email = $("#email").val();
		var token = $("#token").val();
		
		if($("#email")[0].validity.valid == false) {
			$("#email").focus();
			return;
		}
		
		var showId = urlparameters.get("id");
		
		var seatsP = urlparameters.get("sp").split(",");
		var seatsL = urlparameters.get("sl").split(",");
		var seatsS = urlparameters.get("ss").split(",");
		var [pn,pe,ln,le,sn,se] = urlparameters.get("p").split(",");
		
		// prepare data for ajax
		var book = {paymentoption: "giftcard",
					verification: token,
					showId: parseInt(showId),
					seats: [],
					customer: { firstname: firstName,
								lastname: lastName,
								email: email,
								sessiontoken: cookie}};
		for(var i=0; i<seatsP.length; i++) {
			if(seatsP[i] != "")
				book.seats.push({id: parseInt(seatsP[i]), isReducedPrice: (pe-- > 0 ? true : false)});
		}
		for(var i=0; i<seatsL.length; i++) {
			if(seatsL[i] != "")
				book.seats.push({id: parseInt(seatsL[i]), isReducedPrice: (le-- > 0 ? true : false)});
		}
		for(var i=0; i<seatsS.length; i++) {
			if(seatsS[i] != "")
				book.seats.push({id: parseInt(seatsS[i]), isReducedPrice: (se-- > 0 ? true : false)});
		}
		
		// send ajax
		var data = "book=" + JSON.stringify(book);
		$.ajax({
		  type: "POST",
		  url: "http://localhost:8080/cinema-system/reservation/book",
		  data: data,
		  contentType: "application/json; charset=utf-8",
		  success: (data) => processBookingResult(data),
		  error: function (xhr,status,error){
			console.log(xhr, status, error);
			processBookingResult(null);
		  }
		});
	});
});

function processBookingResult (data) {
	if(data != null && data != [] && data != {}) {
		var reservationId = data.id;
		if(reservationId != null && reservationId > 0) {
			// successful
			var url = "./bestaetigung.html";
			url += "?rid=" + reservationId;
			url += "&sid=" + urlparameters.get("id");
			url += "&p=" + urlparameters.get("p");
			url += "&preis=" + urlparameters.get("preis")
			window.location.href = url;
			return;
		}
	}
	console.log(data);
	window.location.href = "./fehler.html";
}

function setCurrentShow (show) {
	currentShow = show; // necessary to access seat-array for show
}