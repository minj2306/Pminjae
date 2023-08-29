
/*
	onchange : 포커스(커서) 변경할떄 값이 다르면 실행
	onkeyup : 키보드에서 키를 누르고 때었을떄
	onkeydown : 키보드에서 키를 눌렀을때

*/

/*
	정규표현식 : 문자열에 특정 규칙 / 패턴 집합 표현할때 사용되는 언어
		문법
			/^ : 정규표현식 시작 알림.
			$/ : 정규표현식 끝 알림.
			[a-z] : 소문자 a-z 패턴 검색
			[A-Z] : 대문자 A-Z 패턴 검색
			[0-9] : 숫자 0~9 패턴 검색
			[가-힣] : 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상반복
			* : 앞에 있는 패턴 0개 반복
						
			예시]
				1. [a-z]			: 소문자 a-z 검색
				2. [a-zA-z] 		: 영문(대,소) 검색
				3. [a-zA-z0-9] 		: 영문 + 숫자 조합 검색
				4. [a-zA-z0-9가-힣] 	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a 와 c 패턴
				6. (?=.*[패턴문자])	: 해당 패턴 문자가 한개 이상 포함패턴
					(?=.*[a-z])		: 소문자 한개이상 필수
					(?=.*[A-Z])		: 대문자 한개이상 필수
					(?=.*[0-9]) 	: 숫자 한개 이상 필수
					(?=.*[\d])		: 숫자 한개 이상 필수
					(?=.*[!@#$%^&*]): 패턴 문자내 특수문자 한개 이상 필수
				
								/^(?=.*[A-Z]{5.20}$/

				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{5.20}$/
				영대문자 1개 + 영소문자 1개 + 숫자 1개 + 특수문자 1개 이상 ㅁ필수로 갖는 5~20 글자 사이
			
			1. /^ [a-z0-9]{5,30} $/ : 영문(소문자)+숫자 조합의 5~30 글자 패턴
			2. /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/ : 
			
		패턴검사
			"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false

*/

//1. 아이디 유효성검사
function idcheck(){//실행조건 : 아이디 입력창에 입력할떄마다
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheckbox = document.querySelector('.idcheckbox')
	// 2. 유효성검사
		// 제어문 이용한 검사 if(mid.length <= 5 && mid.length >= 30 ){ }
		// 1. 아이디는 영문(소문자)+숫자 조합의 5~30 글자 사이 이면서
				//1. 정규표현식 작성.
		let midj = /^[a-z0-9]{5,30}$/
				//2. 정규표현식 검사
		console.log( midj.test(mid) )
	if(midj.test(mid)){//입력한 값이 패턴과 일치하면
		idcheckbox.innerHTML ='패턴합격'	
		// --입력한 아이디가 패턴과 일치하면 아이디 중복검사
		$.ajax({
			url : "/jspweb/MemberFindController" ,
			method : "get" ,
			data : { type : "mid" , data : mid } ,
			success : r => { 
				if(r){ idcheckbox.innerHTML ='사용중인 아이디 입니다.'; checkList[0] = false; }
				else{ idcheckbox.innerHTML ='사용 가능한 아이디 입니다.'; checkList[0] = true;  }
			} ,
			error : r => {}
		})
	}
	else{
		document.querySelector('.idcheckbox').innerHTML ='영문(소문자)+숫자 조합의 5~30 글자 가능합니다.';
		checkList[0] = false; 
	}
	// 3. 결과출력  

}//idcheck end

//비밀번호 유효성검사 [ 1. 정규 표현식 검사 2. 비밀번호와 비밀번호 확인 일치여부 ]
function pwcheck(){
	
		let pwcheckbox = document.querySelector('.pwcheckbox')
	
		console.log('패스워드 입력중')
		let mpwd = document.querySelector('.mpwd').value; console.log('mpwd :' + mpwd);
		
		let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
		
		
		 
		 //2. 유효성검사	
		 	//1. 정규 표현식 만들기 [영대소문자 + 숫자 조합 5~20 글자 사이] 
	 	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
	 	
	 	
		if(mpwdj.test(mpwd)){
		
			if(mpwdj.test(mpwdconfirm)){
				
				if(mpwd==mpwdconfirm){
					pwcheckbox.innerHTML ='사용가능한 비밀번호'; checkList[1] = true; 
				}
				else{
					pwcheckbox.innerHTML = '비밀번호가 일치하지 않습니다.'; checkList[1] = false; 
				}
			}
			else{
				pwcheckbox.innerHTML = '영대소문자 1개 이상 + 숫자 1개 이상 조합 5~20글자 사이로 입력해주세요'; checkList[1] = false; 
			}
		}
		else{
			pwcheckbox.innerHTML = '영대소문자 1개 이상 + 숫자 1개 이상 조합 5~20글자 사이로 입력해주세요'; checkList[1] = false; 
		}
		
}


