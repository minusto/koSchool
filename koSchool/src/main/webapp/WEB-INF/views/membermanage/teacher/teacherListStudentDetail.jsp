<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
	<!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
    	$(function(){
    		$('#correctionOk').on('click','#correction',function(){
    			$('input[id=inputPassword3]').attr("readonly",false);
    			$('#correction').css("display","none");
    			$('#del').css("display","none");
    			$('#commitGo').css("display","inline");
    			$('#cancelGo').css("display","inline");
    			
    			$('#pic').css("display","inline");
    		})
    		$('#correctionOk').on('click','#cancelGo',function(){
    			$('input[id=inputPassword3]').attr("readonly",true);
    			$('#commitGo').css("display","none");
    			$('#cancelGo').css("display","none");
    			$('#correction').css("display","inline");
    			$('#del').css("display","inline");
    		})
    		$('#deleteOk').click(function(){
    			location.href="deleteStudent?m_id=${student.memberId}";
    		})
    		
    			$('#cancelGo').click(function(){
    				$('#pic').css("display","none");
    		})
    	})
    </script>
</head>
<style type="text/css">
	.card_wan{
		background-color: #FFF;
  		border-radius: 1px;
  		overflow: hidden;
  		position: relative;
  		width: 800px;
  		height: 800px;
	}
	#pic{
	display: none;
	}
</style>
<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="../../common/teacherMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                	<div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">${student.memberName} 학생 정보</div>
                                    </div>
                                    <div class="pull-right card-action">
                                        <div class="btn-group" role="group" aria-label="...">
                                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalCardProfileExample"><i class="fa fa-code"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="row no-margin col-xs-12">
                                    	<div class="col-md-1 ">
                                        </div>
                                        <div class="col-md-2">
                                       
                                            <div class="card profile">
                                                <div class="card-profile-img">

<%--                                                     <img src="upload/${student.studentPicture }"> --%>
                                                    <c:if test="${student.studentPicture!=null }">
														<c:set var="head" value="${fn:substring(student.studentPicture,0,fn:length(student.studentPicture)-4) }"></c:set>
														<c:set var="pattern" value="${fn:substringAfter(student.studentPicture,head) }"></c:set>
														<li class="profile-img"><img src="upload/${ head}_resize${pattern}"class="profile-img"></li>
													</c:if>

                                                </div>
                                                
                                            </div>
                                            <div class=" col-md-12">
                                                <br>
                                                </div>
                                                
                                        </div>
                                        <div class="col-md-4 col-xs-12">
                                        </div>
                                    </div>
                                    <form class="form-horizontal" action="correctionStudent" method="post" enctype="multipart/form-data">
                                    		<div class="col-md-2"></div>
                                    		<div class="col-md-3"id="pic">
	                                                <label  class='control-label col-lg-2'>사진</label><input type='file' class='form-control' name='file' >
	                                                </div>	
	                                                <div class="col-xs-12">
	                                                <br><br>
	                                                </div>
                                    	<div class="col-xs-12">
                                    		<div class="form-inline">
												<div class="col-md-5 col-xs-12" >
													
													<label for="inputPassword3" class="control-label col-lg-2">학생ID</label>
													<input id="inputPassword2" class="form-control" type="text" value="${student.memberId}" name="memberId" readonly="readonly">
													<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">이름</label>
                                                	<input type="text" class="form-control" id="inputPassword3" value="${student.memberName}" name="memberName" readonly="readonly">
                                        			<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">생년월일</label>
                                                	<input type="date" class="form-control" id="inputPassword3" value="<fmt:formatDate value="${student.memberBirthday}" pattern="yyyy-MM-dd"/>" name="memberBirthday" readonly="readonly">
                                          	 		<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">주소</label>
                                               	 	<input type="text" class="form-control" id="inputPassword3" value="${student.memberAddress}" name="memberAddress" readonly="readonly">
                                           		 	<br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2">전화번호</label>
                                                    <input type="text" class="form-control" id="inputPassword3" value="${student.memberTel}" name="memberTel" readonly="readonly">
                                           		 	<br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2">이메일</label>
                                           			<input type="email" class="form-control" id="inputPassword3" value="${student.memberEmail}" name="memberEmail" readonly="readonly">
                                           			<br>
                                           			<label for="inputPassword3" class="control-label col-lg-2">학교ID</label>
                                            		<input type="text" class="form-control" id="inputPassword3" value="${student.schoolId}" name="schoolId" readonly="readonly">
                                        		</div>
												<div class="col-md-5 col-xs-12">
											 		<label for="inputEmail3" class="control-label col-lg-2">학번</label>
                                           		 	<input type="text" class="form-control" id="inputPassword3" value="${student.studentCode}" name="studentCode" readonly="readonly">
                                        			<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">학년</label>
                                                	<input type="text" class="form-control" id="inputPassword3" value="${student.studentGrade}" name="studentGrade" readonly="readonly">
                                        			<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">반</label>
                                                	<input type="text" class="form-control" id="inputPassword3" value="${student.studentClass}" name="studentClass" readonly="readonly">
                                          	 		<br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">출석번호</label>
                                               	 	<input type="text" class="form-control" id="inputPassword3" value="${student.studentNum}" name="studentNum" readonly="readonly">
                                           		 	<br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2">성별</label>
                                                    <input type="text" class="form-control" id="inputPassword3" value="${student.studentGender}" name="studentGender" readonly="readonly">
                                           		 	<br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2">학과</label>
                                           			<input type="text" class="form-control" id="inputPassword3" value="${student.studentMajor}" name="studentMajor" readonly="readonly">
                                           			<br>
                                           			<label for="inputPassword3" class="control-label col-lg-2">비고</label>
                                            		<input type="text" class="form-control" id="inputPassword3" value="${student.memberNote}" name="memberNote" readonly="readonly">
                                        			<!-- 이미지사진 파일 -->
