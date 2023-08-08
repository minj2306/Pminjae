package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() { return memberController; }
	private MemberController() {}
	
	public int sineupLogic( String id , String pw , String name , String phone ) {
		System.out.println("sineupLogic 컨트롤 도착");
		System.out.println(id +"," + pw + "," + name + "," + phone + " 도착" );
		
		//1. 아이디 중복첵크
		if(MemberDao.getInstance().infoCheck("mid", id)) { return 3; }
		
		//2. 전화번호 중복체크
		if(MemberDao.getInstance().infoCheck("mphone", phone)) { return 4; }
		
		//1. 객체화 : 5개 변수들이 이동 할때 마다 매개변수의 코드 길어지니까.. 패키지화
		MemberDto memberDto = new MemberDto(0, id, pw, name, phone);
			// 1.회원가입시 회원변호는 자동[auto_increment] 이므로 필요 없으므로 기본값 0
		//2. Dao 에게 전달하고 SQL 결과 받기
		boolean result =
		MemberDao.getInstance().signupSQL( memberDto );
		if(result) return 1;
		else return 2;
	}
	
	//0. 로그인된 회원의번호( PK식별용 ) 를 저장하는 필드 = 웹세션
	private int loginsession = 0; // 0 : 로그인 안한 상태 1이상 : 로그인 된 회원의 번호
	
	
	//3. 로그인 처리
	public int getLoginSession() { return loginsession; }
	
	public boolean loginLogic( String id , String pw ) {
		System.out.println("loginLogic 컨트롤 도착");
		System.out.println( id +"," + pw + " 도착" );
		
		//2. Dao에게 전달
		int result =
		MemberDao.getInstance().loginSQL( id , pw );

		// 로그인 성공했을때 기록하기 [ -로그인이후 로그이된 정보로 활동 ]
		if( result >=1 ) { this.loginsession = result; return true; }
		else { return false; }
		
	}
	
	//3-2 로그아웃 처리
	public void logOut() { this.loginsession = 0; }
	
	//4.
	public String findById( String name , String phone ) {
		
		System.out.println("view value" + name + phone);
		//테스트 : view 전달받은 매개변수 확인
		String result =
				MemberDao.getInstance().findById(name, phone);
		
		return result;
		
	}
	//5.
	public String findByPw( String id , String phone ) {
		
		System.out.println("view value" + id + phone);
		
		String result =
				MemberDao.getInstance().findByPw(id, phone);
		
		return result;
		
	}
	
	//6. 
	public MemberDto info() {
		// 현재 로그인 된 회원번호[loginsession] 는 view 에서 전달받지 않고 컨트롤 안에 저장 되어 있으므로
		// 현재 로그인 된 회원번호로 회원정보 요청하기
		return MemberDao.getInstance().info(this.loginsession);
			
	}
	
	//7.
	public boolean infoUpdate ( String newPw ) {
		
		return MemberDao.getInstance().infoUpdate(newPw, loginsession);
	
	}
	
	//8.
	public boolean infoDelete () {

		return MemberDao.getInstance().infoDelete(loginsession);
	
	}
}
