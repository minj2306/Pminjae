


console.log('view js 열림')

// 1. list.jsp 에서 클릭된 제목의 bno를 전달받아 게시물 1개 가져오기
getBoard()
function getBoard(){
	console.log('getBoard 실행')
	//1. URL 에 있는 매개변수(쿼리스트링) 가져오기
		// 1. 현재 주소(url) 상 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams;
		console.log( urlParams )
	let bno = urlParams.get("bno"); // url주소에서 bno의 데이터 가져오기
	
	console.log(bno);
	
	// 2. AJAX 이용한 bno 전달해서 게시물의 상세정보 모두 가져오기
	
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "get",
	data : { type : 2 , bno : bno } ,
	success : r => {
		console.log('getBoard 통신성공')
		console.log(r)
		
			//1. 
			let boardBox = document.querySelector('.boardBox');
			
			let html = `
						부가정보 : <div>
									 ${r.bcname} , 
									 ${r.bview} , 
									 ${r.bdate} 
								 </div>
						부가정보2 : <div> 
									 ${r.mid} , 
									 <img src ="/jspweb/member/img/${r.mimg}" width="50px">
								  </div>
						제목 : <div> 
								${r.btitle} 
							 </div>
						내용 : <div> 
								${r.bcontent} 
							</div>
						첨부파일 : <div> 
									<a href="/jspweb/FileDownLoad?filename=${r.bfile}">
										${r.bfile}
									</a> 
								 </div>
						`;
						/* <a href=""> */
			html += `<a href="list.jsp"><button type="button">목록보기</button> </a>`;
			//3. 만약에 본인글 인지 제어 [ 본인글이면 수정/삭제 표시함 / 아니면 표시안함]
			if(r.ishost ){
				html += `
						<button onclick = "onUpdate(${bno})" type="button">수정</button>
						<button onclick = "ondelete(${bno})" type="button">삭제</button>
						`;
			}
			boardBox.innerHTML = html;
	} ,
	error : e => {
		console.log(e)
	}
	})
	
}

// 2.게시물 삭제 -> 레코드 삭제 -> 레코드 식별 -> pk
function ondelete( bno ){
	
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "delete",
	data : { bno : bno } ,
	success : r => { 
		console.log('ondelete 통신 성공');
		console.log(r);
		
		if(r==true){
			alert('삭제 되었습니다.')
			location.href = '/jspweb/board/list.jsp';
		}
		else{ alert('삭제 실패') }
		 
	} ,
	error : e => { console.log(e) }
	})
	
}

// 게시물수정 페이지로 이동
function onUpdate( bno ){
	
	//1. 수정페이지로 이동
	location.href = `/jspweb/board/update.jsp?bno=${bno}`
	
	
	
}