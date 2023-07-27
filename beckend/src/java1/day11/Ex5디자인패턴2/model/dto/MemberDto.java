package java1.day11.Ex5디자인패턴2.model.dto;

public class MemberDto {//데이터 모델/형식 이동 객체
	
	private String id;
	private String password;
	private String name;
	private String phone;
	private int age;
	//2. 생성자
		//1. 빈생성자
	public MemberDto() {}
		//2. 풀생성자
	public MemberDto(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	//3 메소드
		//1. settet or gettet : 필드가 private 인 경우 간접접근
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// 2. toString : 객체의 필드 상태 확인
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	


}
