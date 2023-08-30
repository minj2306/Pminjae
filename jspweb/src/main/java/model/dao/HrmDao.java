package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao{

	private static HrmDao hrmDao = new HrmDao();
	private HrmDao () {}
	public static HrmDao getinstance() { return hrmDao;}
	
	public boolean registRation( HrmDto hrmDto ) {
		
		try {
			
			String sql = "insert into hrm (hname , hphone , hposition , hrmimg ) values( ? , ? , ? , ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, hrmDto.getHname());
			ps.setString(2, hrmDto.getHphone());
			ps.setString(3, hrmDto.getHposition());
			ps.setString(4, hrmDto.getHimg());
			
			int row = ps.executeUpdate();
			
			if(row == 1) { return true; }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	public ArrayList<HrmDto> Output(){
		
		ArrayList<HrmDto> list = new ArrayList<>();
		
		try {
			
			String sql = "select * from hrm";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HrmDto hrmDto = new HrmDto(
						rs.getInt(1) , rs.getString(2) ,
						rs.getString(3) , rs.getString(4) ,
						rs.getString(5) , rs.getString(6) 
						);
				list.add(hrmDto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
