package controller.library;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.libraryDao;
import model.dto.libraryDto;

/**
 * Servlet implementation class libraryy
 */
@WebServlet("/libraryy")
public class libraryy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public libraryy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      System.out.println(" 퇴실하기 로직 도착 ");
	      // 요청
	      int sno = Integer.parseInt(request.getParameter("sno"));
	      System.out.println(sno);
	      String sname = request.getParameter("sname");
	      System.out.println(sname);
	      String sphone = request.getParameter("sphone");
	      System.out.println(sphone);
	      
	      // DAO에게 전달 및 반환 값 받기
	      libraryDto dto = new libraryDto( sno , sname , sphone );
	      System.out.println(dto);
	      boolean r = libraryDao.getinstance().Dsql(dto);
	      System.out.println(r);
	      // 응답
	      response.setContentType("application/json;charset=UTF-8");
	      response.getWriter().print(r);

		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
