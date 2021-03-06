<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	int semester = 0;
	int size=0;
	int size2=0;
	int size3=0;
	int i = 0;
	int j = 0;
	int k = 0;
	int i2 = 0;
	int j2 = 0;
	int i3 = 0;
	int j3 = 0;
%>
<!DOCTYPE html>
<html>
<head>
<title>내신점수 확인 페이지</title>
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/listScore.js" type="text/javascript"></script>
<script src="/resources/js/nesinChartjs.js" type="text/javascript"></script>
</head>
<body class="flat-blue">
   <div class="app-container">
        <div class="row content-container">
            <c:if test="${grade eq 'teacher' }">
				<jsp:include page="../../common/teacherMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'student' }">
				<jsp:include page="../../common/studentMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'parent' }">
				<jsp:include page="../../common/studentMenu.jsp" />
			</c:if>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div class="row">
						<div class="col-md-12">
							<h3>내신성적</h3>
							<label>${student.studentGrade }학년 ${student.studentClass }반 ${student.memberName }</label>
								<label for="exampleInputName2">&nbsp;&nbsp;</label>
                               		<div class="radio3 radio-check radio-inline">
                                  		<input type="radio" id="radio4" name="subjectGrade" value="1">
                                       	<label for="radio4">1학년</label>
                                   	</div>
                                    <div class="radio3 radio-check radio-inline">
                                    	<input type="radio" id="radio5" name="subjectGrade" value="2">
                                    	<label for="radio5">2학년</label>
                                    </div>
                                    <div class="radio3 radio-check radio-inline">
                                    	<input type="radio" id="radio6" name="subjectGrade" value="3">
                                    	<label for="radio6">3학년</label>
                                    </div>
							<select style="width: 150px" id="selectTerm">
								<option value="default" selected>학기선택</option>
								<option value="1">1학기</option>
								<option value="2">2학기</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div style="display:none">
							<!-- 표준편차-->
							<table>
							<c:forEach var="list" items="${list }">
								<c:if test="${list.subjectGrade == subjectGrade}">
									<tr>
										<td id="stdevSubjectId<%=++size%>">${list.subjectId }</td>
										<td id="stdev<%=++size2%>">${list.subjectTotal }</td>
									</tr>
								</c:if>
							</c:forEach>
							</table>
							<p id="listSize4" style="display:none"><%=size2%></p>
							<!-- 석차와 이수자수-->
							<table>
							<c:forEach var="list" items="${list2 }">
								<c:if test="${id == list.memberId }">
								<tr>
									<td id="rankSubjectId<%=++i2 %>">${list.subjectId}</td>
									<td id="rankSend<%=++j2%>">${list.rank }</td>
								</tr>
								</c:if>
							</c:forEach>
							<c:forEach var="list" items="${list3 }">
								<tr>
									<td id="allStudentSubjectId<%=++i3 %>">${list.subjectId}</td>
									<td id="allStudentNum<%=++j3%>">${list.allStudentNum }</td>
								</tr>
							</c:forEach>
							</table> 
							<!-- for문 size 구하기 위함-->
							<p id="listSize2" style="display:none"><%=i2%></p>
							<p id="listSize3" style="display:none"><%=i3%></p>
							</div>
							<table class="table table-bordered" style="text-align:center" >
								<thead>
									<tr>
										<th rowspan="2" style="text-align:center; vertical-align:middle; width:10%" >교과</th>
										<th rowspan="2" style="text-align:center; vertical-align:middle; width:10%">과목</th>
										<th colspan="7" style="text-align:center" ><b id="chartGrade">${subjectGrade }</b>학년 ${semester }학기</th>
									</tr>
									<tr>
										<td>단위수</td>
										<td>원점수</td>
										<td>과목평균</td>
										<td>표준편차</td>
										<td>학교석차</td>
										<td>석차등급</td>
										<td>이수자수</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${list }">
									<c:if test="${id == list.memberId && subjectGrade == list.subjectGrade}">
									<tr>
										<td id="subjectId<%=++k%>" style="display:none">${list.subjectId }</td>
										<td>${list.subjectType }</td>
										<td id="subjectName<%=k%>">${list.subjectName }</td>
										<td>${list.subjectUnit }</td>
										<td id="originalScore<%=k %>">${list.subjectTotal }</td>
										<td id="avg<%=k%>"><fmt:formatNumber value="${list.subjectAvg }" pattern=".00"/></td>
										<td id="stdevResult<%=++size3%>"></td>
										<td id="ranking<%=++i%>"></td>
										<td id="rating<%=i %>"></td>
										<td id="allStudent<%=++j%>"></td>
									</tr>
									</c:if>
									</c:forEach>
								</tbody>
							</table>
							<!-- for문 size 구하기 위함-->
							<p id="listSize" style="display:none"><%=i%></p>
						</div>
					</div>
						<!-- Chart JS -->
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">과목별 비교분석 차트</div>
                                    </div>
                                </div>
                                <div class="card-body no-padding">
                                    <canvas id="radar-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="card">
                            	<div class="card-header">
                            		<div class="card-title">
                                        <div class="title">과목별 비교분석</div>
                                    </div>
                                </div>
                                <div id="nesinText" class="card-body">
                                </div>
                            </div>
                            <div>
                            	<div>
                            	</div>
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
