package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao {

	private static VisitDao visitDao = new VisitDao();
	private VisitDao() {}
	public static VisitDao getincetance() { return visitDao; }
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 DTO , 리턴 : 성공 / 실패 = true/false ]
	public boolean vwrite( VisitDto visitDto ) {
		// 0. try{} catch
		try {
			// 1. SQL 작성
			String sql = "insert into visitlog(vwriter , vpwd , vcontent) values( ? , ? , ? )";
			
			// 2. SQL 연결
			ps = conn.prepareStatement(sql);

			// 3. SQL 매개변수 대입
			ps.setString(1, visitDto.getVwriter());
			ps.setString(2, visitDto.getPwd());
			ps.setString(3, visitDto.getVcontent());
			// 4. SQL 실행
			ps.executeUpdate();
			// 5. 결과반환
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 2. 호출 [ 인수 : x , 리턴 : 여러개의 방문록 DTO ]
	public ArrayList<VisitDto> vread(){
		
		ArrayList<VisitDto> list = new ArrayList<>(); //여러개 dto를 담을 리스트 객체
		
		try {
			String sql = "select * from visitlog order by vdate desc";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while (rs.next()) { //rs.next() : select 검색 결과중 다음 레코드 이동 = 존재하면 true / 존재하지 않으면 false
				//*레고트/줄 하나/행 하나 / 방문록 하나 / DTO 하나
				//레코드 --> DTO 변환 ( 레코드마다 각 필드 호출 = rs.get타입( 필드순서번호 ) vs rs.get타입( "필드명" )
				VisitDto visitDto = new VisitDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3) ,
						rs.getString(4) , rs.getString(5)
						);
				list.add(visitDto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	// 3. 수정 [ 인수 : 수정할 방문록 번호 / 수정할 방문록 내용 , 리턴 : 성공/실패 = true/false ]
	public boolean vupdate( int vno , String vcontent ) {
		return false;
	}
	
	// 4. 삭제 [ 인수 : 삭제할 방문록 번호(int) , 리턴 : 성공/실패 = true/false ]
	public boolean vdelete( int vno ) {
		return false;
	}

}
