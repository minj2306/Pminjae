package java1.day10.Ex2;

public class Computer {

		//1. 필드
		//2. 생성자
		//3. 메소드
			//1. 가변(정해져 있지 않는) 길이 매개변수를 갖는 메소드 선언
			//2. 여러개 리터럴과 하나의 배열을 가변길이 매개변수로 전달 받음
			//3. 가변길이와 일반 매개변수 있을 경우 가변길이매개변수 가장 뒤에 선언
		int sum( String str , int ...values) { // ...키워드 이용한
				//타입 ...배열번수명
			
			int sum = 0; // 매개변수로 들어온 여러개의 변수를 더한 변수
			
			for(int i =0; i<values.length; i++) {
				sum+= values[i]; // 배열내 하나씩 누적합계
			}//for end
			
			return sum;
		}//f end
	
}
