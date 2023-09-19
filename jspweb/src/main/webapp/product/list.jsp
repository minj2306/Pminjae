<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/list.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
	
	<div class="mapcontent">
		
		<div id="map" style=""></div>
		
		<div class="sidebar">
			<!-- <div class="card mb-3" style="max-width: 540px;">mb-3 : 아래마진 / m : 마진 / p : 패딩
			  <div class="row g-0">row : flex역할 하위 요소를 가로배치 / g-0 : 기본 간격 제거
			    
			    <div class="col-md-4">
			      <img src="" class="img-fluid rounded-start" alt="...">
			    </div>
			    
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Card title</h5>
			        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
			      </div>
			    </div>

			  </div>
			</div> -->
		</div>
	
	</div>


<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f48e0ac6b5d85a68d1d11932b1270b6&libraries=clusterer"></script>
<script src="/jspweb/js/product/list.js" type="text/javascript"></script>
</body>
</html>