<%--                                         			<input type="hidden" class="form-control" id="inputPassword3" value="${student.studentPicture}" name="studentPicture" readonly="readonly"> --%>
                                        			
                                        		</div>
											</div>
                                    	</div>
                                        <div class="col-xs-12">
                                        <br><br>
                                            <div class="col-md-3 col-xs-12">
                                                <button type="button" class="btn btn-default" onclick="location.href='teacherListStudent.jsp'">이전페이지</button>
                                            </div>
                                            <div class="col-md-3 col-xs-12">
                                                <button class="btn btn-primary btn-success" data-target="#modalSuccess" data-toggle="modal" type="button"> 성적조회 </button>
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
																			<a href="studentListScore?id=${student.memberId }">
																			<h3>내신 성적 조회</h3>
																			</a>
																		</div>
																		<div class="col-sm-6 col-xs-12" style="text-align:center;">
																		<a href="mockTestList?id=${student.memberId }">
																			
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
                                            <div class="col-md-3 col-xs-12" id="correctionOk">
                                            	<!--수정 Button-->
                                                <input type="button" class="btn btn-primary btn-primary" id="correction" value="수정">
                                                <!--삭제 Button trigger modal -->
                                        		<input type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary" id="del" value="삭제">
                                        		<!-- 수정 완료 -->
                                        		<input type="submit" class="btn btn-primary btn-primary" id="commitGo" style="display:none" value="완료">
                                        		<!--수정 취소  -->
                                        		<input type="button" class="btn btn-primary btn-primary" id="cancelGo" style="display:none" value="취소">
                                        		<!--삭제 알림 Modal -->
                                        		<div class="modal fade modal-primary" id="modalPrimary" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            		<div class="modal-dialog">
                                                		<div class="modal-content">
                                                    		<div class="modal-header">
                                                        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        		<h4 class="modal-title" id="myModalLabel">알림창</h4>
                                                    		</div>
                                                    		<div class="modal-body">
                                                        		정말 삭제하시겠습니까?	
                                                        	</div>
                                                    		<div class="modal-footer">
                                                        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                        		<button type="button" class="btn btn-primary" id="deleteOk">OK</button>
                                                    		</div>
                                                		</div>
                                            		</div>
                                        		</div>
                                            </div>
                                        </div>
                                    </form>
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