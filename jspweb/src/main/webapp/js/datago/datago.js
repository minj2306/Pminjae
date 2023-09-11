/*

	공공데이터 포털
	
	고공데이터 선택 -> 활용신청 -> 요청URL 확인
 
*/
api1()
console.log('datago js 열림')
 //1. 안산시 착한 가격 업소 API 호출
function api1(){
	
	$.ajax({
	url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=j8XysggG6zX0QB9iLybK99xi%2Fd0T7eeki0mUu%2BT1P20CFZ7QvRKiAAbz10kWysI1s73XW1k0VF2UNbOhF379kQ%3D%3D",
	method : "get",
	data : {} ,
	success : response => {
		console.log(response);
		let data = response.data;
		console.log('0번쨰 data 업소명: '+data[0].업소명);
		console.log('0번쨰 data 대표: '+data[0].대표자);
		//1. 출력할 dom 객체
		let apiTable1 = document.querySelector('.apiTable1')
		
		let html = ``;
		
		data.forEach( ( d , i )  =>{
			html += `
				<tr>
					<td>${i+1}</td>
					<td>${d.업소명}</td>
					<td>${d.소재지도로명주소}</td>
					<td>${d.연락처 }</td>
					<td>${d.품목1} / ${d.가격1}</td>
					<td>${d.품목2} / ${d.가격2}</td>
					<td>${d.품목3} / ${d.가격3}</td>
				</tr>
					`;
		})
		apiTable1.innerHTML = html;		
		
	} ,
	error : e =>{}
	})

}

//1. 접속한 브라우저의 GPS 좌표 얻기 [ geolocation ]
/*navigator.geolocation.getCurrentPosition( pos => { 
	console.log(pos); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;

	// 카카오 지도 출력
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴 */
	
/*	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(lat, lng); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);*/

	
	//} )
	//////////////카카오 지도 출력하는 객체
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
    

// 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 7 // 클러스터 할 최소 지도 레벨 
    });

///////////////////////////마커 이미지 설정
// 마커 이미지의 주소
var markerImageUrl = '/jspweb/img/번개.png', 
	markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
	markerImageOptions = { 
		 offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
	};

// 마커 이미지를 생성한다   
var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);


 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=j8XysggG6zX0QB9iLybK99xi%2Fd0T7eeki0mUu%2BT1P20CFZ7QvRKiAAbz10kWysI1s73XW1k0VF2UNbOhF379kQ%3D%3D",
     function(response) {
		 console.log(response)
		 //response : 공공데이터 응답객체
		 //response.data : 응답객체 내 검색된 전기차 충전소 목록/배열/리스트
		 
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(response.data).map(function(i, position) {
            
            //개별 마커 생성후
            let marker = new kakao.maps.Marker({
					position : new kakao.maps.LatLng(position['위도(WGS84)'] , position['경도(WGS84)']) ,
					image : markerImage
			})
            
	        // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
			kakao.maps.event.addListener(marker, 'click', function() {
				
				let html = `<div> 충전소명 : ${position.충전소명} </div>
							<div> 충전소명 : ${position.충전기타입명} </div>
							<div> 충전소명 : ${position.운영기관명} </div>
							<div> 충전소명 : ${position.소재지도로명주소} </div>
							`	
				document.querySelector('.detailbox').innerHTML = html
			
			});
            
            //생성된 마커 리턴
            return marker;
        
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });
    
 /*
 	$.ajax({ url : "" , method : "" , data : "" })
 
 	-for 문
 		- 배열명 : arrayList
 		
 		1. 인덱스 0부터  베열의 길이만큼 반복
 			for( let = 0; i < arrayList.lenght ; i++ ){ }
 		
 		2. 배열의 첫번째 인덱스 부터 마지막 인덱스까지 반복
 			for( let 반복변수 in arrayList){ }
 		
 		3. 배열의 첫번째 데이터 부터 마지막 인덱스까지 반복
 			for( let 반복변수 of arrayList){ } 
 
 		4. 배열의 반복변수 or 인덱스를 첫번째 부터 마지막까지 반복 [ 반환값 x ]
 			arrayList.forEach( ( 반복변수 )=>{ } )
 			arrayList.forEach( ( 반복변수 , 인덱스변수 )=>{ } )
 			
 		5. 배열의 반복변수 or 인덱스를 첫번째 부터 마지막까지 반복 [ 반환값 o] => 새로운 배열에 저장할수 있다!
 			arrayList.map( ( 반복변수 ) => { } )
 			arrayList.map( ( 반복변수 , 인덱스변수 ) => { } )
 			let returnArrays = arrayList.map( ( 반복변수 , 인덱스변수 ) => { return } )
		
		6. filter

 */

let arrayList = [ 'a' , 'b' , 'c' , 'd'  ]

for( let i = 0; i < arrayList.length; i++){ console.log(i) }

for( let data1 in arrayList ){ console.log(data1) }

for( let data2 of arrayList ){ console.log(data2) }

arrayList.forEach( (data3) =>{ console.log(data3) } )

arrayList.forEach( (data4 , index4 ) =>{ console.log(data4) 
											console.log(index4)   } )

let newArrayList = arrayList.map( (data5) => { console.log(data5) } )	
console.log(newArrayList);										