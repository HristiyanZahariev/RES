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

$(document).ready(function() {
	$('#button').click(function() {
		alert('button clicked');
		getData();
	});
});