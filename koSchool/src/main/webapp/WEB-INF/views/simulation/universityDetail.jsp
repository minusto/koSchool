<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<title>대학 세부</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/resources/css/ghi.css">
<script type="text/javascript">
	window.onload=function(){
		$("#korConvertScoreSum").html($("#korConvertScore").html());
		$("#matConvertScoreSum").html($("#matConvertScore").html());
		$("#engConvertScoreSum").html($("#engConvertScore").html());
		$("#researchConvertScoreSum").html($("#researchConvertScore").html());

		
		var result=eval($("#korConvertScoreSum").html())+eval($("#matConvertScoreSum").html())+eval($("#engConvertScoreSum").html())+eval($("#researchConvertScoreSum").html());
		$("#TotalConvertScore").html(result.toFixed(2));
		
		var totalConvertMaxScore=eval($("#korConvertMaxScore").html())+eval($("#matConvertMaxScore").html())+eval($("#engConvertMaxScore").html())+eval($("#researchConvertMaxScore").html());
		$("#totalConvertMaxScore").html(totalConvertMaxScore);
		
		var sumConvertSocre=eval($("#korConvertScore").html())+eval($("#matConvertScore").html())+eval($("#engConvertScore").html())+eval($("#researchConvertScore").html())
		$("#sumConvertScore").html(sumConvertSocre);
	}

</script>
<style type="text/css">
.tableColor thead{
	background-color: #fdfdfd;
}
.tableColor tbody{
	background-color: #fbfbfb;
}

.totalColor{
	color:#19B5FE;
}

</style>

