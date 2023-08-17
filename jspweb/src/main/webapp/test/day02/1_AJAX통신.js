/**
 * 
 */
console.log("1_AJAX통신.js Open")
 
 function 예제1(){
	 
	 console.log("예제1() Open");
	 //ajax 메소드 이용한 서블릿과 통신
	 	//$.ajax( { } );
	 	
	    $.ajax( { 
      url : "/jspweb/Test02"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 힘수명 ( result){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   		});
	 
 } // 예제 1 end
 
 function 예제2(){
	 
	 console.log("예제2() Open");
	 //ajax 메소드 이용한 서블릿과 통신
	 	//$.ajax( { } );
	 	
	    $.ajax( { 
      url : "/jspweb/Test03"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 힘수명 (  result){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   		});
	 
 }// 예제 2 end
 
 function 예제3(){
	 
	 console.log("예제3() Open");
	 //ajax 메소드 이용한 서블릿과 통신
	 	//$.ajax( { } );
	 	
	    $.ajax( { 
      url : "/jspweb/Test04"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 힘수명 (result){
		   console.log(result); 
		   console.log(result.title);
		   console.log(result.content); 
		   }   // 3. 통신을 성공했을때 반환된 데이터
   		});
	 
 }// 예제 3 end
 
  function 예제4(){
	 
	 console.log("예제4() Open");
	 //ajax 메소드 이용한 서블릿과 통신
	 	//$.ajax( { } );
	 	
	    $.ajax( { 
      url : "/jspweb/Test05"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 힘수명 (result){
		   console.log(result); 
		   console.log(result.title);
		   console.log(result.content); 
		   }   // 3. 통신을 성공했을때 반환된 데이터
   		});
	 
 }// 예제 4 end
 
 /*
 
  $.ajax( { 
      url : "통신할 경로"  , 
      method : "통신방법 : get , post , put , delelte 선택",                        
      success : function 함수명 ( 통신반환변수 ){ 통신 성공했을때 실행코드 } ,
      err : function 함수명 ( 통신반환변수 ){ 통신 실패했을때 실행코드 }
   		});
   		
	- success 속성에서 반환함수 작성시
		1. success : function 함수명 ( 통신반환변수 ){ 통신 성공했을때 실행코드 }
		2. success : function ( 통신반환변수 ){ 통신 성공했을때 실행코드 }
		3. success : ( 통신반환변수 ) => { 통신 성공했을때 실행코드 }
	----------------------------------------------------
	 
	
	
	----------------------------------------------------
	서블릿
		- request : 요청객체
		- response : 응답객체
			- response.getWriter().print(데이터); 
				웹 출력 = 응답 데이터
			- response.setContentType("전송헐 데이터 타입명; 인코딩타입");
				출력할 데이터의 타입 혹은 인코딩
				-1. 문자전송[default]
					response.setContentType("text/html;charset=UTF-8")
				-2. JSON 전송
 					response.setContentType("application/json;charset=UTF-8");
	----------------------------------------------------
	JACKSON : JAVA 객체를 JSON 형식에 대한 다양한 클래스 제공 라이브러리
		jackson-annotations-2.14.2 , jackson-core-2.14.2 , jackson-databind-2.14.2 
 		1. ObjectMapper 클래스 : JAVA 객체를 JSON 형식으로 변환해주는 함수들을 제공하는 클래스
 			1. .writeValueAsString( JAVA객체 ) : 해당객체를 JSON 형식의 문자열로 반환
 */
 
 
 
 