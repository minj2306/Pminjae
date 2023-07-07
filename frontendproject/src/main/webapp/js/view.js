/**
 * 
 */
//1. list.js에서 클릭된 게시물 번호 호출 [세션]
let no = sessionStorage.getItem('no');
let boardList = JSON.parse( localStorage.getItem('boardList') );

console.log('list.js 에서 저장된 세션 정보 : ' + no);



//2. 클릭된 게시물 번호의 게시물 찾아서 출력
onView()
function onView(){
	//식별자 : 인덱스 , 게시물번호
	//1.어디에
	let title = document.querySelector('.title')
	let writerdate = document.querySelector('.writerdate')	
	let content = document.querySelector('.content')
	
	// 1. 해당하는 게시물 번호의 게시물 찾기
	for( let i =0 ; i < boardList.length ; i++){
		let b = boardList[i] //i 번째 개시물 꺼내기
		if(b.no ==no){
			//만약애 i번째 게시물 번호와 클릭된 게시물 번호와 같으면
			console.log(b)
			//3. 대입
			title.innerHTML = b.title
			writerdate.innerHTML = `작성자 : ${b.writer} 작성일 : ${b.date}`
			content.innerHTML = b.content
			
			break;
		}
	}
}
// 3. 삭제하기 [실행조건 : 삭제하기 버튼을 클릭했을떄]
function onDelete(){//인수?? 삭제할 식별자 x 전역변수에 있기때문에
	
	//삭제할 게시물 찾기
	for( let i = 0 ; i<boardList.length ; i++ ){//for s
		//2. 클릭된 게시물(현재 보고있는 게시물) 과 i 번째 게시물과 번호가 같으면
		if( no = boardList[i].no){
			//3. 삭제하기
			boardList.splice( i ,1 )
			//배열에 변화된 결과를 쿠키에 반영[js 메모리x]에 반영
			localStorage.setItem('boardList' ,JSON.stringify(boardList) )
			alert('삭제되었습니다.')
			//클릭된 게시물 삭제 했으면 클릭된 게시물 번호기 저장된 세션 삭제
			sessionStorage.removeItem('no'); 
			location.href='list.jsp'
			
			//삭제했으면 다음 인덱스 확인할 필요 x
			break;
		}
	}//for end
	
	
	
}//함수 끝