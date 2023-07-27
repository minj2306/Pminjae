package java1.day11.Ex2;

import java1.day11.Ex1.B;

public class C {
	// 1. 오류 A와 C 클래스는 다른 패키지 이지만 A클래스가 defailt 이므로 
	// A a = new A();
	
	// 2. B와 C 클래스는 다른 패키지 이지만 B클래스가 public 이므로 
	B b = new B();
			
			private C() { } 

}
