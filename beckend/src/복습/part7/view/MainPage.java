package 복습.part7.view;

import java.util.Scanner;

import 복습.part7.controller.MemberController;



public class MainPage {
	
	private static MainPage mainPage = new MainPage();
	
	public static MainPage getinstance() {
		return mainPage;
	}
	private MainPage() {}

	private static Scanner scanner = new Scanner(System.in);
	public void mainPage() {
		
		while (true) {
			System.out.println("------------회원시스템------------");
			System.out.println("1.회원가입 2.로그인");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				sineup();
			}
			else if(ch==2) {
				login();
			}
		}
		
	}
	
	void sineup() {
		System.out.println("------------회원가입------------");
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		System.out.println("나이 : "); int age = scanner.nextInt();
		
		boolean result = MemberController.getinstance().sineup(id, pw, name, phone, age);
		
		if(result) {
			System.out.println("회원가입 성공");
		}
		else {
			System.out.println("회원가입 실패");
		}
		
	}
	void login() {
		System.out.println("------------로그인------------");
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		
		boolean result = MemberController.getinstance().login(id, pw);
		
		if(result) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}
