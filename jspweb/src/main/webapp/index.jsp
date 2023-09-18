<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
	<%@ include file="header.jsp" %>
	

	<!-- 캐러셀 부트스트랩 이미지 슬라이드 -->
	<div id="carouselExample" class="carousel slide">
	  	
	  	<div class="carousel-inner">
		
		    <div class="carousel-item active" >
		      	<img src="/jspweb/img/쇼핑몰1.jpg" class="d-block w-100" alt="...">
		    </div>
		
		    <div class="carousel-item" >
		      	<img src="/jspweb/img/쇼핑몰2.jpg" class="d-block w-100" alt="...">
		    </div>
		
		    <div class="carousel-item" >
		      	<img src="/jspweb/img/쇼핑몰3.jpg" class="d-block w-100" alt="...">
	    	</div>
	  	
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
	
	<!-- 인디케이터 -->
	<div id="carouselExampleIndicators" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/jspweb/img/쇼핑몰4.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/jspweb/img/쇼핑몰5.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/jspweb/img/쇼핑몰6.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	
	
	<!-- 덮어씌우기 -->
	<div id="carouselExampleFade" class="carousel slide carousel-fade">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/jspweb/img/쇼핑몰4.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/jspweb/img/쇼핑몰5.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/jspweb/img/쇼핑몰6.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- 인터벌 -->
<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="5000">
      <img src="/jspweb/img/쇼핑몰4.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item" data-bs-interval="5000">
      <img src="/jspweb/img/쇼핑몰5.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item" data-bs-interval="5000">
      <img src="/jspweb/img/쇼핑몰6.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- 카드 (부트스트랩) 다양한 제품을 표시하는 컨테이너[구역]-->

<div class="card" style="width: 18rem;">
  <img src="/jspweb/img/카드사진1.gif" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

<div class="webcontainer">

	<div class="container">
		<div class="productBox row row-cols-1 row-cols-md-4 g-4">
		  <!-- <div class="col">
		    <div class="card h-100">
		      <img src="/jspweb/img/카드사진1.gif" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		      </div>
		    </div>
		  </div> -->
		</div>
	</div>



</div>

	<!-- JSP 파일안에 다른 JSP 파일 import 하기 -->
	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>
<!--
		ip : 네트워크(인터넷) 사용하는 컴퓨터의 식별번호 [ip당 1개]
			ip : localhost / 192.168.17.134
			-cmd ->ipconfig
			
		port : 컴퓨터 내 프로그램 식별하는 번호 [pc 1개당 프로그램명 여러개 -> port 여러개]
				mysql : 3306 권장
				톰캣서버 : 8080 권장
				http : 80 권장
					-cmd - > netstat -ano
						-여기서 
		
		JAVA
			.java -> 실행[ctrl +f11] -> .class -> console 실행
						컴파일러[번역]
	  	JSP
	  		.jsp -> 실행[ctrl +f11] -> 톰캣[서버]
	  				서버에 파일 빌드
	  -->
	