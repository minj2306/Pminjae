package java2.day26_컬렉션프레임워크;

public class Board {

	//필드
	private String sbject;
	private String content;
	private String writer;
	
	//생성자
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String sbject, String content, String writer) {
		super();
		this.sbject = sbject;
		this.content = content;
		this.writer = writer;
	}
	
	//메소드
	public String getSbject() {
		return sbject;
	}

	public void setSbject(String sbject) {
		this.sbject = sbject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "Board [sbject=" + sbject + ", content=" + content + ", writer=" + writer + "]\n";
	}
	
	
}
