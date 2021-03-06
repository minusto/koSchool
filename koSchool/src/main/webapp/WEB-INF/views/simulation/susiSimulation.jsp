<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>수시 시뮬레이션</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="/resources/js/susiChart.js"></script>
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/susiJquery.js" type="text/javascript"></script>
<script src="/resources/js/susiRecomJquery.js" type="text/javascript"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {

		var data = google.visualization.arrayToDataTable([

				<c:forEach var="i" items="${list}" varStatus="status">[
						"${i.universityName}", 10, eval("${i.minAverscore}"),
						eval("${i.maxAverscore}"), 0], </c:forEach> ], true);

		var options = {
			//legend: 'none',
			bar : {
				groupWidth : '20%'
			}, // Remove space between bars.
			candlestick : {
				fallingColor : {
					strokeWidth : 0,
					fill : '#a52714'
				}, // red
				risingColor : {
					strokeWidth : 0,
					fill : '#0f9d58'
				}
			// green
			}
		};

		var chart = new google.visualization.CandlestickChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);

		removeLine();
	}

	function removeLine() {
		$("rect[fill='#3366cc']").remove();
	}
</script>
<style type="text/css">
#center2{
	text-align:center; 
	vertical-align:middle;
}
</style>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/studentMenu.jsp" />
			<!--			메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div id="compareToHopUniversityTotalExam" class="row">
						<div class="table-responsive col-md-12 ">
							<h3>${studentName }님의 학년별 내신 등급</h3>
							<table id="nesinTable" class="table table-bordered"
								style="text-align: center">
								<tr>
									<th id="center2">학년</th>
									<th id="center2">국어</th>
									<th id="center2">영어</th>
									<th id="center2">수학</th>
									<th id="center2">사회</th>
									<th id="center2">과학</th>
									<th id="center2">기타</th>
								</tr>
								<tr>
									<td>1</td>
									<td>${first.kor }</td>
									<td>${first.eng }</td>
									<td>${first.math }</td>
									<td>${first.sol }</td>
									<td>${first.sci }</td>
									<td>${first.etc }</td>
								</tr>
								<tr>
									<td>2</td>
									<td>${second.kor }</td>
									<td>${second.eng }</td>
									<td>${second.math }</td>
									<td>${second.sol }</td>
									<td>${second.sci }</td>
									<td>${second.etc }</td>
								</tr>
								<tr>
									<td>3</td>
									<td>${third.kor }</td>
									<td>${third.eng }</td>
									<td>${third.math }</td>
									<td>${third.sol }</td>
									<td>${third.sci }</td>
									<td>${third.etc }</td>
								</tr>
							</table>
						</div>
					</div>

<!-- 					<div id="recommendContainer" class="row"> -->
<!-- 						<div class="col-md-12 "> -->
<!-- 							<h3>추천 대학</h3> -->
<!-- 							<button id="testId">국민대학교</button> -->
							<!-- <div id="recommendUniversityDiv">
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
                    		</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<h3>수시 대학목록</h3>
					<!-- <div id="chart_div"></div> -->
					<div id="chart_div"></div>
					<br>
					<h3>추천 학과목록  &nbsp; (나의 내신등급: ${resultAver})</h3>
					 <jsp:include page="../simulation/susiRecommendTable.jsp"/>


					<div id="searchUniversityResult" class="row">
						<div class="col-md-12 ">
							<h3>대학 검색</h3>
							<jsp:include page="susiSimulationTable.jsp" />
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>

</html>
​
