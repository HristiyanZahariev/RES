var carsPerPage = 16;
var currPage;

// function generateData() {
//
// 	$.ajax({
// 		url: "http://localhost:8080/rest/api/cars",
// 		type: "GET",
// 		dataType: "json",
// 		contentType: "text/plain",
// 		data: {
// 			carsPerPage : carsPerPage,
// 			currentPage : currPage
// 		},
// 		success: function(data) {
// 			console.log(data);
// 			currPage++;
// 			$.each(data, function(index){
// 				createCarInTable(data[index]);
// 			});
// 		}
// 	});
// }

function inputFormToJSON() {
	return JSON.stringify({
		"manufacture": $('#manufacture').val(),
		"model": $('#model').val(),
		"year": $('#year').val(),
		"color": $('#color').val(),
	});
}

// function filterToJSON() {
// 	return JSON.stringify({
//         "manufacture" : $('#manufacturersFilter').val(),
//         "model" : $('#modelFilter').val(),
//         "year" : $('#yearFilter').val(),
//         "color" : $('#colorFilter').val()
// 	});
// }

function createCarInTable(car) {
	var tr = $('<tr>');
	tr.append('<td>' + car.id + '</td>');
	tr.append('<td>' + car.manufacture + '</td>');
	tr.append('<td>' + car.model + '</td>');
	tr.append('<td>' + car.year + '</td>');
	tr.append('<td>' + car.color + '</td>');
	tr.append('</tr>');
	$('#carsTableBody').append(tr);
}

function	 loadFiltersAndGenerateData() {
    //console.log($('#manufacturersFilter').val());
	$.ajax({
			url: "http://localhost:8080/rest/api/cars",
			type: "GET",
			dataType: "json",
			contentType: "text/plain",
			data: {
				carsPerPage : carsPerPage,
				currentPage : currPage,
				"manufacture" : $('#manufacturersFilter').val(),
				"model" : $('#modelFilter').val(),
				"year" : $('#yearFilter').val(),
				"color" : $('#colorFilter').val()
			},
			success: function(data) {
				currPage++;
				$.each(data, function(index) {
					createCarInTable(data[index]);
				});
			}
		}
	);
}

function registerForm() {
	var form = $('.form-horizontal');
	$(form).submit(function(event) {
		// Stop the browser from submitting the form.
		event.preventDefault();
		console.log("HELLOO");
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: "http://localhost:8080/rest/api/cars",
			dataType: "json",
			data: inputFormToJSON(),
			success: function(data) {
				console.log("Yeah");
				//createCarInTable(data);
			}

		});
	});
}

function getCarNames() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/names",
		type: "GET",
		dataType: "json",
		success: function (data) {
			$.each(data, function(key, val) {
				$('#manufacturersFilter')
					.append($('<option>', { value : val })
						.text(val));
			});
		}
	});
}

function getCarModels() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/models",
		type: "GET",
		dataType: "json",
		success: function (data) {
			$.each(data, function (key, val) {
				$('#modelFilter')
					.append($('<option>', {value : val })
						.text(val));
			});
		}
	});
}

function getCarYears() {
	console.log($('#yearFilter').val());
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/years",
		type: "GET",
		dataType: "json",
		success: function (data) {
			var option='';
			for (var i=1940; i <= 2016; i++){
				option += '<option value="'+ i + '">' + i + '</option>'; //copi pasta from http://stackoverflow.com/questions/3446069/populate-dropdown-select-with-array-using-jquery
			}
			$('#yearFilter').append(option);
		}
	});

}

function getCarColors() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/colors",
		type: "GET",
		dataType: "json",
		success: function (data) {
			$.each(data, function (key, val) {
				$('#colorFilter')
					.append($('<option>', {value : val })
						.text(val));
			});
		}
	});
}

$(document).ready(function() {
	currPage = 1;
	$(window).scroll(function () {
		if (($(window).scrollTop() + $(window).height()) >= $('body').height()) {
			loadFiltersAndGenerateData();
		}
	});
	registerForm();
	getCarNames();
	getCarModels();
	getCarYears();
	getCarColors();
	loadFiltersAndGenerateData();

	$('#manufacturersFilter').change(function() {
		$('#carsTableBody tr').remove();
		currPage = 1;
		loadFiltersAndGenerateData();
	});

	$('#modelFilter').change(function () {
		$('#carsTableBody tr').remove();
		currPage = 1;
		loadFiltersAndGenerateData();
	});

	$('#yearFilter').change(function () {
		$('#carsTableBody tr').remove();
		currPage = 1;
		loadFiltersAndGenerateData();
	});

	$('#colorFilter').change(function () {
		$('#carsTableBody tr').remove();
		currPage = 1;
		loadFiltersAndGenerateData();
	});
});