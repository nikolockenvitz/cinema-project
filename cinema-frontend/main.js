
const URL_SERVER = "http://localhost:8080/cinema-data";
const PATH_ALL_MOVIES = "/movie/getAllMovies";

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

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
var date = (dd<10 ? "0"+dd : dd) + "." + (mm<10 ? "0"+mm : mm) + "." + yyyy;

switch(page) {
	case "index.html":
		loadMovies();
		break;
}

/* index.html - Movies */
var templateMovies = `
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
var templateShowButton = `<a href="./vorstellung.html?id={showID}" class="btn btn-outline-primary btn-show {show3D}">{showTime}</a>`;

function loadMovies () {
	getData(PATH_ALL_MOVIES, displayMovies);
}

function displayMovies (data) {
	for(var i=0; i<data.length; i++) {
		var movie = data[i];
		showButtons = "";
		for(var j in movie.shows) {
			var show = movie.shows[j];
			if(show.date == date) {
				showButtons += templateShowButton
					.replace("{showID}",show.id)
					.replace("{show3D}",(show["3d"] ? "show-3d" : ""))
					.replace("{showTime}",show.time);
			}
		}
		var genres = "";
		for(var j in movie.genres) {
			genres += ", " + movie.genres[j].genre;
		}
		$("#movies").append(templateMovies
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
