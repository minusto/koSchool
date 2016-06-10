<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>대학 세부</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

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
								<img id="universityMark" alt="서울대학교마크"
									src="/resources/img/SeoulUniversityMark.jpg">
								<div id="entranceUniversityInfo">
									<ul class="list-unstyled list-inline">
										<li class="entranceInfoUniversityName">서울대</li>
										<li class="entranceInfoUniversityMajor">국어교육과</li>
										<li id="entrancInfoDetail"><a href="http://www.snu.ac.kr/">홈페이지</a></li>
									</ul>
								</div>
							</div>
							<div id="entranceInfoDiv2">
								<div class="row">
									<div id="entranceInfo1" class="entranceInfo col-md-5 col-sm-12">
										<div class=" panel fresh-color panel-success">
											<div class="panel-heading entranceInfoPanelHead">
												<h3>정시</h3>
											</div>
											<div class="panel-body">
												<ul id="mockTestUl" class="list-unstyled">
													<li>정시 모집 인원<span id="mockTestRecruitNum">12</span></li>
													<li>정시 커트라인<span id="mockTestRecruitNum">526.8</span></li>
													<li>현재 이 대학 목표자<span id="mockTestNowHopeThis">214</span></li>
													<li>작년 정시 목표율<span id="lastMockTestRate">15/231</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div id="entranceInfoBlank"
										class="col-md-1 hidden-sm hidden-xs">
										<p></p>
									</div>
									<div id="entranceInfo2"
										class="entranceInfo col-md-5 col-md-offset-1 col-sm-12">
										<div class=" panel fresh-color panel-info">
											<div class="panel-heading entranceInfoPanelHead">
												<h3>수시</h3>
											</div>
											<div class="panel-body">
												<ul id="totalExamUl" class="list-unstyled">
													<li>수시 모집 인원<span id="totalExamRecruitNum">15</span></li>
													<li>수시 커트라인<span id="totalExamRecruitNum">1.6</span></li>
													<li>현재 이 대학 목표자<span id="totalExamNowHopeThis">283</span></li>
													<li>작년 수시 목표율<span id="lastTotalExamRate">17/295</span></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="entranceInfoChangeDiv">
								<h3>작년대비 모집요강 변경사항</h3>
								<div id="entranceInfoChange">
									<div class="row">
										<div id="entranceInfo3"
											class="entranceInfo table-responsive col-md-5 col-sm-12">
											<table class="table table-striped">
												<tr>
													<th>정시</th>
													<th>작년</th>
													<th>현재</th>
												</tr>
												<!-- 데이터 들어갈 곳 -->
												<tr>
													<td id="entranceChangeName">모집인원</td>
													<td>15</td>
													<td>12</td>
												</tr>
												<!--  -->
											</table>
										</div>
										<div id="entranceInfoBlank"
											class="col-md-1 hidden-sm hidden-xs"></div>
										<div id="entranceInfo4"
											class="entranceInfo table-responsive col-md-5 col-md-offset-1 col-sm-12">
											<table class="table table-striped">
												<tr>
													<th>수시</th>
													<th>작년</th>
													<th>현재</th>
												</tr>
												<!--  -->
												<tr>
													<td id="entranceChangeName">모집인원</td>
													<td>17</td>
													<td>15</td>
												</tr>
												<!--  -->
											</table>
										</div>
									</div>
								</div>
							</div>
							<br>
							<!-- 성적 상세비교 테이블 -->
							<div>
								<h3>모의고사성적 산출</h3>
								<table class="table">
									<thead align="center">
										<tr>
											<td rowspan="2" style="vertical-align: middle;">분류</td>
											<td rowspan="2" style="vertical-align: middle;">사정단계(비율%)</td>
											<td rowspan="2" style="vertical-align: middle;">구분</td>
											<td rowspan="2" style="vertical-align: middle;">국어</td>
											<td rowspan="2" style="vertical-align: middle;">수학</td>
											<td rowspan="2" style="vertical-align: middle;">영어</td>
											<td colspan="2">탐구영역</td>
											
											<td rowspan="2" style="vertical-align: middle;">제2외</td>
											<td rowspan="2" style="vertical-align: middle;">한국사</td>
											<td rowspan="2" style="vertical-align: middle;">합계</td>
										</tr>
										<tr>
											
											<td>탐구과목명1</td>
											<td>탐구과목명2</td>
											
										</tr>
									</thead>
									<tbody align="center">
										
										<tr>
											<td colspan="2" rowspan="3" style="vertical-align: middle;">나의 수능성적</td>
											
											<td>표준점수</td>
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
											<td>백분위</td>
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
											<td>등급</td>
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
											<td rowspan="4" style="vertical-align: middle;">환산점수</td>
											<td rowspan="4" style="vertical-align: middle;">일괄합산(100%)</td>
											<td>나의 점수</td>
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
											<td>만점</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<br>
							<!-- 전형 요소 -->
							<div>
								<h3>전형 요소별 반영방법</h3>
								<table class="table">
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
											<td>임시1</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<br>
							<!-- 수능성적 반영방법 -->
							<div>
								<h3>수능성적 반영방법</h3>
								<table class="table">
									<thead align="center">
										<tr>
											<td rowspan="3" style="vertical-align: middle;">시정단계(비율%)</td>
											<td rowspan="3" style="vertical-align: middle;">활용지표</td>
											<td rowspan="3" style="vertical-align: middle;">반영영역</td>
											<td colspan="9">영역별 반영비율(%)</td>
											<td rowspan="3" style="vertical-align: middle;">탐구반영과목수</td>
										</tr>
										
										<tr>
											<td rowspan="2" style="vertical-align: middle;">국어</td>
											<td colspan="2">수학</td>
											<td rowspan="2" style="vertical-align: middle;">영어</td>
											<td colspan="3">탐구</td>
											<td rowspan="2" style="vertical-align: middle;">제2외/한문</td>
											<td>한국사</td>
										</tr>
										<tr>
											<td>가</td>
											<td>나</td>
											<td>사탐</td>
											<td>과탐</td>
											<td>직탐</td>
										</tr>
									</thead>
									
									<tbody align="center">
										<tr>
											<td>임시2</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
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
​
