package 과제.과제4.Level3.ex4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_4 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_4 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		/* 문제풀이 위치 */
		
		int b = 0 ;
		char 네모 = '■';
		
		while (true) {
			
			System.out.println("입력하세요>>");
			int a = scanner.nextInt();
			b += a;
			
			if(b>=1) {
				System.out.println("누적값 : "+b);
				for(int i = 1 ; i<=b ; i++ ) {
					System.out.print(네모);
				}
			}
			else {
				System.out.println("누적값 : "+b);
				System.out.println("종료합니다.");
				break;
			}
			System.out.println();
		}
		
	
		/* ----------- */

	}
}
/* 
	[문제] 그림과 같이 계속입력한 수에 따라 누적으로 저장되어 저장된 수 만큼 '■' 를 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 만약에 누적값이 0 보다 작으면 종료됩니다.
*/
