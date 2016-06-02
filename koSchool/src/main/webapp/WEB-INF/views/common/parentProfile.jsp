<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
<head>
<title>빈칸</title>
<!-- jQuery-->
<script src="/resources/js/jquery.js" type="text/javascript"></script>

</head>
<style type="text/css">
.card_wan {
	background-color: #FFF;
	border-radius: 1px;
	overflow: hidden;
	position: relative;
	width: 800px;
	height: 800px;
}
</style>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="studentMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">${member.memberName}학부모 정보</div>
									</div>

								</div>
								<div class="card-body">
									<div class="row no-margin col-xs-12">
										<div class="col-md-2 col-xs-12"></div>
										<div class="col-md-4 col-xs-12">
											<div class="card profile">
												<div class="card-profile-img">
													<p class="profile-img"><img
														src="/resources/img/profile/picjumbo.com_HNCK4153_resize.jpg"
														class="profile-img"></p>
												</div>
												<div class="col-md-12">
													<br>
													<br>
													<br>
												</div>
											</div>
										</div>
										<div class="col-md-3"></div>
										<div class=" table-responsive col-md-8">
											<!-- Table -->
											<table class="table table-striped">
												<tr height="30">
													<th width="350">이름</th>
													<td width="350">${member.memberName}</td>
													<th width="350">생년월일</th>
													<td width="350"><fmt:formatDate
															value="${member.memberBirthday}" pattern="yyyy-MM-dd" /></td>
												</tr>
												<tr height="30">
													<th width="350">주소</th>
													<td width="350">${member.memberAddress}</td>
													<th width="350">전화번호</th>
													<td width="350">${member.memberTel}</td>
												</tr>
												<tr height="30">
													<th width="350">가족관계</th>
													<td width="350">${parent.familyRelation}</td>
												</tr>
											</table>
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
