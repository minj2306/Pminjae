package controller.hrm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<HrmDto> result = HrmDao.getinstance().Output();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
		
		MultipartRequest multi = new MultipartRequest(
											request, 
											uploadpath,
											1024*1024*10,
											"UTF-8" ,
											new DefaultFileRenamePolicy()
											);
		
		String hname = multi.getParameter("hname");
		String hphone = multi.getParameter("hphone");
		String hposition = multi.getParameter("hposition");
		String hrmimg = multi.getFilesystemName("hrmimg");
		
		if(hrmimg == null) { hrmimg = "default.webp"; }
		
		HrmDto hrmDto = new HrmDto( hname, hphone, hposition, hrmimg);
		
		boolean result = HrmDao.getinstance().registRation(hrmDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
