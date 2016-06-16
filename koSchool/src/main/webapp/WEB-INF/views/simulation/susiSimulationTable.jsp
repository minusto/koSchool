<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#center{
	text-align:center; 
	vertical-align:middle;
}
</style>
</head>
<body class="flat-blue">
	<div class="table-responsive col-md-12">
		<div class="card">
			<div class="card-body" style="padding-top:0px">
				<div class="row" style="padding-top: 10px">
					<div class="col-md-6" style="padding-top:7px">
						<div class="col-md-4">
							<select style="width: 100%" id="selectLocation">
								<option value="default" selected>지역별</option>
								<option value="서울">서울</option>
								<option value="경기">경기</option>
								<option value="대전">대전</option>
								<option value="충남">충남</option>
								<option value="충북">충북</option>
								<option value="전남">전남</option>
								<option value="전북">전북</option>
								<option value="경북">경북</option>
								<option value="경남">경남</option>
								<option value="제주">제주</option>
							</select>
						</div>
						<div class="col-md-4" >
							<select style="width: 100%" id="selectKind">
								<option id="optionKind" value="default" selected>계열</option>
								<option value="인문계">인문</option>
								<option value="자연계">자연</option>
							</select>
						</div>
						<div class="col-md-4"></div>
					</div>
					<div class="col-md-6">
						<div class="col-md-4"></div>
						<div class="col-md-8">
							<div class="col-md-3"></div>
							<div class="col-md-6" style="padding-top:7px">
								<input type="text" id="sUniName" class="form-control input-sm" 
									placeholder=" 'ㅇㅇ대학교' 를 입력하세요." style="width: 100%">
							</div>
							<div class="col-md-3">
								<input id="searchUniName" class="btn btn-primary btn-primary" type="button" value="검색">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<table id="center nesinTable" class="table table-striped" >
							<thead>
								<tr>
									<th id="center">지역명</th>
									<th id="center">대학명</th>
									<th id="center">학과</th>
									<th id="center">전형유형</th>
									<th id="center">계열<br>모집인원</th>
									<th id="center">평균등급</th>
									<th id="center">수시진단결과</th>
									<th id="center">최저학력기준</th>
									<th id="center">진단결과</th>
								</tr>
							</thead>
							<tbody id="susiTable1">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
​
