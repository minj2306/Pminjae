/**
 * 
 */
//로그인 함수
function login(){
	//1. 입력받은 아이디, 비밀번호 가져온다.
	
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	//2. ajax에게 전달해서 회원이 존재하는지 반환받는다.
		//2-1 : 로그인 성공시 index.jsp 이동
		//		: 로그인 실패시 loginchckebox 열림	
	$.ajax({
	url : "/jspweb/MemberFindController",
	method : "post", 
	// get 메소드는 전송하는 data 노출(보안 취약) 
	//post 메소드는 전송하는 data 노출x(보안)
	data : { mid : mid , mpwd : mpwd } ,
	success : function f(r){ 
		console.log("통신성공")
		if(r){location.href = "/jspweb/index.jsp"}	
		else{ document.querySelector('.logincheckbox').innerHTML ='동일한 회원정보가 없습니다.'}
		} ,
	error : function f(r){ console.log(r) }
	})
	}
	
/*
	GET vs POST
	
	GET : 
			- 캐시(기록)
			- 추후에 다시 전송시 속도 빠름
			- 보안 불가능
			- 매개변수 노출o
			- 개인정보 없는 데이터정보 권장
	
	POST : 
			- 캐시(기록x)
			- 추후에 다시 전송시 속도 동일
			- 보안 가능
			- 매개변수 노출X
			- 로그인 , 회원가입(권장)
 */