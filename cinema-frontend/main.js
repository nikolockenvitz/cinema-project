
const URL_SERVER = "http://localhost:8080/cinema-system";
const PATH_ALL_MOVIES = "/movie/getAllMovies";
const PATH_MOVIE = "/movie/{movieID}";
const PATH_SHOW = "/show/{showID}";

function getData (path, func) {
	$.ajax({
	  type: "GET",
	  url: URL_SERVER + path,
	  success: (data) => func(data),
	  error: function (xhr,status,error){
		console.log(xhr, status, error);
		func([]);
	  }
	});
}

var url = new URL(window.location.href);
var path = url.pathname;
var page = path.split("/").pop();
var urlparameters = url.searchParams

var now = new Date();
var dd = now.getDate();
var mm = now.getMonth()+1; //January is 0!
var yyyy = now.getFullYear();
var date = (dd<10 ? "0"+dd : dd) + "." + (mm<10 ? "0"+mm : mm) + "." + yyyy;
var todayMidnight = new Date(yyyy, mm-1, dd);

switch(page) {
	case "index.html":
		loadMovies();
		break;
	case "film.html":
		loadMovieAndShows();
		break;
	case "vorstellung.html":
		loadShow();
		break;
	case "bezahlen.html":
		loadSummaryAndPayment();
		break;
	case "bestaetigung.html":
		loadConfirmation();
		break;
}

/* index.html - Movies */
var templateMovieOverview = `
<div class="row featurette">
		  <div class="col-12 col-sm-4">
            <a href="./film.html?id={movieID}"><img class="featurette-image img-fluid mx-auto" src="./img/{movieID}.jpg" alt="{movieTitle}" width="100%"></a>
          </div>
          <div class="col-12 col-sm-8">
            <h2 class="featurette-heading"><a class="hidden" href="./film.html?id={movieID}">{movieTitle}</a></h2>
            <p class="lead">FSK {movieFSK}, {movieDuration} Minuten{movieGenres}</p>
			
			<p class="lead">{movieDescription}</p>
			<p class="lead">{movieShows}</p>
		  </div>
        </div>
		
		<hr class="featurette-divider">
`;
var templateShowButton = `<a href="./vorstellung.html?id={showID}" class="btn btn-outline-primary btn-show {show3D} {showButtonDisabled}">{showTime}</a>`;

function loadMovies () {
	getData(PATH_ALL_MOVIES, displayMovies);
}

function displayMovies (movies) {
	for(var i=0; i<movies.length; i++) {
		var movie = movies[i];
		showButtons = "";
		for(var j in movie.shows) {
			var show = movie.shows[j];
			if(show.date == date) {
				var [day, month, year] = show.date.split(".");
				var [hour, minute] = show.time.split(":");
				var showTime = new Date(year, month-1, day, hour, minute);
				showButtons += templateShowButton
					.replace("{showID}",show.id)
					.replace("{show3D}",(show["3D"] ? "show-3d" : ""))
					.replace("{showButtonDisabled}", (now > showTime  ? "disabled" : ""))
					.replace("{showTime}",show.time);
			}
		}
		var genres = "";
		for(var j in movie.genres) {
			genres += ", " + movie.genres[j].genre;
		}
		$("#movies").append(templateMovieOverview
			.replace(/\{movieID\}/g,movie.id)
			.replace(/\{movieTitle\}/g,movie.name)
			.replace("{movieFSK}",movie.fsk)
			.replace("{movieDuration}",movie.duration)
			.replace("{movieGenres}",genres)
			.replace("{movieDescription}",movie.description)
			.replace("{movieShows}",showButtons)
		);
	}
}


/* film.html - Movie + Shows */
var templateMovieDetail = `
	<div class="row featurette">
	  <div class="col-12 col-sm-4">
        <img class="featurette-image img-fluid mx-auto" src="./img/{movieID}.jpg" alt="{movieTitle}" width="100%">
      </div>
      <div class="col-12 col-sm-8">
        <h2 class="featurette-heading">{movieTitle}</h2>
        <p class="lead">FSK {movieFSK}, {movieDuration} Minuten{movieGenres}</p>
		<p class="lead rating-{movieRatingRounded}">{movieRating}</p>
      </div>
    </div>

    <div class="row featurette" style="margin-top: 1rem">
	  <div class="col-12">
	    <p class="lead">{movieDescription}</p>
      </div>
    </div>
`;
var templateShowsPerDay = `
	<tr>
		<td>{showWeekday} ({showDate})</td>
		<td>{movieShows}</td>
	</tr>
`;
var templateRatings = `
	<div class="row featurette">
	  <div class="col-12" id="ratings">
		<h2 class="featurette-heading">Bewertungen</h2>
	    {ratings}
      </div>
    </div>
`;
var templateRating = `
	<p class="lead rating-{movieRating}">{ratingUsername}<br>{ratingComment}</p>
`;

function loadMovieAndShows () {
	var movieID = urlparameters.get("id");
	if (movieID == null) {
		window.location.href = "./index.html";
	}
	else {
		getData(PATH_MOVIE.replace("{movieID}", movieID), displayMovieAndShows);
	}
}

