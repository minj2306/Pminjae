package ChatRoom.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ChatRoom.model.dao.ChatRoomDao;
import ChatRoom.model.dto.ChatRoomDto;


@WebServlet("/ChatRoomController")
public class ChatRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChatRoomController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //채팅 출력하기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ChatRoomDto> result = ChatRoomDao.getinstance().readChat();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	//채팅보내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chatid = request.getParameter("loginNum");
		String ccontent = request.getParameter("chatingInput");
		
		ChatRoomDto chatRoomDto = new ChatRoomDto(chatid, ccontent);
		
		boolean result = ChatRoomDao.getinstance().sendButton(chatRoomDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
