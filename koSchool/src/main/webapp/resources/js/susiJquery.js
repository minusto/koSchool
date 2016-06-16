$(function() {
	// 지역선택
	$(document).on('change', '#selectLocation', function() {
		$('#susiTable1').html('');
		$('#selectKind').find('#optionKind').attr("checked", true);
		var region = $(this).val();
		$.ajax({
			url : 'selectLocation?region=' + region,
			type : 'post',
			dataType : 'json',
			data : $(this).serialize(),
			success : regionTable
		});
	})
	function regionTable(data) {
		$.each(data, function(index, list) {
			var html = '<tr>';
			html += '<td id="center">' + list.location + '</td>';
			html += '<td id="center">' + list.university + '</td>';
			html += '<td id="center"><a href="susiUniversityDetail?uniName='+list.university+'&major='+list.major+'">' + list.major + '</a></td>';
			html += '<td id="center">' + list.recruitModelType + '</td>';
			html += '<td id="center">' + list.kind+ '<br>'+ list.recruitNum + '</td>';
			html += '<td id="center">' + list.averScore + '</td>';
			html += '<td id="center">' + list.resultScore + '</td>';
			html += '<td id="center">없음</td>';
			html += '<td id="center">' + list.sfMessage + '</td>';
			html += '</tr>'
			$('#susiTable1').append(html);
		})
	}

	//계열 선택
	$(document).on('change', '#selectKind', function() {
		$('#susiTable1').html('');
		var region = $('#selectLocation').val();
		var kind = $(this).val();
		if (region == "default") {
			alert('지역을 선택하세요.')
			return false;
		} else {
			$.ajax({
				url : 'selectLocation2?region=' + region + '&kind=' + kind,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : regionTable2
			});
		}
	})
	function regionTable2(data) {
		$.each(data, function(index, list) {
			var html = '<tr>';
			html += '<td id="center">' + list.location + '</td>';
			html += '<td id="center">' + list.university + '</td>';
			html += '<td id="center"><a href="susiUniversityDetail?uniName='+list.university+'&major='+list.major+'">' + list.major + '</a></td>';
			html += '<td id="center">' + list.recruitModelType + '</td>';
			html += '<td id="center">' + list.kind+ '<br>'+ list.recruitNum + '</td>';
			html += '<td id="center">' + list.averScore + '</td>';
			html += '<td id="center">' + list.resultScore + '</td>';
			html += '<td id="center">없음</td>';
			html += '<td id="center">' + list.sfMessage + '</td>';
			html += '</tr>'

			$('#susiTable1').append(html);
		})
	}
	
	// 대학명 검색
	$(document).on('click', '#searchUniName', function() {
		$('#susiTable1').html('');
		var uniName = $('#sUniName').val();
		$('#sUniName').val('');
		$.ajax({
			url : 'selectLocation3?uniName='+uniName,
			type : 'post',
			dataType : 'json',
			data : $(this).serialize(),
			success : searchUniTable2,
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		});
	})
	function searchUniTable2(data){
		$.each(data, function(index, list){
			var html = '<tr>';
			html += '<td id="center">' + list.location + '</td>';
			html += '<td id="center">' + list.university + '</td>';
			html += '<td id="center"><a href="susiUniversityDetail?uniName='+list.university+'&major='+list.major+'">' + list.major + '</a></td>';
			html += '<td id="center">' + list.recruitModelType + '</td>';
			html += '<td id="center">' + list.kind+ '<br>'+ list.recruitNum + '</td>';
			html += '<td id="center">' + list.averScore + '</td>';
			html += '<td id="center">' + list.resultScore + '</td>';
			html += '<td id="center">없음</td>';
			html += '<td id="center">' + list.sfMessage + '</td>';
			html += '</tr>'

			$('#susiTable1').append(html);
		})
	}
})