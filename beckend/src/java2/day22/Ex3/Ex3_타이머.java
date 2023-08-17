package java2.day22.Ex3;

import java.time.LocalTime;
import java.util.Scanner;

public class Ex3_타이머 {

	public static void main(String[] args) {

		Ex3_현재시간기능 현재시간 = new Ex3_현재시간기능();
		Thread thread = new Thread( 현재시간 );
		thread.start();
		
		//타이머 사용여부는 선택받이 실행
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			System.out.println("1.타이머시작 2.타이머중지 : ");
			int ch = scanner.nextInt();
			if(ch==1) {
				//[타이머기능 스레드] main 스레드에서 1번 입력하면 타이머 실행
				System.out.println("타이머시작");
				Ex3_타이머기능 타이머 = new Ex3_타이머기능();
				Thread thread2 = new Thread(타이머);
				thread2.start();
			}
			else if(ch==2) {System.out.println("타이머종료");}
		}
		
	}
	
}
