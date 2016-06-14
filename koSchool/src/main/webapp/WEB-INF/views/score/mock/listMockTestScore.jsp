<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>모의고사 점수확인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<script type="text/javascript">
	$(function() {
		$("#selectMock").change(function() {
			var mockId = $(this).val();
			var studentId = $("#studentId").attr('value');
			location.href = "mockTestDetail?id=" + studentId+ "&mockId=" + mockId;
		})
	})
</script>
</head>

<body class="flat-blue">
	<input type="hidden" id="studentName" value="${studentName }">
	<div class="row">
		<input type="hidden" name="studentId" id="studentId"
			value="${studentId }">
		<!-- 언어 차트  START -->
		<c:forEach items="${ selectMyKorScoreList}" var="list" varStatus="status" >
			<input id="myKorScore${status.index}" type="hidden"
				value="${list.languageOriginalScore }">
			<c:forEach items="${ selectMockKorAvgScoreList}" var="list1" varStatus="status1">
				<c:if test="${list.mockId == list1.mockId }">
					<input id="mockKorAvg${status1.index}" type="hidden" value="${list1.avg }">
				</c:if>
			</c:forEach>
		</c:forEach>
		<!-- 언어 차트 END -->
		<!-- 수리 차트  START -->
		<c:forEach items="${ selectMyMathScoreList}" var="list" varStatus="status" >
			<input id="myMathScore${status.index}" type="hidden"
				value="${list.mathOriginalScore }">
			<c:forEach items="${ selectMockMathAvgScoreList}" var="list1" varStatus="status1">
				<c:if test="${list.mockId == list1.mockId }">
					<input id="mockMathAvg${status1.index}" type="hidden" value="${list1.avg }">
				</c:if>
			</c:forEach>
		</c:forEach>
		<!-- 수리 차트 END -->
		<!-- 외국어 차트  START -->
		<c:forEach items="${ selectMyEngScoreList}" var="list" varStatus="status" >
			<input id="myEngScore${status.index}" type="hidden"
				value="${list.englishOriginalScore }">
			<c:forEach items="${ selectMockEngAvgScoreList}" var="list1" varStatus="status1">
				<c:if test="${list.mockId == list1.mockId }">
					<input id="mockEngAvg${status1.index}" type="hidden" value="${list1.avg }">
				</c:if>
			</c:forEach>
		</c:forEach>
		<!-- 외국어 차트 END -->
		
		
		
		
		<div class="col-md-12">
			<h3>모의고사성적</h3>
			<label>${studentDetail.studentGrade}학년
				${studentDetail.studentClass }반 ${studentDetail.memberName }</label> <select
				style="width: 250px" id="selectMock">
				<c:forEach var="list" items="${mockList }">
					<c:if test="${mockId == list.mockId }">
						<option id="selectNowMock" value="${list.mockId }">${list.mockYear }년도 ${list.mockGrade }학년 ${list.mockMonth }월 모의고사</option>
					</c:if>
				</c:forEach>
				<c:forEach var="list" items="${mockList }" varStatus="status">
					<option id="mockName${status.index }" value="${list.mockId }">${list.mockYear }년도 ${list.mockGrade }학년 ${list.mockMonth }월 모의고사</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 table-responsive">
			<div class="sub-title">
				<span class="description"></span>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th colspan="2" rowspan="2">영역</th>
						<th colspan="2">원점수</th>
						<th colspan="2">표준점수</th>
						<th colspan="4">표준점수에 의한 석차/백분위/등급</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2"></td>
						<td>배점</td>
						<td>득점</td>
						<td>범위</td>
						<td>득점</td>
						<td>학급석차</td>
						<td>학교석차</td>
						<td>전국백분위</td>
						<td>등급</td>
					</tr>

					<!-- 			성적표 예시 나중에 DB연동 			-->

					<tr>
						<c:forEach var="list" items="${mockScoreDetailList }">
							<c:if test="${list.mockId == mockId }">
								<c:if test="${list.languageType==null }">
									<td colspan="2">언어</td>
								</c:if>
								<c:if test="${list.languageType!=null }">
									<td colspan="2">${list.languageType }</td>
								</c:if>
								<td>100</td>
								<td>${list.languageOriginalScore }</td>
								<td>200</td>
								<td>${list.languageStandardScore }</td>
								<td>${languageClassRank }</td>
								<td>${languageSchoolRank }</td>
								<td>${list.languagePercentile }</td>
								<td><c:choose>
										<c:when test="${list.languagePercentile>=96 }">
														1
													</c:when>
										<c:when
											test="${list.languagePercentile>=89&&list.languagePercentile<96 }">
														2
													</c:when>
										<c:when
											test="${list.languagePercentile>=77&&list.languagePercentile<89 }">
														3
													</c:when>
										<c:when
											test="${list.languagePercentile>=60&&list.languagePercentile<77 }">
														4
													</c:when>
										<c:when
											test="${list.languagePercentile>=40&&list.languagePercentile<60 }">
														5
													</c:when>
										<c:when
											test="${list.languagePercentile>=23&&list.languagePercentile<40 }">
														6
													</c:when>
										<c:when
											test="${list.languagePercentile>=11&&list.languagePercentile<23 }">
														7
													</c:when>
										<c:when
											test="${list.languagePercentile>=4&&list.languagePercentile<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</c:if>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="list" items="${mockScoreDetailList }">
							<c:if test="${list.mockId == mockId }">
								<c:if test="${list.mathType==null }">
									<td colspan="2">수리</td>
								</c:if>
								<c:if test="${list.mathType!=null }">
									<td colspan="2">${list.mathType }</td>
								</c:if>
								<td>100</td>
								<td>${list.mathOriginalScore }</td>
								<td>200</td>
								<td>${list.mathStandardScore }</td>
								<td>${mathClassRank }</td>
								<td>${mathSchoolRank }</td>
								<td>${list.mathpercentile }</td>
								<td><c:choose>
										<c:when test="${list.mathpercentile>=96 }">
														1
													</c:when>
										<c:when
											test="${list.mathpercentile>=89&&list.mathpercentile<96 }">
														2
													</c:when>
										<c:when
											test="${list.mathpercentile>=77&&list.mathpercentile<89 }">
														3
													</c:when>
										<c:when
											test="${list.mathpercentile>=60&&list.mathpercentile<77 }">
														4
													</c:when>
										<c:when
											test="${list.mathpercentile>=40&&list.mathpercentile<60 }">
														5
													</c:when>
										<c:when
											test="${list.mathpercentile>=23&&list.mathpercentile<40 }">
														6
													</c:when>
										<c:when
											test="${list.mathpercentile>=11&&list.mathpercentile<23 }">
														7
													</c:when>
										<c:when
											test="${list.mathpercentile>=4&&list.mathpercentile<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</c:if>
						</c:forEach>

					</tr>
					<tr>
						<td colspan="2">외국어</td>
						<c:forEach var="list" items="${mockScoreDetailList }">
							<c:if test="${list.mockId == mockId }">
								<td>100</td>
								<td>${list.englishOriginalScore }</td>
								<td>200</td>
								<td>${list.englishStandardScore }</td>
								<td>${englishClassRank }</td>
								<td>${englishSchoolRank }</td>
								<td>${list.englishpercentile }</td>
								<td><c:choose>
										<c:when test="${list.englishpercentile>=96 }">
														1
													</c:when>
										<c:when
											test="${list.englishpercentile>=89&&list.englishpercentile<96 }">
														2
													</c:when>
										<c:when
											test="${list.englishpercentile>=77&&list.englishpercentile<89 }">
														3
													</c:when>
										<c:when
											test="${list.englishpercentile>=60&&list.englishpercentile<77 }">
														4
													</c:when>
										<c:when
											test="${list.englishpercentile>=40&&list.englishpercentile<60 }">
														5
													</c:when>
										<c:when
											test="${list.englishpercentile>=23&&list.englishpercentile<40 }">
														6
													</c:when>
										<c:when
											test="${list.englishpercentile>=11&&list.englishpercentile<23 }">
														7
													</c:when>
										<c:when
											test="${list.englishpercentile>=4&&list.englishpercentile<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</c:if>
						</c:forEach>
					</tr>

					<c:forEach items="${koreaHistroyScoreList }" var="list">
						<c:if test="${list.mockId == mockId }">
							<tr>
								<td colspan="2">한국사</td>
								<td>100</td>
								<td>${list.researchSubjectOriginalScore }</td>
								<td>200</td>
								<td>${list.researchSubjectStandardScore }</td>
								<td>${koreaHistorySubjectClassRank }</td>
								<td>${koreaHistorySubjectSchoolRank }</td>
								<td>${list.researchSubjectPercentile }</td>
								<td><c:choose>
										<c:when test="${list.researchSubjectPercentile>=96 }">
														1
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=89&&list.researchSubjectPercentile<96 }">
														2
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=77&&list.researchSubjectPercentile<89 }">
														3
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=60&&list.researchSubjectPercentile<77 }">
														4
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=40&&list.researchSubjectPercentile<60 }">
														5
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=23&&list.researchSubjectPercentile<40 }">
														6
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=11&&list.researchSubjectPercentile<23 }">
														7
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile>=4&&list.researchSubjectPercentile<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</tr>
						</c:if>

					</c:forEach>

					<tr>
						<td rowspan="2">탐구영역</td>
						<c:forEach items="${researchScoreList }" var="list">
							<c:if test="${list.memberId == studentId }">
								<c:forEach items="${researchSubjectList }" var="list1">
									<c:if
										test="${list1.researchSubjectId == list.researchSubjectId1  }">
										<td>${list1.researchSubjectName }</td>
									</c:if>

								</c:forEach>
								<td>50</td>
								<td>${list.researchSubjectOriginalScore1 }</td>
								<td>200</td>
								<td>${list.researchSubjectStandardScore1 }</td>
								<td>${researchSubject1ClassRank }</td>
								<td>${researchSubjectSchoolRank1 }</td>
								<td>${list.researchSubjectPercentile1 }</td>
								<td><c:choose>
										<c:when test="${list.researchSubjectPercentile1>=96 }">
														1
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=89&&list.researchSubjectPercentile1<96 }">
														2
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=77&&list.researchSubjectPercentile1<89 }">
														3
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=60&&list.researchSubjectPercentile1<77 }">
														4
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=40&&list.researchSubjectPercentile1<60 }">
														5
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=23&&list.researchSubjectPercentile1<40 }">
														6
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=11&&list.researchSubjectPercentile1<23 }">
														7
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile1>=4&&list.researchSubjectPercentile1<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</c:if>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach items="${researchScoreList }" var="list">
							<c:if test="${list.memberId == studentId }">
								<c:forEach items="${researchSubjectList }" var="list1">
									<c:if
										test="${list1.researchSubjectId == list.researchSubjectId2  }">
										<td>${list1.researchSubjectName }</td>
									</c:if>

								</c:forEach>
								<td>50</td>
								<td>${list.researchSubjectOriginalScore2 }</td>
								<td>200</td>
								<td>${list.researchSubjectStandardScore2 }</td>
								<td>${researchSubject1ClassRank }</td>
								<td>${researchSubjectSchoolRank2 }</td>
								<td>${list.researchSubjectPercentile2 }</td>
								<td><c:choose>
										<c:when test="${list.researchSubjectPercentile2>=96 }">
														1
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=89&&list.researchSubjectPercentile2<96 }">
														2
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=77&&list.researchSubjectPercentile2<89 }">
														3
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=60&&list.researchSubjectPercentile2<77 }">
														4
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=40&&list.researchSubjectPercentile2<60 }">
														5
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=23&&list.researchSubjectPercentile2<40 }">
														6
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=11&&list.researchSubjectPercentile2<23 }">
														7
													</c:when>
										<c:when
											test="${list.researchSubjectPercentile2>=4&&list.researchSubjectPercentile2<11 }">
														8
													</c:when>
										<c:otherwise>
														9
													</c:otherwise>
									</c:choose></td>
							</c:if>
						</c:forEach>
					</tr>
					<!-- 제2외국어 -->
					<c:forEach items="${mockScoreDetailList }" var="list">
						<c:if test="${list.mockId == mockId }">
							<c:if
								test="${(!(list.languageId eq 'secondLang00'))&&(list.languageId!=null)}">
								<tr>
									<td>제2외국어</td>
									<td>${list.languageSubjectName }</td>
									<td>100</td>
									<td>${list.secondLanguageOriginalScore }</td>
									<td>200</td>
									<td>${list.secondLanguageStandardScore }</td>
									<td>${secondLanguageClassRank }</td>
									<td>${secondLanguageSchoolRank }</td>
									<td>${list.secondLanguagePercentile }</td>
									<td><c:choose>
											<c:when test="${list.secondLanguagePercentile>=96 }">
														1
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=89&&list.secondLanguagePercentile<96 }">
														2
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=77&&list.secondLanguagePercentile<89 }">
														3
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=60&&list.secondLanguagePercentile<77 }">
														4
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=40&&list.secondLanguagePercentile<60 }">
														5
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=23&&list.secondLanguagePercentile<40 }">
														6
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=11&&list.secondLanguagePercentile<23 }">
														7
													</c:when>
											<c:when
												test="${list.secondLanguagePercentile>=4&&list.secondLanguagePercentile<11 }">
														8
													</c:when>
											<c:otherwise>
														9
													</c:otherwise>
										</c:choose></td>
								</tr>
							</c:if>
						</c:if>

					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>
	<!-- Chart JS -->
	<div class="row">
	
	<!-- 언어 차트 START -->
		<div class="col-sm-4 col-xs-12">
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<div class="title">과목별 비교분석 차트 - 언어</div>
					</div>
				</div>
				<div class="card-body no-padding">
					<canvas id="line-chart" class="chart"></canvas>
				</div>
				<div class="card">
					<div class="card-header">
						<div class="card-title">
							<div class="title">학년평균 대비 분석</div>
						</div>
					</div>
					<div class="card-body no-padding">
						<c:forEach var="list" items="${mockList }" varStatus="status">
							<p id="mockKorScore${status.index }"></p>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!-- 언어 차트 END -->
		
		<!-- 수리 차트 START -->
		<div class="col-sm-4 col-xs-12">
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<div class="title">과목별 비교분석 차트 - 수리</div>
					</div>
				</div>
				<div class="card-body no-padding">
					<canvas id="line-math" class="chart"></canvas>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<div class="title">학년 평균 대비 분석</div>
					</div>
				</div>
				<div class="card-body no-padding">
					<c:forEach var="list" items="${mockList }" varStatus="status">
						<p id="mockMathScore${status.index }"></p>
					</c:forEach>
				</div>
			</div>
			<div>
				<div></div>
			</div>
		</div>
		<!-- 수리 차트 END -->
		
		<!-- 외국어 차트 START -->
		<div class="col-sm-4 col-xs-12">
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<div class="title">과목별 비교분석 차트 -외국어</div>
					</div>
				</div>
				<div class="card-body no-padding">
					<canvas id="chartEng" class="chart"></canvas>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<div class="card-title">
						<div class="title">학년 평균 대비 분석</div>
					</div>
				</div>
				<div class="card-body no-padding">
					<c:forEach var="list" items="${mockList }" varStatus="status">
						<p id="mockEngScore${status.index }"></p>
					</c:forEach>
				</div>
			</div>
			<div>
				<div></div>
			</div>
		</div>	
		<!-- 외국어 차트 END -->
		
		<br><br>
		<div align="center">
			<button class="btn btn-primary btn-success" onclick="location.href='/mockSimulation?studentId=${studentId}'" style="font-family: 'Jeju Gothic' ">정시 시뮬레이션</button>
		</div>
		
	</div>
	<script type="text/javascript" src="/resources/js/MockTestchartjs.js"></script>

</body>
</html>