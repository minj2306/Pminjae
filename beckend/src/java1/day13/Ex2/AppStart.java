package java1.day13.Ex2;

import java1.day13.Ex2.View.MainPage;

public class AppStart {

	public static void main(String[] args) {
		
		//다른 클래스/객체에 없는 메소드 호출하는 방법
		
		//1.호출할 메소드가 있는 클래스의 객체를 만들어서 객체를 이용한 메소드 호출
		//MainPage mainPage = new AppStart()
		//mainPage.mainPage();
		
		//2. 호출할 메소드가 정적[static] 메소드 이면 객체없이 메소드 호출
		//MainPage.mainPage();
		
		//3. 호출할 메소드의 클래스가 싱글톤(객체) 이면 싱글톤 호출후 메소드 호출
		MainPage.getInstance().mainview();
			//MainPage : 클래스명
				//MainPage
			
	}
}
