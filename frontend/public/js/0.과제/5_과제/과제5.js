
//누구를~~
// 1. 조작 / 제어할 HTML 태그 호출
let userbox = document.querySelector('.userbox');

//유저위치 = x좌표
let u_left = 50;

//어떻게~~ : 페이지 전체(body) 에서 키보드를 누를떄 
	//DOM객체명.addEventListener('이밴트명' , () => { })
document.body.addEventListener( 'keydown' , ( e ) => {
	console.log('키눌림')
	//1. 눌린 키 상태 확인 e.keyCode
	console.log( e ); //keydown 이벤트 상태 객체
	
	if(e.keyCode == 37){ 
		console.log('왼쪽으로 이동');
		u_left -= 10; //10 차감
		if(u_left < 0){u_left = 0};//만약 위치가 0보다 작아지면 0으로 고정
	}
	//유효성검사[배경 밖을 못나가게]
	else if(e.keyCode == 39){
		console.log('오른쪽으로 이동');
		u_left += 10; //10 증가
		if(u_left > 910){u_left = 910};//만약 위치가 910보다 커지면 910으로 고정
		userbox.style.backgroundImage = `url("img/캐릭터_이동.png")`;
	}
	else if ( e.keyCode == 65){//a키 눌렀을때
		console.log('공격')
		userbox.style.backgroundImage = `url("img/캐릭터_공격.png")`;//공격이미지 출력
	}
	//3.
	userbox.style.left = `${u_left}px`
	console.log(userbox.style.left);		
})

//2. 키누루고 때었을떄 = keyup
document.body.addEventListener('keyup' , (e)=>{
	userbox.style.backgroundImage = `url("img/캐릭터.png")`;
})