</head>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<c:if test="${grade eq 'schoolAdmin' }">
				<jsp:include page="../common/schoolAdminMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'student' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>
			
			<c:if test="${grade eq 'teacher' }">
				<jsp:include page="../common/teacherMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'parent' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>



			<!--			메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div class="row">
						<div id="entranceInfoDiv1"
							class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
							<div id="entranceUniversityDiv">
								<img id="universityMark" alt="${universitySATInfo.universityName }"
									src="${universitySATInfo.universityMark }">
								<div id="entranceUniversityInfo">
									<ul class="list-unstyled list-inline">
										<li class="entranceInfoUniversityName">${universitySATInfo.universityName }</li>
										<li class="entranceInfoUniversityMajor">${universitySATInfo.majorName }</li>
										<li id="entrancInfoDetail"><a href="${universitySATInfo.universityURL }">홈페이지</a></li>
										<li>${universitySATInfo.recruitSeparate }</li>
									</ul>
								</div>
							</div>
							<br>
							<h3>모집전형</h3>
							<table class="table tableColor">
								<thead>
									<tr>
										<th>군</th>
										<th>대학</th>
										<th>계열</th>
										<th>모집단위</th>
										<th>모집인원</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${universitySatDetail.recruitSeparate }</td>
										<td>${universitySATInfo.universityName }</td>
										<td>${universitySATInfo.kind }</td>
										<td>${universitySATInfo.majorName }</td>
										<td>${universitySatDetail.recruitNum }</td>
									</tr>
								</tbody>
							</table>
							<br>
							<!-- 성적 상세비교 테이블 -->
							<div>
								<h3>모의고사성적 산출</h3>
								<table class="table tableColor">
									<thead align="center">
										<tr>
											<td rowspan="2" style="vertical-align: middle;">분류</td>
											<td rowspan="2" style="vertical-align: middle;">사정단계(비율%)</td>
											<td rowspan="2" style="vertical-align: middle;">구분</td>
											<td rowspan="2" style="vertical-align: middle;">국어</td>
											<td rowspan="2" style="vertical-align: middle;">${studentConvertDto.mathType }</td>
											<td rowspan="2" style="vertical-align: middle;">영어</td>
											<td colspan="2">${studentConvertDto.researchType }</td>
											
											<td rowspan="2" style="vertical-align: middle;">제2외</td>
											<td rowspan="2" style="vertical-align: middle;">한국사</td>
											<td rowspan="2" style="vertical-align: middle;">합계</td>
										</tr>
										<tr>
											<td>${studentConvertDto.research1Name }</td>
											<td>${studentConvertDto.research2Name }</td>
										</tr>
									</thead>
									<tbody align="center">
										
										<tr>
											<td colspan="2" rowspan="3" style="vertical-align: middle;">나의 수능성적</td>
											<td>표준점수</td>
											<td>${smsd.languageStandardScore}</td>
											<td>${smsd.mathStandardScore }</td>
											<td>${smsd.englishStandardScore }</td>
											<td>${smsd.researchSubjectStandardScore1 }</td>
											<td>${smsd.researchSubjectStandardScore2 }</td>
											<td>${smsd.secondLanguageStandardScore }</td>
		 									<td>${smsd.koreaHistroyStandardScore }</td> 
											<td></td>
										</tr>										
									
										<tr>
											<td>백분위</td>
											<td>${smsd.languagePercentile }</td>
											<td>${smsd.mathpercentile }</td>
											<td>${smsd.englishpercentile }</td>
											<td>${smsd.researchSubjectPercentile1 }</td>
											<td>${smsd.researchSubjectPercentile2 }</td>
											<td>${smsd.secondLanguagePercentile }</td>
									 		<td>${smsd.koreaHistoryPercentile }</td> 
											<td></td>
										</tr>
										 
										<tr>
											<td>등급</td>
											<td>${satScoreGrade.korGrade }</td>
											<td>${satScoreGrade.matGrade }</td>
											<td>${satScoreGrade.engGrade }</td>
											<td>${satScoreGrade.research1Grade }</td>
											<td>${satScoreGrade.research2Grade }</td>
											<td>${satScoreGrade.secondLanguageGrade }</td>
											<td>${satScoreGrade.koreaHistoryGrade }</td>
											<td></td>
										</tr>
										
										<tr>
											<td rowspan="4" style="vertical-align: middle;">환산점수</td>
											<td rowspan="4" style="vertical-align: middle;">일괄합산(100%)</td>
											<td>나의 점수</td>
											<c:choose>
												<c:when test="${studentConvertDto.totalConverScore!=0 }">
													<td id="korConvertScore">${fn:substring(studentConvertDto.korConverScore,0,6) }</td>
													<td id="matConvertScore">${fn:substring(studentConvertDto.matConverScore,0,6) }</td>
													<td id="engConvertScore">${fn:substring(studentConvertDto.engConverScore,0,6) }</td>
														<c:choose>
															<c:when test="${studentConvertDto.research2ConverScore==0 }">
																<td id="researchConvertScore" colspan="2" style="text-align: center;">${fn:substring(studentConvertDto.research1ConverScore,0,6) }</td>
															</c:when>
															<c:otherwise>
																<td id="researchConvertScore" colspan="2" style="text-align: center;">${fn:substring((studentConvertDto.research1ConverScore+studentConvertDto.research2ConverScore),0,6) }</td>
															</c:otherwise>
														</c:choose>
													<td></td>
													<td></td>
													<td id="sumConvertScore" class="totalColor"></td>
												</c:when>
												<c:otherwise>
													<td colspan="8" style="text-align: center; color: red;">지 원 불 가</td>
												</c:otherwise>
											</c:choose>
										</tr>
										
										<tr>
											<td>가산점</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									
										<tr>
											<td>합계</td>
											<td id="korConvertScoreSum"></td>
											<td id="matConvertScoreSum"></td>
											<td id="engConvertScoreSum"></td>
											<td id="researchConvertScoreSum" colspan="2"></td>
											<td></td>
											<td></td>
											<c:choose>
												<c:when test="${studentConvertDto.totalConverScore!=0 }">
													<td id="TotalConvertScore" class="totalColor"></td>										
												</c:when>
												<c:otherwise>
													<td><td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td>만점</td>
											<c:choose>
												<c:when test="${studentConvertDto.korConverScore!=0 }">
													<td id="korConvertMaxScore">${universitySatDetail.convertScoreMax*(universitySatDetail.koreanReflectionRate/100) }</td>
												</c:when>
												<c:otherwise>
													<td id="korConvertMaxScore">0.0</td>
												</c:otherwise>
											</c:choose>
											
											<c:choose>
												<c:when test="${studentConvertDto.matConverScore!=0 }">
													<c:choose>
														<c:when test="${mathBTypeReflectionRate=='수리 가' }">
															<td id="matConvertMaxScore">${universitySatDetail.convertScoreMax*(universitySatDetail.mathBTypeReflectionRate/100) }</td>
														</c:when>
														<c:otherwise>
															<td id="matConvertMaxScore">${universitySatDetail.convertScoreMax*(universitySatDetail.mathATypeReflectionRate/100) }</td>
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<td id="matConvertMaxScore">0.0</td>
												</c:otherwise>
											</c:choose>
											
											
											<c:choose>
												<c:when test="${studentConvertDto.engConverScore!=0 }">
													<td id="engConvertMaxScore">${universitySatDetail.convertScoreMax*(universitySatDetail.englishReflectionRate/100) }</td>
												</c:when>
												<c:otherwise>
													<td id="engConvertMaxScore">0.0</td>
												</c:otherwise>
											</c:choose>
											
											
											<c:choose>
												<c:when test="${studentConvertDto.researchType=='사회탐구' }">
													<td id="researchConvertMaxScore" colspan="2">${universitySatDetail.convertScoreMax*(universitySatDetail.socialReflectionRate/100) }</td>
												</c:when>
												<c:otherwise>
													<td id="researchConvertMaxScore" colspan="2">${universitySatDetail.convertScoreMax*(universitySatDetail.scienceReflectionRate/100) }</td>
												</c:otherwise>
											</c:choose>
											<td></td>
											<td></td>
											<td id="totalConvertMaxScore" class="totalColor"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<br>
							
							<h3>수능진단결과</h3>
							<table class="table tableColor">
								<thead>
									<tr>									
										<td align="center">지원가능점수</td>
										<td align="center">나의 점수</td>
										<td align="center">진단 결과</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td align="center">${universitySatDetail.convertStandardScoreCutline }</td>
										<td align="center">${fn:substring(studentConvertDto.totalConverScore,0,6) }</td>
										
										<c:choose>
											<c:when test="${studentConvertDto.totalConverScore==0 }">
												<td align="center" style="color: red">지원불가</td>									
											</c:when>
											<c:when test="${(studentConvertDto.totalConverScore-universitySatDetail.convertStandardScoreCutline)<(-20) }">
												<td align="center" style="color: red">위험지원</td>									
											</c:when>
											<c:when test="${studentConvertDto.totalConverScore>universitySatDetail.convertStandardScoreCutline }">
												<td align="center" style="color: #3b3">합격안정</td>									
											</c:when>
											<c:otherwise>
												<td align="center" style="color: orange">소신지원</td>									
											</c:otherwise>
										</c:choose>
									</tr>
								</tbody>
							</table>
							<br>
							<!-- 전형 요소 -->
							<div>
								<h3>전형 요소별 반영방법</h3>
								<table class="table tableColor">
									<thead align="center">
										<tr>
											<td>시정단계(비율%)</td>
											<td>수능</td>
											<td>학생부</td>
											<td>면접</td>
											<td>논술</td>
											<td>실기</td>
											<td>기타</td>
											<td>전형합계</td>
										</tr>
									</thead>
									<tbody align="center">
										<tr>
											<td>일괄합산(100%)</td>
											<td>${universitySatDetail.satReflectionRate }</td>
											<td>${universitySatDetail.schoolReportReflectionRate }</td>
											<td>${universitySatDetail.interviewReflectionRate }</td>
											<td>${universitySatDetail.essayReflectionRate }</td>
											<td>${universitySatDetail.practiceReflectionRate }</td>
											<td>${universitySatDetail.etcReflectionRate }</td>
											<td>${universitySatDetail.modelSum }</td>
										</tr>
									</tbody>
								</table>
							</div>
							<br>
							<!-- 수능성적 반영방법 -->
							<div>
								<h3>수능성적 반영방법</h3>
								<table class="table tableColor">
									<thead align="center">
										<tr>
											<td rowspan="3" style="vertical-align: middle;">시정단계(비율%)</td>
											<td rowspan="3" style="vertical-align: middle;">활용지표</td>
											<td rowspan="3" style="vertical-align: middle;">반영영역</td>
											<td colspan="8">영역별 반영비율(%)</td>
											<td rowspan="3" style="vertical-align: middle;">탐구반영과목수</td>
										</tr>
										
										<tr>
											<td rowspan="2" style="vertical-align: middle;">국어</td>
											<td colspan="2">수학</td>
											<td rowspan="2" style="vertical-align: middle;">영어</td>
											<td colspan="2">탐구</td>
											<td rowspan="2" style="vertical-align: middle;">제2외/한문</td>
											<td rowspan="2" style="vertical-align: middle;">한국사</td>
										</tr>
										<tr>
											<td>가</td>
											<td>나</td>
											<td>사탐</td>
											<td>과탐</td>
										</tr>
									</thead>
									
									<tbody align="center">
										<tr>
											<td>일괄합산(100%)</td>
											<td>${universitySatDetail.satScoreUseIndex }</td>
											<td>${universitySatDetail.selectCombination }</td>
											<td>${universitySatDetail.koreanReflectionRate }</td>
											<td>${universitySatDetail.mathBTypeReflectionRate }</td>
											<td>${universitySatDetail.mathATypeReflectionRate }</td>
											<td>${universitySatDetail.englishReflectionRate }</td>
											<td>${universitySatDetail.socialReflectionRate }</td>
											<td>${universitySatDetail.scienceReflectionRate }</td>
											<td></td>
											<td></td>
											<td>${universitySatDetail.researchSubjectNum }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