function displayMovieAndShows (movie) {
	if(movie == null || movie == []) {
		window.location.href = "./fehler.html";
	}
	
	document.title += " - " + movie.name;
	
	var genres = "";
	for(var j in movie.genres) {
		genres += ", " + movie.genres[j].genre;
	}
	var rating = 0;
	for(var j in movie.ratings) {
		rating += movie.ratings[j].rating;
	}
	if(movie.ratings.length > 0)
		rating /= movie.ratings.length;
	
	$("#movie").prepend(templateMovieDetail
		.replace("{movieID}", movie.id)
		.replace(/\{movieTitle\}/g, movie.name)
		.replace("{movieFSK}", movie.fsk)
		.replace("{movieDuration}", movie.duration)
		.replace("{movieGenres}", genres)
		.replace("{movieRatingRounded}", Math.max(0, Math.min(5, Math.round(rating))))
		.replace("{movieRating}", (movie.ratings.length > 0 ? rating.toFixed(1).replace(".",",") : "") + " (" + movie.ratings.length + " Bewertung" + (movie.ratings.length == 1 ? "" : "en") + ")")
		.replace("{movieDescription}", movie.description)
	);
	
	var numberOfDisplayedDays = 7;
	showsPerDay = []; for(var j=0; j<numberOfDisplayedDays; j++) { showsPerDay.push([]); }
	for(var j in movie.shows) {
		var show = movie.shows[j];
		var [day, month, year] = show.date.split(".");
		var showDate = new Date(year, month-1, day);
		var differenceToToday = (showDate - todayMidnight) / 1000 / 60 / 60 / 24;
		if(differenceToToday >= 0 && differenceToToday < numberOfDisplayedDays) {
			showsPerDay[differenceToToday].push(show);
		}
	}
	for(var j=0; j<numberOfDisplayedDays; j++) {
		var showButtons = "";
		for(var k in showsPerDay[j]) {
			var show = showsPerDay[j][k];
			var [day, month, year] = show.date.split(".");
			var [hour, minute] = show.time.split(":");
			var showTime = new Date(year, month-1, day, hour, minute);
			showButtons += templateShowButton
				.replace("{showID}",show.id)
				.replace("{show3D}",(show["3D"] ? "show-3d" : ""))
				.replace("{showButtonDisabled}", (now > showTime ? "disabled" : ""))
				.replace("{showTime}",show.time);
		}
		var date = new Date(todayMidnight.getFullYear(), todayMidnight.getMonth(), todayMidnight.getDate()+j);
		var dateDay = date.getDate();
		var dateMonth = date.getMonth()+1;
		$("#shows").append(templateShowsPerDay
			.replace("{showDate}", (dateDay<10 ? "0" : "") + dateDay + "." + (dateMonth<10 ? "0" : "") + dateMonth + "." + date.getFullYear())
			.replace("{showWeekday}", ["Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"][date.getDay()])
			.replace("{movieShows}", showButtons)
		);
	}
	
	if(movie.ratings.length > 0) {
		var ratings = "";
		for(var j=0; j<movie.ratings.length; j++) {
			var rating = movie.ratings[j];
			var name = "";
			if(rating.customer != null) {
				name += (rating.customer.firstname != null ? rating.customer.firstname : "");
				name += ((rating.customer.firstname == null || rating.customer.firstname == "" || rating.customer.lastname == null || rating.customer.lastname == "") ? "" : " ");
				name += (rating.customer.lastname != null ? rating.customer.lastname : "");
			}
			if(name == "") {
				name = "Gast";
			}
			ratings += templateRating
				.replace("{movieRating}", Math.max(0, Math.min(5, Math.round(rating.rating))))
				.replace("{ratingUsername}", name)
				.replace("{ratingComment}", (rating.comment != null ? rating.comment : ""))
			;
		}
		$("#movie").append(templateRatings
			.replace("{ratings}", ratings)
		);
	}
}


/* vorstellung.html - Show */
var templateShow = `
	<div class="row featurette">
	  <div class="col-12 col-sm-4">
        <a href="./film.html?id={movieID}"><img class="featurette-image img-fluid mx-auto" src="./img/{movieID}.jpg" alt="{movieTitle}" width="100%"></a>
      </div>
      <div class="col-12 col-sm-8">
        <h2 class="featurette-heading"><a class="hidden" href="./film.html?id={movieID}">{movieTitle}</a></h2>
        <p class="lead">FSK {movieFSK}, {movieDuration} Minuten{movieGenres}</p>
		<p class="lead">{showDate}, {showWeekday}, {showTime}</p>
      </div>
    </div>
`;

function loadShow () {
	var showID = urlparameters.get("id");
	if (showID == null) {
		window.location.href = "./index.html";
	}
	else {
		getData(PATH_SHOW.replace("{showID}", showID), displayShow);
	}
}

