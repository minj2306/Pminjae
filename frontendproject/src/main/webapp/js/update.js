console.log( 'update.js 실행' )

// 1. 썸머노트 실행할때 사용되는 코드 
$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});
//---------------------------------------//
// 2. 수정/삭제할 게시물 = 클릭된 게시물 = 현재 보고있는 게시물[게시물 번호는= 세션]
let no = sessionStorage.getItem('no'); console.log(no)
let boardList = JSON.parse(localStorage.getItem('boardList'));console.log(boardList)

onView()
//수정할 게시물을 출력
function onView(){
	//1. 어디에
	let title = document.querySelector('.title')
	let content = document.querySelector('#summernote')
	
	//2. 무엇을
	for(let i = 0; i<boardList.length ; i++){
		let b = boardList[i]
		if(b.no == no){
			//3. 출력/대입
			title.value = b.title
			content.value = b.content
			break;
		}//if 끝
	}//for 끝
}//함수 끝

// 3. 수정함수 [실행조건 : 등록 버튼을 클릭했을떄]
function onUpdate(){
	/*
		//누구를
		or( let i = 0 ; i<boardList.length ; i++){
		let b = boardList[i]
		if(b.no == no){
			let title = document.querySelector('.title').value
			let content = document.querySelector('#summernote').value
			b.title = title;
			b.content = content;
			//쿠키/세션 사용중이라면....쿠키/세션 업대이트/새롭게 대입
			localStorage.setItem('boardList' , JSON.stringify(boardList))
			//알림,페이지 전환
			alert('수정되었습니다.')	
			location.href = 'view.jsp'		
		}
	
	
	*/
	
	let title = document.querySelector('.title')
	let content = document.querySelector('#summernote')
	
	for( let i = 0 ; i<boardList.length ; i++){
		let b = boardList[i]
		if(b.no == no){
			boardList[i].title = title.value
			boardList[i].content = content.value
			
			localStorage.setItem('boardList' , JSON.stringify(boardList))
			
			alert('수정되었습니다.')
			
			location.href = 'view.jsp'
		}
		
		
	}
}

