$(function(){
	$('#rowAdd').click(function(){
		var size = $('#listSize').val();
		var subjectGrade = $('#subjectGrade'+1).val();
		var subjectType = $('#subjectType'+1).val();
		var subjectName = $('#subjectName'+1).val();
		var subjectUnit = $('#subjectUnit'+1).val();
		var subjectId = $('#subjectId'+1).val();
		var semester = $('#selectTerm').val();
		var html = '<tr>';
		
		for(var i=1; i<=size; i++){
			subjectGrade = $('#subjectGrade'+i).val();
			subjectType = $('#subjectType'+i).val();
			subjectName = $('#subjectName'+i).val();
			subjectUnit = $('#subjectUnit'+i).val();
			subjectId = $('#subjectId'+i).val();	
			
			html += '<input type="hidden" name="semester" value="'+semester+'">'
			html += '<td><input type="hidden" name ="subjectGrade" value="'+subjectGrade+'">'+subjectGrade+'</td>';
			html += '<td>'+subjectType+'</td>';
			html += '<td><input type="hidden" name ="arrSubjectId" value="'+subjectId+'">'+subjectName+'</td>';
			html += '<td>'+subjectUnit+'</td>';
			html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrMidExam"></td>';
			html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrFinalExam"></td>';
			html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrPerformanceEvaluation"></td>';
			html += '<td><input type="text" class="form-control" id="inputPassword3" size="1"></td>';
			html += '</tr>';
		}
		$('tbody:eq(0)').append(html);
		
	})
})