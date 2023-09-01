<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="../css/board/list.css" rel="stylesheet" />
</head>
<body>
<%@include file ="../header.jsp" %>

	<div class="webcontainer">
		<h3>글 목록 페이지</h3>
		<div>
			<table>
				<thead>
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td><td>글 제목 들어갈 공간</td><td>아이디</td><td>2023-09-01 14:47:30</td><td>12</td>
					</tr>
				</tbody>
			</table>
		</div>
		<button onclick="onWrite()" type="button">글쓰기</button>
	</div>

<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="../js/board/list.js" type="text/javascript"></script>
</body>
</html>