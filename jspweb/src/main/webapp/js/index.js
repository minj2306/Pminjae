
findByTop(10);
//findByPno(2)
//findByAll() 



//1.n개 제품들을 최신순으로 출력 함수
function findByTop(count){
	
	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "get",
	data : { type : "findByTop" , count : count } ,
	success : jsonArray => { console.log(jsonArray)
	
		let productBox = document.querySelector('.productBox');
		let html = ``;
		
		jsonArray.forEach( (p) => {
			
			//* 대표이미지 출력하기[첫번째 이미지] / Object.keys(객체명)
			let firstImg = Object.values(p.imgList)[0] ;
			html += `
					  <div class="col">
					    <div class="card h-100">
					      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
					      <div class="card-body">
					        <h5 class="card-title">${p.pname}</h5>
					        <p class="card-text">
					        <div>${p.pcontent}</div>
					        <div>${p.pprice.toLocaleString() } 원</div>
					        </p>
					      </div>
					    </div>
					  </div>
					`;
			
		} )
		productBox.innerHTML = html;
	
	 } ,
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


/*
	
	자바스크립트 객체
		형태 : let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터 }
			추가 : 객체명.새로운필드명 = 데이터
			삭제 : delete 객체명.삭제할 속성명
			* 사용자 정의 함수중에 delete 이름 선언 불가능
			호출 : 객체명.속성명 / 객체명['속성명']
				-Object.keys( 객체명 ) : 객체내 모든 키를 배열로 반환
	자바스크립트 배열/리스트
		형태 : let 변수명 = [ 데이터 , 데이터 , 데이턴 ]
			추가 : 배열명.push
			삭제 : 배열명.splice(인덱스 , 개수)
			호출 : 배열명[인덱스]
				- 배열명.length : 배열의 길이
*/