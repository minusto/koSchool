<%@page import="ko.school.membermanage.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", "학교관리> 사용자 ID 등록");
%>
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="flat-blue"> 
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/schoolAdminMenu.jsp"/>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top" id="content">
					<div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">사용자 ID 등록</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <form class="form-horizontal" action="/schoolAdminInsertUserIdForm" method="post">
                                    <input type="hidden" name="schoolAdminId" value="${Id}"> <!-- 세션값으로 넣어야하나? -->
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">사용자 ID</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="memberId">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">등급</label>
                                            <div class="col-sm-5">
                                            <div>
<!--                                           <div class="radio3 radio-check radio-inline"> -->
<!--                                             <input type="radio" id="radio4" name="memberGrade" value="교사" checked=""> -->
<!--                                             <label for="radio4">교사</label> -->
<!--                                           </div> -->
                                          <div class="radio3 radio-check radio-inline">
                                            <input type="radio" id="radio5" name="memberGrade" value="학생">
                                            <label for="radio5">학생</label>
                                          </div>
                                          <div class="radio3 radio-check radio-inline">
                                            <input type="radio" id="radio6" name="memberGrade" value="학부모">
                                            <label for="radio6">학부모</label>
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
	</div>

</body>

</html>
​