function emailcheck(){
	console.log('emailcheck 열림')
	let emailcheckbox = document.querySelector('.emailcheckbox');
	//1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;
	
	//2. 이메일 정규표현식 [ 영대소문자,숫자,_- @ ]
	//itdanja@kakao.com
	// 1.itdanja	: 이메일 아이디부분은 영대 소문자 , 숫자 , _- 패턴
	// 2. @			: + @ 	@ 앞에 패턴이 1개 이상 필수
	// 3. 도메인
		//회사명		: @ 뒤에 그리고 . 앞에 패턴은 a-zA-Z0-9_-
		// .		: +\.	: . 앞에 패턴이 1개 이상 필수
		//도메인		: .뒤에 패턴은 a-zA-Z
	
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/	
	
	if(memailj.test(memail)){
		console.log('테스트 통과')
		$.ajax({
			url : "/jspweb/MemberFindController" ,
			method : "get" ,
			data : { type : "memail" , data : memail },
			success : r => {console.log(r);
				if(r){
					emailcheckbox.innerHTML = '사용중인 이메일입니다.'; checkList[2] = false; 
					 document.querySelector('.authReqBtn').disabled = true; // 해당 버튼의 disabled 속성 적용
				}
				 else{
					 emailcheckbox.innerHTML = '사용가능한 이메일입니다.'; checkList[2] = false;
					 document.querySelector('.authReqBtn').disabled = false;// 해당 버튼의 disabled 속성 해제
					 
				 }
			},
			error : r => {console.log(r);}
		})
	}
	else{
		emailcheckbox.innerHTML = '이메일 형식에 맞게 입력해주세요'; checkList[2] = false; 
		document.querySelector('.authReqBtn').disabled = true; // 해당 버튼의 disabled 속성 적용
		
	}
}
//4.  인증요청 버튼 눌렀을때
function authReq(){
	console.log('authReq() 실행')

				//1. div 호출
				let authbox = document.querySelector('.authbox')
				
				//2. auth html 구성
				let html = `
							<span class="timebox"></span>
							<input class="ecode" type="text">
							<button onclick="auth()" type="button">인증</button><br/>
							`;
				// 3. auth html 구성
				authbox.innerHTML = html;
				
				//4. 타이머 실행
				authcode = '1234'; //[controller (서블릿) 에게 전달 받은 값 = 인증코드]
				timer = 120;
				settimer(); // 타이머실행

/////////////////////////////////////////////////////////////////////////////////////////

	// 인증요청시 서블릿 통신 [인증코드 생성 , 이메일전송]
	/*$.ajax({
		url : "/jspweb/AuthSendEmailController" ,
		method : "get" ,
		data : { memail : document.querySelector('.memail').value } ,
		success : r => {
			console.log("authReq Ajax 통신성공")
			console.log(r)

				//1. div 호출
				let authbox = document.querySelector('.authbox')
				
				//2. auth html 구성
				let html = `
							<span class="timebox"></span>
							<input class="ecode" type="text">
							<button onclick="auth()" type="button">인증</button><br/>
							`;
				// 3. auth html 구성
				authbox.innerHTML = html;
				
				//4. 타이머 실행
				authcode = r; //[controller (서블릿) 에게 전달 받은 값 = 인증코드]
				timer = 120;
				settimer(); // 타이머실행
			
			},
		error : e => {console.log(e)}
	})*/
	

}

let authcode = '';
let timer = 0;

let timerInter; //setInterval() 함수를 가지고 있는 변수 [setInterval 종료시 필요]
	
//5. 타이머 함수 만들기
function settimer(){
	//setInterval( 함수명 , 실행간격[밀리초]): 특정시간마다 함수를 실행하는 함수
	timerInter = setInterval( () => { 
		
		// 시간형식 만들기	
			//1. 분 만들기
		let m = parseInt( timer/ 60 ); // 분 계산 [ 몫 ]
		let s = parseInt( timer% 60 ); // 초 계산 [ 나머지 ]
			//2. 두자리수 맞춤 3 -> 03
		m = m < 10 ? "0"+m : m; //만약에 분이 10보다 작으면 한자리수 이므로 0 붙이고 아니면
		s = s < 10 ? "0"+s : s;
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증시간(초) HTML 대입
		timer--; // 1씩 차감
		
		//만약에 타이머가 0보다 크면 [시간 끝] 
		if(timer < 0){
			//1. setInterval 종료
			clearInterval(timerInter);
			//2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML ='인증실패' ;checkList[2] = false; 
			//3. authbox 구역 HTML 초기화
			document.querySelector('.authbox').innerHTML = ``;
		}
	
	} , 1000 );
	
}
/*
	setInterval() : 특정 시간마다 함수를 실행하는 함수
		1.
			let 변수명 = setInterval(function 함수명(){ } , 밀리초 )
			let 변수명 = setInterval(function (){ } , 밀리초 )
			let 변수명 = setInterval( 함수명(){ } , 밀리초 )
			let 변수명 = s etInterval(()=>{ } , 밀리초 )

	clearInterval( timerInter )

*/
// 6. 인증요청후 인증코드를 입력하고 인증하는 함수

