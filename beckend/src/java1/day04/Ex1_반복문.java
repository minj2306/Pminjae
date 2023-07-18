package java1.day04;

import java.util.Iterator;
import java.util.Scanner;

public class Ex1_반복문 {//class 시작
	
	public static void main(String[] args) { //main s
		
		//[p.124] 1부터 10 까지 누적합계
		int sum = 0;
		sum = sum+1 ; sum+=2; sum+=3; sum+=4; sum+=5; sum+=6; sum+=7; sum+=8; sum+=9; sum+=10;
		
		//1부터 10 까지 누적 합계 (for 이용)
		int sum2 = 0;
		for( int i =1 ; i<=10 ; i++) {
			sum2 +=i;
		}
		
		//[p.125] 1부터 10까지 출력
		
		 
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.print( i + " " );
		}
		
		//[p.126] 초기값 변수는 for에서 선언시 지역변수이다.
		int sum3 = 0 ;
		for(int 반복변수 = 1 ; 반복변수 <= 10 ; 반복변수++ ) {
			sum += 반복변수;
		}
		//System.out.println( 반복변수 ); =>x for ( ) 에서 선언된 변수는 for { } 밖에서 사용불가
		
		int sum4 = 0 ; int i;
		for( i = 1 ; i <= 100 ; i++ ) {
			sum4 += i ;
		}
		System.out.println(" 1~ "+(i-1)+" 합 : "+sum4 );
	
		//[p.127] 실수 //소수점 뒤에 f 사용 이유 : (직접 작성한) 리터럴 소수점 = double 이기 떄문에
		for( float x = 0.1f ; x <= 1.0f ; x += 0.1f ) {
			System.out.print( x + " " );
		}
		
		for( double x = 0.1f ; x <= 1.0f ; x += 0.1f ) {
			System.out.print
			( x + " " );
		}
		System.out.println(" ");
		//[p.128] 구구단
		
		for( int 곱 = 1 ; 곱<=9 ; 곱++) {
			System.out.println(2*곱 + " ");
		}
			//1. 2단 ~ 9단 for
		//for(int 단 = 2 ; 단<=9 ; 단++) { }
			//2. 1곱 ~ 9곱 for
		//for(int 곱 = 1 ; 곱<=9 ; 곱++) { }
			//3. 1,2 합치기 [단마다 곱 실행(x) vs 곱마다 단실행(x)
		
		for(int 단 = 2 ; 단 <= 9 ; 단++ ) {
			for(int 곱 =1 ; 곱<=9 ; 곱++) {
				System.out.printf("%2d X %2d = %2d \n", 단 , 곱, 단*곱);
			}
		}
		
		//[p.129 vs 124] 1~10 출력
		int a = 1;
		while(a <=10 ) {System.out.println(a+" "); a++;}
		
		//[p.130 vs 126]
		int sum5 = 0;
		int b = 1;
		while(b<=100) { sum5 += b; b++; }
		
		//[p.131] 무한루프
	
		//while(true) {System.out.println("무한반복");}
		//for( ; ; ) {System.out.println("무한반복");}
	
		Scanner scanner = new Scanner(System.in);
		boolean run = true; //while문 true/false 저장하는변수 , on/off 역할
		int speed = 0 ; //현재 속도 저장하는 변수
		
		//while(run) {System.out.println("무한루프");}
		while(run) {//while s
			
			System.out.println("-----------------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("-----------------------------------");
			System.out.println("선택 : ");
			//-------무한입력
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")) { //만약에 입력이 1이면
				speed++; //스피드 증가
				System.out.println("현재속도 : "+speed);
			}
			else if(strNum.equals("2")) {//만약에 입력이 2이면 
				speed--; //스피드 감소
				System.out.println("현재속도 : "+speed);
			}
			else if(strNum.equals("3")) {//만약에 입력이 3이면
				run = false; // 1. //위치1
				//break; //2 : 가장 가까운 반복문 탈출 // 위치1
				//return; //3 : 현재 함수 강제 반환/종료 //위치2
			} 
		}// while e
		
		//위치1
		
		
		//[p.135] 
			//1. for문에 식별이름 정의 : 	for이름 : for(){}
			
			//2. break;
				//가장 가까운 반복문 탈출 , continue for 이름
		
			//2. break; for 이름
				//해당 for 탈출
			//3. continue;
				//가장 가까운 반복문 증감식/조건식 으로 이동
			//3. continue;
				// : 해당 for 반복문 증감식/조건식으로 이동
		
		대문자for : for(char upper = 'A' ; upper <= 'Z' ; upper++) {
		
			System.out.println(upper+" ");
				
		소문자for : for(char lower = 'A' ; lower <= 'Z'; lower++) {
				System.out.print("\t"+lower);
				//*특정 for break;
//				///if(lower =='g') break; 대문자 for;
				if(lower =='g') break 대문자for;
		}//for2 e
			System.out.println();
		}//for1 e
	
		//[p.137]
		숫자for : for(int j = 1 ; j<= 10 ; j++) {
			if(j % 2 != 0) {//for로 홀수찾기
				//continue; // for로 이동 // 아래에 있는 코드는 실행 x //홀수출력X
				continue 숫자for;
			}//if e
		}
		
		
		
		
	}//main s
	//위치2
}//class e

/*
  	for문
  		for(1.초기값 ; 2.조건식 ; 4.증감식 ; ){
  			3.실행문
  		}
  		
  		1. 초기값이 실행된다
  		2. 조건식 판단해서 true 이면 { } 들어감 , false 건너뜀/종료
  		3. true 면 실행문 실행
  		4. 초기값이 들어있는 변수에 증감식
  		5. 조건식 판단해서 반복
  		
  	while문
  		1.*초기값
  		while(2.조건식){3.실행문 4.*증감식}
  		
  		-초기값과 증감식은 필수x
  		1. 조건식 판단해서 true면 { } 들어감 , false { } 건너뛴/ 종료
  		2. true이면 실행문 실행
  		
  		--일반적으로 패턴이 있는경우 for문 사용
  		--무한루프 while문
  
  
*/
 