$(function(){
		$('#selectTerm').change(function(){
			var subjectGrade = $('input:radio[name="subjectGrade"]:checked').val();
			if(subjectGrade == null){
				alert("학년을 선택해주세요.")
			}else{
			var semester = $(this).val();
			location.href = "listScore?semester="+semester+"&subjectGrade="+subjectGrade;
			}
		})
		$('input:radio[name="subjectGrade"]:input[value="${subjectGrade}"]').attr("checked", true);
		
		$(document).ready(function(){
					var listSize = $('#listSize').html();
					var listSize2 = $('#listSize2').html();
					var listSize3 = $('#listSize3').html();
					var listSize4 = $('#listSize4').html();
					var size = parseInt(listSize);
					var size2 = parseInt(listSize2);
					var size3 = parseInt(listSize3);
					var size4 = parseInt(listSize4);
					var arrSubjectId = new Array();
					var arrRankSubjectId = new Array();
					var arrRankSend = new Array();
					var arrStdev = new Array();
					var arrAllStudentSubjectId = new Array();
					var arrAllStudentNum = new Array();
					var arrAllStdevSubjectId = new Array();
					for (var i=1; i<=size; i++){
						arrSubjectId[i]= $('#subjectId'+i).html();
						$('#arrSubject'+i).html(arrSubjectId[i]);
					}
					for (var i=1; i<=size2; i++){
						arrRankSubjectId[i]= $('#rankSubjectId'+i).html();
						arrRankSend[i]= $('#rankSend'+i).html();
					}
					for(var i=1; i<=size3; i++){
						arrAllStudentSubjectId[i] = $('#allStudentSubjectId'+i).html();
						arrAllStudentNum[i] = $('#allStudentNum'+i).html();
					}
					for(var i=1; i<=size4; i++){
						arrStdev[i] = $('#stdev'+i).html();
						arrAllStdevSubjectId[i] = $('#stdevSubjectId'+i).html();
					}
					for (var i=1; i<=size; i++){
						for (var j=1; j<=size2; j++){
							if(arrSubjectId[i]==arrRankSubjectId[j]){
								$('#ranking'+i).html(arrRankSend[j]);
							}
						}
					}
					for (var i=1; i<=size; i++){
						for (var j=1; j<=size3; j++){
							if(arrSubjectId[i]==arrAllStudentSubjectId[j]){
								$('#allStudent'+i).html(arrAllStudentNum[j]);
							}
						}
					}
					//표준편차
					var g = 0;
					var result = parseFloat(g);
					for (var i=1; i<=size; i++){
						for (var j=1; j<=size4; j++){
							if(arrSubjectId[i]==arrAllStdevSubjectId[j]){
								result = result+Math.pow(parseFloat(arrStdev[j])-parseFloat($('#avg'+i).html()),2)/parseFloat($('#allStudent'+i).html());
							}
						}
						$('#stdevResult'+i).html(Math.sqrt(result).toFixed(2));
						result = 0;
					}
		});
		
		
	})