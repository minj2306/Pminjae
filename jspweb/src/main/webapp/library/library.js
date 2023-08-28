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
	
	if(nameInput.value.length==0){
		alert('이름을 정확히 입력해주세요');
	}
	else if(phoneInput.value.lenght==0){
		alert('핸드폰 번호를 정확히 입력해주세요\n(xxx-xxxx-xxxx)')
	}
	else{
		$.ajax({
		url : "/jspweb/library",
		method : "get",
		data : "" ,
		success : function f(r){
			
		
			let phoneInput= document.querySelector('.phoneInput');
		
			if(r[sno-1].sstatusName == '입실중'){
			alert('입실중인 좌석입니다.') 
			return;
			} 
			
			else if(phoneInput.value.length==13){
				
				for(let i = 0 ; i<r.length; i++){
					let phone = r[i].sphone;
					if(phone == phoneInput){
						alert('한명당 1개의 자리만 입실 할 수 있습니다.')
					}
					break;
				}//for end
				
				$.ajax({
				url : "/jspweb/library",
				method : "put",
				data : {sno : sno , 
				sname : nameInput.value , 
				sphone : phoneInput.value  } ,
				success : function f(r){
					if(r==true){
						alert( nameInput.value + "님" +
										 sno + '좌석 입실되었습니다.')
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
      }
   });
   
   
   let nameInput = document.querySelector('.nameInput').value;
   let phoneInput = document.querySelector('.phoneInput').value;
      let data = {
      sno : sno,
      sname : nameInput,
      sphone : phoneInput
      }
   if( phoneInput == r){
      $.ajax({
         url : "/jspweb/libraryy",
         method : "put",
         data : data ,
         success : function f(r){
            console.log('퇴실하기 로직 JAVA와 통신성공02')
            console.log(r)
         } ,
         error : function f(r){}
      })
   }
   
   sno = 0;
}



