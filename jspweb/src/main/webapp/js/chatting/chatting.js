
//ajax가 응답의 결과를 가지고 오기전에 아래코드 실행.[ loginState 변경되기 전에 실행되므로 문제발생]
//- 해결방안 ajax 동기화 통신하자..

// 1. 비로그인시 입장 불가능
if(loginState == false){
	alert('회원전용 페이지 입니다.');
	location.href ="/jspweb/member/login.jsp";
}

console.log('채팅방에 입장한 아이디' + loginMid)
// 2. JS 클라이언트[유저] 소켓 만들기
let clientSocket = new WebSocket(`ws://localhost:80/jspweb/serversocket/${loginMid}`);
// - 클라이언트 소켓이 생성되었을때 자동으로 서버소켓에 접속 -----> 서버소켓의 @onOpen으로 이동
// - 서버소켓URL 에 매개변수 전달하기[ 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
	// --- 메소드 4가지 자동으로 실행
		// 1. 클라이언트 소켓이 정상적으로 서버소켓 접속했을때
clientSocket.onopen = e => { console.log('서버와 접속이 성공') };

		// 2. 클라이언트 소켓이 서버소켓과 연결에서 오류가 발생헀을때 
clientSocket.onerror = e => { console.log('서버와 오류발생' + e)  } ;

		// 3. (자동실행) 클라이언트 소켓이 서버소켓과 연결이 끊겼을때
clientSocket.onclose = e => { console.log('서버와 연결이 끊김' + e) } ;

		// 4. (자동실행) 클라이언트 소켓이 메세지를 받았을때
clientSocket.onmessage = e => onMsg(e);

// 3. 서버에게 메세지 전송
function onSend(){
	// 3-1 textarea. 입력값 호출
	let msg = document.querySelector('.msg').value;
	if(msg ==''){ alert('내용을 입력해주세요'); return; }
	// 3-2 메세지 전송..
	clientSocket.send( msg );
	//클라이언트 소켓과 연결된 서버소켓에게 메세지 전송 ---> 서버소켓의 @OnMessage 으로 이동
}

// 4. 메세지를 받았을 때 추후 행동(메소드) 선언
function onMsg(e){
	console.log(e); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data) //.data 속성에 전달받은 메시지 내용
	let msg = JSON.parse( e.data );
		//JSON.parse( ) : 문자열 타입의 JSON 형식을 JSON 타입으로 변환
		//JSON.stringfy() : JSON 타입을 문자열 타입(JSON )
	// 1. 어디에 출력할건지
	let chatcont = document.querySelector('.chatcont');
	
	// 2. 무엇을 
	let html = ``;
	// 2-2 만약에 내가 보냈으면
	if( msg.frommid == loginMid){		
		html +=	 `
				<div class="rcont">
					<div class="subcont">
						<div class="date">오전 10:02</div>
						<div class="content">${msg.msg}</div>
					</div>
				</div>
				`;
	}
	else{//내가보낸 내용이 아니면
		html +=`
				<div class="lcont" >
					<img class="pimg" src="/jspweb/member/img/default.webp">
					<div class="tocont">	
						<div class="name">${msg.frommid} </div>보낸사람
						<div class="subcont">
							<div class="content"> 
								${msg.msg} 
							</div>
							<div class="date">오전 10:10</div>
						</div>
					</div>
				</div>
				`
	}
	
	//3. 누적대입 [ 기존 채팅 목록에 이어서 추가 += ]
	chatcont.innerHTML += html;
} 


/*
	JS [ HTML 파일 종속된 파일 - HTML 안에서 실행되는 구조 ]
	
	* 클라이언트 : 사용자PC
	* 서버 : 데이터 제공하는 PC
	
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
		2. 경로매개변수 : URL/데이터1/데이터2/데이터3
	
	* 소켓이란 
		- 통신의 도착점 [ 데이터가 전달되는 위치 - 받는사람 -보낸사람 ]
	
		
		[클라이언트소켓]								[서버소켓]
		강호동집										우체국					
			안산시 상록구[소켓]									
		신동엽집
			수원시 영통구[소켓]
	
	* WebSocket 웹 소켓 라이브러리
		- 소켓 관련된 함수들을 제공하는 클래스
		1. 클라이언트 웹 소켓 객체 생성
			new WebSocket("ws://IP주소:PORT번호/프로젝트명/서버소켓경로")
		
		2. 메소드제공
			.send() : 클라이언트 소켓이 연결된 서버소켓에게 메세지를 전송
	* 동기화 vs 비동기화
	
	동기화								비동기화
	
	Client			Server				Client			Server
		------요청1----->					------요청1----->
	대기상태			요청1 처리중			대기상태x			요청1 처리중
		<------응답1-----					------요청2----->
														요청2 처리중
		------요청2----->					<------응답2-----
					요청2 처리중
		<-----응답2------					<------응답1-----
*/

//---------------------------------------------------------------------------//
/*
		1. AJAX 
			
			발신자(보내는사람) : AJAX	 
			수신자(받는사람) : 	서블릿	
			
			JS						JAVA[ 서블릿 ]
		
			AJAX
						rest		get
									post
									put
									delete
		2. (웹) 소켓
			소켓 : 통신의 종착점 [ 도착위치 ]
			- 전제조건 : 서버가 클라이언트 소켓의 정보를 가지고 있어야 한다.
			
			JS						JAVA[ 서버소켓 ]
			[클라이언트 소켓]			[ 서버소켓 ] 
			websoket
			1. 서버소켓 접속			2. 서버소켓 24시간 상시 클라이언트 소켓 명단 저장
			3. 데이터 전송				4. 데이터 받는다.			
 */
/*
				클라이언트[사용자]					서버[서비스회사]
		
		강호동 카카오톡
					'안녕' ------------------------>
						 1. 강호동 메시지(안녕) 보낸다.
						 
						 <-------------------------
						 3. '안녕메세지 보낸다.'		
		유재석 카카오톡										    
						<-------------------------
						 3. '안녕메세지 보낸다.'			카카오서버[제주도]
						 								-전제조건 : 클라이언트의 정보들 보관
						 								접속된 명단 : [강호동 , 유재석]
														2. '안녕' 메세지 받는다
		신동엽 카카오톡
						 <-------------------------
						 3. '안녕메세지 보낸다.'
	
		하하 카카오톡
						 <-------------------------
						 3. '안녕메세지 보낸다.'

//1. 클라이언트 소켓 만들기

	//1. JS 웹 소켓 객체 [ ]
	//let 클라이언트소켓 = new WebSocket( 'ws://ip주소:포트번호/서버소켓URL' );
	let 클라이언트소켓 = new WebSocket( 'ws://localhost:80/jspweb/ChattingSocket' ); console.log(클라이언트소켓)
	//2. onopen , onclose , send , onmessage
	
	// 내가만든 함수를 클라이언트 소켓 속성에 대입
	클라이언트소켓.onmessage = (e) => onmsg(e);
	
//2. 연결된 서버소켓에 메세지 보내기
function msgsend(){
	//1. input에 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	//2. 클라이언트소켓.send();
	클라이언트소켓.send( msg ); //input에서 입력받은 데이턱를 보내기 [ 클라이언트소켓.send()=====> 서버소켓 @onMessage ]
}//f end

//3. 연결된 서버소켓으로 부터 메세지를 받았을떄
function onmsg(e){
	console.log(e);
	document.querySelector('.contentbox').innerHTML += `<div>${e.data}</div>`
	document.querySelector('.inputcontent').value =``;
}


*/