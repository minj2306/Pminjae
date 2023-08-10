package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

public class BoardController {

	private static BoardController boardController = new BoardController();
	public static BoardController getinstance() {
		return boardController;
	}
	private BoardController() {}
	
	
		//5. boardWrite : 게시물 쓰기 페이지
		public boolean boardWrite ( String title , String content ) {
			
			//1. 유효성 검사
			if(title.length() == 0 || title.length() >=50 ) {return false;}
			// 2. Dto [입력받은 제목 , 입력받은내용 , 로그인된 회원번호
			BoardDto boardDto = new BoardDto(title, content, MemberController.getInstance().getLoginSession() );
			
			//3. DAO 에게 전달후 결과 받아서 받은 결과 바로 반환
			return BoardDao.getinstance().boardWrite(boardDto);
		}
		
		
		
		//6. boardPrint : 모든 게시물 출력
		public ArrayList<BoardDto> boardPrint () {
			return BoardDao.getinstance().boardPrint();
		}
		
		//7. boardView : 개별 개시물 출력
		public void boardView () {}
		
		//8. boardUpdate : 게시물 수정
		public void boardUpdate () {}
		
		//9. boardDelete : 게시물  삭제
		public void boardDelete () {}
		
	
}
