package java2.day27_컬렉션프레임워크2.Ex1_Hashset;


public class Member {

	public String name; 
	public int age;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//-----------해당 객체의 기준 만들기------------ㅏ
	
	//Object( 모든 클래스는 Object으로부터 자동으로 상속받음 ) 의 메소드를 재정의
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {

		//만약에 해당객체가 이름과 나이가 일치하면[중복 = true]
		if(obj instanceof Member target ) { // javaSE-16 이상
			return target.name.equals(name) && ( target.age == age );
		}else {
			return false;
		}
	}
}

