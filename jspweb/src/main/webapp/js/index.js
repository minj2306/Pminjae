

//1.n개 제품들을 최신순으로 출력 함수
function findByTop(count){
	
	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "get",
	data : { type : "findByTop" , count : count } ,
	success : jsonArray => { console.log(jsonArray) } ,
	error : e =>{}
	})
	
	
}


//2 현재 카카오지도내 보고있는 동서남북 기준내 제품들을 출력함수
function findByLatLng( east , west , south , north ){

	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "get",
	data : { type : "findByLatLng" ,
			 east : east , 
			 west: west ,
			 south : south ,
			 north: north 
			 } ,
	success : jsonArray => { console.log(jsonArray) } ,
	error : e =>{}
	})

}

//3. 선택된 제품번호에 해당하는 제품 출력함수
function findByPno( pno ){

	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "get",
	data : { type : "findByPno" , pno : pno } ,
	success : jsonArray => { console.log(jsonArray) } ,
	error : e =>{}
	})	
	
	
}

//4. 모든 제품들을 출력하는 함수
function findByAll(){

	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "get",
	data : { type : "findByAll" } ,
	success : jsonArray => { console.log(jsonArray) } ,
	error : e =>{}
	})	
}