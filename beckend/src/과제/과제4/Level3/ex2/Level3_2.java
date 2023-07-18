package 과제.과제4.Level3.ex2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		
		/* 문제풀이 위치 */
		boolean 온오프 = true;
		int i = 0;
		while (온오프) {//w s
			
			if(i>=0) {//if s
				++i;
				System.out.print(i+" 회 입력 :");
				String 입력 = scanner.next();
				
				if(입력.equals("end")) {
					System.out.println("안내)프로그램 종료합니다.");
					System.out.println("[총 "+i+" 회 입력]");
					break;
				}
			}//if e
			
		}//w e
		
		/* ----------- */

	}
}
/* 
	[문제] 
		그림과 같이 무한적으로 문자열을 입력 받다가 end 입력시 
		입력받은 횟수와 문구를 출력후 종료되는 반복문을 구현하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.

*/
