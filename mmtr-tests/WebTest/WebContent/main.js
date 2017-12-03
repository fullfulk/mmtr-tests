$('form.ajax').on('submit', function() {
	var tmp = $(this),
		url = tmp.attr('action'),
		method = tmp.attr('method'),
		data = {};
	tmp.find('[name]').each(function(index, value) {
		var tmp = $(this),
			name = tmp.attr('name'),
			color = tmp.attr('color'),
			age = tmp.attr('18-years'),
			radM = tmp.attr('radio-morning'),
			radN = tmp.attr('radio-night');
		data[name] = value;
	});
	$.ajax({
		url : url,
		type : type,
		data : data,
		success : function(response) {
			console.log(response);
		}
	});
})