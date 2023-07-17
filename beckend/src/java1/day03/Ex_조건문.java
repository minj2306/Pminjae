package java1.day03;

import java.util.Random;

public class Ex_조건문 { // class s

	public static void main(String[] args) {//main s
		
		//1.[p.111]
		int score = 93;
		if( score >= 90 ) System.out.println("합격");
		
		//2.
		if( score >= 90 ) 
			System.out.println("점수가 90 보다 큽니다.");
			System.out.println("등급은 A등급 입니다.");
			
		//2.
		if( score < 90 )
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B등급 입니다.");
	
		//3.[p.113]
		if( score > 90 ) {
			System.out.println("점수가 90 보다 큽니다.");
			System.out.println("등급은 A등급 입니다.");
		}
		else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B등급 입니다.");
		}
		
		//4.[p.114]
		if(score >= 90) {
			System.out.println("4점수가 100~90 입니다.");
			System.out.println("4등급은 A등급 입니다.");
		}
		else if(score >= 80) {
			System.out.println("4점수가 80~89 입니다.");
			System.out.println("4등급은 B등급 입니다.");
		}
		else if(score >= 70) {
			System.out.println("4점수가 70~79 입니다.");
			System.out.println("4등급은 C등급 입니다.");
		}
		else if(score < 70) {
			System.out.println("4점수가 70 미만 입니다.");
			System.out.println("4등급은 D등급 입니다.");
		}
		
		//---------------------------------------
		if(score >= 90) {
			System.out.println("5점수가 100~90 입니다.");
			System.out.println("5등급은 A등급 입니다.");
		}if(score >= 80) {
			System.out.println("5점수가 80~89 입니다.");
			System.out.println("5등급은 B등급 입니다.");
		}if(score >= 70) {
			System.out.println("5점수가 70~79 입니다.");
			System.out.println("5등급은 A등급 입니다.");
		}if(score < 70) {
			System.out.println("5점수가 70 미만 입니다.");
			System.out.println("5등급은 D등급 입니다.");
		}
		
		//[p.115] 난수 Math.random()
		System.out.println( Math.random() );//0.0 <= ~ < 1.0
		System.out.println( Math.random()*6 );//0.0 <= ~ < 6.0
		System.out.println( (int)(Math.random()*6) );//0 <= ~ < 6
		System.out.println( (int)(Math.random()*6)+1 );//1 <= ~ < 7
		// 정수 난수공식 : (int) ( Math.random() * n )+s
			//s : 난수 시작번호	n : 난수 개수
			//예시) 1~45
			System.out.println((int)(Math.random()*45)+1 );
		//-----------------------vs-----------------------------
		//난수생성 클래스 : Random 클래스
			//1. Random 객체 생성한다.
			//2. 랜덤값 호출
				//random.next타입명() ㅣ 타입의 허용 범위 내 난수 생성
		Random random = new Random();
		System.out.println( random.nextInt() ); // -21억 ~ + 21억
		System.out.println( random.nextInt(3) ); // 0~2
		//random.nextInt(개수) + 시작번호
		System.out.println( random.nextInt(6)+1 ); // 1~6
		System.out.println( random.nextInt(45)+1 ); // 1~45
		//예시 a-z
		System.out.println( (char)(random.nextInt(26) + 97)  ); //97~122
		
		//[p.116] // 주사위 예제
		int num = (int)(Math.random()*6)+1; // 1~6
		
		int num2 = random.nextInt(6)+1; //1~6
		
		if ( num == 1 ) { System.out.println("1 나왔습니다."); }
		else if (num == 2) {System.out.println("2 나왔습니다."); }
		else if (num == 3) {System.out.println("3 나왔습니다."); }
		else if (num == 4) {System.out.println("4 나왔습니다."); }
		else if (num == 5) {System.out.println("5 나왔습니다."); }
		else {System.out.println("6 나왔습니다."); }
		//----------------------------vs-------------------------------
		//[p.119] 주사위 예제 = switch
		
		switch( num ) {//num 변수를 연결해서 제어
		case 1 : System.out.println("1 나왔습니다."); break;
		case 2 : System.out.println("2 나왔습니다."); break;
		case 3 : System.out.println("3 나왔습니다."); break;
		case 4 : System.out.println("4 나왔습니다."); break;
		case 5 : System.out.println("5 나왔습니다."); break;
		default : System.out.println("6 나왔습니다.");
		}
		
		
		//[p.117] if 중첩
		int score3 = ( (int)Math.random() * 20 ) + 81 ;
		
		String grade; // 등급 저장하는 변수
		
		if (score3 >=90) {//점수가 90점 이상이면
			
			if( score3 >= 95 ) { grade = "A+"; }// 100~95 이면서
			else { grade = "a"; }
		} else { //점수가 90점 미만이면
			
			if( score3 >= 85 ) { grade = "B+"; }
			else { grade = "B";	}
		}
	
		//[P.121]
		char grade2 = 'B';
		
		switch( grade2 ) { // 값을 제어할 변수
			case 'A' :
			case 'a' :
					System.out.println("A등급 우수회원");
					break;
			case 'B' :
			case 'b' :
					System.out.println("B등급 우수회원");
					break;
			default :
			}
	
	
	
	
	
	
	
	}//main e
	
}//class e

/*
 	if : 조건에 따른 흐름제어
 		형태 
 			1. if( 조건식 ) 실행문;
  			2. if( 조건식 ) { 실행문 ; 실행문; }
  				*만약에 조건문이 2개 이상일경우 { } 묶음
  			
  			3. if(조건식) {참일 경우 실행문}
  				else{거짓일경우 실행문
  				
  			4. if(조건식) {참 1 일경우 실행문}
  				else if (조건식2) {참 2 일 경우 실행문}
  				else if (조건식3) {참 3 일 경우 실행문}
  				else {거짓일경우 실행문}
  					*만약에 조건이 충족할경우 참 실행문 실행후 전체 if 종료
  					[다수 조건에 하나의 실행문 처리]
  			4. if(조건식1) {참 1 일경우 실행문}
  				if(조건식2) {참 2 일경우 실행문}
  				if(조건식3) {참 3 일경우 실행문}
  				if(조건식4) {참 4 일경우 실행문}
  					*[다수조건에 다수 실행문 처리]
 
 	switch( 변수 ) {
 		case 값1 :
 		case 값2 :
 		case 값3 :
 		default	:
 		}
 		
 	* if = 조건에 따른 true/false 실행
 	* 	-경우의 수의 값이 정해져있지 않는 경우 / 범위 논리 O
 	* switch = 변수 값에 따른 실행
 		-경우의 수 의 값이 정해져있는경우 / 범위X
 		-break; : switch { } 탈출 / 만약에 해당 case 
 */
 