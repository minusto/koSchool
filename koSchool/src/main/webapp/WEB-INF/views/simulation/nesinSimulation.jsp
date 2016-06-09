<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("path", "진학시뮬레이션 > 수시시뮬레이션");
%>
<!DOCTYPE html>
<html>

<head>
    <title>수시 시뮬레이션</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="../common/studentMenu.jsp"/>
<!--			메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
					<div id="compareToHopUniversityTotalExam" class="row">
	                    <div class="table-responsive col-md-8 col-md-offset-2">
                    	<h3>목표대학과의 비교</h3>
	                    	<table id="hopeUniversityTable" class="table table-bordered">
	                    		<tr>
	                    			<th>현재 내신 평균</th>
	                    			<th>목표대학</th>
	                    			<th>목표학과</th>
	                    			<th>수시 커트라인</th>
	                    			<th>점수 차이</th>
	                    		</tr>
	                    		<tr>
	                    			<td>4.3</td>
	                    			<td><a id="hopeUniversityName" href="/universityDetail">서울대학교</a></td><!-- 목표대학 목표학과의 상세 페이지를 보여준다. -->
	                    			<td><a id="hopeUniversityMajor" href="/universityDetail">국어국문학과</a></td>
	                    			<td>3.9</td>
	                    			<td>0.4</td>
	                    		</tr>
	                    	</table>
	                    </div>
                    </div>
                    
                    <div id="recommendContainer" class="row">
                    	<div class="col-md-8 col-md-offset-2">
                    		<h3>추천 대학</h3>
                    		<div id="recommendUniversityDiv">
                    			<ul class="list-unstyled list-inline">
                    				<li id="firstRecommend"><a href="/universityDetail">
                    					<img id="SeoulUniversityMark" alt="서울대학교마크" src="img/SeoulUniversityMark.jpg">
                    					<span id="firstRecommendUniversityName" class="recommendUniversityName">서울대학교</span>
                    					<span id="firstRecommendMajorName" class="recommendMajorName">국어국문학과</span>
                    				</a></li>
                    				<li id="secondRecommend"><a href="/universityDetail">
                    					<img id="YonseiUniversityMark" alt="연세대학교마크" src="img/YonseiUniversityMark.jpg">
                    					<span id="secondRecommendUniversityName" class="recommendUniversityName">연세대학교</span>
                    					<span id="secondRecommendMajorName" class="recommendMajorName">국어국문학과</span>
                    				</a></li>
                    				<li id="thirdRecommend"><a href="/universityDetail">
                    					<img id="KoreaUniversityMark" alt="고려대학교마크" src="img/KoreaUniversityMark.jpg">
                    					<span id="thirdRecommendUniversityName" class="recommendUniversityName">고려대학교</span>
                    					<span id="thirdRecommendMajorName" class="recommendMajorName">국어국문학과</span>
                    				</a></li>
                    			</ul>
                    		</div>
                    	</div>
					</div>
                    
					<div class="row">
                    	<div class="col-md-8 col-md-offset-2">
                    		<h3>대학 검색</h3>
                    		<div id="searchUniversityResult" class="row">
                    			<div class="table-responsive col-md-12">
                    				<div class="row">
                       		 			<div class="col-xs-12">
		                    				<div class="card">
			                    				<div class="card-body">
				                    				<table id="searchResultTable" class="datatable table table-bordered table-striped">
				                    					<thead>
					                    					<tr>
					                    						<th>학교 이름</th>
					                    						<th>학과 이름</th>
					                    						<th>수시 커트라인</th>
					                    						<th>모집인원</th>
					                    					</tr>
				                    					</thead>
				                    					<tfoot>
				                    						<tr>
					                    						<th>학교 이름</th>
					                    						<th>학과 이름</th>
					                    						<th>수시 커트라인</th>
					                    						<th>모집인원</th>
					                    					</tr>
				                    					</tfoot>
				                    					<tbody>
					                    					<c:forEach var="allEntranceInfoList" items="${allEntranceInfoList }">
					                    						<tr>
						                    						<td>
						                    							<img class="tableUniversityMark" alt="서울대학교마크" src="${allEntranceInfoList.universityMark }">
						                    							<a id="hopeUniversityName" href="/universityDetail">${allEntranceInfoList.universityName }</a>
						                    						</td>
						                    						<td><a id="hopeUniversityMajor" href="/universityDetail">${allEntranceInfoList.majorName }</a></td>
						                    						<td>${allEntranceInfoList.mockTestCutline }</td>
						                    						<td>${allEntranceInfoList.mockTestRecruitNum }</td>
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
                    
                </div>
            </div>
        </div>
    </div>
          
</body>

</html>
​