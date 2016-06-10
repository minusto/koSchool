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
					var arrRating = new Array();
					var arrStdev = new Array();
					var arrAllStudentSubjectId = new Array();
					var arrAllStudentNum = new Array();
					var arrAllStudentNum2 = 0;//등급 구하기 위한 전체 명수
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
						for (var j=1; j<=size3; j++){
							if(arrSubjectId[i]==arrAllStudentSubjectId[j]){
								$('#allStudent'+i).html(arrAllStudentNum[j]);
								if(j==1){
									arrAllStudentNum2 = arrAllStudentNum[j];
								}
							}
						}
					}
					for (var i=1; i<=size; i++){
						for (var j=1; j<=size2; j++){
							if(arrSubjectId[i]==arrRankSubjectId[j]){
								$('#ranking'+i).html(arrRankSend[j]);
								arrRating[j] = (arrRankSend[j]/arrAllStudentNum2)*100;
								if((0<arrRating[j])&&(arrRating[j]<=4)){
									$('#rating'+i).html('1');
								}else if((4<arrRating[j])&&(arrRating[j]<=11)){
									$('#rating'+i).html('2');
								}else if((11<arrRating[j])&&(arrRating[j]<=23)){
									$('#rating'+i).html('3');
								}else if((23<arrRating[j])&&(arrRating[j]<=40)){
									$('#rating'+i).html('4');
								}else if((40<arrRating[j])&&(arrRating[j]<=60)){
									$('#rating'+i).html('5');
								}else if((60<arrRating[j])&&(arrRating[j]<=77)){
									$('#rating'+i).html('6');
								}else if((77<arrRating[j])&&(arrRating[j]<=89)){
									$('#rating'+i).html('7');
								}else if((89<arrRating[j])&&(arrRating[j]<=96)){
									$('#rating'+i).html('8');
								}else if((96<arrRating[j])&&(arrRating[j]<=100)){
									$('#rating'+i).html('9');
								}
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