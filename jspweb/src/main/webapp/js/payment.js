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

	$.ajax({
	url : "/jspweb/PointController",
	method : "get",
	data : { type : "getPoint" } ,
	success : r => {
		console.log(r);
	} ,
	error : e =>{
		console.log(e);
	}
	})
	
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



































