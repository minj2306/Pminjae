package controller.library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.libraryDao;
import model.dto.libraryDto;

/**
 * Servlet implementation class library
 */
@WebServlet("/library")
public class library extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public library() {
        super();
        // TODO Auto-generated constructor stub
    }

    //죄석 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<libraryDto> result = libraryDao.getinstance().outputbox();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		String sphone = request.getParameter("sphone");
		
		boolean result = libraryDao.getinstance().C(sno, sname, sphone);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
