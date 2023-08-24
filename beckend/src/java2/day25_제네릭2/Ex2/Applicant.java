package java2.day25_제네릭2.Ex2;

public class Applicant <T> {

	public T kind;
	
	// 생성자
	public Applicant( T kind ) {
		this.kind = kind;
	}
	public Applicant() {
		// TODO Auto-generated constructor stub
	}
}
