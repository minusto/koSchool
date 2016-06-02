
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/systemAdminMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top" id="content">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">학교관리자 상세정보</div>
									</div>
								</div>
								<div class="card-body">
									<div class="row">

										<div class="col-sm-5">
											<div class="panel panel-default">
											<div class="box-body">
												<div class="panel-body">ID : ${schoolAdminDetailVO.schoolAdminId }</div>
												<div class="panel-body">이름 : ${schoolAdminDetailVO.schoolAdminName }</div>
												<div class="panel-body">전화번호 : ${schoolAdminDetailVO.schoolAdminTel }</div>
												<div class="panel-body">삭제신청여부 : ${schoolAdminDetailVO.deleteRequest }</div>
												<div class="panel-body">
													등록일 :
													<fmt:formatDate value="${schoolAdminDetailVO.schoolRegistDate }"
														pattern="yyyy-MM-dd" />
												</div>
												<div class="panel-body">
													만료일 :
													<fmt:formatDate value="${schoolAdminDetailVO.schoolEndDate }"
														pattern="yyyy-MM-dd" />
												</div>
									
													<a href="/schoolAdminUpdate?id=${schoolAdminDetailVO.schoolAdminId }"><button class="btn btn-primary">수정</button></a>
													<button  class="btn btn-default" onclick="location.href='/schoolAdminList'">목록보기 </button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--컨텐츠 끝 -->

					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>
​
