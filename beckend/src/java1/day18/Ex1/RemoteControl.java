package java1.day18.Ex1;

/*
 	JVM 실행 매모리
 	
 	 1. 메소드영역 		2. 스택영역			3. 힙영역
 	 - 클래스정보			- 함수{ }내 변수들		- 객체(인스턴스)
 	 - 메소드										- 필드
 	 - static정적
 	 - 인터페이스정보
 	 
 	 class 사람{
 	 	int 나이;					사람 유재석 = 102번지		유재석 객체( 나이 = 30 )	유재석.밥먹기() => 30
 	 							사람 강호동 = 103번지		강호동 객체( 나이 = 40 )	강호동.밥먹기() => 40
 	 	void 밥먹기 () {
 	 		print( this.나이 )
 	 	}
 	 }
 	 
 */


public interface RemoteControl {

	//  대표 멤버 구성
		//1. 상수필드		: 프로그램 내 수정 불가능한 데이터
			// int MAX_VOLUME;
		static final int MAX_VOLUME = 10;
		int MIN_VOLUME =0;
		//2. 추상[abstract]메소드	: 선언부만 작성하고 구현{ }은 안하는 함수 [ 구현은 각 클래스가 구현 ]
								//메소드 선언부 , 메소드 호출하는 방법
			//[ public abstract ] 리턴타입 메소드명( 매개변수1 , 매개변수2 );
	// 1. 선언만 하는 전원켜기 함수
	public abstract void turnOn();
	// 2. 선언만 하는 전원끄기 함수
	void turnOff();
	// 3. 선언만 하는 볼륨조절함수
	void setVolume( int volume );
}
