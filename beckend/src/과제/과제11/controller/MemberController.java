package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() { return memberController; }
	private MemberController() {}
	
	public boolean sineupLogic( String id , String pw , String name , String phone ) {
		System.out.println("sineupLogic 컨트롤 도착");
		System.out.println(id +"," + pw + "," + name + "," + phone + " 도착" );
		//1. 객체화 : 5개 변수들이 이동 할때 마다 매개변수의 코드 길어지니까.. 패키지화
		MemberDto memberDto = new MemberDto(0, id, pw, name, phone);
			// 1.회원가입시 회원변호는 자동[auto_increment] 이므로 필요 없으므로 기본값 0
		//2. Dao 에게 전달하고 SQL 결과 받기
		boolean result =
		MemberDao.getInstance().signupSQL( memberDto );
		return result;
	}
	
	public boolean loginLogic( String id , String pw ) {
		System.out.println("loginLogic 컨트롤 도착");
		System.out.println( id +"," + pw + " 도착" );
		
		
				
		//2. Dao에게 전달
		boolean result =
		MemberDao.getInstance().loginSQL( id , pw );
		return result;
	}
	
}
