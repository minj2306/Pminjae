package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.LetterDto;

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
		public BoardDto boardView ( int bno ) {
			
			return BoardDao.getinstance().boardView(bno);

		}
		
		//8. boardUpdate : 게시물 수정 [ 준비물 : bno = 수정할 게시물의 식별[누구를 수정할건지] / mno(게시물의 작성자) = 수정요청한 회원과 게시물의 작성자가 일치한 경우에만[유효성검사] / title : 수정할 값 , content ]
		public int boardUpdate ( int bno , int mno , String title , String content ) {
			
			//1. 유효성  검사
				//1. 게시물의 작성자 회원번호와 로그인된 회원과 일치하지 않으면
			if(mno != MemberController.getInstance().getLoginSession()) {return 3;}
				//2. 제목 글자수 검사
			if(title.length() < 1 || title.length()>50) { return 4; }
			
			//2.
			boolean result = BoardDao.getinstance().boardUpdate( new BoardDto(  mno , title , content ) );
			if(result) {return 1;}
			else { return 2; }
			
		}
		
		//9. boardDelete : 게시물  삭제[ 준비물 bno = 삭제할 게시물의 식별[ 누구를 삭제할건지 ] / mno(게시물의 작성자) = 삭제 요청한 회원과 게시물의 작성자가 일치한 경우에만 [유효성검사] ]
		public int boardDelete ( int bno , int mno ) {
			
			if(mno != MemberController.getInstance().getLoginSession()) {return 3;}
			
			boolean result = BoardDao.getinstance().boardDelete(bno);
			
			if(result) {return 1;}
			else { return 2; }
		}
		
		//10. 쪽지보내기
		public boolean letterWrite(  String content , int bno , int savem  ) {
			
			int givem = MemberController.getInstance().getLoginSession();
			
			if( content.length() == 0 ) { return false; }
			LetterDto letterDto = new LetterDto( content , bno , givem  , savem);
			
			return BoardDao.getinstance().letterWrite( letterDto );
			
		}
		
		//11 쪽지 확인하기
	
	
}
