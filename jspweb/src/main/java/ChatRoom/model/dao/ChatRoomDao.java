package ChatRoom.model.dao;

import ChatRoom.model.dto.ChatRoomDto;

public class ChatRoomDao extends Dao {

	private static ChatRoomDao chatRoomDao = new ChatRoomDao();
	private ChatRoomDao() {}
	public static ChatRoomDao getinstance() {return chatRoomDao;}
	
	//채팅전송
	public boolean sendButton( ChatRoomDto chatRoomDto) {
		try {
			
			String sql = "input into ezenchat( chatid , ccontent ) valuse( ? , ? )";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,chatRoomDto.getChatid());
			ps.setString(2, chatRoomDto.getCcontent());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
