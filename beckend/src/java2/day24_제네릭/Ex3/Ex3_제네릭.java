package java2.day24_제네릭.Ex3;

public class Ex3_제네릭 {
	
	public static void main(String[] args) {
		
		// 1. 홈 렌탈 대리점 객체 생성 [안산 지점 집 렌탈 대리점]
		HomeAgency 홈렌탈안산지점 = new HomeAgency();
		Home 유재석집 = 홈렌탈안산지점.rent();	//해당 대리점에서 새로운 Home 객체를 생성
		유재석집.turnOnLigth();	//3. 렌탈한 home 객체 (유재석집) 생성해서 메소드 실행
		
		Home 강호동집 = 홈렌탈안산지점.rent();//해당 대리점에서 새로운 Home 객체를 생성
		강호동집.turnOnLigth();//3. 렌탈한 home 객체(강호동집) 에서 메소드 실행
		
		//1-2 홈 렌탈 대리점 객체 생성 [수원지점 집 렌탈 대리점]
		HomeAgency 홈렌탈수원지점 = new HomeAgency();
		Home 신동엽집 = 홈렌탈수원지점.rent();
		신동엽집.turnOnLigth();
		Home 하하집 = 홈렌탈수원지점.rent();
		하하집.turnOnLigth();
		
		//2. 자동차 렌탈 구현체
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
	}
	
}
