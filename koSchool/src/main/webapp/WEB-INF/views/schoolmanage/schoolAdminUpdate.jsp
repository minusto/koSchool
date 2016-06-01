<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
	
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/systemAdminMenu.jsp"></jsp:include>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">학교 관리자 수정</div>
                                    </div>
                                </div> 
                                <div class="card-body">

									<form class="form-horizontal"  method="POST">
										<fieldset>
												
											<div class="control-group">
												<label class="control-label" for="SchoolMasterName">이름</label>
												<div class="controls">
													<input type="text" id="schoolAdminName" name="schoolAdminName"
														value="${schoolAdminDetailVO.schoolAdminName }" class="form-control">
												</div>
											</div>
											
											<div class="control-group">
												<label class="control-label" for="SchoolMasterTel">전화번호</label>
												<div class="controls">
													<input type="tel" id="schoolAdminTel" name="schoolAdminTel"
														value="${schoolAdminDetailVO.schoolAdminTel }" class="form-control">
												</div>
											</div>
											
												<div class="control-group">
												<label class="control-label">삭제여부</label>
												<div class="controls">
													<input type="tel" id="deleteRequest" name="deleteRequest"
														value="${schoolAdminDetailVO.deleteRequest }" class="form-control">
												</div>
											</div>
											
											<div class="control-group">
												<label class="control-label" for="SchoolEndDate">만료일</label>
												<div class="controls">
<!-- 													<input type="date" id="SchoolEndDate" name="schoolEndDate" -->
<!-- 														value=" "   class="form-control"> -->
											<fmt:formatDate var="fmtDate" value="${schoolAdminDetailVO.schoolEndDate }" pattern="yyyy-MM-dd"/>
											<input class="form-control" type="date" name="schoolEndDate" value="${fmtDate}"/>
												</div>
											</div>         
											<input type="hidden" id="systemAdminId" name="systemAdminId"
														value="system">
														<input type="hidden" id="schoolAdminId" name="schoolAdminId"
														value="${schoolAdminDetailVO.schoolAdminId }">
												</div>                                 

												<input class="btn btn-default" type="submit" value="수정">
												
										</fieldset>
									</form>
									<button  class="btn btn-default" onclick="javascript:history.go(-1);">취소</button>
								</div>
                            </div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--         컨텐츠 끝 -->
		<footer class="app-footer">
			<div class="wrapper">
				<span class="pull-right">오른쪽쓸것 <a href="#"></a></span> 왼쪽
			</div>
		</footer>
	</div>
	
</body>

</html>
​