function displayShow (show) {
	if(show == null || show == []) {
		window.location.href = "./fehler.html";
	}
	
	var movie = show.movie;
	document.title += " - " + movie.name;
	
	var genres = "";
	for(var j in movie.genres) {
		genres += ", " + movie.genres[j].genre;
	}
	$("#show").prepend(templateShow
		.replace(/\{movieID\}/g, movie.id)
		.replace(/\{movieTitle\}/g, movie.name)
		.replace("{movieFSK}", movie.fsk)
		.replace("{movieDuration}", movie.duration)
		.replace("{movieGenres}", genres)
		.replace("{showDate}", show.date.slice(0,-4))
		.replace("{showWeekday}", show.weekday)
		.replace("{showTime}", show.time)
	);
	
	drawCinemaHall(show.hall);
}


/* bezahlen.html - Summary + Payment options */
function loadSummaryAndPayment () {
	var showID = urlparameters.get("id");
	if (showID == null) {
		window.location.href = "./index.html";
	}
	else {
		getData(PATH_SHOW.replace("{showID}", showID), displaySummaryAndPayment);
	}
}

function displaySummaryAndPayment (show) {
	if(show == null || show == []) {
		window.location.href = "./fehler.html";
	}
	
	var movie = show.movie;
	document.title += " - " + movie.name;
	
	var genres = "";
	for(var j in movie.genres) {
		genres += ", " + movie.genres[j].genre;
	}
	$("#show").prepend(templateShow
		.replace(/\{movieID\}/g, movie.id)
		.replace(/\{movieTitle\}/g, movie.name)
		.replace("{movieFSK}", movie.fsk)
		.replace("{movieDuration}", movie.duration)
		.replace("{movieGenres}", genres)
		.replace("{showDate}", show.date.slice(0,-4))
		.replace("{showWeekday}", show.weekday)
		.replace("{showTime}", show.time)
	);
	
	var summary = "";
	var [pn,pe,ln,le,sn,se] = urlparameters.get("p").split(",");
	if(pn > 0 || pe > 0) {
		summary += '<p class="lead">Parkett: ';
		if(pe > 0) summary += pe + "x ermäßigt";
		if(pe > 0 && pn > 0) summary += ", ";
		if(pn > 0) summary += pn + "x normal";
		summary += "</p>";
	}
	if(ln > 0 || le > 0) {
		summary += '<p class="lead">Loge: ';
		if(le > 0) summary += le + "x ermäßigt";
		if(le > 0 && ln > 0) summary += ", ";
		if(ln > 0) summary += ln + "x normal";
		summary += "</p>";
	}
	if(sn > 0 || se > 0) {
		summary += '<p class="lead">Sofa: ';
		if(se > 0) summary += se + "x ermäßigt";
		if(se > 0 && sn > 0) summary += ", ";
		if(sn > 0) summary += sn + "x normal";
		summary += "</p>";
	}
	$("#summary-seats").html(summary);
	$("#summary-price").text(urlparameters.get("preis"));
	
	setCurrentShow(show);
}


/* bestaetigung.html - Confirmation */
function loadConfirmation () {
	var showID = urlparameters.get("sid");
	if (showID == null) {
		window.location.href = "./index.html";
	}
	else {
		getData(PATH_SHOW.replace("{showID}", showID), displayConfirmation);
	}
}

function displayConfirmation (show) {
	if(show == null || show == []) {
		window.location.href = "./fehler.html";
	}
	
	var movie = show.movie;
	document.title += " - " + movie.name;
	
	var genres = "";
	for(var j in movie.genres) {
		genres += ", " + movie.genres[j].genre;
	}
	$("#show").prepend(templateShow
		.replace(/\{movieID\}/g, movie.id)
		.replace(/\{movieTitle\}/g, movie.name)
		.replace("{movieFSK}", movie.fsk)
		.replace("{movieDuration}", movie.duration)
		.replace("{movieGenres}", genres)
		.replace("{showDate}", show.date.slice(0,-4))
		.replace("{showWeekday}", show.weekday)
		.replace("{showTime}", show.time)
	);
	
	var summary = "";
	var [pn,pe,ln,le,sn,se] = urlparameters.get("p").split(",");
	if(pn > 0 || pe > 0) {
		summary += '<p class="lead">Parkett: ';
		if(pe > 0) summary += pe + "x ermäßigt";
		if(pe > 0 && pn > 0) summary += ", ";
		if(pn > 0) summary += pn + "x normal";
		summary += "</p>";
	}
	if(ln > 0 || le > 0) {
		summary += '<p class="lead">Loge: ';
		if(le > 0) summary += le + "x ermäßigt";
		if(le > 0 && ln > 0) summary += ", ";
		if(ln > 0) summary += ln + "x normal";
		summary += "</p>";
	}
	if(sn > 0 || se > 0) {
		summary += '<p class="lead">Sofa: ';
		if(se > 0) summary += se + "x ermäßigt";
		if(se > 0 && sn > 0) summary += ", ";
		if(sn > 0) summary += sn + "x normal";
		summary += "</p>";
	}
	$("#summary-seats").html(summary);
	$("#summary-price").text(urlparameters.get("preis"));
	
	drawQrCode("kinente/kino-ententeich: " + urlparameters.get("rid"));
}
