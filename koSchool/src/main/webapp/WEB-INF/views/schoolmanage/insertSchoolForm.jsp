<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body class="flat-blue">
<input type="hidden" id="insertOk" value="${insert }">
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
                                        <div class="title">학교등록</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <form class="form-horizontal" action="insertSchoolForm" method="post">
                                    	<input type="hidden" name="schoolAdminId" value="${schoolAdminId }"/><!--  -->
                                    	<div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">학교ID</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolId" placeholder="schoolId">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">학교명</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolName" placeholder="schoolName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">주소</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolAddress" placeholder="schoolAddress">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="schoolTel" placeholder="schoolTel">
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
   </div>
   <script type="text/javascript">
		var isSchool = ${isSchool};
		if(isSchool == true) {
			alert("이미 학교가 등록되어 있습니다.");
			location.replace('/schoolAdminMain');
		}
   </script>
</body>

</html>
​