function auth(){
	console.log('auth() 열림')
	//1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	console.log('ecode : ' + ecode)
	console.log('authcode : ' + authcode)

	//2. 비교[인증코드와 입력받은 인증코드 ]
	if(authcode == ecode){
		//1. setInterval 종료
		clearInterval( timerInter )
		//2. 인증성공 알림
		document.querySelector('.emailcheckbox').innerHTML = '인증성공'; checkList[2] = true; 
		//3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML = ``;
	}
	else{console.log('인증코드불일치')
		document.querySelector('.emailcheckbox').innerHTML = '인증코드 불일치'; checkList[2] = false; 
	}
}

// 7. 첨부파일에 사진 등록시 등록 사진을 HTML 표시하기 <등록사진을 미리보기 가능>
function preimg( object ){
	console.log('preimg 열림')
	console.log( object ); //이벤트를 발생시킨 태그의 DOM 객체를 인수로 받음
	console.log( document.querySelector('.img'));
	//1. input 태그의 속성 [ type , class , onchange , name 등등]
	//1. input 태그 이면서 type="file" 이면 추가적인 속성
	 	//.files : input type="file" 에 선택한 파일 정보를 리스트로 받음
	console.log( object.files); 
	console.log( object.files[0]); //리스트중에서 하나의 파일만 가져오기
	
	//해당 파일을 바이트코드 로 변환
	//2. JS 파일 클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기 객체 선언
	//3. 파일 읽어오기 함수 제공
	file.readAsDataURL( object.files[0]); //input 에 등록된 파일 리스트중 1개를 파일 객체로 읽어오기 
	console.log( file );
	//4. 익어온 파일을 해당 html img 태그에 load
	file.onload = e => { //onload() : 읽어온 파일의 바이트코드를 불러오기
		console.log( e.target.result ); //읽어온 파일의 바이트코드
		document.querySelector('.preimg').src= e.target.result; // img srcㅇㅂ 속성에 대입
	}
}//preimg end

console.log("signup js 열림")
let checkList = [ false , false , false ] //[0] : 아이디 통과 여부 , [1] : 패스워드 통과 여부 [2] : 이메일 통과여부
// 8. 회원가입 메소드
function signup(){
	
	console.log("signup 열림");
	
	//1. 아이디 / 비밀번호 / 이메일 유효성 검사 통과 여부 체크 
		console.log( checkList );
	if(checkList[0] && checkList[1] && checkList[2] ){ // checkList에 저장된 논리가 모두 true면
		
		console.log('회원가입 진행가능  ');
		
		//2. 입력받은 데이터를 한번에 가져오기 form 태그 이용 
			// <form> 각종 input/button </form>
			//1. form 객체 호출 document.querySelectorAll( 폼태그 식별자 )
			let signupForm = document.querySelectorAll('.signupForm')[0];
			console.log(signupForm);
			//2. form 데이터 객체화
				// 일반 객체로 첨부파일 전송 X -> FormData 객체 이용시 첨부파일 전송 가능
			let signupData = new FormData( signupForm ); // 첨부파일[ 대용량 ] 시 필수..
			console.log( signupData );
			
			//3. AJAX 에게 첨부파일 [대용량] 전송하기
			//첨부파일 있을때. [기존 json 형식의 전송 x form 객체 전송 타입으로 변환]
			$.ajax({
				url: "/jspweb/MemberInfoController" ,
				method : "post" , //첨부파일 form전송은 무조건 post 방식
				data : signupData ,	//FormData 객체를 전송
				contentType : false , //FormData
				processData : false , 
				success : r =>{
					console.log(r);
				},
				error : e => {console.log(e);}
			})
		
	}
	else{ console.log('회원가입 불가능') }
	
	
}

// 0. 유효성검사가 없는 회원가입 메소드
/*
function signup(){
	
	console.log("signup열림")
	//1. HTML 에 가져올 데이터의 tag 객체 호출 [DOM 객체 : html 태그를 객체화]
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let memailInput = document.querySelector('.memail');
	let ecodeInput = document.querySelector('.ecode');
	let mimgInput = document.querySelector('.mimg');
	
	//2. 객체화
	let info = {
		mid : midInput.value ,
		mpwd : mpwdInput.value ,
		memail : memailInput.value ,
		mimg : mimgInput.value
	} 
	//3. 유효성검사 
	
	//4. AJAX 메소드를 이용한 Servlet 과 통신
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "post" ,
		data : info ,
		success : r => {
			console.log('통신성공')
			if(r==true){
				console.log('회원가입 성공')
				
			}
			else{ console.log('회원가입 실패')}
		},
		error : r => {console.log('통신실패')}
	})
		//5. Servlet 의 응답에 따른 제어
	
}*/