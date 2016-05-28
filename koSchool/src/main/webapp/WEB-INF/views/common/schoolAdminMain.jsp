<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", "Main");
%>
<!DOCTYPE html>
<html>
 
<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css" href="/resources/lib/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/animate.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/select2.min.css">
<!-- CSS App -->
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/themes/flat-blue.css">
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
		<jsp:include page="schoolAdminMenu.jsp"/>
		
		<!-- 메인 컨텐츠 -->
			<div class = "container-fluid">
    			<div class = "side-body">
    				<div class = "page-title">
    					<div class="page-title">
    						<span class="title">관리자 메뉴</span>
    					</div>
    					<div class="row">
    						<div >
    							<div class="card">
    							<div class="col-lg-2"></div>
                                <div class="card-body col-lg-10">
                                    <div class="row no-margin no-gap">
                                        <div class="col-sm-3">
                                            <div class="pricing-table green">
                                                <div class="pt-header">
                                                    <div class="plan-pricing">
                                                        <div class="pricing">학교관리</div>
                                                        <div class="pricing-type"></div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>학교등록</li>
                                                        <li>학교 정보 조회</li>
                                                        <li>사용자ID 등록</li>
                                                        <li>사용자ID 목록</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-success" data-target="#modalSuccess" data-toggle="modal" type="button"> 선택</button>
                                                	<div id="modalSuccess" class="modal fade modal-success" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">학교관리</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminInsertSchoolForm.jsp">
																			<h3>학교 등록</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolDetail.jsp">
																			<h3>학교 정보조회</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminInsertUserIdForm.jsp">
																			<h3>사용자 ID 등록</h3>
																				</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="userIdList.jsp">
																			<h3>사용자 ID 목록</h3>
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
										</div>
                                        <div class="col-sm-3">   
                                            <div class="pricing-table blue">
                                                <div class="pt-header">
                                                    <div class="plan-pricing">
                                                        <div class="pricing">교사 관리</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                   		<li>교사 등록</li>
                                                        <li>교사 목록</li>
                                                        <li>&nbsp;</li>
                                                        <li>&nbsp;</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-info" data-target="#modalInfo" data-toggle="modal" type="button"> 선택</button>
                                                	<div id="modalInfo" class="modal fade modal-info" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">교사 관리</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminInsertTeacherForm.jsp">
																			<h3>교사 등록</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminTeacherList.jsp">
																			<h3>교사 목록</h3>
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
                                        </div>
                                        <div class="col-sm-3">
                                            <div class="pricing-table yellow">
                                                <div class="pt-header">
                                                    <div class="plan-pricing">
                                                        <div class="pricing">게시판관리</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>공지사항</li>
                                                        <li>학사일정</li>
                                                        <li>학급 게시판</li>
                                                        <li>&nbsp;</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-warning" data-target="#modalWarning" data-toggle="modal" type="button"> 선택</button>
													<div id="modalWarning" class="modal fade modal-warning" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">게시판 관리</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminNoticeBoardList.jsp">
																			<h3>공지사항</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="scheduleList.jsp">
																			<h3>학사일정</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="schoolAdminClassBoardList.jsp">
																			<h3>학급 게시판 </h3>
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
                                        </div>
                         
                                    </div>
                                </div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
      	</div>     
	</div>
</div>
	<!-- Javascript Libs -->
	<script type="text/javascript" src="/resources/lib/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/Chart.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/jquery.matchHeight-min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/select2.full.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/ace.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/mode-html.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/theme-github.js"></script>
	<!-- Javascript -->
	<script type="text/javascript" src="/resources/js/app.js"></script>
	<script type="text/javascript" src="/resources/js/index.js"></script>
</body>

</html>
​
