/**
 * 
 */
console.log('chatRoom 열림')
let loginNum = 0;

function StartChat(){
	
	let newlogin = 0;
	newlogin = parseInt( Math.random()*9999+0 );
	loginNum = newlogin;
	console.log(loginNum);
	
	let wrap = document.querySelector('.wrap')
	let html = ``;
	html +=`
		<div class="chatHead">
			<div class="EKAOTALK">EKAO TALK</div>
		</div>
		<div class="chatContent">

		</div>
		<div class="chatInput">
			<div class="ChatButton">
				<button onclick="EndChat()" class="EndChat">이카오톡 끝내기</button>
			</div>
			<div class="sendArea">
				<textarea class="chating"></textarea>
				<button onclick="sendButton()" class="sendButton">전송</button>
			</div>
		</div>
			`
	
		wrap.innerHTML = html;
		
		
		let chatContent = document.querySelector('.chatContent')
	
		chatContent.scrollTop = chatContent.scrollHeight ;
		readChat();
}

function EndChat(){
	loginNum = 0;
	
}

function sendButton(){
	
	
	let chatingInput = document.querySelector('.chating'); console.log('chatingInput : '+chatingInput);
	
	let chating = { loginNum : loginNum ,
				  	chatingInput : chatingInput.value ,
	 			}
	
	  $.ajax({
      url : "/jspweb/ChatRoomController",
      method : "post",
      data : chating ,
      success : function f(r){
		  
		  if(r==true){
			  
			  console.log(chating);
			  chatingInput.value = ''; readChat();
		  }
		  
		  
	  } ,
      error : function f(r){}
   })
	
}//sendButton end

function readChat(){
	$.ajax({
		url : "/jspweb/ChatRoomController",
		method : "get" ,
		data : "",
		success : function f(r){
			let output = document.querySelector('.chatContent');
			let html = ``;
			
			for(let i = 0; i<r.length; i++){
				html += `
				<div class="speechBubble">
					<div class="anonymousId">${r[i].chatid}님</div>
					<div class="anonymousChat">${r[i].ccontent}</div>
					<div class="Chattime">${r[i].ctime}</div>
				</div>
				`
			}//for end
			
			
			output.innerHTML = html;
			
		} ,
		error : function f(r){}
	})
}


