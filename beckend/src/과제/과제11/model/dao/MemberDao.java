package 과제.과제11.model.dao;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() { return memberDao; }
	private MemberDao() {}
	
	public boolean signupSQL( MemberDto memberDto ) {
		System.out.println(" signupSQL 다오 도착 ");
		System.out.println( memberDto );
		// 1. 회원가입 필요한 SQL을 문자열에 작성해서 저장
			//테이블에 레코드 삽입 : insert into 테이블명 ( 필드명 , 필드명 , 필드명 ) values( 값 , 값 , 값 )
		String sql = "insert into member ( mid , mpassword , mname , mphone ) values( ? , ? , ? , ? )";
		
		try { // Connection , prepareStatement , Resultset 예외처리 필수!!!
		// 2. 위에서 작성한 SQL을 DB 연동객체에 대입 
		// 3. 대입된 SQL 조작하기위해 반환된 prepareStatement 를 ps 대입 
		ps = conn.prepareStatement( sql ); //prepareStatement( 조작할 SQL 문자열 )
		//conn/ps 필드는 Dao 부모클래스에게 물려받음
		
		//4. SQL 에서 작성한 매개번수(?) 에 대해 값 대입		[ .setString( ?순서번호 , 값 ) ]
		ps.setString( 1 , memberDto.getMid());
		ps.setString( 2 , memberDto.getMpassword());
		ps.setString( 3 , memberDto.getMname());
		ps.setString( 4 , memberDto.getMphone());
		
		//5. SQL 실행			[ ps.executeUpdate();	: SQL 실행 ]		
		ps.executeUpdate();
		
		//6. 리턴 [회원가입 성공 = true / 실패 = false]
		return true;
		
		} catch (Exception e) {
			System.out.println("경고] 회원가입 실패 사유 : "+e);
		return false;
		}
		
		
	}
	//3. 로그인 SQL 
	public boolean loginSQL( String id , String pw ) {
		try {
		//1단계 : SQL 작성한다.[ 추전 : MYSQL 워크벤치에서 임의의 값으로 테스트 하고 ]
		String sql = "select * from member where mid = ? and mpassword = ?";
		//2단계 : SQL 조작할수 있는 객체 필요하므로 preparedStatement반환받기
		ps = conn.prepareStatement( sql );
		//3단계 : SQL 조작 [ SQL 안에 있는 매개변수 [?]에 값 대입 ]
		ps.setString(1 , id);
		ps.setString(2, pw);
		//4단계 : SQL 실행해서 그 결과객체를 rs 객체에 대입 [ *ps는 결과를 조작할수 없다. ]
			//[insert/update/delete : ps.executeUpdate(); / select : rs = ps.executeQuery();]
		rs = ps.executeQuery();
		//5단계 : SQL 실행결과 조작	[ rs.next() : 결과중에서 다음 레코드객체 호출 ]
			//만약에 결과의 레코드 3개 [ rs = null -> 레코드1객체 -> 레코드2객체 -> 레코드3객체 ]
			//							  .next()	 .next()	 .next()
		if( rs.next() ) {//로그인 SQL 결과 레코드는 1개 또는 0개 이므로 if 사용해서 .next() 1번 호출
			return true; //로그인 성공
		}
		}catch (Exception e) {
			System.out.println(e);
		}//try catch end
		return false;//로그인 실패
		
	}
	
}
