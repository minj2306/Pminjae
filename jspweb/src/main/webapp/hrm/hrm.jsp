<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="hrm.css" rel="stylesheet" />
</head>
<body>
<%@include file ="../header.jsp" %>

	<div class="wrap"><!-- 전체구역 -->
		<div class="RegistrationBox"><!-- 직원등록 구역 -->
			<form class="regForm" action="">
				<div class="inputbox">
					직원명
					<input class="hname" name="hname" type="text">
				</div>
				<div class="inputbox">
					전화번호
					<input onkeyup="hphoneCheck()" class="hphone" name="hphone" type="text">
				</div>
				<div class="inputbox">
					직급
					<select class="hposition" name="hposition" >
						<option>사장</option>
						<option>부장</option>
						<option>팀장</option>
						<option>대리</option>
						<option>주임</option>
						<option>사원</option>
				</select>
				</div>
				<div class="inputbox">
					직원사진
					<input onchange="hrmimg( this )" class="hrmimg" name="hrmimg" type="file">
				</div>
			</form>
				<div>
					<button onclick="registRation()" class="RegistrationBtn">등록</button>
				</div>
		</div>
		
		<div class="OutputBox"><!-- 직원 출력구역 -->

			<table class="outputTable">
				<thead class="outputth">
					<tr>
						<th>직원번호</th><th width="100px">프로필</th><th>직원명</th><th>직급</th><th>입사일</th><th>연락처</th>
					</tr>
				</thead>
				<tbody class ="output outputtd">
				<!-- <tr>
						<td>1000</td><td> <img alt="" src="img/default.webp" width="100px"> </td><td>김철수</td><td>사원</td><td>2023-08-30</td><td>010-1111-1111</td>
					</tr> -->
				</tbody>
			</table>
		</div>
	
	
	</div><!-- 전체구역 end -->



<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script src="hrm.js" type="text/javascript"></script>
</body>
</html>