<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file ="../header.jsp" %>

	<div class="webcontainer">
			
		<form class="registerForm">
			카테고리 : <select name="pcno" >
							<option value="1">노트북</option>
							<option value="2">테블릿</option>
							<option value="3">냉장고</option>			
					</select> <br/>
			제품명 : <input name="pname" type="text" ><br/>
			제품설명 : <textarea name="pcontent"></textarea><br/>
			제품가격 : <input name="pprice" type="number"><br/>
			
			제품장소 : <div id="map" style="width:100%;height:350px;"></div>
			<p><em>지도를 클릭해주세요!</em></p> 
			<div id="clickLatlng"></div>
			
			
			<!-- 첨부파일 1개일때 --> 
			<!-- 제품이미지 : <input name="pimg" type="file"><br/> -->
			
			<!-- 첨부파일 여러개일때 input 속성에 multiple -->
			<!-- 제품이미지 : <input name="pimg" type="file" multiple="multiple" ><br/> -->
			<!-- multiple="multiple" 속성 사용시 cos.jar 에서는 여러개 파일명 호출 불가능 -->
			
			<!-- 해결방안 : 1. multiple="multiple" 사용하지 않고 input 여러개 사용 -->
			<!-- 해결방안 : 2 . multiple="multiple" 사용하고 cos.jar 대신 commons.jar -->
			
			<!-- 3. 드래그 앤 드랍 -->
			<div class="fileDropBox" style= "width: 300px; height: 100px; border: 1px solid red;">
				여기에 드래그 해서 파일을 올려주세요
			<!-- 	<div>
					<span>파일명</span>
					<span>파일사이즈</span>
					<span> <button type="button">삭제</button> </span>
				</div> -->
			</div>
			
			<button onclick="onRegister()" type="button">등록</button>
		</form>
		
	</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f48e0ac6b5d85a68d1d11932b1270b6"></script>
<script src="/jspweb/js/product/register.js" type="text/javascript"></script>
</body>
</html>

<!-- 		<h3>제품 등록 페이지 [ form 태그 없는 경우 1 ] </h3>
		<div>
			제품명 : <input class="pname1" type="text"> <br/>
			제품설명 : <textarea class="pcontent1" ></textarea> <br/>
			<button onclick="register1()" type="button">등록</button>
		</div> -->

			<!-- cos.jar 첨부파일 여러개일때 -->
			
			<!-- <input name="pimg" type="file" multiple="multiple" >
			<input name="pimg" type="file" multiple="multiple" >
			<input name="pimg" type="file" multiple="multiple" >
			<input name="pimg" type="file" multiple="multiple" >
			 -->
					
		
		
		
		
		