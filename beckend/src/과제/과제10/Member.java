package 과제.과제10;
							//현재 클래스에서 같은 패키지에 있는 클래스 호출 = 생략
							//java.lang 기본 패키지이므로 생략 (String , system 등)
import java.util.Arrays;	// 현재 클래스에서 다른 패키지에 있는 클래스 호출 = import
import java.util.Scanner;	

//import java.util.*;			// 해당 패키지내 모든 클래스 호출

public class Member {
	// 1. 필드 : 객체의 데이터를 저장하는 곳
	String id;
	String password;
	String name;
	String phone;
	int age;
	
	public Member() {}
	
	//2. 생성자 : 객체의 초기화를 담당 열할 
	public Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	
	}
		//3. 특정 개수 필드를 저장하는 생성자 -> 추후에 필요하면 선언

	//3. 메소드 : 객체의 행동을 담당 열할
			// 1. setter or getter
		
			// 2. toString : 객체 호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [* 개발자가 객체 상태 검사용 ]
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}

	
}


/*
 
 	JVM : 자바 가상(논리적으로 만들어 낸) 메모리
 	
 	 	Member.java -----클래스로더----> Member.class----------> 메소드영역
 	 	자바 코드파일				바이트코드 파일						클래스코드 ,메소드코드
 																정적멤버
 																
 		this			: 인스턴스멤버	: new 힙생성시 할당되고 힙 초기화될때[ GC ]
 							- static 키워드 없으면
 							- 객체를 통해 사용
 		static			: 정적멤버	: 프로그램 시작 할당되고 프로그램이 종료될때 [전역/공통/공용/공유]
 							- static 키워드 있으면
 							- 클래스 통해 사용
 		final 			: 	수정불가	: 초기화할때 대입만 가능하고 수정 불가능
 		static final	:	상수		: 프로그램내에서 1개만 저장(static) 수정 불가능(final) 합친 키워드 
 */	
 