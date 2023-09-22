<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="../css/payment.css" rel="stylesheet" />

</head>
<body>
<%@include file="../header.jsp" %>

	<div class="webcontainer">
		<div class="wrap">
			<div class="paymenthaeder">
			결제 페이지
			</div>
			<div class="patmentspc">
				<div class="amountselect">
					<button onclick="onAmount(1000)" type="button">1000포인트</button>
					<button onclick="onAmount(5000)" type="button">5000포인트</button>
					<button onclick="onAmount(10000)" type="button">10000포인트</button>
					<button onclick="onAmount(50000)" type="button">50000포인트</button>
					<button onclick="onAmount(100000)" type="button">100000포인트</button>
				</div>
				<div class="methodselect">
					<button onclick="onPayMethod('card')" type="button">신용카드</button>
					<button onclick="onPayMethod('trans')" type="button">실시간 계좌이체</button>
					<button onclick="onPayMethod('vbank')" type="button">가상계좌</button>
					<button onclick="onPayMethod('phone')" type="button">휴대폰 소액결제</button>
				</div>
				<div class="finalbtn">
					<button class="paybtn" onclick="requestPay()" type="button">결제하기</button>
				</div>
			</div>
		</div>
	</div>
	
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script src="../js/payment.js" type="text/javascript"></script>
</body>
</html>