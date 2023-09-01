/**
 * 
 */
console.log('list.js 열림');
// 1. 글쓰기 버튼을 클릭하면
function onWrite(){
	
	console.log('onWrite() 실행');
	
	if(loginState){// - 만약에 비 로그인 이면 로그인페이지로 이동
		location.href="/jspweb/board/write.jsp";	
	}
	else{// - 로그인이면 쓰기페이지로 이동
		alert('로그인후 글쓰기 가능합니다.')
		location.href = "/jspweb/member/login.jsp"
	}
	
}

// 2. 모든글 조회 [js 열렸을떄 1회 자동 실행]
getList()
function getList(){
	
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "get",
	data : "" ,
	success : function f(r){
		console.log(r);
		//1. 출력할 위치
		let boardTable = document.querySelector('.boardTable')
		
		let html = `
					<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
					`
			// *서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
			//배열명.forEach			
			r.forEach( b => {
				console.log(b);
				html +=`					
					<tr>
						<th>${b.bno}</th>
						<th>${b.bcname}</th>
						<th>${b.btitle}</th>
						<th>${b.mid}</th>
						<th>${b.bview}</th>
						<th>${b.bdate}</th>
					</tr>
						`
			} ); // for end
		// 3. 구성된 html 내용물 출력
		boardTable.innerHTML = html;
	} ,
	error : function f(r){}
	})
	
}