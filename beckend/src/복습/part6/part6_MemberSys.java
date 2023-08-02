package 복습.part6;

import java.util.Scanner;

public class part6_MemberSys {
	
	static part6_Member[] memberList = new part6_Member[100];
	static Scanner scanner = new Scanner(System.in);
	static int login = -1;
	
	public static void main(String[] args) {
	
		while (true) {
			
			System.out.println("--------------회원시스템--------------");
			System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
			System.out.println(">>>>>>>>>선택"); int ch = scanner.nextInt();
			
			if(ch==1) { 회원가입(); }
			else if (ch==2) { 로그인(); }
			else if (ch==3) { 아이디찾기(); }
			else if (ch==4) { 비밀번호찾기(); }
		}
	
	}//main end
	
	static void 회원가입() {

		System.out.println("--------------회원가입--------------");
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		System.out.println("나이 : "); int age = scanner.nextInt();
		
		part6_Member member = new part6_Member(id, pw, name, phone, age);
		
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i]==null) {
				memberList[i]=member;
				System.out.println("회원가입 완료");
				break;
			}
		}
	}
	static void	로그인() {
		
		System.out.println("--------------로그인--------------");
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i]!=null &&
					memberList[i].id.equals(id)&&
					memberList[i].password.equals(pw)) {
				login = i;
				break;
			}
		}
		if(login>=0) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
	static void 아이디찾기() {
		
		System.out.println("--------------아이디찾기--------------");
		System.out.println("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i]!=null &&
					memberList[i].name.equals(name)&&
					memberList[i].phone.equals(phone)) {
				System.out.println("찾은아이디 : "+memberList[i].id);
				return;
			}
		}
		
	}
	static void 비밀번호찾기() {
		
		System.out.println("--------------비밀번호 찾기--------------");
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i]!=null &&
					memberList[i].id.equals(id)&&
					memberList[i].phone.equals(phone)) {
				System.out.println("찾은 비밀번호 : "+memberList[i].password);
				return;
			}
		}
	}
	
	
}
