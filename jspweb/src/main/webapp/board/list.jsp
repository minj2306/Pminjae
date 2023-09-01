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
		<button onclick="onWrite()" type="button">글쓰기</button>
	</div>

<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="../js/board/list.js" type="text/javascript"></script>
</body>
</html>