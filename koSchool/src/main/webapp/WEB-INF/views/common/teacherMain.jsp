
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
	request.setAttribute("path", "Main");
%>
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
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
    <link rel="stylesheet" type="text/css" href="/resources/css/sangWan.css">
</head>
<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="teacherMenu.jsp"/>
            <!-- 메인 컨텐츠  -->
    		<div class = "container-fluid">
    			<div class = "side-body">
    				<div class = "page-title">
    					<span class="title">교사</span>
    					</div>
    					<div class="row">
    						<div class="col-sm-12">
    							<div class="card">
                                <div class="card-body">
                                    <div class="row no-margin no-gap">
                                        <div class="col-sm-3">
                                            <div class="pricing-table green">
                                                <div class="pt-header">
                                                    <div class="plan-pricing">
                                                        <div class="pricing">학생 관리</div>
                                                        <div class="pricing-type"></div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>학생 정보 입력</li>
                                                        <li>학생 정보 열람</li>
                                                        <li>내신 성적 입력</li>
                                                        <li>모의고사 성적 입력</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-success" data-target="#modalSuccess" data-toggle="modal" type="button"> 선택 </button>
                                                	<div id="modalSuccess" class="modal fade modal-success" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">학생 관리</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="teacherInsertStudentForm.jsp">
																			<h3>학생 정보 입력</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="teacherListStudent.jsp">
																			<h3>학생 정보 열람</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="teacherInsertScoreForm.jsp">
																			<h3>내신 성적 입력</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="teacherInsertMockScoreForm.jsp">
																			<h3>모의고사 성적 입력</h3>
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
                                                        <div class="pricing">학부모 관리</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                   		<li>학부모 정보 입력</li>
                                                        <li>학부모 정보 열람</li>
                                                        <li>&nbsp;</li>
                                                        <li>&nbsp;</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-info" data-target="#modalInfo" data-toggle="modal" type="button"> 선택 </button>
                                                	<div id="modalInfo" class="modal fade modal-info" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" style="display: none;">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">학부모 관리</h4>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="teacherInsertParentForm.jsp">
																			<h3>학부모 정보 입력</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="teacherListParent.jsp">
																			<h3>학부모 정보 열람</h3>
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
                                                        <div class="pricing">가정통신문</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>가정통신문 발송</li>
                                                        <li>가정통신문 조회</li>
                                                        <li>&nbsp;</li>
                                                        <li>&nbsp;</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                    <button class="btn btn-primary btn-warning" data-target="#modalWarning" data-toggle="modal" type="button"> 선택 </button>
													<div id="modalWarning" class="modal fade modal-warning" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">가정통신문</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="teacherInsertNoticeParentForm.jsp">
																			<h3>가정통신문 발송</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="teacherListNoticeParent.jsp">
																			<h3>가정통신문 조회</h3>
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
                                            <div class="pricing-table red">
                                                <div class="pt-header">
                                                    <div class="plan-pricing">
                                                        <div class="pricing">소통공간</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>교내 공지사항</li>
                                                        <li>학급 게시판</li>
                                                        <li>일정</li>
                                                        <li>&nbsp;</li>
                                                    </ul>
                                                </div>
                                                <div class="pt-footer">
                                                	<button class="btn btn-primary btn-danger" data-target="#modalDanger" data-toggle="modal" type="button"> 선택 </button>
													<div id="modalDanger" class="modal fade modal-danger" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
                                                    <div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button class="close" aria-label="Close" data-dismiss="modal" type="button">
																		<span aria-hidden="true">×</span>
																	</button>
																	<h4 id="myModalLabel" class="modal-title">소통공간</h4>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="col-sm-4 col-xs-12" style="text-align:center;">
																			<a href="teacherNoticeBoardList.jsp">
																			<h3>교내 공지사항</h3>
																			</a>
																		</div>
																		<div class="col-sm-4 col-xs-12" style="text-align:center;">
																			<a href="teacherClassBoardList.jsp">
																			<h3>학급 게시판</h3>
																			</a>
																		</div>
																		<div class="col-sm-4 col-xs-12" style="text-align:center;">
																			<a href="scheduleList.jsp">
																			<h3>일정</h3>
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
<!--     				<div class="page-title"> -->
<!--     					<span class="title">일정표</span> -->
<!--     				</div> -->
<!--     				<div class="row"> -->
<!--     					<div class="col-sm-12"> -->
<!--     						<div class="card"> -->
<!-- 								<div class="card-body"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!--     					</div> -->
<!--     				</div> -->
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