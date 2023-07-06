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
					<td>${board.no}</td><td>${board.title}</td><td>${board.writer}</td>
					<td>${board.date}</td><td>${board.view}</td><th>${board.like}</th>
				  </tr>`
	 }
	 tcontent.innerHTML= html ;
 }