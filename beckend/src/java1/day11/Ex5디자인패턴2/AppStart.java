package java1.day11.Ex5디자인패턴2;

import java1.day11.Ex5디자인패턴2.view.Mainpage;

public class AppStart {//프로그램 전원
	public static void main(String[] args) {
		// 다른 클래스에 있는 메소드를 호출하는 방법
		// 1. 메소드가 인스턴스 멤버이면 => 객체를 이용한 메소드 호출
			//Mainpage mainpage = new Mainpage();
			//mainpage.mainPage();
		// 2. 메소드가 정적멤버이면 => 클래스 이용한 메소드 호출
			//Mainpage.mainPage();
		// 3. 싱글톤 객체이면	=> 싱글톤 객체 호출해서 메소드 호출
			Mainpage.getInstance().mainPage();
	
	}

}
