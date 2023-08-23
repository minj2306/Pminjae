package AccountBook.model.Dto;

public class AccountBookDto {
	
	private int ano;	//식별번호
	private String atext;//항목내용
	private int anumber;//금액
	private String date;//날짜
	
	public AccountBookDto() { }

	public AccountBookDto(int ano, String atext, int anumber, String date) {
		super();
		this.ano = ano;
		this.atext = atext;
		this.anumber = anumber;
		this.date = date;
	}
	
	
	//저장용
	public AccountBookDto(String atext, int anumber, String date) {
		super();
		this.atext = atext;
		this.anumber = anumber;
		this.date = date;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAtext() {
		return atext;
	}

	public void setAtext(String atext) {
		this.atext = atext;
	}

	public int getAnumber() {
		return anumber;
	}

	public void setAnumber(int anumber) {
		this.anumber = anumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AccountBookDao [ano=" + ano + ", atext=" + atext + ", anumber=" + anumber + ", date=" + date + "]";
	}
	
}
