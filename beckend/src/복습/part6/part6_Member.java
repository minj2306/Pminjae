package 복습.part6;

public class part6_Member {
	
	String id;
	String password;
	String name;
	String phone;
	int age;
	
	public part6_Member() {
		// TODO Auto-generated constructor stub
	}

	public part6_Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "part6_Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
