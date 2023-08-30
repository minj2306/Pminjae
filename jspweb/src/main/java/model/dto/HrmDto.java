package model.dto;

public class HrmDto {

	private int hno;
	private String hname;
	private String hphone;
	private String hposition;
	private String hdate;
	private String himg;
	
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}

	public HrmDto(int hno, String hname, String hphone, String hposition, String hdate, String himg) {
		super();
		this.hno = hno;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
		this.hdate = hdate;
		this.himg = himg;
	}

	//등록용
	public HrmDto(String hname, String hphone, String hposition, String himg) {
		super();
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
		this.himg = himg;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHposition() {
		return hposition;
	}

	public void setHposition(String hposition) {
		this.hposition = hposition;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", hname=" + hname + ", hphone=" + hphone + ", hposition=" + hposition
				+ ", hdate=" + hdate + ", himg=" + himg + "]";
	}
	
	
	
}
