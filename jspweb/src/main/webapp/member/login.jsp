<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="../css/member.css" rel="stylesheet" />
</head>
<body>


<%@include file="../header.jsp" %>

	<div class="wrap"><!-- 회원가입 전체 구역 -->
		<div class="signuphaeder">
		회원가입
		</div>
		<div class="signupspc">
		<form class="signupForm" action=""><!-- 폼전송시 각 input에 name 속성 -->
			<h2>이젠 개발자 커뮤니티 회원가입</h2><br/>
			<p>환영합니다. 다양한 커뮤니티 플렛폼을 제공합니다.</p><br/>
			
			<div>아이디 : </div>  
			<input name="mid" class="mid" type="text"><br/>
			
			<br/>
			
			<div>비밀번호 : </div> 
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"><br/>
			
			<!-- 로그인 유효성검사 구역 -->
			<div class="logincheckbox"></div>
			
			<!-- 아이디/비밀번호 찾기 구역 -->
			<div class="findbtnbox"">
				<a href="#" >아이디찾기</a>|
				<a href="#" >비밀번호찾기</a>
			</div>
			<div class="signupbtn">
				<button onclick="login()" type="button">로 그 인</button><br/>
			</div>
		</form>
		</div>
	</div>
		
	<script src="../js/login.js" type="text/javascript"></script>
</body>
</html>
