<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href ="chatRoom.css" rel="stylesheet" />

</head>
<body>
	<div class="start">
		<button onclick="StartChat()" class="StartChat">이카오톡 시작하기</button>
	</div>

	<div class="wrap"><!-- wrap s -->
	<!--<div class="chatHead">
			<div class="EKAOTALK">EKAO TALK</div>
		</div>
		<div class="chatContent">

		</div>
		<div class="chatInput">
			<div class="ChatButton">
				<button onclick="EndChat()" class="EndChat">이카오톡 끝내기</button>
			</div>
			<div class="sendArea">
				<textarea class="chating"></textarea>
				<button onclick="sendButton()" class="sendButton">전송</button>
			</div> sendArea end
		</div> chatInput end -->
		
	</div>


<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script src="chatRoom.js" type="text/javascript"></script>
</body>
</html>