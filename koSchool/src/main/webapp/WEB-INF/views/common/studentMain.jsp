<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body class="flat-blue">
   <div class="app-container">
        <div class="row content-container">
            <jsp:include page="studentMenu.jsp"/>
            <!-- 메인 컨텐츠  -->
    		<div class = "container-fluid">
    			<div class = "side-body">
    				<div class = "page-title">
    					<span class="title">${grade }</span>
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
                                                        <div class="pricing">성적 조회</div>
                                                        <div class="pricing-type"></div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>내신 성적 조회</li>
                                                        <li>모의고사 성적 조회</li>
                                                        <li>&nbsp;</li>
                                                        <li>&nbsp;</li>
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
																	<h4 id="myModalLabel" class="modal-title">성적 조회</h4>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="studentListScore.jsp">
																			<h3>내신 성적 조회</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="studentListMockTestScore.jsp?studentId=${id}">
																			<h3>모의고사 성적 조회</h3>
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
                                                        <div class="pricing">진학 시뮬레이션</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                   		<li>수시 시뮬레이션</li>
                                                        <li>정시 시뮬레이션</li>
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
																	<h4 id="myModalLabel" class="modal-title">진학 시뮬레이션</h4>
																</div>
																<div class="modal-body"> 
																	<div class="row">
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="studentTotalExamSimulation.jsp">
																			<h3>수시 시뮬레이션</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="studentMockTestSimulation.jsp">
																			<h3>정시 시뮬레이션</h3>
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
                                                        <div class="pricing">학교생활</div>
                                                    </div>
                                                </div>
                                                <div class="pt-body">
                                                    <ul class="plan-detail">
                                                        <li>시간표 조회</li>
                                                        <li>식단표 조회</li>
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
																	<h4 id="myModalLabel" class="modal-title">학교생활</h4>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="studentTimetable.jsp">
																			<h3>시간표 조회</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																			<a href="#">
																			<h3>식단표 조회</h3>
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
                                                        <li>가정 통신문 조회</li>
                                                        <li>학급 게시판</li>
                                                        <li>일정</li>
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
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="studentNoticeBoardList.jsp">
																			<h3>교내 공지사항</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="parentNoticeBoardList.jsp">
																			<h3>가정 통신문 조회</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
																			<a href="studentClassBoardList.jsp">
																			<h3>학급 게시판</h3>
																			</a>
																		</div>
																		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
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
    			</div>
    		</div>
      	</div>
    </div>
    

</body>

</html>
​
