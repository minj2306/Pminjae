package 과제.과제4;

import java.util.Random;
import java.util.Scanner;

public class 과제4_2_가위바위보 {//class s
	
	public static void main(String[] args) {//main s
		
		Scanner scanner = new Scanner(System.in);
		
		int 플레이어;
		int 컴퓨터;
		int 게임수 = 0; 
		int 플레이어승리수 = 0 ; int 컴퓨터승리수 = 0 ;
		
		while(true) {// w s
			
			System.out.println("\n\n--------------[[ 가위바위보 게임 ]] ----------- ");
			System.out.print(" >>>>>>>  가위[0] 바위[1] 보[2] 종료[3] 중 선택 : ");
			플레이어 = scanner.nextInt();
			
			/* 문제풀이 위치 */
			if(플레이어 == 0) {// if 0 s
				
				Random random = new Random();
				컴퓨터 = random.nextInt(3);
				System.out.println(">>>>>>> 컴퓨터가 낸수 : "+ 컴퓨터 );
				
				if(컴퓨터 == 1) {
					System.out.println(">>>>>>> 컴퓨터 승리");
					컴퓨터승리수 += 1 ;
					게임수 +=1 ;
				}
				else if(컴퓨터 == 2) {
					System.out.println(">>>>>>> 플레이어 승리");
					플레이어승리수 += 1 ;
					게임수 +=1 ;
				}
				else {
					System.out.println(">>>>>>> 무승부");
					게임수 +=1 ;
				}
				
			}// if 0 e
			
			if(플레이어 == 1) {// if 1 s
				
				Random random = new Random();
				컴퓨터 = random.nextInt(3);
				System.out.println(">>>>>>> 컴퓨터가 낸수 : "+ 컴퓨터 );
				
				if(컴퓨터 == 2) {
					System.out.println(">>>>>>> 컴퓨터 승리");
					컴퓨터승리수 += 1 ;
					게임수 +=1 ;
				}
				else if(컴퓨터 == 0) {
					System.out.println(">>>>>>> 플레이어 승리");
					플레이어승리수 += 1 ;
					게임수 +=1 ;
				}
				else {
					System.out.println(">>>>>>> 무승부");
					게임수 +=1 ;
				}
			}// if 1 e
			
			if(플레이어 == 2) {// if 2 s
				
				Random random = new Random();
				컴퓨터 = random.nextInt(3);
				System.out.println(">>>>>>> 컴퓨터가 낸수 : "+ 컴퓨터 );
				
				if(컴퓨터 == 0) {
					System.out.println(">>>>>>> 컴퓨터 승리");
					컴퓨터승리수 += 1 ;
					게임수 +=1 ;
				}
				else if(컴퓨터 == 1) {
					System.out.println(">>>>>>> 플레이어 승리");
					플레이어승리수 += 1 ;
					게임수 +=1 ;
				}
				else {
					System.out.println(">>>>>>> 무승부");
					게임수 +=1 ;
				}
			}// if 2 e
			
			if(플레이어 == 3) {//if 3 s
				System.out.println("[게임종료] : 게임횟수"+게임수+" 회");
				if(플레이어승리수>컴퓨터승리수) {
					System.out.println("[최종승리자] : 플레이어 : "+플레이어승리수+"회 승리");
					System.out.println("컴퓨터 : "+컴퓨터승리수+"회 승리");
					System.out.println("무승부 : "+(게임수-플레이어승리수-컴퓨터승리수)+" 회");
				}
				else if(플레이어승리수<컴퓨터승리수) {
					System.out.println("[최종승리자] : 컴퓨터 : "+컴퓨터승리수+"회 승리");
					System.out.println("플레이어 : "+플레이어승리수+"회 승리");
					System.out.println("무승부 : "+(게임수-플레이어승리수-컴퓨터승리수)+" 회");
				}
				else if(플레이어승리수==컴퓨터승리수) {
					System.out.println("비겼습니다.");
					System.out.println("플레이어 : "+플레이어승리수+"회 승리");
					System.out.println("컴퓨터 : "+컴퓨터승리수+"회 승리");
					System.out.println("무승부 : "+(게임수-플레이어승리수-컴퓨터승리수)+" 회");
				
				}
				break;
			}//if 3 e
			
			/* ----------- */
			
		}//w e
	}  //main e
}  //class e

/*
 	주제 : 가위바위보 만들기 
 		입력 조건 
 			1. 플레이어 값은 가위 대신 0 , 바위 대신 1 , 보 대신 2 , 종료 대신 3 입력받는다.
 			2. 컴퓨터 값은 난수 0~2 사이로 입력받는다.
 		실행 조건 
 			1. 플레이어에게 입력 받은 후 컴퓨터수는 난수로 자동으로 생성 한다.
 			2. 승리자 판단 한다.
 			3. 게임은 플레이어가 3을 입력할때까지 계속 진행 
 		출력 조건 
 			1. 매 게임 마다 승리자 출력 
 			2. 게임종료시 게임수 와 최종승리자 출력[ 가장 많이 이긴 플레이어 호출 
*/





