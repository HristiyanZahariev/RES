function generateData() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				createCarInTable(data[index]);
			});
		}
	});
}

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
	$('#carsTable').append(tr);
}

function loadFilters() {
	$.ajax({
			url: "http://localhost:8080/rest/api/cars",
			type: "GET",
			dataType: "json",
			data: filterToJSON(),
			success: function(data) {
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
				createCarInTable(data);
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
			$.each(data, function(key, value) {
				$('#manufacturersFilter')
					.append($('<option>', { value : key })
						.text(value));
			});
		}
	});
}

$(document).ready(function() {
	getCarNames();
	generateData();
	registerForm();
	$('#manufacturersFilter').change(function() {
		loadFilters();
	});

});