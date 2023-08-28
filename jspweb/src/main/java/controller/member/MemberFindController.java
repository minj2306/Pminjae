package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //하나의 메소드의 여러개 ajax 통신할때 type 전송 ( 1: 아이디 중복검사 , 2 : 이메일 중복검사 vs 필드명 : mid :아이디 중복검사 , memail)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 요청한다.
		String type = request.getParameter("type");
		
		String data = request.getParameter("data");
		
		boolean result = MemberDao.getinstance().findIdOrEmail( type , data);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
