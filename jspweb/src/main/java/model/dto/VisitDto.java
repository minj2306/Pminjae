package model.dto;

public class VisitDto {
	//필드
	private int vno ;
	private String vwriter;
	private String pwd;
	private String vcontent;
	private String vdate;
	
	//2. 생성자 [기본셋팅 : 1.빈생성자 , 2. 풀생성자 3. 그외 추가]
	public VisitDto() {
		// TODO Auto-generated constructor stub
	}

	public VisitDto(int vno, String vwriter, String pwd, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.pwd = pwd;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}
	
	//저장할떄 사용되는 생성자 [매개변수 3개]
	public VisitDto(String vwriter, String pwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.pwd = pwd;
		this.vcontent = vcontent;
	}

	//3. 메소드[기본셋팅 : 1. get , set 2. toString() 3.]
	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	@Override
	public String toString() {
		return "VisitDto [vno=" + vno + ", vwriter=" + vwriter + ", pwd=" + pwd + ", vcontent=" + vcontent + ", vdate="
				+ vdate + "]";
	}
	
}
