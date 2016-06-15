$(function(){
	$(document).on('click','#testId',function(){
		var uniName = $(this).html();
		$.ajax({
			url : 'susiSimulationTable?uniName='+uniName,
			type : 'post',
			dataType : 'json',
			data : $(this).serialize(),
			success : createTable
		});
	})
	
	function createTable(data){
			$.each(data, function(index, list) {
				var html = '<tr>';
				html += '<td>'+list.location+'</td>';
				html += '<td>'+list.university+'</td>';
				html += '<td>'+list.major+'</td>';
				html += '<td>'+list.recruitModelType+'</td>';
				html += '<td>'+list.recruitNum+'</td>';
				html += '<td>'+list.averScore+'</td>';
				html += '<td>'+list.resultScore+'</td>';
				html += '<td>없음</td>';
				html += '</tr>'
				
				$('#susiTable1').append(html);
			})
		}
})