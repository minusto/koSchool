<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%
	int i = 1;
	int j = 1;
%>
<html>

<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
		$(function(){
			$(document).on('click','#clickStu1',function(){
				$('input[id=parentId]').val($(this).html());
				$('button[class=close]').trigger('click'); 
			})
			$('#clickStu1').on({
				 mouseenter: function(){
				  $(this).css('color','red');
				 },
				 mouseleave: function(){
				  $(this).css('color','#333');
				 }
			});
			$(document).on('click','#clickStu',function(){
				$('input[id=memberId]').val($(this).html());
				$('button[class=close]').trigger('click'); 
			})
			$('#clickStu').on({
				 mouseenter: function(){
				  $(this).css('color','red');
				 },
				 mouseleave: function(){
				  $(this).css('color','#333');
				 }
			});
		})
	</script>
<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="../../common/teacherMenu.jsp"/>
             <!-- 메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                    <div class="row">
                        <div class="col-xs-12">
                           <div class="card-body">
                                    <form class="form-horizontal" method="POST">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">학부모ID</label>
                                            <div class="col-sm-5">
                                            	<input type="text" class="form-control" id="parentId" name="memberId" placeholder="parentID">
                                                <!-- Button trigger modal -->
                                        		<button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary" >
                                            		학부모ID 찾기
                                      			</button>
                                      			<!-- Modal -->
                                      			<div class="modal fade modal-primary" id="modalPrimary" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            		<div class="modal-dialog">
                                               			<div class="modal-content">
                                                    		<div class="modal-header">
                                                        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        		<h4 class="modal-title" id="myModalLabel">학부모ID 리스트</h4>
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
																			<th>학부모ID</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="parent" items="${list }">
																		<tr >
																			<td><%=i++ %></td>
																			<td id="clickStu1" style="cursor:pointer">${parent.memberId }</td>
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
                                            <label for="inputPassword3" class="col-sm-2 control-label">이름</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="parentName"  name="memberName" placeholder="Name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">가족관계</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="familyRelation" name="familyRelation" placeholder="ex)'부' 혹은 '모'">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">학생ID</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="memberId" name="studentMemberId" placeholder="StudentID">
                                            	<button type="button" class="btn btn-primary btn-primary" data-toggle="modal" data-target="#modalPrimary2" >
                                            		학생ID 찾기
                                      			</button>
                                      			<!-- Modal -->
                                      			<div class="modal fade modal-primary" id="modalPrimary2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
																			<th>이름</th>
																			<th>생년월일</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="student" items="${list2 }">
																		<tr >
																			<td><%=j++ %></td>
																			<td id="clickStu" style="cursor:pointer">${student.memberId }</td>
																			<td>${student.memberName }</td>
																			<td><fmt:formatDate value="${student.memberBirthday }" pattern="yyyy-MM-dd"/></td>
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
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="submit" class="btn btn-default" value="등록">
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
