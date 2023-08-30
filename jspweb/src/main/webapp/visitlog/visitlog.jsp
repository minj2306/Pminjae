<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- css import -->
	<link href ="visitlog.css" rel="stylesheet" />
	
</head>
<body>
<%@include file ="../header.jsp" %>

	<!-- CRUD 기반의 비회원 게시판/방문록 구현 -->
	<div class="visitwrap"><!-- 전체구역 -->
		
		<div class="visit_Top"><!-- 쓰기구역 -->
			<div class="visit_Inputs">
				<input class="vwriter" type="text" placeholder="작성자">
				<input class="vpwd" type="password" placeholder="비밀번호">
			</div>
			<textarea class="vcontent" ></textarea>
			<button onclick="vwrite()" type="button">등록</button>
		</div><!-- 쓰기 end -->
		
		<div class="visit_Bottom"><!-- 출력구역 -->
			<!-- JS가 출력해주는 구역 -->
			<!-- <div class="visitbox"> 방문록 1개의 표시구역
				<div>
					<div> 유재석 </div>
					<div class="visitdate"> 2023-08-22 13:30:50 </div>
				</div>
				<div class="visitbox_center">안녕하세요.안녕하세요.안녕하세요.안녕하세요.</div>
				<div class="visitbox_bottom">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>  -->
			
		</div><!-- 출력 end -->
		
		
	</div><!-- 전체구역 end -->

<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- js import -->
<script src="visitlog.js" type="text/javascript"></script>
</body>
</html>