package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.LetterDto;

public class BoardDao extends Dao {
		
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getinstance() {
		return boardDao;
	}
	private BoardDao() {}
	
		//5. boardWrite : 게시물 쓰기 페이지
		public boolean boardWrite ( BoardDto boardDto ) {
			
			try {
				String sql = "insert into board( btitle , bcontent , mno ) values ( ? , ? , ? )";
				//2..
				ps = conn.prepareStatement(sql);
				//3.
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getMno());
				
				//4.
				int row = ps.executeUpdate();
				
				if(row == 1) {
					return true;
				}
		
			
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		
		//6. boardPrint : 모든 게시물 출력
		public ArrayList<BoardDto> boardPrint () {

			ArrayList<BoardDto> list = new ArrayList<>();// 여러개 BoardDto 를 저장할 리스트객체 선언
		
			try {
				
				//String sql = "select * from board order by bdate desc"; //1. 최신순 [desc 내림차순] 으로 모든 레코드 호출
				String sql = "select b.* , m.mid from member  m natural join board b order by b.bdate desc"; 
				
				ps = conn.prepareCall(sql); //2.,
				
				//3. SQL 에 ?(매개변수) 없으므로 set~~~ 생략
				
				rs = ps.executeQuery(); // 4, 검색 결과의 레코드를 여러개 조작하기 위해 resultSet 객체 반환
				//5. 여러개 레코드 조회 [ rs.next() : 다음 레코드 이동 : 존재하면 true / 존재하지 않으면 false ]
				while (rs.next()) { // 마지막 레코드까지 하나씩 레코드 이동 ( 다음 레코드가 존재하지 않을때 까지 반복 )
					//[ 레코드 개수만큼 반복 ]
					
					//레코드 1개 마다 1개의 DTO 변환
					BoardDto dto = new BoardDto(
							rs.getInt(1) , rs.getString(2) , rs.getString(3) ,
							rs.getString(4) , rs.getInt(5) , rs.getInt(6) , rs.getString(7) );

					// 변환된 Dto 를 리스트 객체에 담기
					list.add(dto);
					
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return list ;
		}
		
		//7. boardView : 개별 개시물 출력
		public BoardDto boardView ( int bno ) {
			try {
				
				String sql = "select b.* , m.mid from board b natural join member m where b.bno = ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , bno);
				rs = ps.executeQuery();
				if(rs.next()) {
					// 레코드 1개 --> Dto 변환
					BoardDto dto = new BoardDto(
							rs.getInt(1) , rs.getString(2) , rs.getString(3) ,
							rs.getString(4) , rs.getInt(5)+1 , rs.getInt(6) , rs.getString(7) );
					boardViewCount( rs.getInt(5) , bno );
					return dto;
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
		// 7-2 조회수증가 함수
		public void boardViewCount( int view , int bno ) { 
			
			try {
				String sql = "update board set bview = ? where bno = ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , view+1 );
				ps.setInt(2 , bno );
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			
		
		}
		//8. boardUpdate : 게시물 수정
		public boolean boardUpdate ( BoardDto boardDto ) {
			
			try {
				String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getBno());
				
				int row = ps.executeUpdate(); //select -> ps.ececuteQuery() / insert , update , delete -> int row = ps. excuteUpdate()
				if (row == 1) { return true; }
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return false;
		}
		
		//9. boardDelete : 게시물  삭제
		public boolean boardDelete ( int bno ) {
			
			try {
				String sql = "delete from board where bno  = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , bno);
				int row = ps.executeUpdate();
				
				if(row ==1 ) {return true;}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return false;
		}

		//10. 쪽지보내기
		public boolean letterWrite( LetterDto letterDto ) {
			
			try {
				
				String sql = "insert into letter ( lcontent , bno , givemno , savemno ) values ( ? , ? , ? , ? )";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, letterDto.getLcontent());
				ps.setInt(2, letterDto.getBno());
				ps.setInt(3, letterDto.getGivemno());
				ps.setInt(4 , letterDto.getSavemno());
				
				int row = ps.executeUpdate();
				
				if(row == 1 ) {
					return true;
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return false;
		}
		
		//11 쪽지 확인하기
		public void letterView() {}
}

/*
 	테이블
 		레코드 / 행 / 가로	-> DTO 1개
 		레코드 / 행 / 가로	-> DTO 1개	여러개 DTO 를 하나의 객체로 담기 => 리스트 혹은 배열
 		레코드 / 행 / 가로	-> DTO 1개
 	
 	예) 
 		로그인한 회원정보 조회 = DTO 
 		관리자가 모든 회원정보 조회 = ArrayList<DTO>
 		
 		개별 게시물 1개 출력 = DTO
 		모든 게시물 여러개 출력 = ArrayList<DTO> 
 	
 */
