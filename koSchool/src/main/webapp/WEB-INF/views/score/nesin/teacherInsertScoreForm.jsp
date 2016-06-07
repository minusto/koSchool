<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	int i = 1;
%>
<html>

<head>
<!-- CSS -->
<style type="text/css">
.jbFixed {
	position: fixed;
	top: 70px;
}
</style>
<!-- jQuery-->
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/createTable.js" type="text/javascript"></script>
</head>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../../common/teacherMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">내신 성적 입력</div>
									</div>
								</div>
								<div class="card-body table-responsive col-xs-9">
									<!-- Table -->
									<form action="subjectScore" method="post">
										<table class="table table-striped">
											<thead>
												<tr class="headings">
													<th rowspan="2">학년</th>
													<th rowspan="2">교과</th>
													<th rowspan="2">과목</th>
													<th colspan="4">
														<select id="selectTerm">
															<option value="default" selected>학기선택</option>
															<option value="1">1학기</option>
															<option value="2">2학기</option>
														</select>
													</th>
												</tr>
												<tr>
													<th>단위수</th>
													<th>중간고사</th>
													<th>기말고사</th>
													<th>수행평가</th>
													<th>삭제</th>
												</tr>
											</thead>
											<tbody id="tbody1">
											</tbody>
										</table>
									<!--페이지 -->
									<div class="col-md-11">
										<div class="col-sm-4">
											<input id="addSubject" type="button" class="btn btn-default" value="과목추가">
										</div>
										<div class="col-sm-7">
										<!-- 테이블 저장 -->
										 <button class="btn btn-primary btn-primary" data-target="#modalSave" data-toggle="modal" type="button"> 저장 </button>
                                                	<div id="modalSave" class="modal fade modal-primary" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">학년별 입력테이블 저장</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row" >
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="firstSave">
																			<h3>1학년</h3>
																			</a>
																		</div>
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="sencondSave">
																			<h3>2학년</h3>
																			</a>
																		</div>
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="thirdSave">
																			<h3>3학년</h3>
																			</a>
																		</div>
																	</div>
																</div>
																<div class="modal-footer">
																</div>
															</div>
														</div>
                                                	</div>
                                        <!-- 테이블 저장 -->
										 <button class="btn btn-primary btn-primary" data-target="#modalLoad" data-toggle="modal" type="button"> 불러오기 </button>
                                                	<div id="modalLoad" class="modal fade modal-primary" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">학년별 입력테이블 불러오기</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row" >
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="firstLoad">
																			<h3>1학년</h3>
																			</a>
																		</div>
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="sencondLoad">
																			<h3>2학년</h3>
																			</a>
																		</div>
																		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
																			<a href="#" id="thirdLoad">
																			<h3>3학년</h3>
																			</a>
																		</div>
																	</div>
																</div>
																<div class="modal-footer">
																</div>
															</div>
														</div>
                                                	</div>
										</div>
									</div>
									<div class="col-md-1">
										<input type="text" name="semester">
										<input type="text" name="memberId">
										<!-- 학년 검사 용도 -->
										<input type="text" id="checkGrade" >
										<input type="submit" name="success" class="btn btn-default" value="완료">
									</div>
									</form>
									<div class="saveFormDiv">
										<form action="saveForm" method="post">
											<input type="text" name ="memberIdS" id="memberIdS" value="${teacher.memberId }">	
											<input type="text" name="subjectGrade" id="subjectGradeS">				
											<input type="submit" id="sendSaveForm">
										</form>
									</div>
								</div>
								<div class="card-body table-responsive col-xs-3">
									<div id="jbMenu"
										style="width: 320px; height: 400px; overflow: auto;">
										<h4>학생 명단</h4>
										<table class="table table-hover"
											style="border: 1px solid #bcbcbc">
											<thead>
												<tr class="headings">
													<th>번호</th>
													<th>학년</th>
													<th>이름</th>
													<th>생년월일</th>
												</tr>
											</thead>
											<tbody id="tbody2">
												<c:forEach var="student" items="${list2 }">
													<tr id="clickTr">
														<td><%=i++%></td>
														<td  id="clickStu" style="display:none">${student.memberId }</td>
														<td  id="clickGrade">${student.studentGrade }학년</td>
														<td>${student.memberName }</td>
														<td><fmt:formatDate
																value="${student.memberBirthday }" pattern="yyyy-MM-dd" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
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
