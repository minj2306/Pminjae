

let 헤더변수 = "헤더변수 데이터";

let loginState = false; /*로그인 상태 true 로그인중  false 비로그인*/

getMemberinfo()
function getMemberinfo(){
	
	console.log('getMemberinfo() 열림')
	
	// 1. ajax 이용한 서블릿 세션 정보 가져오기
	$.ajax({
	url : "/jspweb/MemberInfoController",
	method : "get",
	data : {type : "info"} ,
	success : function f(r){
		
		let submenu = document.querySelector('.submenu');
		let html = ``;

		if(r==null){//비로그인
			loginState = false;
			html +=`
					<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a> </li>
					<li> <a href="/jspweb/member/login.jsp">로그인</a></li>
					`;
			
			
		}
	 	else{//로그인
			loginState = true;
			html += `
					<li> <a href="#">${r.mid} 님</a></li>
					<li> <img class="himg" alt="" src="/jspweb/member/img/${r.mimg}"></li>
					<li> <a href="/jspweb/member/info.jsp">마이페이지</a></li>
					<li> <a onclick="logout()" href="#">로그아웃</a></li>
					`;		
			if(r.mid=="admin"){ }//로그인 했는데 관리자 메뉴 
		 }//else end
		 
		 submenu.innerHTML = html;
		 
	} ,
	error : function f(r){}
	})
	
}
//2. 로그아웃 함수 [ 서블릿에 세션을 삭제.. 그리고 로그아웃 성공시 메인페이지로 이동]
function logout(){
	
	$.ajax({
	url : "/jspweb/MemberInfoController",
	method : "get",
	data : { type : "logout"} ,
	success : function f(r){
		
		alert('로그아웃 되었습니다')
		location.href ="/jspweb/index.jsp"
		
	} ,//success end
	error : function f(r){}
	})
	
}




