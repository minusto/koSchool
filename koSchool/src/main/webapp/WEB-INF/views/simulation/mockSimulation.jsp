<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
    <title>정시 시뮬레이션</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/resources/css/ghi.css">
    
	<script type="text/javascript" src="/resources/js/jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			$(document).on('change', '#selectUniversity', function() { //희망대학 입력 
				$('#selectMajor').empty();
				var uniId = $(this).val();
				$.ajax({
					url : '/ajaxMajorList',
					dataType : 'json',
					type : 'post',
					data : {uniId : uniId},
					success : function(data) {
						var html = '<option id="firstMajorOption">-- 학과 선택 --</option>';
						
						$.each(data, function(index, list) {
							html += '<option value="' + list.majorId + '">' + list.majorName + '</option>';								
						});
						$("#selectMajor").append(html);
					}
				});
			});
		});
		
		window.onload=function(){
			//대학리스트 클릭시 디테일로 넘어감
			$(".clickTitle").on("click", function(){
				$("#formRecruitSeparate").val($(this).find("#TrecruitSeparate").html());
				$("#formMajorId").val($(this).find("#TmajorId").html());
				$("#formUniversityId").val($(this).find("#TuniversityId").html());
				$("#formSubmit").trigger('click');
			})
			
			//추천대학 클릭시 디테일로 넘어감
			$(".clickTitle2").on("click", function(){
				alert("zzzz");
				$("#formRecruitSeparate").val($(this).find("#TrecruitSeparate").val());
				$("#formMajorId").val($(this).find("#TmajorId").val());
				$("#formUniversityId").val($(this).find("#TuniversityId").val());
				$("#formSubmit").trigger('click');
			})
			
			//목표대학 클릭시 디테일로 넘어감
			$(".clickTitle3").on("click", function(){
				alert("ㄴㅁㅇ?");
				$("#formRecruitSeparate").val($(this).find("#TrecruitSeparate").val());
				$("#formMajorId").val($(this).find("#TmajorId").val());
				$("#formUniversityId").val($(this).find("#TuniversityId").val());
				$("#formSubmit").trigger('click');
			})
		}
		
	</script>
	<style type="text/css">
		#selectUniversity {
			width : 150px;
		}
		#selectMajor {
			width : 150px;
		}
		#disNoneTd{
			display: none;
		}
	</style>
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
                    		<div id="hopeUniversityContainer">
		                    	<c:choose>
		                    		<c:when test="${hopeUniversity != null}">
		                    			<table id="hopeUniversityTable" class="table table-bordered">
	                   						<tr>
				                    			<th>모의고사 총합</th>
				                    			<th>목표대학</th>
				                    			<th>목표학과</th>
				                    			<th>정시 커트라인</th>
				                    			<th>점수 차이</th>
				                    		</tr>
				                    		<tr class="clickTitle3">
				                    			<c:if test="${standardScoreSum != 0 }">
					                    			<td id="hopeUniversityCol1">${standardScoreSum }</td>
				                    			</c:if>
				                    			<c:if test="${standardScoreSum == 0 }">
					                    			<td id="hopeUniversityCol1">모의고사 점수 없음</td>
				                    			</c:if>
				                    			<td id="hopeUniversityCol2"><a id="hopeUniversityName">${hopeUniversity.universityName }</a></td><!-- 목표대학 목표학과의 상세 페이지를 보여준다. -->
				                    			<td id="hopeUniversityCol3"><a id="hopeUniversityMajor">${hopeUniversity.majorName }</a></td>
				                    			<td id="hopeUniversityCol4">${hopeUniversity.standardScoreCutline}</td>
				                    			<c:if test="${standardScoreSum != 0 }">
					                    			<td id="hopeUniversityCol5">${standardScoreSum - hopeUniversity.standardScoreCutline}</td>
				                    			</c:if>
				                    			<c:if test="${standardScoreSum == 0 }">
					                    			<td id="hopeUniversityCol5">-</td>
				                    			</c:if>
				                    			<td id="disNoneTd">
				                    				<input type="hidden" id="TmajorId" value="${hopeUniversity.majorId}">
				                    				<input type="hidden" id="TuniversityId" value="${hopeUniversity.universityId}">
				                    				<input type="hidden" id="TrecruitSeparate" value="${hopeUniversity.recruitSeparate}">
				                    			</td>
				                    		</tr>
	                   					</table>
		                    		</c:when>
		                    		<c:otherwise><!-- 목표대학이 설정되어있지 않을 경우 -->
		                    			<c:choose>
		                    				<c:when test="${ grade eq 'student' }">
		                    					<form id="insertHopeUniversityForm" action="InsertHopeUniversity" method="post">
	                    							<h4>희망대학 설정하기</h4>
		                    						대학교 : <select id="selectUniversity" name="universityId">
			                    						<option>-- 대학 선택 --</option>
			                    						<c:forEach var="universityList" items="${universityList }">
				                    							<option value="${universityList.universityId }">${universityList.universityName }</option>
			                    						</c:forEach>
		                    						</select>&nbsp;&nbsp;
		                    						학과 : <select id="selectMajor" name="majorId"></select>
		                    						&nbsp;&nbsp;
		                    						<input type="submit" value="등록" class="flat-blue btn btn-primary"/>                						
	                    						</form>
		                    				</c:when>
		                    				<c:when test="${ grade eq 'parent' }">
		                    					<table id="hopeUniversityTable" class="table table-bordered">
					                    			<tr><th colspan="4">안녕하세요 학부모님</th></tr>
					                    			<tr><td colspan="4">자녀의 희망대학이 설정되어있지 않습니다</td></tr>
				                    			</table>
		                    				</c:when>
		                    				<c:when test="${ grade eq 'teacher' }">
		                    					<table id="hopeUniversityTable" class="table table-bordered">
					                    			<tr><th colspan="4">안녕하세요 선생님</th></tr>
					                    			<tr><td colspan="4">학생의 희망대학이 설정되어있지 않습니다</td></tr>
				                    			</table>
		                    				</c:when>
		                    				<c:otherwise>
		                    					<p>해당없음</p>
		                    				</c:otherwise>
		                    			</c:choose>
		                    		</c:otherwise>
		                    	</c:choose>
	                			<br><br>
                			</div>
	                    </div>
                    </div>
                    
                    <div id="recommendContainer" class="row">
                    	<div class="col-md-8 col-md-offset-2">
                    		<h3>추천 대학</h3>
                    		<c:if test="${hopeUniversity == null && standardScoreSum > 0 }">
                    			<label>(모의고사 총합 : ${standardScoreSum } )</label>
                    		</c:if>
                    		<div id="recommendUniversityDiv">
                    			<ul class="list-unstyled list-inline">
                   
                    			<c:choose>
										<c:when test="${empty recommandList}">
											<br><br>
											<p>모의고사 점수가 없습니다. 희망대학을 설정해주세요</p>
											<br><br>
										</c:when>
										
										<c:otherwise>
											<c:forEach var="re" items="${recommandList}">
		                    					<li class="clickTitle2">
		                    						<img id="SeoulUniversityMark" alt="${re.universityName }마크" src="${re.universityMark }">
		                    						<span id="firstRecommendUniversityName" class="recommendUniversityName">${re.universityName }</span>
		                    						<span id="firstRecommendMajorName" class="recommendMajorName">${re.majorName }</span>
		                    						<input type="hidden" id="TrecruitSeparate" value="${re.recruitSeparate }">
		                    						<input type="hidden" id="TuniversityId" value="${re.universityId }">
		                    						<input type="hidden" id="TmajorId" value="${re.majorId }">
		                    					</li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
                    			</ul>
                    		</div>
                    		<P>* 추천대학은 표준점수의 단순 합산으로 도출한 결과입니다.</P>
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
					                    					<c:forEach var="allEntranceInfoList" items="${allMockList }">
					                    						<tr class="clickTitle">
						                    						<td>
						                    							<img class="tableUniversityMark" alt="${allEntranceInfoList.universityName }마크" src="${allEntranceInfoList.universityMark }">
						                    							<a id="hopeUniversityName">${allEntranceInfoList.universityName }</a>
						                    						</td>
						                    						<td><a id="hopeUniversityMajor">${allEntranceInfoList.majorName }</a></td>
						                    						<td>${allEntranceInfoList.standardScoreCutline }</td>
						                    						<td>${allEntranceInfoList.recruitNum }</td>
						                    						<td id="TuniversityId" style="display: none">${allEntranceInfoList.universityId }</td>
						                    						<td id="TmajorId" style="display: none">${allEntranceInfoList.majorId }</td>
						                    						<td id="TrecruitSeparate" style="display: none">${allEntranceInfoList.recruitSeparate }</td>
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
	<form action="/universityDetail" style="display: none" method="POST">
		<input type="hidden" id="formMemberId" name="memberId" value="${ControllerStudentId}">
		<input type="hidden" id="formRecruitSeparate" name="recruitSeparate">
		<input type="hidden" id="formMajorId" name="majorId">
		<input type="hidden" id="formUniversityId" name="universityId">
		<input type="submit" id="formSubmit">
	</form>
</body>

</html>