package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	// 0.싱글톤
	private static LoginPage loginPage = new LoginPage();
	
	public static LoginPage getinstance() {
		return loginPage;
	}
	private LoginPage() {}
	
	//0.입력객체
	private Scanner sc = new Scanner(System.in); 
	
	//1. loginMenu : 로그인 헀을때 메뉴 페이지
	public void loginMenu() {
		while (MemberController.getInstance().getLoginSession() != 0) {
			
			boardPrint();
			
			System.out.println("----------------------------");
			System.out.println("1.로그아웃 2.회원정보 3.글쓰기  >>>>>선택");
			
			try {
			int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
			
			if(ch==1) { MemberController.getInstance().logOut(); }
			else if(ch==2) { info(); }
			else if(ch==3) { boardWrite(); }
			
			}catch(Exception e) {
				System.out.println("경고] 잘못된 입력입니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
			}//try catch end
		}
	}
	
	
	//2. info : 회원정보 페이지
	public void info() {
		
		System.out.println("----------------------------");
		// 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[DTO] 반환받기
		MemberDto result = MemberController.getInstance().info();  
		
		// 2. 반환받은 회원정보객체[memberDto] 의 각 필드를 출력
		//System.out.println(">ID : " + result.id()); // Dto 필드의 직접접근 불가능
		System.out.println(">ID : " + result.getMid());
		System.out.println(">NAME : " + result.getMname() );
		System.out.println(">PHONE : " + result.getMphone());
		
		//2. 서브메뉴
		System.out.println("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 >>>>선택");
		int ch = sc.nextInt();
		if(ch==1) { infoUpdate(); }
		else if(ch==2) { infoDelete(); }
		else if(ch==3) { return; }//생략가능
		
	}
	
	//3. infoUpdate : 비밀번호 수정 페이지
	public void infoUpdate () {
		
		System.out.println("--------------비밀번호 변경--------------");
		System.out.println("새로운 비밀번호 : "); String newPw = sc.next();
		
		boolean result = MemberController.getInstance().infoUpdate(newPw);
		if(result) {
			System.out.println("안내) 비밀번호 수정 완료 : 로그아웃 됩니다.");
			MemberController.getInstance().logOut();
		}
		else {
			System.out.println("경고] 비밀번호 수정 실패 : 관리자에게 문의");
		}
	}
	
	//4. infoDelete : 회원 탈퇴 페이지
	public void infoDelete () {
		
		System.out.println("--------------회원탈퇴--------------");
		System.out.println("정말 탈퇴하시겠습니까?? 1.예 2.아니요");
		int ch = sc.nextInt();
		
		if(ch==1) {
			
			boolean result = MemberController.getInstance().infoDelete();
			
			if(result) {
				
				System.out.println("안내] 회원탈퇴 성공 : 로그아웃 됩니다.");
				MemberController.getInstance().logOut();
			}
			else {
				System.out.println("경고] 회원탈퇴 실패 : 관리자에게 문의");
			}
		}
		
	}
	
	//5. boardWrite : 게시물 쓰기 페이지
	public void boardWrite () {
		System.out.println("--------------글쓰기 페이지--------------");
		System.out.println("제목");	String title = sc.next();
		System.out.println("내용");	String content = sc.next();
		
		boolean result = BoardController.getinstance().boardWrite( title , content );
	
		if(result) {
			System.out.println("안내] 글쓰기 등록");
		}
		else {
			System.out.println("안내] 글쓰기 실패 : 관리자 문의");
		}
	}
	
	//6. boardPrint : 모든 게시물 출력
	public void boardPrint () {
		
		System.out.println("--------------게시판--------------");
		//1. 여러개의 게시물을 요청해서 반환된 결과 저장
		ArrayList<BoardDto> result =
				BoardController.getinstance().boardPrint();
		//2. 출력
		System.out.printf(" %-3s %-4s %-20s %-10s %s \n" , "no" , "view" , "date" , "mid" , "title");
		for(int i = 0 ; i < result.size(); i++) {
			BoardDto dto = result.get(i); // i번쨰 객체를 호출
			System.out.printf(" %-3s %-4s %-20s %-10s %s \n" , 
							dto.getBno() , dto.getBview() , dto.getBdate() , dto.getMid() , dto.getBtitle() );
		}
		
		
	}
	
	//7. boardView : 개별 개시물 출력
	public void boardView () {}
	
	//8. boardUpdate : 게시물 수정
	public void boardUpdate () {}
	
	//9. boardDelete : 게시물  삭제
	public void boardDelete () {}
	
}
/*
 	ArrayList<리스트에 저장할 타입> 리스트 객체명 = new ArrayList<>();
 		1. .size()	: 리스트내 객체수				== 유사 result.length
 		2. .get(인덱스) : 리스트내 인덱스번째의 객체 호출 	== 유사 result[i]
 */

