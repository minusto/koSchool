<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<% int i=1; //이만한게 없음 스클립트에 존재이유임 더 좋은 방법있으면 알려주세요^^ 작성자:김상완 %> 
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
		$(function(){
			var teacherClass=Number($("#teacherClass").val());
			var schoolClass=teacherClass%100;
			var schoolGrade=parseInt(teacherClass/100);
			
			$("#studentGrade").val(schoolGrade);
			$("#studentClass").val(schoolClass);
			
			
			$('tbody').on('click','#clickStu',function(){
				$('input[name=memberId]').val($(this).html());
				$('button[class=close]').trigger('click'); 
			})
			$('tbody #clickStu').on({
				 mouseenter: function(){
				  $(this).css('color','red');
				 },
				 mouseleave: function(){
				  $(this).css('color','#333');
				 }
			})
		})
	</script>
	<style type="text/css">
	.error{
		color: #ff0000;
		
	}
</style>
</head>
<body class="flat-blue">
<input type="hidden" id="teacherClass" value="${teacher.teacherClass}">
    <div class="app-container">
        <div class="row content-container">
        	<jsp:include page="../../common/teacherMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                    <div class="row">
                        <div class="col-xs-12">
                           <div class="card-body">
                                    <form action="teacherInsertStudentForm" class="form-horizontal"  method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">학생ID</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="memberId"  >
                                                <form:errors path="detailRequest.memberId" cssClass="error"/>
                                                <!-- Button trigger modal -->
                                        		<button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary" >
                                            		학생ID 찾기
                                      			</button>
                                      			<!-- Modal -->
                                      			<div class="modal fade modal-primary" id="modalPrimary" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            		<div class="modal-dialog">
                                               			<div class="modal-content">
                                                    		<div class="modal-header">
                                                        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        		<h4 class="modal-title" id="myModalLabel">학생ID 리스트</h4>
                                                    		</div>
                                                    		<div class="modal-body">
                                                               	<div class="row" style="width:100%; height:200px; overflow:auto">
																<!-- Table -->
																<div class="col-md-2"></div>
																<div class="col-md-8">
																<table class="table table-striped">
																	<thead>
																		<tr class="headings">
																			<th>번호</th>
																			<th>학생ID</th>
																		</tr>
																	</thead>
																	<tbody >
																		<c:forEach var="list" items="${list }">
																		<tr >
																			<td><%= i++ %></td>
																			<td id="clickStu" style="cursor:pointer">${list.memberId }</td>
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
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">이름</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="memberName" placeholder="memberName">
                                            	<form:errors path="detailRequest.memberName" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">생년월일</label>
                                            <div class="col-sm-5">
                                                <input type="date" class="form-control" name="memberBirthday" placeholder="YYYY-MM-dd">
                                            </div>
                                        </div>
                                          <div class="form-group">
                                            <label class="col-sm-2 control-label">주소</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="memberAddress" placeholder="memberAddress">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">전화번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberTel" placeholder="Tel">
                                            	<form:errors path="detailRequest.memberTel" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">이메일</label>
                                            <div class="col-sm-5">
                                                <input type="email" class="form-control"  name="memberEmail" placeholder="aaa@bbb.com">
                                            	<form:errors path="detailRequest.memberEmail" cssClass="error"/>
                                            </div>
                                        </div>
                                       
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">학번</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="studentCode" placeholder="memberAddress">
                                            	<form:errors path="detailRequest.studentCode" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">학년</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="studentGrade" placeholder="studentGrade" id="studentGrade">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">반</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="studentClass" placeholder="studentClass" id="studentClass">
                                            	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">출석번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="studentNum" placeholder="studentNum">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">성별</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="studentGender" placeholder="M/W">
                                            	<form:errors path="detailRequest.studentGender" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">학과</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"  name="studentMajor" placeholder="문과/이과">
                                            	<form:errors path="detailRequest.studentMajor" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">사진</label>
                                            <div class="col-sm-5">
                                               <input type="file"  name="file">
                                            <p class="help-block">jpg 형식의 파일만 지원합니다.</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">비고</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberNote" value="없음">
                                            	<form:errors path="detailRequest.memberNote" cssClass="error"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-default">등록</button>
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
     
           
</body>

</html>
​