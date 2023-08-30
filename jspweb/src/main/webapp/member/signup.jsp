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
			<input onkeyup="idcheck()" name="mid" class="mid" type="text"><br/>
			<span class="idcheckbox"></span>
			<br/>
			
			<div>비밀번호 : </div> 
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"><br/>
			<br/>
			<div>비밀번호 확인 : </div> 
			<input onkeyup="pwcheck()" class="mpwdconfirm" type="password"><br/>
			<span class="pwcheckbox"></span><br/>
			
			
			<div>이메일 :</div> 
			<input onkeyup="emailcheck()" name="memail" class="memail" type="text"> <button onclick="authReq()" class="authReqBtn" disabled type="button">인증요청</button><br/>
			
			<div class="authbox" >
			<!-- 인증요청 버튼 클릭시 보이는 구역 -->
			</div>
			
			<span class="emailcheckbox"></span><br/>
			
			<div>프로필 : </div> 
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image"><br/>
			<br/>
			<!-- <태그명 이벤트명 = "함수명( this )"/> -->
			<img class="preimg " alt="" src="img/default.webp" width="100px"><!-- 등록 사진을 미리보기할 사진 태그 -->
			
			<div class="signupbtn">
				<button onclick="signup()" type="button">회 원 가 입</button><br/>
			</div>
		</form>
		</div>
	</div>
		
	<script src="../js/signup.js" type="text/javascript"></script>
</body>
</html>
