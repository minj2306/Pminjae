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
	url : "/jspweb/AdmissionLibrary",
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

//입실하기
function C(){
	
	let nameInput = document.querySelector('.nameInput');
	let phoneInput= document.querySelector('.phoneInput');
	
	if(nameInput.value.length==0){
		alert('이름을 정확히 입력해주세요');
	}
	else if(phoneInput.value.length==0){
		alert('핸드폰 번호를 정확히 입력해주세요\n(xxx-xxxx-xxxx)')
	}
	else{
		$.ajax({
		url : "/jspweb/AdmissionLibrary",
		method : "get",
		data : "" ,
		success : function f(r){
			
			if(r[sno-1].sstatusName == '입실중'){
				alert('입실중인 좌석입니다.') 
				return;
			} 
			else if(phoneInput.value.length==13){
				console.log('else if 입장')
			
				for(let i = 0 ; i<r.length; i++){
					console.log('for문 입장')
					
					let phone = r[i].sphone;
					console.log(phone)
					if(phone == phoneInput.value){
						alert('한명당 1개의 자리만 입실 할 수 있습니다.')
						return;
					}
				}//for end
				
				$.ajax({
				url : "/jspweb/AdmissionLibrary",
				method : "put",
				data : {sno : sno , 
				sname : nameInput.value , 
				sphone : phoneInput.value } ,
				success : function f(r){
					if(r==true){
						alert( nameInput.value + "님" +
										 sno + '좌석 입실되었습니다.')
						nameInput.value = ''; phoneInput.value = '';
						outputbox();
						sno = 0;
						
					}
				} ,
				error : function f(r){}
				}) 
			
		}//else if end
	
		} ,//success end
		error : function f(r){}
		})
	}//else end
}//C() end



function changeStyle(button) {
  button.classList.toggle("changed");
}

function D(){
   console.log('퇴실하기 로직 입장')
   
    $.ajax({
      url : "/jspweb/Library",
      method : "get",
      data : {sno : sno} ,
      success : function f(r){
         console.log('퇴실하기 로직 JAVA와 통신성공01')
         console.log(r)
          	let nameInput = document.querySelector('.nameInput').value;
   			let phoneInput = document.querySelector('.phoneInput').value;
           
           if(nameInput.length==0){ alert('이를을 입력해주세요') }
           else if( phoneInput.length == 0 ){ alert('핸드폰 번호를 입력해주세요') }
           else{
            if( phoneInput == r){
			      
  				let data = {
      				sno : sno,
      				sname : nameInput,
      				sphone : phoneInput
      				}
			      $.ajax({
			         url : "/jspweb/Library",
			         method : "put",
			         data : data ,
			         success : function f(r){
			            console.log('퇴실하기 로직 JAVA와 통신성공02')
			            console.log(r)
			            alert( nameInput + '님 퇴실되었습니다.')
			            sno = 0;
			            console.log(sno);
						document.querySelector('.nameInput').value = '';
   						document.querySelector('.phoneInput').value = '';
			            outputbox();
			         } ,
			         error : function f(r){}
		     	})
   			}//if end
   			else{ alert('핸드폰 번호가 일치하지 않습니다.\n본인좌석을 다시 한번 확인해주세요') }
      }//else end
   }//success end
   });
   
}// D() end



