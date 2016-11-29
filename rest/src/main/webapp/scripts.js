var carsPerPage = 16;
var currPage;

function inputFormToJSON() {
	return JSON.stringify({
		"manufacture": $('#manufacture').val(),
		"model": $('#model').val(),
		"year": $('#year').val(),
		"color": $('#color').val(),
	});
}


function createCarInTable(car) {
	var tr = $('<tr>');
	tr.append('<td>' + car.manufacture + '</td>');
	tr.append('<td>' + car.model + '</td>');
	tr.append('<td>' + car.year + '</td>');
	tr.append('<td>' + car.color + '</td>');
	tr.append('</tr>');
	$('#carsTableBody').append(tr);
}

function removeTable() {
    $('#carsTableBody tr').remove();
    currPage = 1;
}

function loadFiltersAndGenerateData() {
	$.ajax({
			url: "http://localhost:8080/rest/api/cars",
			type: "GET",
			dataType: "json",
			contentType: "text/plain",
			data: {
				carsPerPage : carsPerPage,
				currentPage : currPage,
				"manufacture" : $('#manufactureFilter').val(),
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

function fillDropdown(data, dropdown) {
	$.each(data, function (key, val) {
		$(dropdown)
			.append($('<option>', {value : val})
				.text(val));
	});
}

function getCarNames() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/names",
		type: "GET",
		dataType: "json",
		success: function (data) {
			fillDropdown(data, '#manufactureFilter')
		}
	});
}

function getCarModels() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/models",
		type: "GET",
		dataType: "json",
		success: function (data) {
			fillDropdown(data, '#modelFilter')
		}
	});
}

function getCarYears() {
	console.log($('#yearFilter').val());
	$.ajax({
		url: "http://localhost:8080/rest/api/cars/years",
		type: "GET",
		dataType: "json",
		success: function ()	 {
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
			fillDropdown(data, '#colorFilter')
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

	$('#manufactureFilter').change(function() {
		removeTable();
		loadFiltersAndGenerateData();
	});

	$('#modelFilter').change(function () {
		removeTable();
		loadFiltersAndGenerateData();
	});

	$('#yearFilter').change(function () {
		removeTable();
		loadFiltersAndGenerateData();
	});

	$('#colorFilter').change(function () {
		removeTable();
		loadFiltersAndGenerateData();
	});
});