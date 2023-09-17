console.log( 'register.js 열림' )

//제품등록은 회원제이므로 비로그인시 접근제한
if(loginState == false){
	alert('로그인 후 사용 가능한 페이지. ');
	location.href = "/jspweb/member/login.jsp";
}



function onRegister(){
	
	//1. form dom 객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log( registerForm );
	
	let formData = new FormData( registerForm ); console.log( formData );

	//*** 카카오 지도에서 선택된 좌표 선택했을때 */
	if(plng == 0 || plat == 0 ){ alert('제품위치를 선택해주세요'); return; }
		
	formData.set( 'plat' , plat);
	formData.set( 'plng' , plng);
	


		// *** 드래그앤드랍을 사용했을떄
			//현재 드랍된 파일들을 form 같이 추가하기 [ 왜? 드랍된 파일은 input 태그 드랍된 파일이 아니므로]
	
	if( fileList.length >= 1){ //드랍된 파일이 1개 이상이면
	 	fileList.forEach( f=> {
			 //formData.set( 'fileList' , f ); // 폼데이터 객체.set( 키 , 값 ); : 폼데이터 객체에 데이터를 추가하는 방법
			 formData.append('fileList' , f);
			 	// - 폼데이터 객체에 데이터를 추가하는 방법
			 	// 폼데이터객체.set( 키/필드명/속성명 , 값);
			 		//만약에 기존의 동일한 키가 있으면 덮어쓰기 되므로 기존데이터 사라짐
			 	// 폼데이터객체.append(키/필드명/속성명 , 값); : 폼
			 	 	//만약에 기존의 동일한 키가 있으면 해당키에 데이터 추가
			 	 //폼데이터객체.delete('키'); : 폼데이터객체내 데이터 삭제
		 });
	}
	
	$.ajax({
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => {
		console.log(r);
		if(r == true){
			alert('제품등록 성공');
			location.href = "/jspweb/index.jsp";
		}else{
			alert('제품등록 실패')
		}
	} ,
	error : e =>{}
	})	
}

// 2. 드래그 앤 드랍
	// 1. 드래그 앤 드랍 할 구역 dom 객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2 해당 dom객체 구역 내 드래그가 들어왔을때
fileDropBox.addEventListener( "dragenter" , (e) => { 
	
	console.log("드래그가 들어왔어");
	e.preventDefault(); 
	
}); // dragenter end
	
	// 3. 해당 dom객ㅊ체 구역 내 드래그가 올라왔을때
fileDropBox.addEventListener( "dragover" , (e) => { 
	
	console.log("현재 드개그가 위치중");
	fileDropBox.style.backgroundColor ='#e8e8e8';
	e.preventDefault(); 
})
	
	//4. 해당 dom객체 구역에서 드래그가 나갔을때 
fileDropBox.addEventListener( "dragleave" , (e) =>{  
	
	console.log("드래그가 나갔을때")
	fileDropBox.style.backgroundColor ='#ffffff';
	e.preventDefault(); 
})

	 // 5. 
fileDropBox.addEventListener( "drop" , (e) =>{
	console.log("해당 드래그가 드랍했어")
	// * 브라우저 자체적으로 'drop' 이벤트 우선적으로 실행되므로 해당 이벤트 실행 불가능
	// - 해결방안 : 기존 상위(브라우저) 이벤트 무시
	console.log(e);
	
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	
	// 드랍된 파일의 정보
		//1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log( e.dataTransfer);
		console.log(e.dataTransfer.files);
		console.log(e.dataTransfer.files[0]);
		console.log(e.dataTransfer.files[0].name)	
		
		let files = e.dataTransfer.files
		for( let i = 0 ; i < files.length ; i ++){
			if(files[i] != null && files[i] != undefined){
				fileList.push( files[i] );
			 }
		}//for end
		
		// 3. 배경색 초기화 
		fileDropBox.style.backgroundColor ='#ffffff';
		
		// 4. 현재 드랍된 파일의 정보를 드래그앤 드랍 구역에 표시
		fileListPrint()
})


let fileList = []; // 현재 드래그앤 드랍으로 등록된 파일들

function fileListPrint(){
	// 1. [어디에]fileDropBox 에  [ fileDropBox dom 객체가 함수 밖에 존재하므로 재호출x ]
	
	// 2. [무엇을] HTML 구성
	let html = ``;
		fileList.forEach( ( f , i ) => {
			let fname = f.name; //파일의 이름
			let fsize = ( f.size/1024 ).toFixed(1); //파일의 용량 [ 바이트 단위] kb 변환
									//.toFixed(소수점 단위) : 소수점 자르기
			html += `
					<div>
						<span>${fname}</span>
						<span>${fsize}</span>
						<span> <button onclick ="fileDelete(${i})" type="button">삭제</button> </span>
					</div>
					
					`
		} )
	// 3. [대입]
	fileDropBox.innerHTML = html;
}

//4. 현재 드랍된 파일들 둥에 삭제버튼 클릭시 해당 파일 제거
function fileDelete( i ){
	
	fileList.splice( i , 1 );
	fileListPrint();
}


// 6. 카카오 지도 표시

	// 1. 현재 접속한 클라이언트[브라우저]의 위치 좌표 구하기
navigator.geolocation.getCurrentPosition( e => {
	
	console.log(e);
	console.log(e.coords);
	console.log(e.coords.latitude); //위도
	console.log(e.coords.longitude); //경도
	let currentlat = e.coords.latitude;
	let currentlng = e.coords.longitude
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
   
    plat = latlng.getLat();
    plng = latlng.getLng();
	});

})

let plat = 0; // 현재 카카오 지도에서 선택한 좌표
let plng = 0;

/*
	
	dom 객체 이벤트 추가하는 방법 2가지
		가정 : 특정구역에 클릭(onclick) 이벤트 추가
		1.< button onclick="" type="button" ></button>
		
		2. .addEventListener( '이벤트명' , 함수 ) 사용하는 방법
			let button = document.querySelector('.button');
			fileDropBox.addEventListener( "onclick" , 함수 )
		
		이벤트 
		
			종류 : click , keyup , keydown , drop 등등등
			- 정의 : 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트 결과물 반환해주는 구조
			
	드래그 앤 드랍 관련 이벤트
	1. dragenter
	2. dragover
	3. dragleave
	4. drop
*/








/*function register1() {
	
	console.log( 'register1() 실행' );
	
	$.ajax({// form 태그 없는 경우
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : { 
		pname1 : document.querySelector('.pname1').value ,
		pcontent1 : document.querySelector('.pcontent1').value
	 } ,
	success : r => { console.log(r) } ,
	error : e =>{}
	})// ajax end	
	
}

function register2(){
	
	let registerForm1 = document.querySelector('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({// from 태그 이용하는 경우
	url : "/jspweb/ProductInfoController",
	method : "post",
	data : formData ,
	contentType : false ,
	processData : false ,
	success : r => { console.log(r) } ,
	error : e =>{}
	})// ajax end	
	
}*/