<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
										<div class="title">학교 정보 수정</div>
									</div>
								</div>
								<div class="card-body">
                                    <form class="form-horizontal" action="/schoolUpdate" method="post">
  
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">학교명</label>
                                            <div class="col-sm-5">
                                             <input type="hidden" class="form-control" name="schoolId" value="${school.schoolId}">
                                                <input type="text" class="form-control" name="schoolName" value="${school.schoolName}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">주소</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolAddress" value="${school.schoolAddress}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolTel" value="${school.schoolTel}">
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
