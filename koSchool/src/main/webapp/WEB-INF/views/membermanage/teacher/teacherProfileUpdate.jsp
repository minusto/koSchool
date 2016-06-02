<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%int i =0; %>
<!DOCTYPE html>
<html>
<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
		$(function(){
			
			$('tbody:eq(0)').on('click','#clickStu',function(){
				$('input[name=subjectId]').val($(this).html());
				$('button[class=close]').trigger('click'); 
			})
			$('tbody:eq(0) #clickStu').on({
				 mouseenter: function(){
				  $(this).css('color','red');
				 },
				 mouseleave: function(){
				  $(this).css('color','#333');
				 }
			});
		})
	</script>
</head>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../../common/teacherMenu.jsp"/>
<script type="text/javascript">
        </script>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top" id="content">
					<div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">${member.memberName} 정보수정</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <form class="form-horizontal"  method="post" enctype="multipart/form-data">
                                    
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">이름</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberName" value="${member.memberName}">
                                                <input type="hidden" class="form-control" name="memberId" value="${member.memberId}">
                                   
                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">생년월일</label>
                                            <div class="col-sm-5">
														<input type='date' class="form-control" name="memberBirthday" value="${(member.memberBirthday).substring(0, 10)}"/> 
											</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberTel"value="${member.memberTel}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">주소</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberAddress" value="${member.memberAddress}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">이메일</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberEmail" value="${member.memberEmail}">
                                            </div>
                                        </div>
                            
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">담당학급</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="teacherClass" value="${teacher.teacherClass}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">담당과목</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="subjectId" value="${teacher.subjectId}">
                                                <button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary2" >
                                            		과목ID 찾기
                                      			</button>
                                      			<!-- Modal -->
                                      			<div class="modal fade modal-primary" id="modalPrimary2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            		<div class="modal-dialog">
                                               			<div class="modal-content">
                                                    		<div class="modal-header">
                                                        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        		<h4 class="modal-title" id="myModalLabel">과목ID 리스트</h4>
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
																			<th>교과명</th>
																			<th>과목명</th>
																		</tr>
																	</thead>
																	<tbody >
																		<c:forEach var="subject" items="${list }">
																		<tr >
																			<td><%=i++ %></td>
																			<td id="clickStu" style="cursor:pointer">${subject.subjectId }</td>
																			<td>${subject.subjectType }</td>
																			<td>${subject.subjectName }</td>
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
                                            <label for="inputPassword3" class="col-sm-2 control-label">사진</label>
                                            <div class="col-sm-5">
                                               <input type="file" id="exampleInputFile" name="file" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">직책</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="teacherPosition" value="${teacher.teacherPosition}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-default">수정</button>
                                                
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

</html>​