console.log('wishlist 열림')

/*
	1. document.querySelector(선텍자); : 해당 선탟자의 dom 객체로 1개 가져오기
	2. document.quertSelectorAll(선택자) : 해당 선택자의 dom 객체를 여러개 가져오기
*/
getWishProductList();

let checkIdex = [ ]; // 현재 체크된 인덱스
// 0. 제품 목록에서의 선택상자 모두 체크기능
	// 1. 모든 checkbox를 가져오기
	let checkList = document.querySelectorAll('.checkbox');
	console.log( checkList);
	
	// 2. 첫번째 체크박스를 클릭 이벤트
	checkList[0].addEventListener( 'click' , (e) => {
		console.log('첫번쨰 체크박스를 클릭했습니다.')
		console.log(e);
		console.log( checkList[0].checked ) 
		//type="checkbox" 인 input 태그는 checked 속성 이용한 체크여부 확인하기 true : 체크되어 있는 상태 / false : 체크 안되어 있는 상태
		
		// 3. 만약에 첫번째 체크 박스가 체크되면 모든 체크박스는 체크 활성화
		if( checkList[0].checked == true ){
			checkList.forEach( (check) => {
				check.checked = true;
			})
		}//if end
		else{
			checkList.forEach( (check) =>{
				check.checked = false; 
			})
		}
		
	})
function getWishProductList(){
	
	console.log('findByAll 실행')
	
	let table = document.querySelector('.table')
	
	$.ajax({
	url : "/jspweb/PwishListController",
	async : false ,
	method : "get",
	data : { type : "findByAll"} ,
	success : r => {
		console.log(r);
		let html = `
					<tr>	
						<th width="5%"> <input class="checkbox" type="checkbox"> </th>
						<th width="5%">이미지</th>
						<th width="40%">제품정보</th>
						<th width="10%">가격</th>
						<th width="10%">비고</th>
					</tr>
					`
		r.forEach ( (p) => {
			html += `
					<tr>	
						<td> <input class="checkbox" type="checkbox">  </td>
						<td> <img src="/jspweb/product/img/${Object.values( p.imgList)[0] }" width="100%"> </td>
						<td>${p.pname}</td>
						<td>${p.pprice.toLocaleString()} 원</td>
						<td> <button onclick="deleteWish( ${p.pno} )" type="button">X</button></td>
					</tr>
					`
		})
		table.innerHTML = html;
	} ,
	error : e =>{}
	})
	
}



































