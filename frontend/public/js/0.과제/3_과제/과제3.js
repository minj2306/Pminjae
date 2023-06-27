/**
 * 
 */
let 날짜배열 = []
let 항목배열 = []
let 금액배열 = []

console.log('js 열림')
출력();//js 열렸을때 최초 1번 실행

function 등록(){
	
	
	console.log('등록함수클릭');
	
	//1. HTML 특정태크를 가져오기
	//document.getElementsByClassName('.클래스명')
	let dateInput = document.querySelector('.date'); console.log('dateInput')
	let nameInput = document.querySelector('.name'); console.log('nameInput')
	let moneyInput = document.querySelector('.money'); console.log('moneyInput')

	//2.태그의 입력된 값 호출
	let date = dateInput.value; console.log(date)
	let name = nameInput.value; console.log(name)
	let money = moneyInput.value; console.log(money)
	
	//*유효성검사 : 만약에 3가지중에 하나라도 공백이면
	if(date ==``|| name==``|| money==``){
		alert('미입력이 존재합니다[등록불가]');
		return; //함수 강제 종료 //return 실행하면 아래코드는 실행x
	}
	
	//3. 배열저장
	날짜배열.push(date); console.log(날짜배열)
	항목배열.push(name); console.log(항목배열)
	금액배열.push(money); console.log(금액배열)
	
출력()
	
	//저장 성공시 input 상자 초기화
	dateInput.value = ``
	nameInput.value = ``
	moneyInput.value = ``
}

function 출력(){
	console.log('가계부 목록 출력합니다.')
	
	let outputTable = document.querySelector('.outputTable')
	let html =`<tr>	
				<th> 날짜 </th>
				<th> 항목 </th>
				<th> 가격 </th>
				<th> 비고 </th>
			</tr>`
	
	for(let 인덱스 = 0 ; 인덱스<날짜배열.length; 인덱스++){
	html += `<tr>
				<td> ${날짜배열[인덱스]} </td>
				<td> ${항목배열[인덱스]} </td>
				<td> ${금액배열[인덱스].toLocaleString()}원 </td>
				<td> <button class='delete' onclick="삭제(${인덱스})">삭제 </button> </td>
			</tr>` //삭제할 인덱스 번호를 삭제() 함수에  인수로 전달
			}
	let 총합계 = 0 ;
	for(let 인덱스 = 0 ; 인덱스<금액배열.length ; 인덱스++){
		console.log(금액배열)
		console.log(금액배열[인덱스])
		총합계+= Number( 금액배열[인덱스] );
	}
	
	html += `<tr>
				<td colspan="2">총합계</td>
				<td colspan="2">${총합계.toLocaleString()}원</td>
			</tr>`
	outputTable.innerHTML = html ;
}

function 삭제(삭제할인덱스번호){
	console.log('삭제할인덱스번호 : ' + 삭제할인덱스번호)
	날짜배열.splice(삭제할인덱스번호,1)
	금액배열.splice(삭제할인덱스번호,1)
	항목배열.splice(삭제할인덱스번호,1)
	//화면/테이블/새로고침
	출력()
}








