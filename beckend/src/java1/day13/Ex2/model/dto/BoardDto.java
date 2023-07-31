package java1.day13.Ex2.model.dto;

public class BoardDto {

	// 싱글톤x : 게시물 마다 DTO 1개 이기때문에 여러 DTO 필요
	
	// 1. 필드
		//1. 작성자(문자열) , 내용(문자열 , 조회수(int)
	// 2. 생성자
	
	// 3. 메소드
		//1. setter and getter
			//set 필드명() 	: 필드에 값 대입할떄 사용되는 메소드
			//get 필드명()	: 필드에 값 호출할때 사용되는 메소드
	
		//2. toString()		: 객체 호출시 주소값이 반환되지만 객체내 필드값을 반환하고 
	//DTO : 이동객체
		//1. 객체에 저장할 필드 선언
			//1. private 으로 필드선언	: [권장] : 객체내 필드 직접적인x
			//2. 타입
			//3. 필드명
	
	
	private String writer;
	private String content;
	private int view;
	//2. 생성자
		//1. 빈생성자
		public BoardDto() {}
		//2. 풀생성자
		public BoardDto(String writer, String content) {
			super();
			this.writer = writer;
			this.content = content;
	}
	//3. 메소드
		//1. setter and getter : 외부로부터 필드
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getView() {
			return view;
		}
		public void setView(int view) {
			this.view = view;
		}
		@Override
		public String toString() {
			return "BoardDto [writer=" + writer + ", content=" + content + ", view=" + view + "]";
		}

	
	
	
	
	
	
}// class end
