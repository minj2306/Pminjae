<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet" >
</head>
<body>
<%@include file ="../header.jsp" %>
	<div class="webcontainer">
		
		<!-- 채팅 전체구역 -->
		<div class="chatbox">
			
			<!-- 채팅 내용 목록 -->
			<div class="chatcont" >
			
				<!-- 보냇을때 메세지 [오른쪽]-->
		   <!-- <div class="rcont">
					<div class="subcont">
						<div class="date">오전 10:02</div>
						<div class="content">안녕하세요ㅋㅋㅋ</div>
					</div>
				</div>
				알람
				<div class="alarm">강호동 님이 입장하셨습니다.</div>
				받았을때 메세지 [왼쪽]
				<div class="lcont" >
					<img class="pimg" src="/jspweb/member/img/default.webp">
					<div class="tocont">	
						<div class="name"> 강호동 </div>보낸사람
						<div class="subcont">
							<div class="content"> 
								포항항ꉂꉂ(ᵔᗜᵔ*)ㅋㅋㅋㅋ🛳🌊포항항항🚢🌊포핳핳항🛳🌊🚢🌊⚓️⛴ 
							</div>
							<div class="date">오전 10:10</div>
						</div>
					</div>
				</div> -->
			</div>	
			
			<!-- 채팅 입력창 , 전송버튼 -->
			<div class="chatbottom">
				<textarea class="msg"></textarea>
				<button onclick="onSend()" type="button">전송</button>
			</div>
		</div>
	</div>


<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>
</body>
</html>

<!-- <h2> 채팅 </h2>
		<div>
			<div class="contentbox"> </div>
			<input class="inputcontent" type="text">
			<button class="sendbtn" onclick="msgsend()" type="button">전송</button>
		</div> -->