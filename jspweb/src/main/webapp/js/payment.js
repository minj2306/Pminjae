// 1. 테스트
//setPoint( 1000 , "회원가입 ㅊㅋ");
//setPoint( -500 , "구매구매구매");
console.log('payment.js 열림')
getPointList()
//getPoint()
// 1. 포인트 사용함수
function setPoint( mpamount , mpcomment){
	
	console.log('setPoint 실행')
	
	if( loginState == false ){ return; }
	
	$.ajax({
	url : "/jspweb/PointController",
	method : "post",
	data : { mpamount : mpamount , mpcomment : mpcomment } ,
	success : r => {} ,
	error : e =>{}
	})
	
}

// 2. 내 포인트 확인 함수
function getPoint(){
	
	console.log('getPoint 실행')
	
	if( loginState == false ){ return; }

	let returnData = false;
	
	$.ajax({
	url : "/jspweb/PointController",
	method : "get",
	async :false , // ajax 가 응답이 올때까지 대기상태 = 동기식
	data : { type : "getPoint" } ,
	success : r => {
		console.log(r);
		returnData = r;
	} ,
	error : e =>{
		console.log(e);
	}
	})
	
	return returnData; // ajax 결과를 리턴하는 방식
}

function getPointList(){
	
	console.log('getPointList 실행')
	
	if( loginState == false ){ return; }

	$.ajax({
	url : "/jspweb/PointController",
	method : "get",
	data : { type : "getPointList" } ,
	success : r => {
		console.log(r);
	} ,
	error : e =>{
		console.log(e);
	}
	})

}


//-----------------------------결제연동---------------------

// 1. 
IMP.init('imp42611532') // 아임포트 콘솔에서 확인

 function requestPay() {
	 
	 // 2-1 : 만약에 결제방식을 선택 안했으면
	 if( pay_method == ''){
		 alert('결제 방식을 선택해주세요'); return;
	 }
	 if( amount == 0 ){
		 alert('결제 금액을 선택해주세요'); return;
	 }
	 
	 // 2-2 : 주문번호 만들기
	 	// * 고유성/중복X/PK/식별키
	 	// 1. 날짜(밀리초)+상품코드+회원번호 조합해서 설계
		// 2. 회사전화번호+사업자번호 조합해서 설계
			// ---- 등등
		let now = new Date(); console.log(now); // 현재날짜
		let time = now.getTime();	console.log(time); // 현재시간[밀리초]
		let merchant_uid = "p"+time+"-"+loginMid; console.log( merchant_uid )
	 	
	 	
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst", // 아임포트 콘솔에서 확인
      pay_method: pay_method,
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "포인트결제",
      amount: amount ,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "박민재",
      buyer_tel: "010-4242-4242",
      buyer_addr: "경기도 안산시 상록구",
      buyer_postcode: "12345"
    }, function (rsp) { // callback
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
      console.log(rsp);
      if(rsp.success){ // 결제성공
	  }else{ // 결제 실패 [ 테스트 : 실패가 성공이라는 가정]
		  alert('결제성공')
		  
		  // 1. 포인트 적립 기능ㅊ처리
		  let result = setPoint( amount , '포인트결제');
		  
		  // 2. 결제내역 테이블 기능처리 [구현x] 
	  }
      
    });
  }

let pay_method = ''; // 결제방식
function onPayMethod( method ){
	pay_method = method;
	
}

let amount = 0; // 결제금액
function onAmount(value){
	amount = value;
}
























