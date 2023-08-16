package java2.day21;

public class Ex3_예외던지기 {

	public static void main(String[] args) {
		//p.478 예외 던지기 : 메소드 안에서 예외가 발생하면 해당 메소드를 호출했던곳으로 예외이동
		try {
			findClass(); // 해당클래스가 예외 던지기 하기 전에는 에외 x
		} catch (ClassNotFoundException e) {
			System.out.println("예외처리 : " +e.toString());
		}
		
	}
	public static void findClass() throws ClassNotFoundException {
		
		Class.forName("java.lang.String2");
		//예외발생 처리방법 2가지
			//1. try{} catch{}	: 해당 메소드에 직접 처리하는 방법
			//2. throws			: 해당 메소드에 직접 처리하지 않고 해당 메소드를 호출했던곳으로 예외 이동
				// 웹에서는 자동 예외처리 가능[ 서블릿 클래스 ] 
		
	}
}
