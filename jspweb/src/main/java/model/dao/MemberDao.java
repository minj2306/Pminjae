package model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.MemberDto;
import model.dto.MpointDto;

public class MemberDao extends Dao {

	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getinstance() { return memberDao; }
	
	//1.회원가입 
	public boolean signup( MemberDto memberDto ) {
		
		
		try {
			
			String sql = "insert into member( mid , mpwd , memail , mimg ) values( ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMemail());
			ps.setString(4, memberDto.getMimg());
			
			int row = ps.executeUpdate();
			
			if(row==1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}
	
	
	//2. 로그인
	public boolean login ( String mid , String mpwd ) {
		
		try {
			String sql = "select * from member where mid = ? and mpwd = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if(rs.next()) { return true; }
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	//3. 아이디찾기
	
	//4, 비밀번호 찾기
	
	//5. 내정보 호출
	public MemberDto info (String mid) {
		
		try {
			
			String sql = "select mno ,mid , memail , mimg from member where mid = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				MemberDto memberDto = new MemberDto(
						LocalDateTime.now().toString() , // 현재 날짜 시간 문자열 반환함수
						rs.getInt(1) , rs.getString(2) ,
						rs.getString(3) , rs.getString(4));
			return memberDto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	//6. 아이디 중복검사 [ 인수 : 검사할 아이디 / 반환 ]
	//type : 필드명 / data : 필드에서 찾을 값
	public boolean findIdOrEmail( String type , String data ){
		
		try {
			
			String sql ="select mid from member where "+type+" = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			
			rs = ps.executeQuery();
			// while : 결과 레코드 여러개 검사 vs if : 결과 레코드 한개 검사
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	//7. 회원수정
	public boolean mupdate(int mno , String mimg) {
		
		try {
			
			String sql = "update member set mimg = ? where mno = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mimg);
			ps.setInt(2, mno);
			
			int count = ps.executeUpdate();
			
			if(count==1) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//7-1 비밀번호도 수정
	public boolean mallupdate(int mno , String mimg , String mpwd , String newpwd) {
		
		try {
			
			String sql = "update member set mpwd = ? , mimg = ? where mno = ? and mpwd = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newpwd);
			ps.setString(2, mimg);
			ps.setInt(3, mno); 
			ps.setString(4, mpwd);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	 
	//8. 회원탈퇴 [ 삭제할 회원번호 , 검증할 패스워드 ]
	public boolean mdelete(int mno , String mpwd) {
		
		try {
			String sql = "delete from member where mno = ? and mpwd = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			
			int count = ps.executeUpdate();
			if(count ==1 ){
				return true; 
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false; // 회원번호 또는 입력받은 패스워드 일치x
	}
	
	// 포인트 지급 / 사용에 대한 함수
	public boolean setPoint( MpointDto dto ) {
		
		try {
			
			String sql = "insert into mpoint ( mpno , mno , mpamount , mpcomment ) "
							+"values ( ? , ? , ? , ? )";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getMpno());
			ps.setInt(2, dto.getMno());
			ps.setLong(3, dto.getMpamount());
			ps.setString(4, dto.getMpcomment());
			
			int count = ps.executeUpdate();
			
			if( count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("setPoint : " + e);
		}
		
		return false;
	}
	
	
	// 내 포인트 확인 [ 로그인한 사람의 현재 포인트 합계 ]
	public long getPoint( int mno ) {
		
		try {
								// sum( 필드명 ) : 총 합계를 계산할 필드명 인수로 대입 //avg // count
			String sql = "select sum( mpamount ) from mpoint where mno = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mno);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				
				return rs.getLong(1);
				
			}
			
		} catch (Exception e) {
			System.out.println( "getPoint : " + e);
		}
		return 0;
	}
	
	
	// 내 포인트 사용 내역 출력하는 함수
	public List<MpointDto> getPointList( int mno ){
		
		List<MpointDto> list = new ArrayList<>();
		
		try {
			
			String sql = "select * from mpoint where mno = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mno);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				MpointDto dto = new MpointDto(
											  rs.getString(1), rs.getInt(2),
											  rs.getLong(3), rs.getString(4),
											  rs.getString(5)
											  );
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getPointList : "+e);
		}
		
		return list;
	}
	
	/*
	 	JDBC : JAVA 와 DB 간의 연동 라이브러리
	 		
	 		Connection 
			PreparedStatement
			ResultSet 
			- DriverManager.getConnection( 연동할 DB 주소 )
	 	
	 	1. 연동
	 	--------------------------------------------------
	 					스트림[데이터 다니는 통로]
	 	--------------------------------------------------
	 */
	
}
