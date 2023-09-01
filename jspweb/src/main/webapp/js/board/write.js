/**
 * 
 */
console.log('write.js 왔다')

// write , update , delete : js 내장 함수들 존재하기 때문에
function bwrite(){
	
	//1. form 가져오기
		//document.querySelectorAll() : 배열타입으로 여러 dom 객체
		//document.querySelector() : 객체타입으로 한개 dom객체
	let form = document.querySelectorAll('.writeForm')[0];
	console.log(form);
	//2. form 객체화하기
	let formData = new FormData( form );
	console.log (formData);
	
	//3. ajax로 대용량 form 전송하기
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "post",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => {
		console.log('bwrite ajax 통신성공')
		if(r==true){
			alert('글쓰기 성공');
			location.href="/jspweb/board/list.jsp";
		}
		else{
			alert('글쓰기 실패')
		}
		
	} ,
	error : e => {}
	})
}