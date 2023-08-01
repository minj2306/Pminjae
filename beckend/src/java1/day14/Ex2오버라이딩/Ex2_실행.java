package java1.day14.Ex2오버라이딩;

public class Ex2_실행 {

	public static void main(String[] args) {
		
		int r = 10;
		//1. 부모객체 생성
		Caculator  caculator = new Caculator();
		//2. 부모객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 :"+ caculator.areaCircle(r));
		
		//3. 자식 객체 생성
		Computer computer = new Computer();
		//4. 자식객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 : "+computer.areaCircle(r));
		
	}
	
}
