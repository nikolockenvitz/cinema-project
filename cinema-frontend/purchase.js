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
		
		var seats = urlparameters.get("s");
		var [pn,pe,ln,le] = urlparameters.get("p");
		
		// prepare data for ajax
		// send ajax
		// successful (returned reservation-id) -> show confirmation
		// error: show error page
	});
});

function setCurrentShow (show) {
	currentShow = show; // necessary to access seat-array for show
}