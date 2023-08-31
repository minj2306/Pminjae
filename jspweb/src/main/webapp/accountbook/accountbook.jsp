<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="accountbook.css" rel="stylesheet" />
</head>
<body>
<%@include file ="../header.jsp" %>
	<div class="wrap">
		<div class="inputAccount">
			<div class="inputcontent">
				<input class="textAcc" type="text" placeholder="항목">
				<input class="numberAcc" type="text" placeholder="금액">
				<input class="dateAcc" type="text" placeholder="날짜(YYYY-MM-DD)">
			</div>
			<div class="inputBtnSpace">
				<button onclick="inPut()" class="inputBtn">입력</button>
			</div>
		</div>
		<div class="readAccount">
			<table class="accuntTable">
				<tr>
					<th>번호</th><th>날짜</th><th>항목</th><th>금액</th><th>선택</th>
				</tr>			
			<!-- <tr>
					<td>1</td><td>2023-08-23</td><td>볼펜</td><td>1000</td>
					<td class="choiceBtn"><button>수정</button><button>삭제</button> </td>
				</tr> -->
			</table>
		</div>
	</div>


<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- js import -->
<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>