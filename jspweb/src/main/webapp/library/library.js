/**
 * 
 */
outputbox();
let sno = 0;


function seat(i){
   sno = i;
   
}
//좌석 출력하기
function outputbox(){

	$.ajax({
	url : "/jspweb/library",
	method : "get",
	data : "" ,
	success : function f(r){
		
		let output = document.querySelector('.outputbox')
		
		let html = ``;
		
		for(let i = 0 ; i < r.length; i++){
			html +=`
		 	<button onclick="seat(${r[i].sno})" class="seat" type="button"> ${r[i].sno} 번 ${r[i].sstatusName} </button>
			`
		}//for end
		output.innerHTML = html;
	} ,
	error : function f(r){}
	})
}

function C(){
	
	let nameInput = document.querySelector('.nameInput');
	let phoneInput= document.querySelector('.phoneInput');
	
	
	$.ajax({
	url : "/jspweb/library",
	method : "get",
	data : "" ,
	success : function f(r){
		
	
		let phone = r[sno].sphone;
	
		if(r[sno-1].sstatusName == '입실중'){
		alert('입실중인 좌석입니다.') 
		} 
			
		else if(phone == phoneInput.value ){
			alert('이미 입실한 회원입니다.')
		}
		else{
			$.ajax({
			url : "/jspweb/library",
			method : "put",
			data : {sno : sno , 
			sname : nameInput.value , 
			sphone : phoneInput.value  } ,
			success : function f(r){
		
				alert( nameInput.value + "님" +
								 sno + '좌석 입실되었습니다.')
		
			} ,
			error : function f(r){}
			})
		}//else end
	
	} ,
	error : function f(r){}
	})
	
}


function D(){
   console.log('퇴실하기 로직 입장')
   
   let nameInput = document.querySelector('.nameInput').value;
   let phoneInput = document.querySelector('.phoneInput').value;
      let data = {
      sno : sno,
      sname : nameInput,
      sphone : phoneInput
      }
   if( phoneInput == 현재입실중인사람전화번호){
      $.ajax({
         url : "/jspweb/libraryy",
         method : "put",
         data : data ,
         success : function f(r){
            console.log('퇴실하기 로직 JAVA와 통신성공')
            console.log(r)
         } ,
         error : function f(r){}
      })
   }
   
}