package java1.day13.Ex2.controller;

import java.io.Writer;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {

	// 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	
	private static BoardController boardController = new BoardController();
	
	public static BoardController getInstance() {
		return boardController;
	}
	
	private BoardController() {}
	
	
	
	//글 등록 처리 기능함수
	public boolean writeLogic( String content , String writer ) {

		//1. 매개변수로 부터 전달 받은 content , writer 를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(content , writer);
		
		BoardDao.getInstance().boardDtoList.add(boardDto);
			//성공 = true 실패 = false
		return true;
	}

	//글 출력 처리 기능함수
	public BoardDto printLogic(int index) {
		int view = 1;
		//1. 리스트 안에 있는 객체 호출 .get(인덱스) : 해당 인덱스의 객체 호출
		BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
		BoardDao.getInstance().boardDtoList.get(index);
		return boardDto;
		
	}	

	//글 수정 처리 기능함수
	public boolean updateLogic( int index  , String content , String writer ) { 
		
		//1. 입력받은 인덱스의 게시물을 호출해서 새로운 입력받은 값으로 대입
		BoardDao.getInstance().boardDtoList.get(index).setContent(content);
		BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);
		BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);

		return true;
	}

	//글 삭제 처리 기능함수[ D ] : 삭제할 게시물 인덱스
	public boolean deleteLogic( int index ) {
		
		BoardDao.getInstance().boardDtoList.remove(index);
		//2.삭제여부 반환
		return true;
	}

}
