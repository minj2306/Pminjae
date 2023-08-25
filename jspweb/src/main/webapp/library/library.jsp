<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="library.css" rel="stylesheet" />
</head>
<body>
 <div class="wrap"> <!-- 전체레이아웃 -->
   
      <div class="inputboxTop"> <!-- 입력칸 -->
         <div class="inputboxB">
            <h3 class="title"> 이름 </h3>
            <input class="nameInput" type="text"/>
            <h3 class="title"> 전화번호 </h3>
            <input class="phoneInput" type="text"/>   
         </div>
      </div>
      
      <div class="outputbox"> <!-- 출력칸 -->
        <!--  <button onclick="seat()" class="seat" type="button"> 1 </button>
         <button onclick="seat()" class="seat" type="button"> 2 </button>
         <button onclick="seat()" class="seat" type="button"> 3 </button>
         <button onclick="seat()" class="seat" type="button"> 4 </button> 
         <button onclick="seat()" class="seat" type="button"> 5 </button>
         <button onclick="seat()" class="seat" type="button"> 6 </button>
         <button onclick="seat()" class="seat" type="button"> 7 </button>
         <button onclick="seat()" class="seat" type="button"> 8 </button> -->
      </div>
      
      <div class="btn"> <!-- 입실 상태에선 퇴실하기로 보여지게 하기 -->
         <button onclick="C()" class="enterBtn" type="button"> 입실하기 </button>
         <button onclick="D()" class="exitBtn" type="button"> 퇴실하기 </button>
      </div>
   
   
   </div> <!-- 전체 레이아웃 -->


<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- js import -->
<script src="library.js" type="text/javascript"></script>
   
</body>
</html>