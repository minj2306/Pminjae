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

function viewContent(){
	
	$.ajax({
	url : "/jspweb/BoardinfoController",
	method : "get",
	data : "" ,
	success : function f(r){
		
	} ,
	error : function f(r){}
	})
	
}