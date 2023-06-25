/**
 * 
 */

let joinid =[]
let joinpassword = []

function join( ){
	 
	
	console.log('회원가입')
	//input 태그 호출
	let idInput = document.querySelector('.id').value
	let passwordInput = document.querySelector('.password').value
	console.log(idInput)
	console.log(passwordInput)
	
	
	//배열등록및 유효성 검사
	if(idInput==` `|| passwordInput==``){
		alert('학번을 입력해주세요 ')
	}
	else if (idInput.length < 8 || passwordInput.length<8){
		alert('아이디 비밀번호는 8글자 이상이어야 합니다. ')
	}
	else{joinid.push(idInput)
		joinpassword.push(passwordInput)
		alert('회원가입 성공! ')
		
	}
		document.querySelector('.id').value = ''
		document.querySelector('.password').value = ''
		console.log(joinid)
		console.log(joinpassword)
}

function log_in( ){ 
	 let loginid = document.querySelector('.login_id').value
	 let loginpw = document.querySelector('.login_pw').value
	 
	 
	 console.log(loginid)
	 console.log(loginpw)
	 
	 if(joinid.indexOf(loginid)==-1){
		 alert('없는아이디 입니다.')
	 }
	 else if(joinpassword.indexOf(loginpw)==-1){
		 alert('비밀번호가 틀렸습니다.')
	 }
	else {alert('로그인 성공! ')
	}
	document.querySelector('.login_id').value = ''
	document.querySelector('.login_pw').value = ''
}