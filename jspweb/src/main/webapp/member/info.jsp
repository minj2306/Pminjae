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
			<h2>마이 페이지</h2><br/>
			
			<div>프로필 변경</div> 
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image"><br/>
			<br/>
			<!-- <태그명 이벤트명 = "함수명( this )"/> -->
			<img class="preimg " alt="" src="" width="100px"><!-- 등록 사진을 미리보기할 사진 태그 -->
			
			
			<div class="intitle">아이디</div>  
			<div class="mid"></div>			
			
			<div>이메일</div> 
			<div class="memail" ></div>
			
			<div class="intitle">기존 비밀번호</div> 
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"><br/>
			<br/>
			
			<div class="intitle">새로운 비밀번호</div> 
			<input onkeyup="pwcheck()" name="newpwd" class="newpwd" type="password"><br/>
			<span class="pwcheckbox"></span><br/>
			
			
			<div class="signupbtn">
				<button onclick="mupdate()" type="button">수정</button><br/>
				<button onclick="mdelete()" type="button">탈퇴</button><br/>
			</div>
		</form>
		</div>
	</div>
	<script src="../js/signup.js" type="text/javascript"></script>
	<script src="../js/info.js" type="text/javascript"></script>
</body>
</html>
