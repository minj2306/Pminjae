package ChatRoom.model.dao;

import java.util.ArrayList;

import ChatRoom.model.dto.ChatRoomDto;

public class ChatRoomDao extends Dao {

	private static ChatRoomDao chatRoomDao = new ChatRoomDao();
	private ChatRoomDao() {}
	public static ChatRoomDao getinstance() {return chatRoomDao;}
	
	//채팅전송
	public boolean sendButton( ChatRoomDto chatRoomDto) {
		try {
			
			String sql = "insert into ezenchat( chatid , ccontent ) values( ? , ? )";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,chatRoomDto.getChatid());
			ps.setString(2, chatRoomDto.getCcontent());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}//sendButton end
	
	//채팅 출력
	public ArrayList<ChatRoomDto> readChat(){
			ArrayList<ChatRoomDto> list = new ArrayList<>();
			
		try {
			String sql = "select chatid , ccontent , ctime from ezenchat "
						+"order by ctime asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				ChatRoomDto chatRoomDto = new ChatRoomDto(
						rs.getString(1) , rs.getString(2) , rs.getString(3)
						);
				list.add(chatRoomDto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
