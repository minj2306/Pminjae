<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="/jspweb/css/board/list.css" rel="stylesheet" />
</head>
<body>
<%@include file ="../header.jsp" %>

	<div class="webcontainer">
		<div class="boardtop">
			<h2> 게시판</h2>		
			<p> 다양한 사람들과 정보를 공유하세요</p>
		</div>
		<div class="boardtopetc">
			<button class="bbtn" onclick="onWrite()" type="button">글쓰기</button>
			<div>
				<span class="boardcount"> 전체 게시물 수 : 13</span> <!-- 전체 게시물 수 -->
				<select class="bbtn listsize" onchange="onListSize()">	<!-- 하나의 페이지에 표시할 최대 게시물 수 -->
					<option value="10" >10</option>
					<option value="15" >15</option>
					<option value="20">20</option>
				</select>
			</div>
		</div>		
		<!-- 3. 카테고리 구역 -->
		<div class="boardcategorybox">
			<button onclick="onCategory(0)" class="bbtn" type="button">전체보기</button>
			<button onclick="onCategory(1)" class="bbtn" type="button">공지사항</button>
			<button onclick="onCategory(2)" class="bbtn" type="button">자유게시판</button>
			<button onclick="onCategory(3)" class="bbtn" type="button">노하우</button>
		</div>
		<!-- 4. 테이블 구역 -->
		<table class="boardTable">
<!-- 		<tr>
				<th>번호</th><th>카테고리</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
			</tr> -->
			<!-- 글 목록 들어갈 공간 -->				
		</table>
		<div class="boardbottom">
			<!-- 5. 페이징처리 구역 -->
			<div class="pagebox">
<!-- 				<button type="button"> < </button>이전페이지
					<button onclick="getList(1)" type="button">1</button>페이징버튼
					<button onclick="getList(2)" type="button" class="selectpage">2</button>
					<button onclick="getList(3)" type="button">3</button>
					<button onclick="getList(4)" type="button">4</button>
					<button onclick="getList(5)" type="button">5</button>
				<button type="button"> > </button> 다음페이지 -->
			</div>
			<!-- 6. 검색구역 -->
			<select class="bbtn" >	<!-- 검색키워드 -->
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
			<input class="keyword" type="text"> <!-- 검색내용 -->
			<button class="bbtn type="button">검색</button>
		</div>
	</div>

<!-- 최신 jquery  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="../js/board/list.js" type="text/javascript"></script>
</body>
</html>