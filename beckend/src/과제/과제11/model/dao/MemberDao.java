package 과제.과제11.model.dao;

import java.nio.file.spi.FileSystemProvider;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() { return memberDao; }
	private MemberDao() {}
	
	//1. 회원정보 Check SQL type = 1 아이디 중복체크 type = 2 전화번호 중복체크 
	public boolean infoCheck(String 검색필드명 , String 검색할값) {
		
		try {
			String sql = "";
			
			sql = "select * from member where " + 검색필드명+" = ?"; System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , 검색할값 );
			rs = ps.executeQuery();
			if(rs.next()) {
				 return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
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
		}
		return false;
		
	}
	//3. 로그인 SQL 
	public int loginSQL( String id , String pw ) {
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
			return rs.getInt(1); //검색된 회원번호를 반환
		}
		}catch (Exception e) {
			System.out.println(e);
		}//try catch end
		return 0;//로그인 실패
		
	}
	
	//4.
	public String findById( String name , String phone ) {
		
		try {
			// try{} 안에 예외가 발생할것 같은 , 일반예외 : JDBC, 파일처리 필수
			
			//1단계 : sql 작성
			String sql = "select * from member where mname = ? and mphone =? ";
			
			//2단계 : 작석된 sql을 조작할 PreparedStatement 객체를 연동 객체로부터 반환
			ps = conn.prepareStatement(sql);
			
			//3단계 : sql 조작 [ 매개변수 대입 ]
			ps.setString( 1 , name );
			ps.setString( 2, phone );
			
			//4단계 : sql 조작 [sql 실행 ( select = executeQuery() , insert,update,delete = executeUpdate() ) ]
			
			//5단계 : sql 조작할 ResultSet 객체를 executeQuery 메소드로부터 반환 
			rs = ps.executeQuery();
			
			//6단계 : sql 결과 조작 
			// rs.next() : 검색된 레코드중 다음 레코드 이동 ]
			// rs.getString(검색필드순서번호) : 현재 위치한 레코드의 필드값 문자열 호출
			// rs.getInt(검색필드순서번호) : 현재 위치한 레코드의 필드값 정수 호출
			if(rs.next()) { return rs.getString(2); } // 검색된 레코드중 2번째 필드인 id 값을 반환
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
		
	}
			
	//5.
	public String findByPw( String id , String phone ) {
			
		try {
			
			String sql = "select mpassword from member where mid = ? and mphone =?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString( 1 , id );
			ps.setString( 2 , phone );
			
			rs = ps.executeQuery();
			
			if(rs.next()) { return rs.getString(1); }
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	//6. 회원번호를 가지고 있는 회원 정보 찾기 ... 회원번호가 존재하는 레코드 찾기
	public MemberDto info( int mno ) {
		
		try {
			//1. SQL 작성
			String sql = "select * from member where mno = ? ";
			ps = conn.prepareStatement(sql); // 2. SQL 조작할 객체
			ps.setInt(1 , mno); //3. SQL 조작
			rs = ps.executeQuery(); // sql  실행 // 5. sql 결과 조작 객체
			if(rs.next()) {// 6. sql 결과조작 //만약에 다음 레코드가 존재하면
				//*현재 레코드[ 1: 회원번호 2: 아이디 3: 비밀번호 4: 이름 5: 전화번호 ]
				MemberDto dto = new MemberDto(
										rs.getInt(1) , rs.getString(2) ,
										rs.getString(3) , rs.getString(4) ,
										rs.getString(5) );
				return dto;
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;	
			
	}
		
	//7.
	public boolean infoUpdate ( String newPw , int mno ) {
		
		try {
			String sql = "update member set mpassword = ? where mno = ? ";//1. sql 작성한다.
			ps = conn.prepareStatement(sql); //2. 작성한  SQL 조작할 객체
			ps.setString( 1 , newPw); 
			ps.setInt( 2 , mno); // SQL 조작
			int row = ps.executeUpdate(); // 4. SQL 실행 [ 업데이트한 레코드 개수 반환 ]
			
			if(row ==1 )return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//8.
	public boolean infoDelete ( int mno ) {
		
		try {
			
			String sql = "delete from member where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno);
			int row = ps.executeUpdate();
			if(row==1) {
				return true;
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}

