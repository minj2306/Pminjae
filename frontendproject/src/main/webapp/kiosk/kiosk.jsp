<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/frontendproject/css/kiosk.css" rel="stylesheet">

</head>
<body>
	
	<%@include file="../header.jsp" %>
	
	<div class="kioskwrap">
		<div><!-- 헤더 : 광고 이미지 /카테고리 출력 표시되는 구역 -->
			<img class="himg" src="../img/himg1.png">
			<!-- 카테고리 -->
			<ul class="categorymenu">
				
			</ul>
			
		</div><!-- 헤더 끝 -->
		
		<div class="kikskcontent"> <!-- 본문 : 제품 출력 / 카트 출력 구역 -->
			
			<div class="productbox"><!-- 제품구역 -->
				
				<div class="product"><!-- 제품 1개 기준 -->
					<img src="../img/헬로디아블로와퍼.png"/>
					<div class="pinfo">
						<div class="pname">헬로 디아블로 와퍼</div>
						<div class="pprice">15,000원</div>
					</div>
				</div><!-- 제품 한개 끝-->
				
			</div><!-- 제품구역 끝 -->
			
			<div class="cartbox"><!-- 카트구역 -->
				
				<div class="cartcontent"><!-- 제품개수/가격 , 제품정보 -->
	
					<div class="carttop"><!-- 제품개수/가격 출력 -->
						<div>카트 <span class="ccount">3</span> </div>	
						<div>총 주문금액 <span class="ctotal">31,000</span></div>
					</div><!-- 제품개수/가격 출력 끝-->
					
					<div class="cartbottom"><!-- 제품정보 출력 -->
						<div class="citem"><!-- 카트내 제품 1개 -->
							<div class="iname">더블비프불고기버거</div>
							<div class="iprice">12,000원</div>
							<span class="icencle"> X </span>
						</div>
					</div><!-- 제품정보 출력 끝 -->

				</div><!-- 제품개수/가격 , 제품정보 끝 -->
				
				<div class="cartbtn"><!-- 버튼구역 -->
	
					<button class="cenclebtn">취소하기</button>
					<button class="orderbtn">주문하기</button>

				</div><!-- 버튼구역 끝 -->

			</div><!-- 카트구역 끝 -->
			
		</div>
	</div>	
	
	<%@include file="../footer.jsp" %>
	
	<script src="/frontendproject/js/kiosk.js" type="text/javascript"></script>
</body>
</html>

























