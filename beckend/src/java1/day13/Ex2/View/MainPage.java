package java1.day13.Ex2.View;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	//--------------------------싱글톤----------------------
	// 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	// 1. 현재클래스 안에 현재 클래스로 객체 선언 [private static ]
	private static MainPage mainPage = new MainPage();
	
	//2. 외부 간접적으로 싱글톤이 호출되도록 하는 함수
	public static MainPage getInstance() {
		return mainPage;
	}
	//3. 외부로부터 객체 생성 차단하는 생성자 선언
	private MainPage() {}
	//-------------------------------------------------------
	
	private Scanner sc = new Scanner(System.in);
	
	//메인페이지 입출력 함수
	public void mainview () {
		while (true) {
			System.out.println("확인용) "+BoardDao.getInstance().boardDtoList);
			System.out.println("\n\n>>>>>>방문록 프로그램<<<<<<");
			System.out.println("1.글등록 2.글보기 3.글수정 4.글삭제 선택>");
			int ch = sc.nextInt();
			if(ch==1) { writeView(); }
			if(ch==2) { printView(); }
			if(ch==3) { updateView(); }
			if(ch==4) { deleteView(); }
		}//wh end
	}//f end
	
	//글 등록 페이지 입출력 함수
	public void writeView() {
		//1. 내용(띄어쓰기o) 과 작성자(띄어쓰기x)을 입력받아 변수 저장
		sc.nextLine();
		System.out.print("방문록 : "); String content = sc.nextLine();//nextLine() 앞뒤로 
		System.out.println("작성자 : "); String writer = sc.next();
		//2.입력받은 변수를 컨트롤에게 전달
		//현재 위치도 java 컨트롤도 java 이므로 메소드 이용한다.
		// 전달 보내기 = 매개변수 	/		전달받기 = 리턴
		
		//View에서 Controller 함수 호출하기
		boolean result = BoardController.getInstance().writeLogic( content , writer ); // 문자열 2개 매개변수로 전달하고 종료 후 boolean 로 1개 리턴
		// 3. 컨트롤에게 전달받은 내용 제어하기
		if (result) {
			System.out.println("안내) 글 등록 성공");
		}
		else {
			System.out.println("안내) 글 등록 실패");
		}
	}
	//글 출력 페이지 입출력 함수
	public void printView() {
		//1. 보고자하는 게시물의 인덱스 입력 받아서 저장
		System.out.print("출력할 게시물의 인덱스 : "); int index = sc.nextInt();
		
		//2. View 에서 contriller 함수 호출하기
		BoardDto result = BoardController.getInstance().printLogic( index );
		System.out.println("안내) 검색한 방문록 정보");
		System.out.println("작성자 : "+result.getWriter() +
								"\n내용 : "+result.getContent());
	}	
	//글 수정 페이지 입출력 함수
	public void updateView() {
		
		System.out.println("수정할 게시물의 인덱스 : "); int index = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 방문록 : "); String content = sc.nextLine();
		System.out.println("수정할 작성자 : "); String writer = sc.next();

		//입력받은 변수를 컨트롤에게 전달보내고 결과를 리턴받음
		boolean result = BoardController.getInstance().updateLogic( index , content , writer );
		//3. 결과에 따른 제어
		if(result) {
			System.out.println("안내) 수정 성공");
		}
		else {
			System.out.println("안내) 수정 실패");
		}
	
	}
	//글 삭제 페이지 입출력 함수
	public void deleteView() {
		
		//1. 삭제하는 게시물의 인덱스 입력 받아서 저장
		System.out.println("삭제할 게시물의 인덱스 : "); int index = sc.nextInt();
		
		// 2.  
		//View에서 Controller 함수 호출하기
		boolean result = BoardController.getInstance().deleteLogic(index);
		//리턴 결과에 따른 제어
		if(result) {
			System.out.println("안내) 삭제 성공");
		}
		else {
			System.out.println("안내) 삭제 실패");
		}
	}
}
