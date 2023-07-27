package 과제.과제10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import 과제.과제10.Member;

public class MemberSys {
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);// 1. 모든 함수에서 사용 가는한 인스턴스 멤버
	// 프로그램 내 전역구역에서 공유 사용되는 메모리 = 정적멤버
	static int login = -1;	// 정적멤버 = 메소드영역 = 로그인 성공한 인덱스

	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) {회원가입 (); }//main 함수 밖에 있는 다른 함수 호출
			// 1. 인스턴스멤버(static 없는) 함수는 객체를 생성하고 호출한다.
			//2. 정적멤버(static 있는) 함수는 객체없이 클래스를 통한 호출한다.
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}//main end
	
	static void 회원가입 () {
		//입력받기 -> 각각 5개 입력받기
		System.out.println("\n\n--------- 회원가입 ---------"); 
		System.out.println("아이디 : "); String inputID = sc.next();
		System.out.println("비밀번호 : "); String inputPw = sc.next();
		System.out.println("이름 : "); String inputName = sc.next();
		System.out.println("전화번호 : "); String inputPh = sc.next();
		System.out.println("나이 : "); int inputAge = sc.nextInt();
		// 2. 5개 변수를 하나의 묶음 
		Member member = new Member(inputID , inputPw , inputName , inputPh , inputAge );
		//3.  회원의 1개의 객체를 배열 저장
			// 배열내 빈공간=null 을 찾는다
		for(int i =0; i<memberList.length; i++) {
			if(memberList[i] == null ) {
				memberList[i] = member;
				System.out.println("회원가입 성공");
				break;
			}//if end
		}//for end
	}//회원가입 end
	// 로그인 함수 입력받아 기존에 데이터와 일치한지 비교
	static void 로그인 () {
		
		System.out.println("\n\n--------- 로그인 ---------"); 
		System.out.println("아이디 : "); String inputID = sc.next();
		System.out.println("비밀번호 : "); String inputPw = sc.next();
		
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null &&
					memberList[i].id.equals(inputID) && 
					memberList[i].password.equals(inputPw)) {
				login = i; // 정적 멤버 변수에 로그인 성공한 인덱스를 넣어두기 ->추후에 사용할 목적
			}//if end
		}//for end
		if(login >= 0) {System.out.println("로그인 성공");}
		else {System.out.println("로그인 실패");}
		
	}//로그인 end
	static void 아이디찾기 () { 
		System.out.println("\n\n--------- 아이디찾기 ---------"); 
		System.out.println("이름 : "); String inputName = sc.next();
		System.out.println("전화번호 : "); String inputPh = sc.next();
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null &&
					memberList[i].name.equals(inputName) && 
					memberList[i].phone.equals(inputPh)) {
				System.out.println("찾은 아이디 : "+ memberList[i].id );
				return;
			}//if end
		}//for end
	
		System.out.println("아이디가 없습니다.");
	}//아이디찾기 end
	static void 비밀번호찾기 () { 
		
		System.out.println("\n\n--------- 비밀번호 찾기 ---------"); 
		System.out.println("아이디 : "); String inputID = sc.next();
		System.out.println("전화번호 : "); String inputPh = sc.next();
		
		Random random = new Random();
		
		int login = -1;
		String pw = "";
		
		for(int i =1; i<=4; i++) {
			pw += (char)((int)(random.nextInt(26)+97));
		}
		
		for(int i = 0; i<memberList.length; i++) {
			if(memberList[i] != null &&
					memberList[i].name.equals(inputID) && 
					memberList[i].phone.equals(inputPh)) {
				login = i;
				memberList[i].password = pw;
			}//if end
		}//for end
		if(login >=0) {
			System.out.println("바뀐 비밀번호 : " +pw );
		}
		else {System.out.println("일치하지 않습니다.");}
	}
	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














