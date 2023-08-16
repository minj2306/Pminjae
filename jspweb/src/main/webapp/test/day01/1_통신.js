console.log('1_통신.js')

//예제1
function 예제1(){ console.log('예제1() 실행')

//https://jsonplaceholder.typicode.com/
//외부 링크[사이트]에 JSON 데이터 통신

	/*
		AJAX : JQUERY 라이브러리에서 통신 함수 제공 
			JQUERY : JS 언어로 여러개 함수를 제공하는 라이브러리
		1. 정의 : JS 언어에서 외부와 통신하는 목적
		2. 형태 : $.ajax();
		3. 필수!! : JQUERY 라이브러리 필수!! <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			$ is not defined : jquery 라이브러리 추가 안됬을떄 발생하는 오류
		4. 매개변수 : 객체{ 속성 : 값 , 속성 : 값 , 속성 : 값  }
			<속성>
			1. url 속성 : 통신할 대상/링크/주소
			2. HTTP 통신 메소드 : post , get , put , delete 등등 
			3. success 결과 속성 : 통신을 성공했을떄 반환된 데이터를 함수의 매개변수 반환 받음
	*/
	$.ajax( { url : "https://jsonplaceholder.typicode.com/posts"   ,// 1. 통신할 경로
		 method : "get"	,									// 2. 통신할 HTTP 메소드 방식
		 success : function 결과 (result){console.log(result) }
		 } );
}

function 예제2(){
	console.log('예제2() 실행')	
	
	$.ajax( { url : "/jspweb/Test01"   ,// 1. 통신할 경로
		 method : "get"	,									// 2. 통신할 HTTP 메소드 방식
		 success : function 결과 (result){console.log(result) }
		 } );
	
}