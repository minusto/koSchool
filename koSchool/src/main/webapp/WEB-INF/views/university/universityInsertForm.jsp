<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jQuery-->
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {		
	$(document).on('click', '#clickUniversity', function() {
		$('input[id=modalUniName]').val($(this).find('#modalUniName').html());
		$('#universityId').val($(this).find('#modalUniId').html());
		$('#universityId1').val($(this).find('#modalUniId').html());
		
		
		$('button[class=close]').trigger('click');
	})
	$('#clickStu1').on({
		mouseenter : function() {
			$(this).css('color', 'red');
		},
		mouseleave : function() {
			$(this).css('color', '#333');
		}
	});
	
		$(document).on('click', '#clickMajor', function() {
		$('input[id=modalMajorId]').val($(this).find('#modalMajorName').html());
		$('#majorId').val($(this).find('#modalMajorId').html());
		$('#majorId1').val($(this).find('#modalMajorId').html());

		$('button[class=close]').trigger('click');
	}) 
	$('#clickStu').on({
		mouseenter : function() {
			$(this).css('color', 'red');
		},
		mouseleave : function() {
			$(this).css('color', '#333');
		}
	});
	
	
	//FK적용하기
	$('#entranceInfo').on('click',function(){
		$('#reflectionRateId1').val($('#reflectionRateId').val());
		$('#satReflectionRateId1').val($('#satReflectionRateId').val());
		$('#extraPointId1').val($('#extraPointId').val());
	})
	
	$('#satScore').on('click',function(){
		$('#entranceYear1').val($('#entranceYear').val());
		$('#recruitSeparate1').val($('#recruitSeparate').val());
	})
			
	$(document).on('click', '#clickReflectionRate', function(){
		$('#reflectionRateId').val($(this).find('#modalreflectionRateId').html());
		$('#satReflectionRate').val($(this).find('#modalsatReflectionRate').html());
		$('#schoolReportReflectionRate').val($(this).find('#modalschoolReportReflectionRate').html());
		$('#practiceReflectionRate').val($(this).find('#modalpracticeReflectionRate').html());
		$('#interviewReflectionRate').val($(this).find('#modalinterviewReflectionRate').html());
		$('#essayReflectionRate').val($(this).find('#modalessayReflectionRate').html());
		$('#aptitudeReflectionRate').val($(this).find('#modalaptitudeReflectionRate').html());
		$('#etcReflectionRate').val($(this).find('#modaletcReflectionRate').html());
		$('#etcContent').val($(this).find('#modaletcContent').html());
		$('#modelSum').val($(this).find('#modalmodelSum').html());
		
		$('button[class=close]').trigger('click');
	})

	
	
	
	
	//영역별 반영비율
	$(document).on('click', '#clickRRS', function(){
		$('#satReflectionRateId').val($(this).find('#modalsatReflectionRateId').html());
		$('#koreanReflectionRate').val($(this).find('#modalkoreanReflectionRate').html());
		$('#mathBTypeReflectionRate').val($(this).find('#modalmathBTypeReflectionRate').html());
		$('#mathATypeReflectionRate').val($(this).find('#modalmathATypeReflectionRate').html());
		$('#englishReflectionRate').val($(this).find('#modalenglishReflectionRate').html());
		$('#socialReflectionRate').val($(this).find('#modalsocialReflectionRate').html());
		$('#scienceReflectionRate').val($(this).find('#modalscienceReflectionRate').html());
		$('#selectCombination').val($(this).find('#modalselectCombination').html());
		$('#researchSubjectNum').val($(this).find('#modalresearchSubjectNum').html());
		$('button[class=close]').trigger('click');
	})
	
	//가산점 비율
	$(document).on('click', '#clickExtraPoint', function(){
		$('#extraPointId').val($(this).find('#modalextraPointId').html());
		$('#koreanExtraRate').val($(this).find('#modalkoreanExtraRate').html());
		$('#mathBTypeExtraRate').val($(this).find('#modalmathBTypeExtraRate').html());
		$('#socialResearchExtraRate').val($(this).find('#modalsocialResearchExtraRate').html());
		$('#scienceResearchExtraRate').val($(this).find('#modalscienceResearchExtraRate').html());
		$('button[class=close]').trigger('click');
	});
	
	
	
	
	//major ajax
	$(document).on('click','#findMajor',function(){
		var universityId=$("#universityId").val();
		var majorHtml="";

		$.ajax({
			url : "getMajor"+universityId,
			dataType : "json",
			success : function(data) {
				$("#majorAjax").html("");
				$.each(data, function(index, major) {
					$('#majorAjax').append("<tr id='clickMajor' style='cursor: pointer'>");
					$('#majorAjax').append("<td>"+(index+1)+"</td>");
					$('#majorAjax').append("<td id='modalMajorName'>"+major.majorName+"</td>");
					$('#majorAjax').append("<td id='modalMajorId'>"+major.majorId+"</td>");
					$('#majorAjax').append("</tr>");
				})
			}
		});
	});


})
</script>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/systemAdminMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div class="row">
						<div class="col-xs-12">
							<div class="card-body">
								<form class="universityManage" method="POST">
									<div class="form-group">
										<div class="col-sm-5">
											<label for="inputEmail3" class="col-sm-3 control-label">대학찾기</label>
											<input type="text" class="form-control" id="modalUniName"
												name="" placeholder="학교를 등록하세요">
											<!-- Button trigger modal -->
											<button type="button" class="btn btn-primary btn-primary"
												data-toggle="modal" data-target="#modalPrimary">대학
												찾기</button>
											<!-- Modal -->
											<div class="modal fade modal-primary" id="modalPrimary"
												tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
															<h4 class="modal-title" id="myModalLabel">대학 리스트</h4>
														</div>
														<div class="modal-body">
															<div class="row"
																style="width: 100%; height: 200px; overflow: auto">
																<!-- Table -->
																<div class="col-md-2"></div>
																<div class="col-md-8">
																	<table class="table table-striped">
																		<thead>
																			<tr class="headings">
																				<th>번호</th>
																				<th>학교명</th>
																				<th>학교ID</th>
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="university"
																				items="${universityList }" varStatus="status">
																				<tr id="clickUniversity" style="cursor: pointer">
																					<td>${status.count }</td>
																					<td id="modalUniName">${university.universityName }</td>
																					<td id="modalUniId">${university.universityId }</td>
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
									<!-- 학과찾기 -->
									<div class="form-group">
										<div class="col-sm-5">
											<label for="inputEmail3" class="col-sm-3 control-label">학과찾기</label>
											<input type="text" class="form-control" id="modalMajorId"
												name="" placeholder="학과를 등록하세요">
											<!-- Button trigger modal -->
											<button type="button" id="findMajor"
												class="btn btn-primary btn-primary" data-toggle="modal"
												data-target="#modalPrimary1">학과찾기</button>
											<!-- Modal -->
											<div class="modal fade modal-primary" id="modalPrimary1"
												tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
															<h4 class="modal-title" id="myModalLabel">학과 리스트</h4>
														</div>
														<div class="modal-body">
															<div class="row"
																style="width: 100%; height: 200px; overflow: auto">
																<!-- Table -->
																<div class="col-md-2"></div>
																<div class="col-md-8">
																	<table class="table table-striped">
																		<thead>
																			<tr class="headings">
																				<th>번호</th>
																				<th>학과명</th>
																				<th>학과ID</th>
																			</tr>
																		</thead>
																		<tbody id="majorAjax">

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



									<!-- 반영비율 입력 -->
									<table class="table table-striped">
										<thead>
											<tr>
												<th colspan="1">반영비율 정보입력</th>
												<th><button type="button"
														class="btn btn-primary btn-primary" data-toggle="modal"
														data-target="#reflectionRateModal">반영비율찾기</button></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>반영비율ID</td>
												<td>수능 반영비율</td>
												<td>학생부 반영비율</td>
												<td>실기 반영비율</td>
												<td>면접 반영비율</td>
												<td>논술 반영비율</td>
												<td>적인성 반영비율</td>
												<td>기타 반영비율</td>
												<td>기타내용</td>
												<td>전형합계</td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													id="reflectionRateId" name="reflectionRateId"
													placeholder="String"></td>
												<td><input type="number" class="form-control"
													id="satReflectionRate" name="satReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="schoolReportReflectionRate"
													name="schoolReportReflectionRate" placeholder="Double">
												</td>
												<td><input type="text" class="form-control"
													id="practiceReflectionRate" name="practiceReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="interviewReflectionRate" name="interviewReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="essayReflectionRate" name="essayReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="aptitudeReflectionRate" name="aptitudeReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="etcReflectionRate" name="etcReflectionRate"
													placeholder="Double"></td>
												<td><input type="text" class="form-control"
													id="etcContent" name="etcContent" placeholder="String">
												</td>
												<td><input type="text" class="form-control"
													id="modelSum" name="modelSum" placeholder="int">
												</td>
											</tr>
										</tbody>
									</table>


									<!-- 수능 영역별 반영비율 -->
									<table class="table table-striped">
										<thead>
											<tr>
												<th colspan="1">수능 영역별 반영비율 정보입력</th>
												<th><button type="button"
														class="btn btn-primary btn-primary" data-toggle="modal"
														data-target="#rrpModal">수능 영역별 반영비율 찾기</button></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>수능반영비율ID</td>
												<td>국어</td>
												<td>수리 가형</td>
												<td>수리 나형</td>
												<td>영어</td>
												<td>사회탐구</td>
												<td>과학탐구</td>
												<td>선택조합</td>
												<td>탐구갯수</td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													id="satReflectionRateId" name="satReflectionRateId"
													placeholder="수능반영비율ID"></td>
												<td><input type="text" class="form-control"
													id="koreanReflectionRate" name="koreanReflectionRate"
													placeholder="국어"></td>
												<td><input type="text" class="form-control"
													id="mathBTypeReflectionRate" name="mathBTypeReflectionRate"
													placeholder="수리 가"></td>
												<td><input type="text" class="form-control"
													id="mathATypeReflectionRate" name="mathATypeReflectionRate"
													placeholder="수리 나"></td>
												<td><input type="text" class="form-control"
													id="englishReflectionRate" name="englishReflectionRate"
													placeholder="외국어"></td>
												<td><input type="text" class="form-control"
													id="socialReflectionRate"
													name="socialReflectionRate" placeholder="사회탐구">
												</td>
												<td><input type="text" class="form-control"
													id="scienceReflectionRate"
													name="scienceReflectionRate" placeholder="과학탐구">
												</td>
												<td><input type="text" class="form-control"
													id="selectCombination" name="selectCombination"
													placeholder="선택조합"></td>
												<td><input type="text" class="form-control"
													id="researchSubjectNum" name="researchSubjectNum"
													placeholder="탐구갯수"></td>
											</tr>
										</tbody>
									</table>


									<!-- 가산점 -->
									<table class="table table-striped">
										<thead>
											<tr>
												<th colspan="1">가산점 정보 입력</th>
												<th><button type="button"
														class="btn btn-primary btn-primary" data-toggle="modal"
														data-target="#extraPointModal">가산점 비율 찾기</button></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>가산점ID</td>
												<td>수리 가형 가산비율</td>
												<td>국어 가산 비율</td>
												<td>사회 탐구 가산비율</td>
												<td>과학 탐구 가산비율</td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													id="extraPointId" name="extraPointId" placeholder="가산점ID">
												</td>
												<td><input type="text" class="form-control"
													id="mathBTypeExtraRate" name="mathBTypeExtraRate"
													placeholder="수리 가형 가산비율"></td>
												<td><input type="text" class="form-control"
													id="koreanExtraRate" name="koreanExtraRate"
													placeholder="국어 가산비율"></td>
												<td><input type="text" class="form-control"
													id="socialResearchExtraRate" name="socialResearchExtraRate"
													placeholder="사회 탐구 가산비율"></td>
												<td><input type="text" class="form-control"
													id="scienceResearchExtraRate"
													name="scienceResearchExtraRate" placeholder="과학 탐구 가산비율">
												</td>
											</tr>
										</tbody>
									</table>


									<!-- 대학 학과별 입시정보 -->
									<table class="table table-striped">
										<thead>
											<tr>
												<th colspan="2">대학 학과별 입시정보 입력</th>
												<th><button type="button"
														class="btn btn-primary btn-primary" id=entranceInfo>FK적용</button></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>학과ID</td>
												<td>대학ID</td>
												<td>연도</td>
												<td>모집 구분</td>
												<td>한국사 반영 계획</td>
												<td>모집 전형종류</td>
												<td>모집 인원</td>
												<td>반영비율 ID</td>
												<!-- <td>학생부반영비율ID</td> -->
												<td>수능반영비율ID</td>
												<td>가산점ID</td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													id="majorId" name="majorId" placeholder="학과ID"></td>
												<td><input type="text" class="form-control"
													id="universityId" name="universityId" placeholder="대학ID">
												</td>
												<td><input type="text" class="form-control"
													id="entranceYear" name="entranceYear" value="2017">
												</td>
												<td><input type="text" class="form-control"
													id="recruitSeparate" name="recruitSeparate"
													placeholder="모집구분"></td>
												<td><input type="text" class="form-control"
													id="hangooksaReflectionPlan" name="hangooksaReflectionPlan"
													value="없음" placeholder="한국사 반영 계획"></td>
												<td><input type="text" class="form-control"
													id="recruitModelType" name="recruitModelType"
													placeholder="모집전형종류"></td>
												<td><input type="text" class="form-control"
													id="RecruitNum" name="RecruitNum" placeholder="모집인원">
												</td>
												<td><input type="text" class="form-control"
													id="reflectionRateId1" name="" placeholder="반영비율ID">
												</td>
												<!-- <td>
											<input type="text" class="form-control"	id="schoolReportReflectionRateId1" name="schoolReportReflectionRateId" placeholder="학생부반영비율ID">
												</td> -->
												<td><input type="text" class="form-control"
													id="satReflectionRateId1" name="" placeholder="수능반영비울ID">
												</td>
												<td><input type="text" class="form-control"
													id="extraPointId1" name="" placeholder="가산점ID"></td>
											</tr>
										</tbody>
									</table>





									<!-- 정시점수 -->
									<table class="table table-striped">
										<thead>
											<tr>
												<th colspan="2">정시점수 정보 입력</th>
												<th><button type="button"
														class="btn btn-primary btn-primary" id=satScore>FK적용</button></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>학과ID</td>
												<td>대학ID</td>
												<td>연도</td>
												<td>모집구분</td>
												<td>백분위총합</td>
												<td>표준점수 커트라인</td>
												<td>환산점수 만점</td>
												<td>환산 표준점수 커트라인</td>
												<td>수능점수 산출활용 지표</td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													id="majorId1" name="" placeholder="학과ID"></td>
												<td><input type="text" class="form-control"
													id="universityId1" name="" placeholder="대학ID"></td>
												<td><input type="text" class="form-control"
													id="entranceYear1" name="" value="2017"></td>
												<td><input type="text" class="form-control"
													id="recruitSeparate1" name="" placeholder="모집구분"></td>
												<td><input type="text" class="form-control"
													id="totalPercentile" name="totalPercentile"
													placeholder="백분위 총합"></td>
												<td><input type="text" class="form-control"
													id="standardScoreCutline" name="standardScoreCutline"
													placeholder="표준점수 커트라인"></td>
												<td><input type="text" class="form-control"
													id="convertScoreMax" name="convertScoreMax"
													placeholder="환산점수 만점"></td>
												<td><input type="text" class="form-control"
													id="convertStandardScoreCutline"
													name="convertStandardScoreCutline"
													placeholder="환산 표준점수 커트라인"></td>
												<td><input type="text" class="form-control"
													id="satScoreUseIndex" name="satScoreUseIndex"
													placeholder="수능점수 산출활용 지표"></td>
											</tr>
										</tbody>
									</table>




									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" class="btn btn-default" value="등록">
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

	<!-- Modal -->
	<!-- 반영비율 찾기 모달 -->
	<div class="modal fade modal-primary" id="reflectionRateModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">반영비율 리스트</h4>
				</div>
				<div class="modal-body">
					<div class="row" style="width: 100%; height: 200px; overflow: auto">
						<!-- Table -->
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<table class="table table-striped">
								<thead>
									<tr class="headings">
										<th>반영비율ID</th>
										<th>수능반영비율</th>
										<th>학생부반영비율</th>
										<th>실기반영비율</th>
										<th>면접반영비율</th>
										<th>논술반영비율</th>
										<th>적인성반영비율</th>
										<th>기타바영비율</th>
										<th>기타내용</th>
										<th>전형합계</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${reflectionRateList }"
										varStatus="status">
										<tr id="clickReflectionRate" style="cursor: pointer">
											<td id="modalreflectionRateId">${list.reflectionRateId }</td>
											<td id="modalsatReflectionRate">${list.satReflectionRate}</td>
											<td id="modalschoolReportReflectionRate">${list.schoolReportReflectionRate }</td>
											<td id="modalpracticeReflectionRate">${list.practiceReflectionRate }</td>
											<td id="modalinterviewReflectionRate">${list.interviewReflectionRate }</td>
											<td id="modalessayReflectionRate">${list.essayReflectionRate }</td>
											<td id="modalaptitudeReflectionRate">${list.aptitudeReflectionRate }</td>
											<td id="modaletcReflectionRate">${list.etcReflectionRate }</td>
											<td id="modaletcContent">${list.etcContent }</td>
											<td id="modalmodelSum">${list.modelSum }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<div class="col-md-1">
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 수능 영역별 반영비율 찾기 모달 -->
	<div class="modal fade modal-primary" id="rrpModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">수능 영역별 반영비율 LIST</h4>
				</div>
				<div class="modal-body">
					<div class="row" style="width: 100%; height: 200px; overflow: auto">
						<!-- Table -->
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<table class="table table-striped">
								<thead>
									<tr class="headings">
										<th>수능반영비율ID</th>
										<th>국어</th>
										<th>수리 가형</th>
										<th>수리 나형</th>
										<th>영어</th>
										<th>사회탐구</th>
										<th>과학탐구</th>
										<th>선택조합</th>
										<th>탐구갯수</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${rrsList }" varStatus="status">
										<tr id="clickRRS" style="cursor: pointer">
											<td id="modalsatReflectionRateId">${list.satReflectionRateId}</td>
											<td id="modalkoreanReflectionRate">${list.koreanReflectionRate}</td>
											<td id="modalmathBTypeReflectionRate">${list.mathBTypeReflectionRate}</td>
											<td id="modalmathATypeReflectionRate">${list.mathATypeReflectionRate}</td>
											<td id="modalenglishReflectionRate">${list.englishReflectionRate}</td>
											<td id="modalsocialReflectionRate">${list.socialReflectionRate}</td>
											<td id="modalscienceReflectionRate">${list.scienceReflectionRate}</td>
											<td id="modalselectCombination">${list.selectCombination}</td>
											<td id="modalresearchSubjectNum">${list.researchSubjectNum}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 가산점 찾기 모달 -->
	<div class="modal fade modal-primary" id="extraPointModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">대학 리스트</h4>
				</div>
				<div class="modal-body">
					<div class="row" style="width: 100%; height: 200px; overflow: auto">
						<!-- Table -->
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<table class="table table-striped">
								<thead>
									<tr class="headings">
										<th>가산점ID</th>
										<th>수리 가형 가산비율</th>
										<th>국어 가산비율</th>
										<th>사회 탐구 가산비율</th>
										<th>과학 탐구 가산비율</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${extraPointList }"
										varStatus="status">
										<tr id="clickExtraPoint" style="cursor: pointer">
											<td id="modalextraPointId">${list.extraPointId }</td>
											<td id="modalkoreanExtraRate">${list.koreanExtraRate }</td>
											<td id="modalmathBTypeExtraRate">${list.mathBTypeExtraRate }</td>
											<td id="modalsocialResearchExtraRate">${list.socialResearchExtraRate }</td>
											<td id="modalscienceResearchExtraRate">${list.scienceResearchExtraRate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>