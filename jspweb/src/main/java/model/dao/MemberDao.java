package model.dao;

import model.dto.MemberDto;

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
	
	//8. 회원탈퇴
	
}
