<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>대학 세부</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/resources/css/ghi.css">
<style type="text/css">
#center{
	text-align:center; 
	vertical-align:middle;
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
						<div class="table-responsive col-md-8 col-md-offset-2">
							<table class="mTable" width="100%">
								<colgroup>
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
								</colgroup>
								<tbody>
									<tr>
										<td class="tdTop" valign="middle" align="center" rowspan="5">
											<img width="130" height="130"
											src="http://img.uway.com/univ/logo3/LOGO1_01201.gif">
										</td>
										<th>대학명</th>
										<td class="tdTop">${susiInfoVO.universityName }</td>
										<th>모집단위</th>
										<td class="tdTop">${susiInfoVO.majorName }</td>
									</tr>
									<tr>
										<th>대학구분</th>
										<td>4년제</td>
										<th>설립구분</th>
										<td>사립대</td>
									</tr>
									<tr>
										<th>전형유형</th>
										<td>학생부위주(교과)</td>
										<th>지역구분</th>
										<td>${susiInfoVO.universityLocal }</td>
									</tr>
									<tr>
										<th>전형명</th>
										<td>교과우수자</td>
										<th>모집인원</th>
										<td>${susiInfoVO.recruitNum }명</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<br>
					<!-- 전형 요소 -->
					<div class="row">
						<div class="table-responsive col-md-8 col-md-offset-2">
							<h3>전형 요소별 반영비율</h3>
							<table class="table">
								<thead align="center">
									<tr>
										<th id="center">사정비율</th>
										<th id="center">학생부</th>
										<th id="center">면접</th>
										<th id="center">논술</th>
										<th id="center">실기</th>
										<th id="center">기타</th>
										<th id="center">전형합계</th>
									</tr>
								</thead>
								<tbody align="center">
									<tr>
										<td>${susiInfoVO.recruitModelType }</td>
										<td>${susiDetailDTO.schoolreportreflectionrate }</td>
										<td>${susiDetailDTO.practicereflectionrate }</td>
										<td>${susiDetailDTO.interviewreflectionrate }</td>
										<td>${susiDetailDTO.essayreflectionrate }</td>
										<td>${susiDetailDTO.aptitudereflectionrate }</td>
										<td>100</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="table-responsive col-md-8 col-md-offset-2">
							<!-- 수능성적 반영방법 -->
							<h3>학생부 반영비율</h3>
							<table class="table">
								<thead align="center">
									<tr>
										<th id="center" rowspan="2" style="vertical-align: middle;">반영비율</th>
										<th id="center">1학년</th>
										<th id="center">2학년</th>
										<th id="center">3학년</th>
										<th id="center">학생부 교과 반영 비율</th>
										<th id="center">학생부성적 반영교과</th>
									</tr>
								</thead>
								<tbody align="center">
									<tr>
										<td>재학생</td>
										<td rowspan="2" id="center">20%</td>
										<td rowspan="2" id="center">40%</td>
										<td rowspan="2" id="center">40%</td>
										<td rowspan="2" id="center">-</td>
										<td rowspan="2" id="center">${susiInfoVO.reflectionSubjects }</td>
									</tr>
									<tr>
										<td>졸업생</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
​
