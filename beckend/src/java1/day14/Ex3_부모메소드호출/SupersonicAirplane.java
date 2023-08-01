package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirplane extends Airplane {
			//자식클래스명 extends 부모 클래스명
			// ! : 자식 클래스에서 부모 클래스의 구성 멤버를 사용할수 있다.
			//!! : 단) 부모클래스는 자식클래스의 구성 멤버를 사용할수 없다.
	
	//1. 필드
	public static final int NOMAL = 1;
	public static final int SUPERSONOC = 2;
	
	public int flyMode = NOMAL;
	
	//2. 생성자
		public SupersonicAirplane() {
			super(); //부모생성자 호출 -> Airplane
		}
	//3. 메소드
		//부모클래스로부터 오버라이딩 => 컨트롤+스페이스바
	@Override //생략가능
	public void fly() {
		if(flyMode == SUPERSONOC) {
			System.out.println("초음속 비행합니다.");
		}
		else {
		super.fly(); // 부모메소드 호출
		}
	}
	@Override //Object  메소드를 오버라이딩
	public String toString() {
		return "SupersonicAirplane [flyMode=" + flyMode + "]";
	}
	
	
}

/*
 
 */
