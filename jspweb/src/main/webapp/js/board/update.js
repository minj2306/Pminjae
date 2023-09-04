//2. 쿼리스트링(URL 주소상의 변수) 의 변수 가져오기
	//쿼리스트링 : URL?변수명=값&변수명=값&변수명=값
let bno = new URL(location.href).searchParams.get("bno");

console.log('update js 열림')

//수정할 게시물의 기존 정보를 보여주기
getBoard()
function getBoard(){
	console.log('getBoard 실행')

	console.log(bno);
	// 3. ajax 에게 bno 전달해서 게시물 정보 가져오기
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "get",
	data : { type : 2 , bno : bno } ,
	success : r => {
		console.log('getBoard 통신성공')
		console.log(r);
		//응답결과를 html 대입
		document.querySelector('.bcno').value = `${r.bcno}`;
		document.querySelector('.btitle').value = `${r.btitle}`;
		document.querySelector('.bcontent').value = `${r.bcontent}`;
		document.querySelector('.oldfile').innerHTML = `${r.bfile}`;
	
	} ,
	error : e =>{}
	})	
	
}

function onUpdate(){
	 
	//입력된(수정된) form 정보 한번에 가져오기
		// 1. form 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
	console.log(writeForm);
		// 2. form 객체화
	let formData = new FormData(writeForm);
	console.log('.form')
		// 3. form 객체에 데이터 추가(bno)
			//.set( 키 , 값 ); //form에 데이터 속성 추가
		formData.set( "bno" , bno );
	//ajax 대용량(첨부파일) multipart
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "put",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => {
		console.log('onUpdate 통신성공')
		console.log(r)
		if(r==true){
			alert('수정성공')
			location.href = `/jspweb/board/view.jsp?bno=${bno}`
		}
		else{alert('수정실패')}
	} ,
	error : e =>{
		console.log(e)
	}
	})
	 
	 
}