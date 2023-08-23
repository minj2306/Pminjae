package java2.day24_제네릭.Ex4_제네릭메소드;

import java.util.ArrayList;

public class Ex4_제네릭 {

	//제네릭 메소드 선언
		//목적 : 함수에서 매개변수 정의할떄. 정해저 있지 않는 타입 받고싶을떄
			// public boolean 메소드 (int value){}
			// public boolean 메소드 (String value){}
			// --> 통합 // public <T> boolean 메소드(T value){}
	
		// 메소드 선언부 <제네릭타입> : 함수내에서도 제네릭타입 사용할수 있다.
	public static <T> Box<T> boxing( T t ){
					// 매개변수 제네릭타입 사용하기 위한 <T> 선언부에 정의하면 사용가능
					// T t = 100
		Box<T> box = new Box<>();
		box.setT(t);	//box객체 [ t = 100 ]
		return box;
		
	}
	
	public static void main(String[] args) {
		
		//1. Box 객체 t 필드를 Integer 타입으로 선정
		Box<Integer> box1 = boxing(100); // 타입 파라미터에 값 넣으면 (자동으로) 값의 타입으로 Integer 
			//box1 [Integer t]
		int intvalue = box1.getT();
		System.out.println(intvalue);
		
		//2.
		Box<String> box2 = boxing("홍길동"); // 타임 파라미터에 값 넣으면 (자동으로) 값의 타입으로 String
		String strvalue = box2.getT();
		System.out.println(strvalue);
		
		//ArrayList : 누군가가 미리 만든 클래스 [ 라이브러리 ]
			// 라이브러리 [클래스] < API[인터페이스 포함] < 프로그램제공[프레임워크]
		//ArrayList<Integer>
	
	}
	
}
