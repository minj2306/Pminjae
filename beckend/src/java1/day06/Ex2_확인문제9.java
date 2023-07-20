package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_확인문제9 {

	public static void main(String[] args) {
		
		//[p.199]
		
		int count = 0;
		int [] scores = new int[count];
		
		
		while (true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>");
			String ch = scanner.nextLine();
			
			if(ch.equals("1")) {//if 1 s
				
				// 1. 입력받은 데이터를 문자열로 가져화서 정수형으로 반환후 정수 변수에 저장
				count = Integer.parseInt( scanner.nextLine() );
				System.out.println("학생수>"+ count);
				
				// 2. 입력받은 수 만큼 배열 선언
					//1. = { } 저장할 값을 아는경우
					//2. new 타입[길이] 지정할 값을 몰라서 길이만큼 기본값으로 생성 
				scores = new int[count];
				
			}//if 1 end
			
			if(ch.equals("2")) {
				
				//step 5 : 각 기능 구현
				
				//1. 0부터 입력받은 수 만큼 점수(정수) 입력받기
					//Integer.parseInt(scanner.nextLine()); //정수 입력받기 vs scanner.nextint();
				for( int i = 0 ; i<count ; i++) {
					
					System.out.println(i + "번쨰 인덱스에 저장할 학생점수 입력");
					scores[i] = Integer.parseInt(scanner.nextLine()); // 입력받은 정수를 배열내 각 인덱스에 저장/변경
				}
					System.out.println(Arrays.toString(scores));
				
			}//if 2 end
			
			if(ch.equals("3")) {
				
				// 1. 2번 기능에서 학생수만큼 점수를 입력받은 배열 출력[배열내 모든 인덱스 출력 ] 0부터 마지막까지
				for(int i=0 ; i<scores.length; i++) {
					System.out.println(i + " 인덱스에 저장된 학생 점수 : " + scores[i]);
				}

				
			}//if 3 end
			
			if(ch.equals("4")) {
				
				int sum = 0 ; // 배열내 데이터를 모두 더한(누계) 값을 저장하는 변수
				int max = 0 ; // 배열내 데이터중에 가장 큰 값을 저장하는 변수
				
				//배열내 모든 데이터 호출 [0 인덱스 마지막까지 호출]
				for( int i = 0 ; i<scores.length; i++) {
					//1. sum
					sum += scores[i]; // i번째 데이터를 sum 변수에 추가/누계
					//2. max
					if(max < scores[i]) max = scores[i];// 만약에 i번째 데이터가 max보다 크면 max에 i번째 데이터 저장
				}//f end
				System.out.println("최고점수 : "+max);
				System.out.println("평균 : "+((double)sum/count));
			
			}//if 4 end
			
			if(ch.equals("5")) {
				
				System.out.println("프로그램 종료"); break;
				
			}//if 5 end
		}
		
	}
	
	
}
// .nextLine() 사용시 주의할점
	//* nextLine 사용시 다른 next~~() 앞뒤로 존재했을떄 하나로 인신(오류로 보일수 있다.)
	// 해결방안1
	// Integer.parseInt(scanner.nextLine());
	// 해결방안2
	// String 문자 = scanner.nextLine();
	// int 정수 = scanner.nextint(); scanner.nextLine;
 	// String 문자 = scanner.nextLine();


