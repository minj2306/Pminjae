 /**
 * 
 */
 console.log('카랜다 시작')
//0. 현재 연도/월 [ 초기값 ]
	// new Date() 				: 현재 시스템 날짜/시간 반환해주는 클래스
	// new Date( 년 , 월, 일 ) 	:사용자 정의 날짜 반환해주는  클래스
	//.getFullYear() 			: 년도
	//.getMonth() 				: 월[ 0~11 ]
	//.getdate() 				: 일
	//.new Date(year , month , 0) :[다음달 마지막 1일에서 -1] 현재 월의 마지막 일수 구하기

let year = new Date().getFullYear(); //현재 연도
let month = new Date().getMonth()+1; // 현재 월[ 0 ~ 11 ] +1
//* 전역 배열
let contents = [ ] // 여러개 일정 객체를 저장하는 배열
console.log(year)
console.log(month)

calPrint();
 //1. 현재 연도/ 월 기준으로 달력 출력하는 함수
 function calPrint(){//함수 시작
	 //현재 연도와 월 일을 해당 구역에 출력하기
	 document.querySelector('.caldate').innerHTML = `${ year } 년 ${ month } 월`;
	 
	 //1. 요일과 일 출력
	 
	 /*
	 	1. 시작요일
	 	2. 현재 월 마지막 일
	 */
	 let now = new Date( year , month-1 , 1); //month-1 =>7-1 =>6 => 7월
	 let sweek = now.getDay(); console.log(sweek);
	 //현재 월의 마지막 일 구하기
	 let now2 = new Date(year , month , 0); // month => 7 => 7 => 8월
	 let eDay = now2.getDate(); console.log(eDay);
	 
	 let calender = document.querySelector('.calender');
	 let html = '';
	 //1. 요일
	 	html = `
	 			<div class="week sunday">일</div>	<div class="week">월</div>	<div class="week">화</div>
				<div class="week">수</div>	<div class="week">목</div>	<div class="week">금</div>
				<div class="week">토</div>
	 			`
	 			//****** 현재 달력 1일의 요일까지 공백 출력
	 for(let b = 1 ; b<=sweek ; b++){//1부터 1일의 요일까지 공백 구역 출력
		 html += `<div></div>`
		 
	 }
	 //2. *****현재 달력 마지막 일 까지 일수 출력
	 for( let day = 1; day<=eDay ; day++){//for s
		 html += `<div onclick="openModal(${day})">
		 			 ${day}
		 			 ${
						contentPrint(`${year}-${month}-${day}`) 
					  }
		 			
		 			</div>`
		 			//만약에 현재 날짜와 일정목록 등록된 일정의 날짜와 같으면 출력
		 			
	 }//for end
 	calender.innerHTML = html;
 }//함수 끝
 
 //6. 일정 출력함수[실행조건 : 만약에 현재 날짜와 동일한 일정 날짜 찾아서 출력]
 //인수 : 함수 안으로 들어오는 수/값/데이터 = 날짜
 //반환 : 함수{}끝나고 함수 호출 했던 곳으로 수/값/데이터 보내기 = 해당 날짜의 일정 내용 HTML
 function contentPrint(date){
	 console.log(date);
	 //인수로 들어온 날짜와 같은 일정 목록에서 일정찾기
	 let html =``;
	 for( let i = 0 ; i<contents.length ; i++){
		 if(date == contents[i].date){
			 html+= `<span class="content" style="background-color:${contents[i].color}">
			 			${contents[i].content}
			 		</span>`
		 }
	 }
	 return html;
	 
 }
 
 
//2. 버튼을 클릭했을때 현재 월 변환해주는 함수
function onNext( check ){console.log(check)
	
	if( check == 0 ){//이전달
		month--;	//현재 보고있는 월 1 차감
	//만약에 월이 차감했는데 1보다 작아지면 12월 변경하되 연도 1차감
		//2023년도 1월 --> 1차감 --> 2022년도 12월
		if(month < 1 ){month = 12; year--;}
		else if(month > 12 ){month = 1 ; year++;}
	}

		
		
	else if( check == 1 ){// 다음달
		month++; 	//현재 보고있는 월 1 증가
	}
	
	//증감 후 새로고침
	calPrint();
}

//3. 모달 열기
function openModal( day ){
	document.querySelector('.modalwrap').style.display ='flex';
	
	//
	document.querySelector('.date').innerHTML =`${year}-${month}-${day}`;
}

//4. 모달 닫기
function closeModal(){
	document.querySelector('.modalwrap').style.display ='none';
} 
 

 
//5. 일정등록 버튼 클릭했을때
function onWrite(){
	//1. 입력받은 값 호출
	let color = document.querySelector('.color');
	let contentInput = document.querySelector('.contentInput');
	let date = document.querySelector('.date');
	
	//2. 가공[ 1. 유효성 검사 , 2. 객체화]
	
	let object = {
				  color : color.value ,
				  content : contentInput.value ,
				  date : date.innerHTML
					}
	//3. 저장
	contents.push(object);
	console.log(contents)
	
	color.value=''; contentInput.value='';
	
	closeModal(); calPrint();
}

 
 
 
 
 