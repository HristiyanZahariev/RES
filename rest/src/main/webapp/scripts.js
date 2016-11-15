function getData() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id + '</td>');
				tr.append('<td>' + data[index].manufacture + '</td>');
				tr.append('<td>' + data[index].model + '</td>');
				tr.append('<td>' + data[index].year + '</td>');
				tr.append('<td>' + data[index].color + '</td>');
				tr.append('</tr>');
				$('#carsTable').append(tr);
			});
		}
	});
}

function formToJSON() {
	return JSON.stringify({
		"manufacture": $('#manufacture').val(),
		"model": $('#model').val(),
		"year": $('#year').val(),
		"color": $('#color').val(),
		});
}

function addCar() {
	var form = $('.form-horizontal');
	$(form).submit(function(event) {
		// Stop the browser from submitting the form.
		event.preventDefault();
		var formData = formToJSON();
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: "http://localhost:8080/rest/api/cars",
			dataType: "json",
			data: formToJSON(),
			success: function(data) {
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append('<td>' + data[index].id + '</td>');
					tr.append('<td>' + data[index].manufacture + '</td>');
					tr.append('<td>' + data[index].model + '</td>');
					tr.append('<td>' + data[index].year + '</td>');
					tr.append('<td>' + data[index].color + '</td>');
					tr.append('</tr>');
					$('#carsTable').append(tr);
				});
			}
		});
	});
}

$(document).ready(function() {
		getData();
});