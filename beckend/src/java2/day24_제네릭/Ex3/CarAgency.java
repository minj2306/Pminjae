package java2.day24_제네릭.Ex3;
//CarAgency : 자동차 렌탈해주는 대리점
public class CarAgency implements Rentable<Car> {
			//implements : 인터페이스(추상메소드) 구형(정의) 하다.

@Override
public Car rent() {
	return new Car();
}
}
