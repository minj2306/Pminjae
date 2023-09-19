<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="/jspweb/css/header.css" rel="stylesheet" />

</head>
<body>

	<!-- 헤더 -->
	<div id = "header">
		<div class="mainlogo"><!-- 로고 -->
		<a href="/jspweb/index.jsp">
			<img alt="" src="/jspweb/member/img/ezenlogo.png" />
		</a>
		</div>
		
		<ul class="mainmenu"><!-- 본메뉴 -->
			<li> <a href="/jspweb/visitlog/visitlog.jsp">방문록(절대경로)</a>
			<li> <a href="/jspweb/board/list.jsp">게시판</a></li>
			<li> <a href="/jspweb/datago/datago.jsp">공공데이터</a></li>
			<li> <a href="/jspweb/chatting/chatting.jsp">채팅</a></li>		
			<li> <a href="/jspweb/product/register.jsp">제품등록</a></li>	
			<li> <a href="/jspweb/product/list.jsp">제품찾기</a></li>		
			<li> <a href="/jspweb/accountbook/accountbook.jsp" >과제1 : 가계부</a> </li>
			<li> <a href="/jspweb/library/library.jsp" >과제2 : 독서실 좌석 선택</a> </li>
			<li> <a href="/jspweb/hrm/hrm.jsp">과제3 : 직원등록</a> </li>
		</ul>
		
		<ul class="submenu"><!-- 서브메뉴 -->
<!-- 		<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a> </li>
			<li> <a href="/jspweb/member/login.jsp">로그인</a></li>
			<li> <a href="#">로그아웃</a></li>
			<li> <a href="#">마이페이지</a></li>
			<li> <img class="himg" alt="" src="/jspweb/member/img/default.webp"></li> -->
		</ul>

	</div>
	
<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/jspweb/js/header.js"></script>
</body>
</html>
<!-- 404 : 경로문제 [ 1.그 경로/파일 없거나 , 2.있는데 오타 ] -->
<!-- 
	../ : 상위경로 1번 이동
	
	상대경로 : 현위치 기준으로 경로 작성
	visitlog/visitlog.jsp
	
	절대경로 : 모든 경로 작성
	http://localhost/jspweb/test/visitlog/visitlog.jsp
 	- 헤더파일은 불특정 페이지 경로에서 사용되므로 절대경로 링크 권장
 -->
