package AccountBook.model.Dao;

import java.util.ArrayList;

import AccountBook.model.Dto.AccountBookDto;

public class AccountBookDao extends Dao {
	
	private static AccountBookDao accountBookDao = new AccountBookDao();
	private AccountBookDao() {}
	public static AccountBookDao getincetance() { return accountBookDao; }
	
	public boolean inputAccunt(AccountBookDto accountBookDto) {
		try {
			String sql = "insert into accountbook( atext , anumber , adate ) values( ? , ? , ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountBookDto.getAtext());
			ps.setInt(2, accountBookDto.getAnumber());
			ps.setString(3, accountBookDto.getDate());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public ArrayList<AccountBookDto> Aread(){
			
		ArrayList<AccountBookDto> list = new ArrayList<>();
		
		try {
			String sql = "select * from accountbook order by adate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				AccountBookDto dto = new AccountBookDto(
						rs.getInt(1) , rs.getString(2) ,
						rs.getInt(3) , rs.getString(4)
						);
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	//날짜수정
	public boolean datemodify( int ano , String date) {
		try {
			String sql = "update accountbook set adate = ? where ano = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, date);
			ps.setInt(2, ano);
			
			int row = ps.executeUpdate();
			if(row == 1) { return true;  }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}
	//항목수정
	public boolean atextmodify( int ano , String atext ) {
	
		try {
			String sql = "update accountbook set atext = ? where ano = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, atext);
			ps.setInt(2, ano);
			
			int row = ps.executeUpdate();
			
			if(row == 1) { return true;  }
		
		} catch (Exception e) {
			System.out.println(e);
		}
	return false;
	
	}	
	//금액수정
	public boolean anumbermodify( int ano , int anumber  ) {
		
		try {
			String sql = "update accountbook set anumber = ? where ano = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, anumber);
			ps.setInt(2, ano);
			
			int row = ps.executeUpdate();
		
			if(row == 1) { return true;  }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}
	


	public int Adelete( int ano ) {
		
		try {
			
			String sql = "delete from accountbook where ano = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			
			int row = ps.executeUpdate();
			
			if(row==1) {
				
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 2;
	}

}//class end
