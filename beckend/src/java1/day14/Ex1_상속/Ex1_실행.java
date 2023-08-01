package java1.day14.Ex1_상속;

public class Ex1_실행 {
	
	public static void main(String[] args) {
		
		//Phone 부모객체
		Phone phone = new Phone();
		System.out.println(phone.color);
		System.out.println(phone.model);
		//System.out.println(phone.wifi); // 오류발생 : 자식클래스의 멤버이므로 불가능
		
		phone.bell();
		phone.sendVoice("여보세요");
		phone.raceiveVoidce("안녕하세요 ! 저는 홍길동입니다.");
		phone.hangUp();
		// 오류발생 : phone.setWifi(true);
		// 오류발생 : 해당 객체는 부모객체이고 해당 메소드는 자식 클래스의 멤버이므로 불가능
		
		//2. SmartPhone 자식 객체
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		System.out.println(myPhone.color);//해당 객체의 부모클래스 멤버이므로 사용가능
		System.out.println(myPhone.model);//해당 객체의 부모클래스 멤버이므로 사용가능
		System.out.println(myPhone.wifi);//해당 객체의 멤버이므로 사용가능
	
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.raceiveVoidce("안녕하세요 ! 저는 홍길동입니다.");
		myPhone.hangUp();		//해당 객체는 자식객체이므로 부모객체의 멤버 사용가능
		myPhone.setWifi(true);	// 오류발생 없는이유 : 해당 객체는 자식객체이므로 메소드는 자식클래스의 멤버이므로 사용 가능
		myPhone.internet();
	}
	
}
