package java1.day16.Ex1_필드의다형성;

public class Ex1_실행 {

	public static void main(String[] args) {
		
		//Car 객체 생성
		Car mycar = new Car(); // tire 필드에 객체가 없는 상태 
		System.out.println( mycar.tire ); // 필드에 초기화가 없으면 기본값 [ 참조타입 = null ]
		
		//2. Car 객체의 타이어 장착 = Car 객체의 타이어 필드에 초기화
		mycar.tire = new Tire();
		System.out.println(mycar.tire);
		
		//3. 타이어(객체) 장착된 Car 객체가 전진
		mycar.run(); // 기본 타이어 객체가 roll 메소드 실행
		
		//4. 타이어(객체) 교체하기 위해 카센터에서 한국타이어 교체
		mycar.tire = new HankookTire(); // 원래 기존에 있던 Tire 객체는 자동 삭제
		System.out.println(mycar.tire);
		
		//5. 타이어(객체) 교체장착된 Car 객체가 전진
		mycar.run(); // 한국 타이어 객체가 roll 메소드 실행
		
		//6. 타이어(객체) 교체하기위해 카센터에서 금호 타이어 교체
		mycar.tire = new KumhoTire(); // 금호타이어 객체를 대입 // 원래 기존에 있던 한국 Tire 객체는 자동 삭제 
		System.out.println(mycar.tire);
		
		//7. 타이어(객체) 교체장착된 Car 객체가 전진
		mycar.run(); 
	}
	
}
