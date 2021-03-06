<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%int i=1; int j=1;%>
<!DOCTYPE html>
<html>
<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('tbody').on('click','#clickStu',function(){
			$('input[name=subjectId]').val($(this).html());
			$('button[class=close]').trigger('click'); 
		})
		$('tbody #clickStu').on({
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
			<jsp:include page="../common/schoolAdminMenu.jsp"/>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">교사 정보 수정</div>
									</div>
								</div>
								<div class="card-body">
                                    <form class="form-horizontal" method="POST">
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">이름</label>
                                            <div class="col-sm-5">                                     
                                                <input type="text" class="form-control" name="memberName" value="${teacherDetailVO.memberName}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">생년월일</label>
                                            <div class="col-sm-5">
                                            	<input type="text" class="form-control" name="memberBirthday" value="${fn:substring(teacherDetailVO.memberBirthday, 0, 10)}">
                                            </div>
                                        </div>
                                        <%-- <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">주소</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberAddress" value="${teacherDetailVO.memberAddress}">
                                            </div>
                                        </div> --%>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberTel" value="${teacherDetailVO.memberTel}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">이메일</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberEmail" value="${teacherDetailVO.memberEmail}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">담당학급</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="teacherClass" value="${teacherDetailVO.teacherClass}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">담당과목</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="subjectId" value="${preSubject.subjectName }">
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
																		<c:forEach var="subject" items="${subjectList }">
																		<tr >
																			<td><%=j++ %></td>
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

</html>
​
