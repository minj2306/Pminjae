package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7 {//class s
	
	public static void main(String[] args) {//main s
	
		//step 3 : Scanner 클래스를 이용한 입력된 데이처로 [1,2,3,4] 기능제공
			//입력
			//1. 입력객체
		Scanner scanner = new Scanner(System.in);
			//2. 입력객체를 이용한 next~~()메소드로 입력객체내 입력받은 데이터 형변환해서 호출
		
		int 잔고 = 0;
		boolean 온오프 = true;
		
		while (온오프) {//무한루프 //종료할떄따지 4 입력할때 까지 프로그램 실행 계속 되어야 한다 = 무한루프 // 종료조건 : 4 입력시
			
			System.out.println("-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4. 종료");
			System.out.println("-------------------------------");
			System.out.print("선택>");
			
			int select = scanner.nextInt();
			
			if(select == 1) {
			
				System.out.print("예금액>"); int 예금 = scanner.nextInt();
				System.out.println(예금+" 원 입금되었습니다.");
				잔고 += 예금 ;
			}
			if(select == 2) {
				
				System.out.print("출금액>"); int 출금 = scanner.nextInt();
				System.out.println(출금+" 원 출금되었습니다.");
				잔고-= 출금;
			}
			if(select == 3) {
				
				System.out.println("잔고>"+잔고+" 원");
			}
			if(select == 4) {
				
				System.out.println("종료되었습니다.");
				온오프 = false;
			}
			if(select != 1 && select != 2 && select != 3 && select != 4 ) {
			
			System.out.println("올바른 번호를 입력해주세요");
				continue;
			}
			
		}//w end
	}//main e
	
}//class e
