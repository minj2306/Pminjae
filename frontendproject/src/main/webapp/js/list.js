/**
 * 
 */

 console.log('list.js 호출')
 
 //1. 쿠키에 있는 배열 호출
 let boardList = JSON.parse( localStorage.getItem('boardList') );
 	//쿠키/세션에 저장된 객체/ 배열 호출시 JSON.parse()
 	//쿠키/세션에 저장된 객체/배열 저장시 JSON.stringify()
 if(boardList == null)
 boardList = [ ]
 
 boardPrint()
 function boardPrint(){
	 //1. 어디에
	 let tcontent = document.querySelector('.tcontent')
	 //2. 무엇을 
	 let html = ''
	 // HTML 구성 : 쿠키에서 꺼내온 배열을 반복문 해서 HTML 누적 더하기
	 for( let i = 0 ; i<boardList.length ; i++){
		 let board = boardList[i]; // i번째 게시물 호출
		 html += `<tr>
					<td>${board.no}</td><td onclick="onViewLoad( ${board.no} ) ">${board.title}</td><td>${board.writer}</td>
					<td>${board.date}</td><td>${board.view}</td><th>${board.like}</th>
				  </tr>`
	 }
	 tcontent.innerHTML= html ;
}
 
 
 //2. 상세페이지로 이동[실행조건 : 클릭한 게시물 제목]
 function onViewLoad(no){
	 console.log('현재 클릭된 제목(게시물)의 번호 : ' + no);

	 
	 //클릭된 결과를 다른 페이지로 옮기는 방법
	 	//js는 페이지가 전환/새로고침 초기화 -> 세션/쿠키
	 sessionStorage.setItem('no' , no)
	//*조회수 증가 함수 호출
	increaseView( no )
	
	//페이지 이동
	location.href='view.jsp'	 
 }
 
 //3. 조회수 증가함수 [실행조건 : 제목 클릭후 페이지 전환 전에]
 function increaseView( no ){ console.log('조회수증가')
	 //1. 클릭된 게시물 번호의 게시물 찾기
	 for( let i = 0 ; i<boardList.length; i++){
		 if(boardList[i].no == no){//찾았다
		 //조회수 1 증가
		 boardList[i].view++;
		 //*만약에 세션/쿠키를 사용중이라면...업데이트
		 localStorage.setItem('boardList' , JSON.stringify(boardList) )
		break; 
		 }
	 }
	 
 }