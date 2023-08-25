package model.dto;

public class libraryDto {

	private int sno;
	private String sname;
	private String sphone;
	private int sstatus;
	private String sstatusName;
	
	public libraryDto() {
		// TODO Auto-generated constructor stub
	}

	public libraryDto(int sno, String sname, String sphone, int sstatus, String sstatusName) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sstatus = sstatus;
		this.sstatusName = sstatusName;
	}

	
	public libraryDto(int sno, String sname, String sphone, String sstatusName) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sstatusName = sstatusName;
	}

	
	
	public libraryDto(int sno, String sname, String sphone) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getSstatus() {
		return sstatus;
	}

	public void setSstatus(int sstatus) {
		this.sstatus = sstatus;
	}

	public String getSstatusName() {
		return sstatusName;
	}

	public void setSstatusName(String sstatusName) {
		this.sstatusName = sstatusName;
	}

	@Override
	public String toString() {
		return "libraryDto [sno=" + sno + ", sname=" + sname + ", sphone=" + sphone + ", sstatus=" + sstatus
				+ ", sstatusName=" + sstatusName + "]";
	}

	
	
	
	
}
