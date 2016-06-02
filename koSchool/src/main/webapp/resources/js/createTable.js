$(function() {
	$(document).on('change', '#selectTerm', function() {
		var semester = $(this).val();
		$('input[name=semester]').val(semester);
	});
	var i = 1;
	$('#addSubject')
			.on(
					"click",
					function() {
						var html = '<tr id="createTr'+i+'">';
						html += '<td id="subjectGrade' + i + '"></td>';
						// 교과 콤보 박스
						html += '<td>';
						html += '<select id="selectSubjectType' + i + '">';
						html += '<option value="default" selected>교과선택</option>'
						html += '<option value="국어">국어</option>';
						html += '<option>수학</option>';
						html += '<option>영어</option>';
						html += '<option>사회</option>';
						html += '<option>과학</option>';
						html += '<option>도덕</option>';
						html += '<option>체육</option>';
						html += '<option>음악</option>';
						html += '<option>미술</option>';
						html += '<option>기술.가정</option>';
						html += '<option>제2외국어</option>';
						html += '<option>한문</option>';
						html += '</select>';
						html += '</td>';
						// 과목 콤보 박스
						html += '<td>';
						html += '<select id="selectSubjectName' + i + '">';
						html += '<option value="default" selected>과목선택</option>'
						html += '</select>';
						html += '</td>';
						html += '<td id="subjectUnit' + i + '"></td>';
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrMidExam">'
						html += '<input type="hidden" name ="arrSubjectId" id="subjectId'+i+'">';	
						html += '</td>';
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrFinalExam"></td>';
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrPerformanceEvaluation"></td>';
						html += '<td><input type="button" id="rowDelete'+i+'" value="삭제"></td>';
						html += '</tr>'
						i++;
						$('tbody:eq(0)').append(html);
					});
	for (var j = 1; j < 50; j++) {
		$(document).on('click', '#rowDelete' + j, function() {
			var delNum = $(this).attr('id').substr(9,1);
			$('#createTr'+delNum).html('');
		})
		$(document).on('change', '#selectSubjectType' + j, function() {
			var num = $(this).attr('id').substr(17,1);
			$('.sNameOp'+num).remove();
			var subjectType = $(this).val();
			$.ajax({
				url : 'subject_ajax',
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : createTable
			});
			function createTable(data) {
				$.each(data, function(index, list) {
					var html2 = '';
					var subejectType2 = list.subjectType;
					
					if(subjectType==subejectType2){
						html2 = '<option class="sNameOp'+num+'">'+list.subjectName+'</option>';
						$('#selectSubjectName'+num).append(html2);
					}
				})
				
			}
		});
	}
	for (var k = 1; k < 50; k++) {
		$(document).on('change', '#selectSubjectName' + k, function() {
			var num = $(this).attr('id').substr(17,1);
			var subjectName = $(this).val();
			$.ajax({
				url : 'subject2_ajax?s_name='+subjectName,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : createTable2
			});
			function createTable2(subject) {
				var hidden='';
				var subjectId = subject.subjectId;
				var subjectUnit = subject.subjectUnit;
				var subjectGrade = subject.subjectGrade;
				$('#subjectId'+num).val(subjectId);
				$('#subjectGrade'+num).html(subjectGrade);
				$('#subjectUnit'+num).html(subjectUnit);
			}
		})
	}
	

	/*
	 * -----------학생 리스트-----------
	 */
	$('tbody:eq(1)')
			.on(
					'click',
					'tr',
					function() {
						$(this).css('background-color', '#d2d2d2');
						$('input[name=memberId]').val(
								$(this).find('#clickStu').html());
						$('tbody:eq(1)').find('tr').not($(this)).css(
								'background-color', 'white');
					})
	var jbOffset = $('#jbMenu').offset();
	$(window).scroll(function() {
		if ($(document).scrollTop() > jbOffset.top) {
			$('#jbMenu').addClass('jbFixed');
		} else {
			$('#jbMenu').removeClass('jbFixed');
		}
	})
	/*
	 * $('#formId').submit(function(){ $('#rowAdd').trigger('click'); })
	 */
})