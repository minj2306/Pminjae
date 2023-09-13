console.log( 'register.js 열림' )

function onRegister(){
	
	//1. form dom 객체 호출 
	let registerForm = document.querySelector('.registerForm')[0];
	console.log( registerForm );
	
	let formData = new FormData( registerForm ); console.log( formData );

	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => {
		console.log(r);
	} ,
	error : e =>{}
	})	
}










/*function register1() {
	
	console.log( 'register1() 실행' );
	
	$.ajax({// form 태그 없는 경우
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : { 
		pname1 : document.querySelector('.pname1').value ,
		pcontent1 : document.querySelector('.pcontent1').value
	 } ,
	success : r => { console.log(r) } ,
	error : e =>{}
	})// ajax end	
	
}

function register2(){
	
	let registerForm1 = document.querySelector('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({// from 태그 이용하는 경우
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => { console.log(r) } ,
	error : e =>{}
	})// ajax end	
	
}*/