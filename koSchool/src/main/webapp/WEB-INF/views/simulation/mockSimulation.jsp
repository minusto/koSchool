<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	/* request.setAttribute("path", "진학시뮬레이션 > 정시시뮬레이션");
	request.setCharacterEncoding("UTF-8");
	
	String selectUniversityName = request.getParameter("selectUniversityName"); //희망대학이 입력되어있지 않을 경우 대학을 선택했을 때의 대학 이름
	
	if(selectUniversityName != null) { //희망대학 미입력상태일 경우 선택한 대학에 맞는 학과 리스트를 가져온다.
		List<Major> majorList = service.selectMajorListService(selectUniversityName);
		request.setAttribute("majorList", majorList);
		request.setAttribute("selectUniversityName", selectUniversityName);
	}
	
	int checkHopeUniversityExist = 0; //희망대학이 설정되어있는지 체크할 변수
	String studentId = null; //학생의 아이디
	
	if(id != null && grade.equals("학생")) { //학생과 학부모의 경우에 따라 성적을 가져오기 위한 학생 아이디를 studentId에 저장해서 사용
		studentId = id;
		checkHopeUniversityExist = service.checkHopeUniversityService(studentId); //희망대학 유무 체크
		if(checkHopeUniversityExist < 0) { //학생의 경우 희망대학이 없다면 선택할 대학교와 학과 리스트를 가져와야 한다.
			List<University> universityList = service.selectUniversityListService(); //대학교 리스트를 가져옴
			request.setAttribute("universityList", universityList);
			request.setAttribute("id", id); //insert 폼에 학생의 아이디를 넘겨주기 위해서 set
		}
	} else if(id != null && grade.equals("학부모")) {
		Parent parent2 = service.parentInfoDetailService(id); //부모일 경우 부모 객체를 먼저 가져옴
		studentId = parent2.getMemberId();
		checkHopeUniversityExist = service.checkHopeUniversityService(studentId); //희망대학 유무 체크
	}
	
	if(id != null) {
		if(checkHopeUniversityExist > 0) { //학부모든 학생이든 희망대학이 있는 경우 -> 희망대학을 출력해야 한다.
			HopeUniversity hopeUniversity = service.selectHopeUniversityService(studentId);
			String universityName = service.selectUniversityNameService(hopeUniversity.getUniversityId());
			String majorName = service.selectMajorNameService(hopeUniversity.getMajorId());
			
			//희망대학 정시커트라인
			Cutline cutline = new Cutline();
			cutline.setMajorId(hopeUniversity.getMajorId());
			cutline.setUniversityId(hopeUniversity.getUniversityId());
			EntranceInfo info = service.mockTestCutlineService(cutline);
			
			request.setAttribute("info", info);
			request.setAttribute("universityName", universityName);
			request.setAttribute("majorName", majorName);
		} else {
			
		}
		request.setAttribute("grade", grade); //html에서 학생과 학생이 아닌 경우를 나눠 choose를 사용하기 위해 등급을 set을 해줌
		request.setAttribute("checkHopeUniversityExist", checkHopeUniversityExist); //희망대학 유무 결과 set
		
		//학생의 모의고사 점수 총합
		List<Map<String, Object>> mockTestSumList = service.mockTestSum(studentId);
		request.setAttribute("mockTestSumList", mockTestSumList);
		
		//모든 학교 학과의 입시정보 리스트 출력
		List<AllEntranceInfo> allEntranceInfoList = service.selectAllEntranceInfoService();
		request.setAttribute("allEntranceInfoList", allEntranceInfoList);
		
		//모의고사총합점수 변수화
		int total = Integer.parseInt(mockTestSumList.get(0).get("TOTAL").toString());
		
		//추천대학 리스트
		List<RecommendInfo> re = service.recommendUniversityService(total);
		request.setAttribute("re", re); 
	} */
%>
<!DOCTYPE html>
<html>

<head>
    <title>정시 시뮬레이션</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			$(document).on('change', '#selectUniversity', function() { //희망대학 입력 - 대학교 선택했을 경우 대학교 이름을 가지고 새로고침
				var uniName = $(this).val();
				location.href = "studentMockTestSimulation.jsp?selectUniversityName="+uniName;
			});
		});
		
	</script>
</head>

<body class="flat-blue">
   <div class="app-container">
        <div class="row content-container">
            <c:if test="${grade eq 'schoolAdmin' }">
				<jsp:include page="../common/schoolAdminMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'student' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>
			
			<c:if test="${grade eq 'teacher' }">
				<jsp:include page="../common/teacherMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'parent' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>
            
            
            
