
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
clientSocket.onopen = e => { 
	
	//1-2 : 만약에 접속을 성공하면 알림메시지 전송
	let msg = {
		type : "alarm" , 
		content : `${loginMid} 님이 입장했습니다.`
	}
	
	//clientSocket.send(msg);// 문제발생 : 해당 메시지를 받는 JAVA는 JSON 타입을 모른다 그래서 문자열 타입으로 전송
	clientSocket.send( JSON.stringify( msg ) );
	
};

		// 2. 클라이언트 소켓이 서버소켓과 연결에서 오류가 발생헀을때 
clientSocket.onerror = e => { console.log('서버와 오류발생' + e)  } ;

		// 3. (자동실행) 클라이언트 소켓이 서버소켓과 연결이 끊겼을때
clientSocket.onclose = e => { 
	
	let msg = {
		type : "exit" ,
		content : `${loginMid} 님이 나갔습니다.`
	}
	
	clientSocket.send( JSON.stringify( msg ) )
} ;

		// 4. (자동실행) 클라이언트 소켓이 메세지를 받았을때
clientSocket.onmessage = e => onMsg(e);

// 3. 서버에게 메세지 전송
function onSend(){
	// 3-1 textarea. 입력값 호출
	let msaValue  = document.querySelector('.msg').value;
	if(msaValue == '' || msaValue == '\n'){ alert('내용을 입력해주세요'); return; }
	// 3-2 메세지 전송..
	
	let msg = { type : 'message' , content : msaValue }
	
	clientSocket.send( JSON.stringify( msg ) );
	//클라이언트 소켓과 연결된 서버소켓에게 메세지 전송 ---> 서버소켓의 @OnMessage 으로 이동

	//3-3 메시지 전공 성공시
	document.querySelector('.msg').value = ``;
	
	
	
}

// 4. 메세지를 받았을 때 추후 행동(메소드) 선언
function onMsg(e){
	console.log(e); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data) //.data 속성에 전달받은 메시지 내용
	
	// 1. 전달받은 내용물을 JSON 타입으로 형 변환
	// e.data : 서버로부터 전달받은 내용물 e.data 속성에 있는 상태
	let msgBox = JSON.parse( e.data ); console.log(msgBox);
		//JSON.parse( ) : 문자열 타입의 JSON 형식을 JSON 타입으로 변환
		//JSON.stringfy() : JSON 타입을 문자열 타입(JSON )
	msgBox.msg = JSON.parse( msgBox.msg );
	
	// 2. msg 속성 내 content 속성의 \n -> <br>
		//-replace() 문자열 교체 / 치환 / 바꾸기 함수
	msgBox.msg.conetnt = msgBox.msg.conetnt.replace(/\n/g , '<br/>');//replace( '변경할 문자열|정규표현식' , '새로운 문자' )
	// 2. 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체 => java : .replaceAll();  js : 정규표현식
	// /g : 모든 패턴의 문자찾기[전체] 
	
	
	msgBox.msg = JSON.parse(content);//치환하고 대입
	console.log(msgBox);
	 // 1. 어디에 출력할건지
	let chatcont = document.querySelector('.chatcont');
	
	// 2. 무엇을 
	let html = ``;
	
	if( msgBox.msg.type == "exit" ){
		html += `${typeHTML( msgBox.msg )}`;
	}
	//  만약에 메시지 타입이 알림이면
	else if( msgBox.msg.type =="alarm" ){
		html += `${typeHTML( msgBox.msg )}`;
	}
	
	else if( msgBox.frommid == loginMid){		
		html +=	 `
				<div class="rcont">
					<div class="subcont">
						<div class="date">${msgBox.date}</div>
						${typeHTML( msgBox.msg )}
					</div>
				</div>
				`;
	}
	else{//내가보낸 내용이 아니면
		html +=`
				<div class="lcont" >
					<img class="pimg" src="/jspweb/member/img/${msgBox.frommimg}">
					<div class="tocont">	
						<div class="name">${msgBox.frommid} </div>보낸사람
						<div class="subcont">
							${typeHTML( msgBox.msg )}
						<div class="date">${msgBox.date}</div>
						</div>
					</div>
				</div>
				`
	}
	
	//3. 누적대입 [ 기존 채팅 목록에 이어서 추가 += ]
	chatcont.innerHTML += html;
	// ----------스크롤 최하단으로 내리기 ( 스크롤 이벤트 )-------------
	// 1. 현재 스크롤의 상단 위치 좌표
	let topHeight = chatcont.scrollTop; //dom객체.scrollTop : 해당 div의 스크롤 상단위치
	console.log(topHeight);
	// 2. 현재 dom객체의 전체 높이
	let scrollHeight = chatcont.scrollHeight; //dom객체.scrollHeight : 해당 div의 스크롤 전체 높이
	console.log( scrollHeight );
	// 3. 전체 높이값을 현재 스크롤 상단 위치에 대입
	chatcont.scrollTop = chatcont.scrollHeight;
} 

//5. textarea 입력창에서 입력할떄마다 이벤트 발생 함수
function onEnterkey(){
	
		// 2. 만약에 ctrl + 엔터 이면 줄바꿈
	if(window.event.keyCode == 13 && // 조합키 : 한번에 두개이상 입력 가능한 키[ ctrl , shift , alt ]
			window.event.ctrlKey ){
				document.querySelector('.msg').value += `\n`;
				return;
			}
	
	// 1. 만약에 입력한 키가[엔터] 이면 메시지 전송
	if(window.event.keyCode == 13){
		onSend();
	}
	
}
getemo();
//6. 이모티콘 출력하기
function getemo(){
	
	
	
	for(let i =1 ; i<=43; i++){
		document.querySelector('.emolistbox').innerHTML +=	
		`<img onclick="onEmoSend( ${i} )" src="/jspweb/img/imoji/emo${i}.gif">`;
	}//for end

}

//7. 클릭한 이모티콘 서버로 보내기
function onEmoSend( i ){
	console.log('이모')
	let msg = { type : 'emo' , content : i+"" }; // i+"" 하는 이유가 replace 는 문자열만 가능
		//type : msg[메세지] , emo[이모티콘] , img[사진]
		// content : 내용물
	
	//2. 보내기
	clientSocket.send( JSON.stringify( msg ) );
}

// 8. msg 타입에 따른 HTML 반환 함수
function typeHTML( msg ){
	
	let html = ``;
	
	// 1. 메시지 타입
	if( msg.type =='message' ){
		html +=`<div class="content">${msg.content}</div>`;
	}
	// 2. 이모티콘 타입
	else if( msg.type == 'emo' ){
		html +=`<img src ="/jspweb/img/imoji/emo${msg.content}.gif"/>`;
	}
	
	else if( msg.type == "alarm" ){
		html += `<div class="alarm"> ${msg.content} </div>`
	}
	else if( msg.type == "exit" ){
		html +=`<div class="alarm"> ${msg.content} </div>`
	}
	return html;
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