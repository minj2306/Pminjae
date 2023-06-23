/**
 * 
 */

let joinid =[]
let joinpassword = []

function join( ){
	 
	
	console.log('회원가입')
	//input 태그 호출
	let idInput = document.querySelector('.id')
	let passwordInput = document.querySelector('.password')
	console.log(idInput)
	console.log(passwordInput)
	// 입력 받은 값 호출
	let comid = idInput.value;
	let compw = passwordInput.value;
	console.log(comid);
	console.log(compw);
	//배열등록
	 
	
	//입력값 초기화
	idInput.value=''
	passwordInput.value=''
	
	
	
	
}