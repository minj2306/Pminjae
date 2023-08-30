/**
 * 
 */
console.log('hrm js 열림')

function hrmimg( hhimg ){
	
	console.log( 'hrmimg 열림' )
	
	let file = new FileReader();
	
	file.readAsDataURL( hhimg.file[0] );
	
	file.onload = e =>{
		document.querySelector('.hrmimg').src = e.target.result;
	}
}

function registRation(){
	console.log('registRation() 실행')

	let hname = document.querySelector('.hname');
	let hphone = document.querySelector('.hphone');
	let hposition = document.getElementById('.hposition');
	console.log(hposition);
	console.log(hphone.value);
	

	if( hname.value.length == 0 ){
		alert('이름을 입력해주세요');
		return;
	}
	else if( hphone.value.length < 13 ){
		alert('핸드폰 번호를 입력해 주세요');
		return;
	}

	else if(status==false){
		alert('이미 등록된 핸드폰 번호 입니다.');
		return;
	}
	
	let regForm = document.querySelectorAll('.regForm')[0];
	console.log(regForm);
	
	let regData = new FormData( regForm );
	console.log( regData );
	
	$.ajax({
	url : "/jspweb/HrmController",
	method : "post",
	data : regData ,
	contentType : false ,
	processData : false ,
	success : function f(r){
		console.log('통신성공')
		console.log(status);
		
		if(r==true){ alert('직원등록 성공했습니다.') }
		else{alert('직원등록 실패.')}
		
	} ,//success end
	error : function f(r){}
	})//$.ajax end
	
}

let status = false;

function hphoneCheck() {
	console.log('hphoneCheck() 실행');
	let hphone = document.querySelector('.hphone');
	
	if(hphone.value.length == 13){
		
		$.ajax({
		url : "/jspweb/HrmController",
		method : "get",
		data : "" ,
		success : function f(r){
			
			for(let i = 0 ; i < r.length ; i++){
			
				if( r[i].hphone == hphone.value){
				status = false;
				return;
				}
			}
			status = true;
			
		} ,
		error : function f(r){}
		})
	}
}


goOutput()
function goOutput(){

		let output = document.querySelector('.output');
		let html = ``;
		 
		$.ajax({
		url : "/jspweb/HrmController",
		method : "get",
		data : "" ,
		success : function f(r){
			
			for(let i = 0 ; i < r.length ; i++){
			
				html +=`
					<tr>
						<td>${r[i].hno}</td>
						<td><img alt="" src="img/${r[i].himg}" width="100px"></td>
						<td>${r[i].hname}</td>
						<td>${r[i].hposition}</td>
						<td>${r[i].hdate}</td>
						<td>${r[i].hphone}</td>
					</tr>
						`
				}
			
			output.innerHTML = html;
		} ,
		error : function f(r){}
		})
	
}