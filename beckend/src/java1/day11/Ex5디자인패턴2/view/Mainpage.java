package java1.day11.Ex5디자인패턴2.view;

import java.util.Random;
import java.util.Scanner;

import java1.day11.Ex5디자인패턴2.controller.MemberController;
import java1.day11.Ex5디자인패턴2.model.dao.MemberDao;
import 과제.과제10.Member;

public class Mainpage {
	//0. 싱글톤 생성
		//1. 현재 클래스로 static 객체 생성
	public static Mainpage mainPage = new Mainpage();
		//2. 외부 객체에서 해당 싱글톤 호출하기 위한 메소드
	public static Mainpage getInstance() {
		return mainPage;
	}
		//객체 외부에서 해당 클래스로 객체 생성 잠금 , 생성자를 private
	private Mainpage() { } 
	//1. 필드
	private Scanner sc = new Scanner(System.in);
	//2. 생성자
	//3. 함수
	public void mainPage(){
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { sineupPage (); }
			else if( ch == 2 ) { loginPage (); } 
			else if( ch == 3 ) { findIdPage (); } 
			else if( ch == 4 ) { findPwPage (); } 
			
		} // w e 
		
	}


void sineupPage () {
	//입/출력
	System.out.println("\n\n--------- 회원가입 ---------"); 
	System.out.println("아이디 : "); String inputID = sc.next();
	System.out.println("비밀번호 : "); String inputPw = sc.next();
	System.out.println("이름 : "); String inputName = sc.next();
	System.out.println("전화번호 : "); String inputPh = sc.next();
	System.out.println("나이 : "); int inputAge = sc.nextInt();
	//----> 컨트롤러/서빙에게 전달 // 컨트롤 클래스내 메소드 호출
	boolean result = MemberController.getInstance().sineupLogic( inputID , inputPw , inputName , inputPh , inputAge );
	if( result ) {
		System.out.println("안내) 회원가입 성공");
	}
	else {
		System.out.println("안내) 회원가입 실패");
	}
}
void loginPage () {
	System.out.println("\n\n--------- 로그인 ---------"); 
	System.out.println("아이디 : "); String inputID = sc.next();
	System.out.println("비밀번호 : "); String inputPw = sc.next();
	boolean result = MemberController.getInstance().loginLogic(inputID , inputPw);
	if( result ) {
		System.out.println("안내) 로그인 성공");
	}
	else {
		System.out.println("안내) 로그인 실패");
	}
}
void findIdPage () { 
	System.out.println("\n\n--------- 아이디찾기 ---------"); 
	System.out.println("이름 : "); String inputName = sc.next();
	System.out.println("전화번호 : "); String inputPh = sc.next();
	String result = MemberController.getInstance().findIdLogic(inputName , inputPh);
	if(!result.equals("")) {
		System.out.println("찾은 아이디 : "+ result );
	}
	else {System.out.println("아이디가 없습니다.");}
}
void findPwPage () { 
	System.out.println("\n\n--------- 비밀번호 찾기 ---------"); 
	System.out.println("아이디 : "); String inputID = sc.next();
	System.out.println("전화번호 : "); String inputPh = sc.next();
	String result = MemberController.getInstance().findPwLogic(inputID, inputPh);
	if(!result.equals("")) {
		System.out.println("바뀐 비밀번호 : "+result);
	}
	else {
		System.out.println("일치하지 않습니다.");
	}
}

}
