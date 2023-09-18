<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/list.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
	
	<div class="mapcontent">
		
		<div id="map" style=""></div>
		
		<div class="sidebar">
		
		</div>
	
	</div>


<%@include file="../footer.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f48e0ac6b5d85a68d1d11932b1270b6&libraries=clusterer"></script>
<script src="/jspweb/js/product/list.js" type="text/javascript"></script>
</body>
</html>