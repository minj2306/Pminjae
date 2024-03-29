/**
 * 
 */ 

// 1. Create (저장)
function vwrite(){
	
	//HTML input 태그 호출
	let vwriterInput = document.querySelector('.vwriter'); console.log('vwriterInput : ' + vwriterInput)
	let vpwdInput = document.querySelector('.vpwd');  console.log('vpwdInput : ' + vpwdInput)
	let vcontentInput = document.querySelector('.vcontent'); console.log('vcontentInput : ' + vcontentInput)
	
	//2. 객체화
		// let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터}
	let info = {
		vwriter : vwriterInput.value ,
		vpwd : vpwdInput.value ,
		vcontent : vcontentInput.value ,  
	}; console.log(info);
	
	//3. *유효성검사 [중복검사 , 길이체크 등등..]
	
	//4. AJAX (HTML에 JQUERY)
	$.ajax({
		url : "/jspweb/VisitLogController",
		method : "post",
		data : info, 
		success : function f(r){ console.log( r );
			if(r == true){ alert('등록성공'); vread();
			vwriterInput.value = '';
			vpwdInput.value = '';
			vcontentInput.value = '';
			}
			else{alert('등록실패')}
		} ,
		error : function f(r){}	
	})
		//5. 결과에 따른 코드
	
	
}//vwrite end

	
vread()
// 1. Read (호출)
function vread(){//실행조건 : JS 열릴떄 1번 실행 할떄 , 등록 성공 , 수정 , 삭제 => 최신화
	
	$.ajax({
		url : "/jspweb/VisitLogController" ,
		method : "get" ,
		data : "" ,
		success : function f(r){console.log(r);
		
		//-응답 받은 객체를 HTML 에 출력
		//1. [어디에] 출력할 구역의 객체호출
		let output = document.querySelector(".visit_Bottom");
		//2. [무엇을]
		let html = ``;
			//리스트 내 모든 테이터를
			for(let i = 0 ; i<r.length; i++){
				html +=`
				<div class="visitbox"> <!-- 방문록 1개의 표시구역 -->
					<div class="visit_top">
						<div> ${ r[i].vwriter } </div>
						<div class="visitdate"> ${ r[i].vdate} </div>
					</div>
					<div class="visitbox_center"> ${ r[i].vcontent} </div>
					<div class="visitbox_bottom">
						<button onclick="vupdate( ${r[i].vno} )" type="button">수정</button>
						<button onclick="vdelete( ${r[i].vno} )" type="button">삭제</button>
					</div>
				</div>`
			}//for end
			output.innerHTML = html;
		} ,
		error : function f(r){}
	})
}//vread end

// 1. update (수정)
function vupdate( vno ){
	console.log('vupdate open : ' + vno);
	//alert() : 확인알림창
	//confirm() : 확인 / 취소 알림창
	//prompt() : 알림창에서 입력받기
	
	//1.수정할 내용 입력
	let vcontent = prompt('수정할 방문록 내용 : ');
	//2.비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록 비밀번호 : ");
	
	//수정 준비물 : vno(누구를) , vcontent(어떤 내용으로) , vpwd(조건용 : 비밀번호가 일치여부)
	$.ajax({
		url : "/jspweb/VisitLogController" ,
		method : "put" ,
		data : { vno : vno , vcontent : vcontent , vpwd : vpwd } ,
		success : function f (r){
			console.log('통신성공'); 
			if(r == true){
				alert('수정성공');
				vread();
			}
			else{alert('비밀번호가 일치하지 않습니다.');}
		} ,
		error : function f (r){ }
	})
		
}//vupdate end

// 1 delete (삭제)
function vdelete( vno ){
	console.log('vdelete open : ' + vno)
	
	//1. 비밀번호가 일치할 경우에 삭제하므로 확인용 비밀번호 입력받기
	let vpwd=prompt("방문록 비밀번호 : ")
	
	//삭제 준비물 : vno(누구를) , vpwd(조건용 : 비밀번호 일치여부)
	
	$.ajax({
		url : "/jspweb/VisitLogController" ,
		method : "delete" ,
		data : { vno : vno , vpwd : vpwd } ,
		success : function f (r){
			console.log('통신성공');
			if(r == true){
				alert('삭제성공');
				vread();
			}
			else{alert('비밀번호가 일치하지 않습니다.');}
		} ,
		error : function f (r){}
	})
	
}//vdelete end