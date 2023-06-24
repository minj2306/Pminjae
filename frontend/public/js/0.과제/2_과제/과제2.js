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
	//배열등록및 유효성 검사
	if(comid==` `|| compw==``){
		alert('학번을 입력해주세요 ');
	}
	else if (comid.length < 8 || compw.length<8){
		alert('아이디 비밀번호는 8글자 이상이어야 합니다. ');
	}
	else{joinid.push(idInput)
		joinpassword.push(passwordInput)
		alert('회원가입 성공 ')}
	 console.log(joinid)
	console.log(joinpassword )
	//입력값 초기화
	idInput.value=''
	passwordInput.value=''
}

function log_in(){
	 let login_idInput = document.querySelector('login_id')
	 let login_pwInput = document.querySelector('login_pw')
	 
	 
	 
}