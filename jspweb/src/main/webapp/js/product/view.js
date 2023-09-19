console.log('view.js 열림')
// * 게시판 상세 페이지 , 제품 상세 페이지 등등에서는 클릭된 식별자 [제품번호]
// URL(인터넷주소) 에서 매개변수(쿼리스트링) 가져오기
let pno = new URL(location.href).searchParams.get("pno")
//new URL(location.href).searchParams.get("키")
//<a href="/jspweb/product/view.jsp?키=값&키=값&키=값"></a>

findByPno()
// 1. pno 에 해당하는 제품 1개 호출
function findByPno(){
	
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		mathod : "get" ,
		data : {type : 'findByPno' , pno : pno} ,
		success : jsonObject => {
			console.log( jsonObject  ) 
		//-------------캐러셀에 이미지 여러개 대입
		let imgbox = document.querySelector('.imgbox')
		let html = ``;
		
		Object.values(jsonObject.imgList).forEach( ( img , i )=>{
			html += `
					<div class="carousel-item ${ i==0 ? 'active' : '' }">
			     		 <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
			    	</div>
					`
		})
		
		imgbox.innerHTML = html;
		
		// 각 위치에 데이터 넣어주기
		
		document.querySelector('.mid').innerHTML = `판매자 : ${jsonObject.mid}`
		document.querySelector('.pcname').innerHTML = `카테고리 : ${jsonObject.pcname}`
		document.querySelector('.pdate').innerHTML = `등록일 : ${jsonObject.pdate}`
		document.querySelector('.pname').innerHTML = ` ${jsonObject.pname}`
		document.querySelector('.pprice').innerHTML = `${jsonObject.pprice.toLocaleString()}원`
		document.querySelector('.pcontent').innerHTML = `${jsonObject.pcontent}`
		
		}
	})
	
}
