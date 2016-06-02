<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">공지사항 수정</div>
									</div>
								</div>
								<div class="card-body table-responsive col-md-5">
									<form id="contact-form" method="post" action="/updateNoticeBoardForm" enctype="multipart/form-data">
										<div class="messages"></div>
										<div class="controls">
											<div class="row">
												<div class="col-md-12">
													<label for="form_name">제목</label> 
													<input  type="text" name="noticeBoardTitle" class="form-control"
														placeholder="제목을 적어주세요" required="required" value="${noticeBoardDetail.noticeBoardTitle }">
												</div>
												<div class="col-md-12">
													<label for="form_contents">내용</label>
													<textarea name="noticeBoardContent"
														class="form-control" placeholder="내용을 입력해주세요" rows="20"
														required="required">${noticeBoardDetail.noticeBoardContent}</textarea>
												</div>
												<div class="col-md-12">
													<label for="exampleInputFile">File input</label> 
													<input type="file"  name="file">
													<p class="help-block">영문명 파일로 올려주세요</p>
												</div>
												<input type="hidden" name="noticeBoardNum" value="${noticeBoardDetail.noticeBoardNum}">
												<input type="hidden" name="noticeBoardFileName" value="${noticeBoardDetail.noticeBoardFileName}">
										
												<div class="pull-right">
													<input type="submit" class="btn btn-default" value="수정">
													&nbsp;&nbsp;&nbsp;
													<input type="reset" class="btn btn-default" value="취소" onclick="location:history.go(-1)">
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
