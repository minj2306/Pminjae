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
}

function EndChat(){
	loginNum = 0;
	
}

function sendButton(){
	
	
	let chatingInput = document.querySelector('.chating'); console.log('chatingInput : '+chatingInput)
	
	let chating = { loginNum : loginNum ,
				  	chatingInput : chatingInput
	 			}
	
	  $.ajax({
      url : "/jspweb/ChatRoomController",
      method : "post",
      data : chating ,
      success : function f(r){
		  
		  if(r==true){
			  
			  console.log(chating);
			  
		  }
		  
		  
	  } ,
      error : function f(r){}
   })
	
}