<!--			메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
					<div id="compareToHopUniversityTotalExam" class="row">
	                    <div class="table-responsive col-md-8 col-md-offset-2">
                    	<h3>목표대학과의 비교</h3>
	                    	<c:choose>
                    			<c:when test="${ grade == '학생' }">
                    				<c:choose>
                    					<c:when test="${checkHopeUniversityExist > 0}">
                    						<table id="hopeUniversityTable" class="table table-bordered">
	                    						<tr>
					                    			<th>모의고사 총합</th>
					                    			<th>목표대학</th>
					                    			<th>목표학과</th>
					                    			<th>정시 커트라인</th>
					                    			<th>점수 차이</th>
					                    		</tr>
					                    		<tr>
					                    			<td>${mockTestSumList[0].TOTAL}</td>
					                    			<td><a id="hopeUniversityName" href="/universityDetail">${universityName }</a></td><!-- 목표대학 목표학과의 상세 페이지를 보여준다. -->
					                    			<td><a id="hopeUniversityMajor" href="/universityDetail">${majorName }</a></td>
					                    			<td>${info.mockTestCutline}</td>
					                    			<fmt:formatNumber var="finalTotal" value="${mockTestSumList[0].TOTAL - info.mockTestCutline}" pattern="#.00" />
					                    			<td>${finalTotal}</td>
					                    		</tr>
	                    					</table>
                    					</c:when>
                    					<c:otherwise>
                    						<form action="logic/insertHopeUniversityOk.jsp?id=${id}" method="post">
                    							<h4>희망대학 설정하기</h4>
	                    						대학교 : <select id="selectUniversity" name="universityName">
	                    							<optgroup label="선택한 대학">
		                    							<option>${selectUniversityName }</option>
	                    							</optgroup>
	                    							<optgroup label="대학리스트">
		                    							<c:forEach var="universityList" items="${universityList }">
			                    							<option>${universityList.universityName }</option>
		                    							</c:forEach>
	                    							</optgroup>
	                    						</select>&nbsp;&nbsp;
	                    						학과 : <select id="selectMajor" name="majorName">
	                    							<c:forEach var="majorList" items="${majorList }">
	                    								<option>${majorList.majorName }</option>
	                    							</c:forEach>
	                    						</select>
	                    						&nbsp;&nbsp;
	                    						<input type="submit" value="등록" class="flat-blue btn btn-primary"/>                						
                    						</form>
                    					</c:otherwise>
                    				</c:choose>
                    			</c:when>
	                    		<c:otherwise>
		                    		<c:choose>
		                    			<c:when test="${checkHopeUniversityExist > 0}">
		                    				<table id="hopeUniversityTable" class="table table-bordered">
		                    					<tr>
					                    			<th>현재 모의고사 평균 등급</th>
					                    			<th>목표대학</th>
					                    			<th>목표학과</th>
					                    			<th>정시 커트라인</th>
					                    			<th>점수 차이</th>
					                    		</tr>
					                    		<tr>
					                    			<td>${mockTestSumList[0].TOTAL}</td>
					                    			<td><a id="hopeUniversityName" href="/universityDetail">${universityName }</a></td><!-- 목표대학 목표학과의 상세 페이지를 보여준다. -->
					                    			<td><a id="hopeUniversityMajor" href="/universityDetail">${majorName }</a></td>
					                    			<td>${info.mockTestCutline}</td>
					                    			<fmt:formatNumber var="finalTotal" value="${mockTestSumList[0].TOTAL - info.mockTestCutline}" pattern="#.00" />
					                    			<td>${finalTotal}</td>
					                    		</tr>
	                    					</table>
		                   				</c:when>
		                   				<c:otherwise>
		                   					<table id="hopeUniversityTable" class="table table-bordered">
				                    			<tr><th colspan="4">안녕하세요 학부모님</th></tr>
				                    			<tr><td colspan="4">자녀의 희망대학이 설정되어있지 않습니다</td></tr>
			                    			</table>	                    						
		                   				</c:otherwise>
	                   				</c:choose>
	                    		</c:otherwise>
	                    	</c:choose>
                			<br><br>
	                    </div>
                    </div>
                    
                    <div id="recommendContainer" class="row">
                    	<div class="col-md-8 col-md-offset-2">
                    		<h3>추천 대학</h3>
                    		<div id="recommendUniversityDiv">
                    			<ul class="list-unstyled list-inline">
                   
                    			<c:choose>
										<c:when test="${empty re}">
											<br><br>
											추천 가능한 대학이 없습니다
											<br><br>
										</c:when>
					
										<c:otherwise>
											<c:forEach var="re" items="${re}" begin="0" end="2" step="1">
		                    					<li ><a href="universityEntranceInfo.jsp">
		                    					<img id="SeoulUniversityMark" alt="대학교마크" src="${re.universityMark }">
		                    					<span id="firstRecommendUniversityName" class="recommendUniversityName">${re.universityName }</span>
		                    					<span id="firstRecommendMajorName" class="recommendMajorName">${re.majorName }</span>
		                    				</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
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
					                    						<th>정시 커트라인</th>
					                    						<th>모집인원</th>
					                    					</tr>
				                    					</thead>
				                    					<tfoot>
				                    						<tr>
					                    						<th>학교 이름</th>
					                    						<th>학과 이름</th>
					                    						<th>정시 커트라인</th>
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
            <!-- 메인컨텐츠 끝 -->
            
            <br><br>
		<div align="center">
			<button class="btn btn-primary btn-success" onclick="location.href='/universityDetail'" style="font-family: 'Jeju Gothic' ">임시 대학상세페이지 이동</button>
		</div>
            
        </div>
   	</div>
   	
</body>

</html>
​​
