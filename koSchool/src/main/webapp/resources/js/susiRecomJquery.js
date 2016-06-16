$(function(){

	
		$(document).on('click','#chart_div g  g text',function(){
			var uniName = $(this).text();
				
			if(uniName.contains('대학')){
				$('#recomTable').empty();
				$.ajax({
					url : 'recommend?uniName='+uniName,
					type : 'post',
					dataType : 'json',
					data : $(this).serialize(),
					success : createTable
				});
			}
			

	})
	
	function createTable(data){
		
		
			if(data==''){
				var html = '<tr>';
				html += '<td colspan="8" align="center">'+'성적과 부합하는 대학이 존재하지 않습니다.'+'</td>';
				html += '</tr>'
					$('#recomTable').append(html);
			}else{
			$.each(data, function(index, list) {
				
				var html = '<tr>';
				html += '<td>'+list.location+'</td>';
				html += '<td>'+list.university+'</td>';
				html += '<td><a href="susiUniversityDetail?uniName='+list.university+'&major='+list.major+'">'+list.major+'</td>';
				html += '<td>'+list.recruitModelType+'</td>';
				html += '<td>'+list.recruitNum+'</td>';
				html += '<td>'+list.averScore+'</td>';
				html += '<td>'+list.resultScore+'</td>';
				html += '<td>없음</td>';
				html += '</tr>'
				
				$('#recomTable').append(html);
			})
			}
		}
})