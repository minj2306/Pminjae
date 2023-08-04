package 과제.과제11.model.dto;

public class MemberDto {
	//1. 필드
	private int mno;
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	//2. 생성자
		//기본 생성자
	public MemberDto() { }
		//풀생성자
	public MemberDto(int mno, String mid, String mpassword, String mname, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mphone = mphone;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone="
				+ mphone + "]";
	}
	
	
}
