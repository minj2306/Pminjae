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

/* 게시물 조회 조건 객체*/
let pageOject = { type : 1 , 
					bcno : 0 , 
					listsize : 10 , 
					page : 1 ,
					key : '' ,
					keyword : '' 
				}
	// * type : 1 전체조회 , 2 개별조회
	// * bcno : 조회할 카테고리 번호 [ 기본값은 전체보기 ]
	// * listsize : 하나의 페이지에 최대 표시할 게시물 수 [ 기본값은  10개 ]
	//
// 3. 카테고리 버튼을 클릭했을때
function onCategory( bcno ){
	console.log('클릭된 카테고리 : ' + bcno);
	pageOject.bcno = bcno; // 조회 조건객체내 카테고리 번호를 선택한 카테고리로 변경

	//검색 해제
	pageOject.key = '';
	pageOject.keyword = '';
	
	getList(1); // 조건이 변경되었기 때문에 다시 출력 [ 재 랜더링/새로고침 ]
}

//4. 한페이지 최대 표시할 개수를 변경헀을떄
function onListSize(){
	
	pageOject.listsize = document.querySelector('.listsize').value;
	getList(1)
	
}

//5. 검색 버튼을 클릭했을때
function onSearch(){
	pageOject.key = document.querySelector('.key').value;
	pageOject.keyword = document.querySelector('.keyword').value;
	console.log(pageOject.key);
	console.log(pageOject.keyword);
	getList(1);
}

// 2. 모든글 조회 [js 열렸을떄 1회 자동 실행]
getList(1)
function getList( page ){
	
	pageOject.page = page;
	//클릭된 페이지 번호를 조건 객체에 대입
	
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "get",
	data : pageOject ,
	success : function f(r){
		console.log(r);
		
		//---------------------------------1. 게시물 출력--------------
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
			r.boardList.forEach( b => {
				console.log(b);
				html +=`					
					<tr>
						<td>${b.bno}</td>
						<td>${b.bcname}</td>
						<td><a href="/jspweb/board/view.jsp?bno=${b.bno}">${b.btitle}</a></td>
						<td>
							${b.mid}
							<img src="/jspweb/member/img/${b.mimg}"/>
						</td>
						<td>${b.bview}</td>
						<td>${b.bdate}</td>
					</tr>
						`
			} ); // for end
		// 3. 구성된 html 내용물 출력
		boardTable.innerHTML = html;
		//------------------------------2. 페이지 번호 출력---------------------
	
		html = ``;
		//페이지 개수만큼 페이징 번호 구성
			// 이전 버튼 [page <=1 ? page : page-1 : 만약에 1페이지에서 이전버튼 클릭시 1페이지로 고정하고 아니면 1 차감]
		html += `<button onclick="getList(${ page <= 1 ? page : page-1})"  type="button"> < </button>`
			//페이지 번호 버튼	
		for(let i = r.startbtn; i <= r.endbtn ; i++){
		// 만약에 현재페이지와 i번째 페이지와 일치하면 버튼 태그에 class="selectpage" 추가
		html += `	
				<button onclick="getList(${i})" class ="${page==i ? 'selectpage' : '' }" type="button">${i}</button><!-- 페이징버튼 -->
				`;
 		}	
		//다음버튼 [ page >= pageDto.totalpage ? page : page+1 만약에 현재 페이지가 마지막 페이지 이면 고정 아니면 1 증가]
		html +=`<button onclick="getList(${page >= r.totalpage ? page : page+1})" type="button"> > </button> `;
		
		//pagebox 구역에 구성된 html
		document.querySelector('.pagebox').innerHTML = html;
		
		//------------------------------3. 게시물 수 출력---------------------
		let boardcount = document.querySelector('.boardcount');
		
		// 1. 검색이 있을 떄
		if(pageOject.key == '' && pageOject.keyword == ''){
			boardcount.innerHTML = `총 게시물 수 : ${ r.totalsize}`
		}
		// 2. 검색이 없을 떄
		else{
			boardcount.innerHTML = `검색된 게시물 수 : ${ r.totalsize}`
		}	
		
	} ,
	error : function f(r){}
	})
	
}


/*

	HTTP URL 에 매개변수(파라미터) 전달( 쿼리[질의] 스트링 방식 )
		- 형태	
			URL?변수명 = 데이터
			URL?변수명 = 데이터&변수명 = 데이터
			http://localhost:80/jspweb/board/view.jsp?bno=3
			href="/jspweb/board/view.jsp?bno=${b.bno}"
		
		- 정의 : 페이지 전환시 매개변수(식별키(PK)) 전달
		
		- URL 에서 매개변수 호출
		 new URL(location).href.searchParams.get("변수명")

*/

