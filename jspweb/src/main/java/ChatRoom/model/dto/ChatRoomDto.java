package ChatRoom.model.dto;

public class ChatRoomDto {
	  private int cno;
	  private String chatid;
	  private String ccontent;
	  private String ctime;
	  
	  public ChatRoomDto() { }

	public ChatRoomDto(int cno, String chatid, String ccontent, String ctime) {
		super();
		this.cno = cno;
		this.chatid = chatid;
		this.ccontent = ccontent;
		this.ctime = ctime;
	}
	//채팅 출력용
	public ChatRoomDto(String chatid, String ccontent, String ctime) {
		super();
		this.chatid = chatid;
		this.ccontent = ccontent;
		this.ctime = ctime;
	}
	//채팅 전송용
	public ChatRoomDto(String chatid, String ccontent) {
		super();
		this.chatid = chatid;
		this.ccontent = ccontent;
	
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getChatid() {
		return chatid;
	}

	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "ChatRoomDto [cno=" + cno + ", chatid=" + chatid + ", ccontent=" + ccontent + ", ctime=" + ctime + "]";
	}
	
	  
}
