
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
*/