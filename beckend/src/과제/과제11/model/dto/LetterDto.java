package 과제.과제11.model.dto;

public class LetterDto {

	int lno;
	String lcontent;
    int bno;
    int givemno;
    int savemno;
	String ldate;
   
	public LetterDto() {
		// TODO Auto-generated constructor stub
	}

	public LetterDto(int lno, String lcontent, int bno, int givemno, int savemno, String ldate) {
		super();
		this.lno = lno;
		this.lcontent = lcontent;
		this.bno = bno;
		this.givemno = givemno;
		this.savemno = savemno;
		this.ldate = ldate;
	}

	

	public LetterDto(String lcontent, int bno, int givemno, int savemno) {
		super();
		this.lcontent = lcontent;
		this.bno = bno;
		this.givemno = givemno;
		this.savemno = savemno;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getLcontent() {
		return lcontent;
	}

	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getGivemno() {
		return givemno;
	}

	public void setGivemno(int givemno) {
		this.givemno = givemno;
	}

	public int getSavemno() {
		return savemno;
	}

	public void setSavemno(int savemno) {
		this.savemno = savemno;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	@Override
	public String toString() {
		return "LetterDto [lno=" + lno + ", lcontent=" + lcontent + ", bno=" + bno + ", givemno=" + givemno
				+ ", savemno=" + savemno + ", ldate=" + ldate + "]";
	}
	
	
	
	
}