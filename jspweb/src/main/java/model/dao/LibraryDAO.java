package model.dao;

import java.util.ArrayList;

import model.dto.LibraryDTO;

public class LibraryDAO extends Dao{

	private static LibraryDAO libraryDao = new LibraryDAO();
	private LibraryDAO() {}
	public static LibraryDAO getinstance() { return libraryDao; }
	//출력하기
	public ArrayList<LibraryDTO> outputbox(){
		
		ArrayList<LibraryDTO> list = new ArrayList<>();
		
		try {
			
			String sql = "select sno , sname , sphone , "
						+"case when sstatus = 0 then '사용가능' when sstatus = 1 then '입실중' end sstatus " 
						+"from slibrary";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				LibraryDTO libraryDto = new LibraryDTO(
						rs.getInt(1) , rs.getString(2) ,
						rs.getString(3) ,rs.getString(4)
						
						);
				list.add(libraryDto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}//
	//입실하기
	public boolean C( int sno , String sname , String sphone ) {
		
		try {
			String sql = "update slibrary set sname = ? , sphone = ? , sstatus = 1 where sno = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, sname);
			ps.setString(2, sphone);
			ps.setInt(3, sno);
			
			int row = ps.executeUpdate();
			if ( row == 1 ) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	   // 퇴실하기 ------------------------------------------------
	   public boolean Dsql( LibraryDTO dto) {
	      System.out.println(" 퇴실하기 SQL 도착 ");
	      try {
	         String sql = "update slibrary set sname = 'none', sphone = 'none', sstatus = 0 where sno = ?";
	         ps = conn.prepareStatement(sql);
	         ps.setInt( 1 , dto.getSno()); 
	         int row = ps.executeUpdate();
	         System.out.println("row : "+row); // 이게 지금 안찍힘
	         if( row == 1 ) { return true ;}
	      } catch (Exception e) { System.out.println(e); }
	      return false; 
	   }
	
}//class end
