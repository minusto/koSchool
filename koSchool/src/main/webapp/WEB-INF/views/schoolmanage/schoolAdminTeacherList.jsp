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
			<jsp:include page="../common/schoolAdminMenu.jsp" />
            <!-- 메인 컨텐츠  -->
    		<div class = "container-fluid">
    			<div class = "side-body">
    				<jsp:include page="./teacherList.jsp"/> 
    			</div>      
    		</div>
      	</div>       
     </div>
            
</body>

</html>
​