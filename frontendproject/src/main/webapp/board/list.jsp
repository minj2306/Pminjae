<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 : 반응형 동작 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<!-- 
		부트스트랩 : 미리 만들어진 css/js 빠르게 적용
		-설치/적용 cdn
		1. <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		2. <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
		
		1. .container : 반응형 구역
		2. 그리드 : 해당 구역 12조각
			.row			: 하위요소 가로배치
			.col			: 열
			.col-조각수		: 열-그리드 수
		
			.justify-content-md-center : 가로배치 가로 정렬
			.g-여백수			: 열마다 자동여백[ 24px ] g-0[ 열 여백제거 ]
				
		3.	 
			.table			: 테이블 기본 css
			.table-striped	: 홀/짝 행 구별 색상
			.table-hover	: 행에 마우스 올렸을 때 색상
			.table-bordered	: 테이블 테두리
		4.	.text-center	: 하위요소 가운데 정렬
		5. 	.navigation		: 페이지네이션 / 페이징 처리 버튼
		6.	.form-select	: 셀랙트 상자 꾸미기
		7.	.form-control	: input 상자 꾸미기
	 -->

	<%@include file="../header.jsp" %>
	<!-- css/js 관련 라이브러리(미리 만들어진 css/js 제공 -->
	<div class="container"><!-- 현재 게시물 출력 페이지 전체구역 -->
		
		<a href="/frontendproject/board/write.jsp"><button type="button" class="btn btn-outline-info">글쓰기</button></a>
		
		<h3> 커뮤니티</h3>
		<table class="table table-striped table-hover table-bordered text-center">
			<thead class="table-light">
				<tr>
					<th width="5%">번호</th><th width="55%">제목</th><th width="10%">작성자</th>
					<th width="10%">작성일</th><th width="10%">조회수</th><th width="10%">추천수</th>
				</tr>
			</thead>
			<tbody class="tcontent">
			<!-- boardPrint() 함수가 inner 되는 구역 -->
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">total : 3</td>
				</tr>
			</tfoot>		
		</table>
		
		<nav aria-label="Page navigation example">
  			<ul class="pagination justify-content-center">
    			<li class="page-item disabled">
      				<a class="page-link">Previous</a>
    			</li>
    			<li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			    	<a class="page-link" href="#">Next</a>
    			</li>
  			</ul>
		</nav>
		
		<!-- 검색 창 구역 -->
		<div class="row justify-content-md-center gx-1"> <!-- 구역마다 12 조각 -->
			<div class="col-2">
				<select class="form-select" >
					<option>키워드</option>
					<option>번호</option>
					<option>제목</option>
					<option>작성자</option>
				</select>
			</div>
			<div class="col-3">
				<input type="text" class="form-control">
			</div>
			<div class="col-1">
				<button class="form-control">검색</button>
			</div>
		</div>
	</div>

	<%@include file="../footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!--  -->
	<script src="../js/list.js" type="text/javascript"></script>	

</body>
</html>






















