package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {

	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() { return mainPage; }
	private MainPage() {}
	
	private Scanner sc = new Scanner(System.in);
	//1. 메인메뉴
		public void mainView() {
		
			while (true) {
				System.out.println("--------------회원제 커뮤니티--------------");
				System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기  >>>>>선택");
				
				try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				
				if(ch==1) { signupView(); }
				else if(ch==2) { loginView(); }
				else if(ch==3) { findById(); }
				else if(ch==4) { findByPw(); }
				
				}catch(Exception e) {
					System.out.println("경고] 잘못된 입력입니다.");
					sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
				}//try catch end
			}
			 
		}
		
		//2. 회원가입
		public void signupView() {
			System.out.println("--------------회원가입--------------");
			System.out.println("아이디 : "); String id = sc.next();
			System.out.println("비밀번호 : "); String pw = sc.next();
			System.out.println("이름 : "); String name = sc.next();
			System.out.println("전화번호 : "); String phone = sc.next();
			
			//2. 입력받은 값을 컨트롤러에게 전달하고 결과 받기
			int result =
			MemberController.getInstance().sineupLogic( id , pw , name , phone );
			//3. 결과에 출력
			if(result==1) {
				System.out.println("안내] 회원가입이 성공했습니다. 감사합니다.");
			}
			else if(result==2) {
				System.out.println("안내] 회원가입 실패했습니다. 관리자에게 문의하세요");
			}
			else if(result==3) {
				System.out.println("안내] 회원가입 실패했습니다. 아이디 중복입니다.");
			}
			else if(result==4) {
				System.out.println("안내] 회원가입 실패했습니다. 전화번호 중복입니다.");
			}
		}
		
		//3. 로그인
		public void loginView() {
			System.out.println("--------------로그인--------------");
			System.out.println("아이디 : "); String id = sc.next();
			System.out.println("비밀번호 : "); String pw = sc.next();
			boolean result =
			MemberController.getInstance().loginLogic( id , pw );
			
			if(result) {
				System.out.println("안내] 로그인 성공");
				LoginPage.getinstance().loginMenu(); //만약에 로그인 성공하면 다른 view 클래스로 이동
			}
			else {
				System.out.println("경고] 로그인 실패");
			}
		}
		//4.
		public void findById() {
			
			System.out.println("--------------아이디 찾기--------------");
			System.out.println("이름 : "); String name = sc.next();
			System.out.println("전화번호 : "); String phone = sc.next();
			
			String result 
				= MemberController.getInstance().findById(name, phone);
			
			if(result != null) {
				System.out.println("회원님의 아이디 : " + result );
			}
			else {
				System.out.println("경고] 정보가 일치한 아이디가 없습니다.");
			}
		}
		
		//5.
		public void findByPw() {
			
			System.out.println("--------------비밀번호 찾기--------------");
			System.out.println("아이디 : "); String id = sc.next();
			System.out.println("전화번호 : "); String phone = sc.next();
			
			String result 
				= MemberController.getInstance().findByPw(id, phone);
			
			if(result != null) {
				System.out.println("회원님의 비밀번호 : " + result);
			}
			else {
				System.out.println("경고] 정보가 일치한 비밀번호가 없습니다.");
			}
		}
		
	
}
