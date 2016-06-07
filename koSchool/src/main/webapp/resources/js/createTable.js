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
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrMidExam">';
						html += '<input type="hidden" name ="nesinYear" id="nesinYear'+i+'">';
						html += '<input type="hidden" name ="arrSubjectId" id="subjectId'+i+'">';
						html += '</td>';
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrFinalExam"></td>';
						html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrPerformanceEvaluation"></td>';
						html += '<td><input type="button" id="rowDelete'+i+'" value="삭제"></td>';
						html += '</tr>'
						
						$('#tbody1').append(html);
						
						//입력 테이블 저장 폼
						var html2 = '<div class="createIn'+i+'">';
						html2 += '<input type="text" name ="arrSubjectId" id="arrSubjectIdS'+i+'">';
						html2 += '</div>';
						$('.saveFormDiv form').append(html2);
						i++;
					});
	for (var j = 1; j < 50; j++) {
		$(document).on('click', '#rowDelete' + j, function() {
			var delNum = $(this).attr('id').substr(9,2);
			$('#createTr'+delNum).html('');
			$('.createIn'+delNum).html('');
		})
		$(document).on('change', '#selectSubjectType' + j, function() {
			var num = $(this).attr('id').substr(17,2);
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
			var num = $(this).attr('id').substr(17,2);
			var subjectName = $(this).val();
			$.ajax({
				url : 'subject2_ajax?s_name='+subjectName,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : createTable2
			});
			function createTable2(subject){
				var hidden='';
				var subjectId = subject.subjectId;
				var subjectUnit = subject.subjectUnit;
				var subjectGrade = subject.subjectGrade;
				if($('#checkGrade').val()==''){
					alert("학생을 선택해주세요.");
					$('.sNameOp'+num).remove();
					$('#selectSubjectType'+num).val('default').attr("checked", true);
					return;
				}
				var checkGrade = 0;
				checkGrade = eval($('#checkGrade').val().substr(0,1));
				if(checkGrade==1){
					if(checkGrade==subjectGrade){
						$('#nesinYear'+num).val('2016');
					}else{
						alert('1학년 과목만 입력 가능 합니다.')
						$('#subjectId'+num).val('');
						$('#subjectGrade'+num).html('');
						$('#subjectUnit'+num).html('');
						$('.sNameOp'+num).remove();
						$('#selectSubjectType'+num).val('default').attr("checked", true);
						return;
					}
				}else if(checkGrade==2){
					if(checkGrade==subjectGrade){
						$('#nesinYear'+num).val('2016');
					}else if((checkGrade-1)==subjectGrade){
						$('#nesinYear'+num).val('2015');
					}else{
						alert('3학년 과목은 입력할 수 없습니다.')
						$('#subjectId'+num).val('');
						$('#subjectGrade'+num).html('');
						$('#subjectUnit'+num).html('');
						$('.sNameOp'+num).remove();
						$('#selectSubjectType'+num).val('default').attr("checked", true);
						return;
					}
				}else if(checkGrade==3){
					if(checkGrade==subjectGrade){
						$('#nesinYear'+num).val('2016');
					}else if((checkGrade-1)==subjectGrade){
						$('#nesinYear'+num).val('2015');
					}else if((checkGrade-2)==subjectGrade){
						$('#nesinYear'+num).val('2014');
					}
				}
				$('#subjectId'+num).val(subjectId);
				$('#subjectGrade'+num).html(subjectGrade);
				$('#subjectUnit'+num).html(subjectUnit);
				
				//입력 테이블 저장 폼
				$('#arrSubjectIdS'+num).val(subjectId);
				
			}
			
		})
	}
	//모델 버튼 클릭 이벤트 (입력 테이블 저장)
	$('#firstSave').click(function(){
		var cnt = 0;
		for(var a=1; a<15; a++){
			if($('#subjectGrade'+a).html()==2||$('#subjectGrade'+a).html()==3){
				cnt++;
			}
		}
		if(cnt>0){
			alert('1학년 과목만 입력 가능합니다.');
		}else{
		$('#subjectGradeS').val(1);
		$('#sendSaveForm').trigger('click');
		}
	})
	$('#sencondSave').click(function(){
		var cnt2 = 0;
		for(var a=1; a<15; a++){
			if($('#subjectGrade'+a).html()==1||$('#subjectGrade'+a).html()==3){
				cnt2++;
			}
		}
		if(cnt2>0){
			alert('2학년 과목만 입력 가능합니다.');
		}else{
		$('#subjectGradeS').val(2);
		$('#sendSaveForm').trigger('click');
		}
	})
	$('#thirdSave').click(function(){
		var cnt3 = 0;
		for(var a=1; a<15; a++){
			if($('#subjectGrade'+a).html()==1||$('#subjectGrade'+a).html()==2){
				cnt3++;
			}
		}
		if(cnt3>0){
			alert('3학년 과목만 입력 가능합니다.');
		}else{
		$('#subjectGradeS').val(3);
		$('#sendSaveForm').trigger('click');
		}
	})
	// 입력 테이블 불러오기
	//1학년과목 불러오기
	$('#firstLoad').click(function(){
		var studentGrade = $('#checkGrade').val().substr(0,1);
		var check = "first";
		if(studentGrade==''){
			alert("학생을 선택해주세요.");
		}else if(studentGrade==1){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable,
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
			});
		}else if(studentGrade==2){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable
			});
		}else if(studentGrade==3){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable
			});
		}
	})
	
	//2학년과목 불러오기
	$('#sencondLoad').click(function(){
		var studentGrade = $('#checkGrade').val().substr(0,1);
		var check = "second";
		if(studentGrade==''){
			alert("학생을 선택해주세요.");
		}else if(studentGrade==1){
			alert('1학년 과목만 입력 가능 합니다.')
		}else if(studentGrade==2){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable
			});
		}else if(studentGrade==3){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable
			});
		}
	})
	
	//3학년과목 불러오기
	$('#thirdLoad').click(function(){
		var studentGrade = $('#checkGrade').val().substr(0,1);
		var check = "third";
		if(studentGrade==''){
			alert("학생을 선택해주세요.");
		}else if(studentGrade==1){
			alert('1학년 과목만 입력 가능 합니다.')
		}else if(studentGrade==2){
			alert('1, 2학년 과목만 입력 가능 합니다.')
		}else if(studentGrade==3){
			$.ajax({
				url : 'loadForm_ajax?studentGrade='+studentGrade+'&check='+check,
				type : 'post',
				dataType : 'json',
				data : $(this).serialize(),
				success : loadTable
			});
		}
	})
	
	//불러오기 ajax 함수
		function loadTable(data){
			alert('asdf')
			$.each(data, function(index, list) {
				var html = '<tr>';
				html += '<td>'+list.subjectGrade+'</td>';
				html += '<td>'+list.subjectType+'</td>';
				html += '<td>'+list.subjectName+'</td>';
				html += '<td>'+list.subjectUnit+'</td>';
				html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrMidExam">';
				html += '<input type="text" name ="arrNesinYear" value="'+list.nesinYear+'">';
				html += '<input type="text" name ="arrSubjectId" value="'+list.subjectId+'">';
				html += '</td>';
				html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrFinalExam"></td>';
				html += '<td><input type="text" class="form-control" id="inputPassword3" size="1" name="arrPerformanceEvaluation"></td>';
				html += '<td>x</td>';
				html += '</tr>'
				
				$('#tbody1').append(html);
			})
		}
	
	/*
	 * -----------학생 리스트-----------
	 */
	$('#tbody2')
			.on(
					'click',
					'tr',
					function() {
						$(this).css('background-color', '#d2d2d2');
						$('input[name=memberId]').val(
								$(this).find('#clickStu').html());
						$('#checkGrade').val(
								$(this).find('#clickGrade').html());
						//입력 테이블 폼 없애기
						$('#tbody1').html('');
						//입력 테이블 저장 폼 없애기
						$('.saveFormDiv form div').html('');
						$('#tbody2').find('tr').not($(this)).css(
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