var currentShow = null;

$(function () {
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
		var [pn,pe,ln,le] = urlparameters.get("p").split(",");
		
		// prepare data for ajax
		var book = {paymentoption: "giftcard",
					verification: token,
					showId: parseInt(showId),
					seats: [],
					customer: {firstname: firstName, lastname: lastName, email: email}};
		for(var i=0; i<seatsP.length; i++) {
			if(seatsP[i] != "")
				book.seats.push({id: parseInt(seatsP[i]), isReducedPrice: (pe-- > 0 ? true : false)});
		}
		for(var i=0; i<seatsL.length; i++) {
			if(seatsL[i] != "")
				book.seats.push({id: parseInt(seatsL[i]), isReducedPrice: (le-- > 0 ? true : false)});
		}
		
		// send ajax
		var data = "book=" + JSON.stringify(book);
		$.ajax({
		  type: "POST",
		  url: "http://localhost:8080/cinema-data/reservation/book",
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