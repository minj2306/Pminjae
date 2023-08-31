/**
 * 
 */
//0. 로그인된 회원정보
getInfo()

function getInfo(){
	
	$.ajax({
	url : "/jspweb/MemberInfoController",
	method : "get",
	data : {type : "info"} ,
	success : function f(r){
		
		if(r==null){//비로그인 상태 -> 페이지 차단
			alert('회원전용 페이지입니다. [로그인 페이지로 이동]');
			location.href = "/jspweb/member/login.jsp"
		}
		else{
			document.querySelector('.preimg').src=`img/${r.mimg}`;
			document.querySelector('.mid').innerHTML=r.mid;
			document.querySelector('.memail').innerHTML=r.memail
		}
	} ,
	error : function f(r){}
	})
	
}

//수정
function mupdate(){
	
	//1. form 가져오기
	let form = document.querySelectorAll('.signupForm')[0];
	
	//2. form 데이터 객체화하기
	let formdata = new FormData (form);
	
	//3. * form 전송 ajax
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "put" ,
		data : formdata ,
		//폼 전송타입 : 문자x json x , multipart/form-data
		/*
			HTTP 전송타입
				1. text/html		: 문자타입[ 기본값 ]
				2. application		: json 타입
				3. multipart/form-data : 대용량 form전송 타입
						contentType : false ,
						processData : false ,
		*/
		contentType : false ,
		processData : false ,
		success : r =>{
			
			if(r==true){
				alert('수정성공[ 다시로그인해주세요 ]')
				logout();
			}
			else{
				alert('수정실패 [비밀번호는 5자 이상이어야 합니다.]');
			}
		} ,
		error : e => {}
	});
	
}
//탈퇴
function mdelete(){
	//1.탈퇴여부 확인	confirm()확인/취소 버튼 알림창
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	//2. 확인버튼을 눌렀을떄
	if( dconfirm == true){
		let mpwd = prompt('비밀번호 확인');
		// 3. ajax [ 입력받은 패스워드 전송해서 로그인 회원의 패스워드와 입력받은 패스워드와 일치하면 탈퇴]
		$.ajax({
		url : "/jspweb/MemberInfoController",
		method : "delete",
		data : { mpwd : mpwd } ,
		success : function f(r){
			console.log(r)
			if(r==true){
				alert('회원탈퇴했습니다.'); logout();
			}
			else{ alert('패스워드가 일치하지 않습니다.') }
		} ,
		error : function f(r){}
		})

	}//if end
}