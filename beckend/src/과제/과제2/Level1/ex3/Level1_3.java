package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		
		System.out.print("input boolean : ");
		boolean a = scanner.nextBoolean();

		System.out.print("input byte : ");
		byte b = scanner.nextByte();
		
		System.out.print("input char : ");
		char c = scanner.next().charAt(0);
		
		System.out.print("input short : ");
		short d = scanner.nextShort();
		
		System.out.print("input int : ");
		int e = scanner.nextInt();
		
		System.out.print("input long : ");
		long f = scanner.nextLong();
		
		System.out.print("input float : ");
		float g = scanner.nextFloat();
		
		System.out.print("input double :");
		double h = scanner.nextDouble();
		
		
		System.out.print("output boolean : "+a+"\n");
		System.out.print("output byte : "+b+"\n");
		System.out.print("output char :"+c+"\n");
		System.out.print("output short : "+d+"\n");
		System.out.print("output int : "+e+"\n");
		System.out.print("outout long : "+f+"\n");
		System.out.print("outout float : "+g+"\n");
		System.out.print("outout double : "+h);
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
