<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/view.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>

	<div class="webcontainer">
		<div class="productBox">
			<!-- 캐러샐 -->
			<div id="carouselExample" class="carousel slide"><!-- 캐러셀 : 이미지 슬라이드 -->
			  
			  <div class=" imgbox carousel-inner">	<!-- carousel-inner : 캐러셀 안에 넣을 이미지 목록 구역 -->
			    <!-- <div class="carousel-item active"> carousel-item : 이미지 1개당 active :
			      <img src="..." class="d-block w-100" alt="...">
			    </div> -->
			    
			  </div>
			  
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			
			</div>
			<!-- 캐러샐 end -->
			
			<div>이미지 슬라이드</div>
			<div class="mid"></div>
			<div class="categorydate">
				<div class="pcname"></span> </div>
				<div class="pdate"> </div>
			</div>
			<div class="pname"> </div>
			<div class="pprice"></div>
			<div class="pcontent"></div>
			<div class="etcbtnbox">
				<button type="button">찜하기S2</button>
				<button type="button">바로구매</button>
			</div>
			
			<!-- 탭스 -->
				<!-- 1. 탭 목록 -->
			<ul class="mt-5 nav nav-tabs nav-pills nav-fill" id="myTab" role="tablist">
			 
			  <li class="nav-item" role="presentation">
			    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">
			    	제품위치
			    </button>
			  </li>
			 
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">
			  	  제품후기
			    </button>
			  </li>
			 
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact-tab-pane" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">
			    	QnA
			    </button>
			  </li>
			 
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="disabled-tab" data-bs-toggle="tab" data-bs-target="#disabled-tab-pane" type="button" role="tab" aria-controls="disabled-tab-pane" aria-selected="false" >
			    	구매유의사항
			    </button>
			  </li>
			
			</ul>
			<!-- 2. 탭 내용 -->
			<div class="tab-content" id="myTabContent">
		
			  <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
			  	제품 위치 출력되는 구역
			  </div>
			
			  <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			  	제품 후기 출력되는 구역
			  </div>
			  
			  <div class="tab-pane fade" id="contact-tab-pane" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">
			  	QnA 출력되는 구역
			  </div>
			  
			  <div class="tab-pane fade" id="disabled-tab-pane" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">
			  	구매 유의사항 출력되는 구역
			  </div>
			
			</div>
			<!-- 탭스 end -->
		</div>
	</div>
 
<%@include file="../footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f48e0ac6b5d85a68d1d11932b1270b6&libraries=clusterer"></script>
<script src="/jspweb/js/product/view.js" type="text/javascript"></script>
</body>
</html>