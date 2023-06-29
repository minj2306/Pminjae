/*
	메모리 설계
		1. 저장
			누가 작성했는지 = 작성자 let  writer
			무엇 작성했는지 = 제목, 내용 let title , let content
			게시판 작성자 식별방법 = 비밀번호 [작성자 동명이인 있을수 있기 때문에] let password
			*언제 작성되고 몇명이 조회했는지 = 작성일 / 조회수 let date , let view
		
		2. 무엇 입력 요구 할껀지
			작성자, 제목, 내용, 비밀번호 
			
		3. 기능 상태 데이터 저장
			1. 작성일=등록기능이 실행된 시간상태 저장
			2. 조회수=해당 게시물 조회기능 실행된 상태 저장
		4. 데이터 구조 구성
			변수, 배열, 객체
			1. 여러개 데이터 저장하기 위해(배열 vs 객체)
				['유재석' , '제목1' , '내용' , '1234, '2023--06-29' , 0]
				
				vs
				
				{ 작성자 : '유재석' , 제목 : '제목1' , 내용 : '내용1' , 비밀번호 : '1234' , 작성일 : '2023-06-29' , 조회수 : '0' }
			2. 게시물 1개 = 객체 => 게시물(객체) 여러개 저장 공간 => 배열 저장
			
		기능설계
			1. 글 등록기능 = 함수/행동 = onwrite()			C
			2. 글 전체 출력 기능 = 함수/행동 = onPrinte()		R
			3. 글 개별 출력 기능 = 함수/행동 = onView			R
				-수정									U
			4. 글 삭제 기능 = 함수/행동  = onDelete()		D
			

*/
let boardlist = []
//JS 열였을때 최초 한번 실행
onPrinte()

function onwrite(){ console.log('함수실행')
	// 1. 입력받은 데이터 호출
		// 1. document.querySelector(식별자.value)
	let writerValue = document.querySelector('#writer').value;
	let passwordValue = document.querySelector('#password ').value;
	let titleValue = document.querySelector('#title ').value;
	let contentValue = document.querySelector('#content ').value;

		//날짜 모양으로 출력
		let now = new Date(); //1. 현재시스템(pc)의 날짜 / 시간 호출
		let year = now.getFullYear(); // 현재연도
		let month = now.getMonth()+1; //현재 월 [0 = 1월 / 1 = 2월 / 5 = 6월 / 11 = 12월]
		let week = now.getDay(); //현재 요일 [ 0 = 일 1 = 월 ~~]
		let day = now.getDate(); //현재 일
		let hour = now.getHours(); //현재 시
		let minuite = now.getMinutes(); //현재 분
		let second = now.getSeconds(); //현재 초

	// 2. 게시물 1개당 = 객체 1개 선언 만들기 = 각 input은 입력받은 값들을 각 속성명 별로 대입해서 객체 생성
	let board = {
			writer : writerValue , 
			password : passwordValue, 
			title : titleValue,
			content : contentValue,
			date : `${now.getFullYear()} 년
					 ${now.getMonth()+1}월
					  ${now.getDate()}일
					   ${now.getHours()} :
					    ${now.getMinutes()} :
					     ${now.getSeconds()}
					 	`	,
			view : 0
			}
			console.log(board) // board 생성 확인
	//3. 현재 { } 안에서 선언된 board 는 } 끝나면 사라짐[ 지역변수 ] => 전역변수/배열에 저장하자
	boardlist.push(board); console.log(boardlist)//배열 확인
	// 새로운 게시물이 등록되었을떄 게시물 출력 화면 업데이트
	onPrinte() 
}//함수 끝

//2. 출력함수 // 실행조건 : 1. js 실행했을떄 2. 등록했을떄 , 3. 삭제했을떄 , 4. 수정했을떄, 5. 조회수 증가할때마다
function onPrinte() { console.log('프린트함수실행')
	
	//1. 어디에 출력할건지??
	let boardTable = document.querySelector('#boardTable')
	
	//2. 테이블 무엇을 대입/출력할건지?? 객체에 정보들을 객체 1개당 1개씩<tr>출력
	let html =`<tr><th>번호</th><th>제목</th><th>작성일</th><th>조회수</th></tr>`
	
	//배열내 순차적으로 하나씩 열어보자
	for( let i = 0 ; i<boardlist.length ; i++){
		let board = boardlist[i]; //i번째 인덱스 객체 호출
		//로그인=비교=if //HTML 출력 = HTML 구성
	
		html += `<tr>
					<td>${i+1}</td>
					<td onclick="onView(${i})">${board.title}</td>
					<td>${board.date}</td>
					<td>${board.view}</td>
				</tr>`	
	}//for end
	//3. 대입
	boardTable.innerHTML = html

}

function onView( index ){ console.log('제목클릭'+index)
	
	//1. 어디에~~
	let viewBox = document.querySelector('#viewBox')
	//2. 무엇을~~
	let board = boardlist[index]//인수로 전달받은 인덱스의 객체를 1개 꺼내기
	
	let html = `<div> 제목 : ${board.title}</div>
				<div> 내용 : ${board.content}</div>
				<div> 작성자 : ${board.writer}</div>
				<button onclick="onDelete(${index})">삭제</button>
				<button>수정</button>`
	//3. 대입
	viewBox.innerHTML= html
	
	//4. 조회수 증가 하고나면 새로고침
	board.view++; onPrinte();
}

function onDelete( index ){ console.log('삭제함수')
	
	// 1. 삭제할 인덱스의 객체 호출
	let board = boardlist[index];
	
	//2. 
	let password = prompt('비밀번호 : ')
	
	//3. 비교 [삭제할 객체내 비밀번호와 입력받은 비밀번호와 일치하면 삭제 성공]
	if(board.password = password){
		boardlist.splice(index , 1 );//삭제할 인덱스 번호부터 1개 삭제
		onPrinte();
		document.querySelector('#viewBox').innerHTML = ``//현재 삭제된 개별 게시물 출력화면 없애기 
		alert('[삭제성공] 게시물이 삭제되었습니다.')
	}
	else{ //일치하지 않으면
		alert('[삭제실패] 비밀번호가 틀립니다.')}

}