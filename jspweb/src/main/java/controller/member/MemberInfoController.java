package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoController() {
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
	//1.[C] (첨부파일 있을때 form)회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//첨부파일 저장할 폴더의 절대 경로
		String uploadpath = "C:\\Users\\504\\git\\Pminjae\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
	
		//첨부파일 전송했을떄
			//1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 ) 
				//MultipartRequest : 파일 업로드 클래스
			MultipartRequest multi = new MultipartRequest(
					request, 			//1. 요청방식
					uploadpath , 		//2. 첨부파일을 저장할 폴더 경로
					1024*1024*10 ,		//3. 첨부파일 용량 허용범위 [바이트단위] 10MB
					"UTF-8" ,			//4. 한글 인코딩 타입
					new DefaultFileRenamePolicy() //5.[파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기
					); 
			//2. form 안에 있는 각 데이터 호출
			
		//일반 input : multi.getParameter("form 객체전송시 input name")
		//첨부파일 input : multi.getFilesystemName()
		String mid = multi.getParameter("mid"); 		System.out.println(mid);
		String mpwd = multi.getParameter("mpwd");		System.out.println(mpwd);
		String memail = multi.getParameter("memail");	System.out.println(memail);
		//String mimg = multi.getParameter("mimg");		System.out.println(mimg);
		String mimg = multi.getFilesystemName("mimg");	System.out.println(mimg);
		//2. (선택) 객체화
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
		
		//3. Dao 에게 전달하고 결과 받는다
		boolean result = MemberDao.getinstance().signup(memberDto);
		
		//4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [response]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	/*
	 * //1.[C] (첨부파일 없을때)회원가입 protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { //1.
	 * AJAX 통신받은 data 요청한다. [request]
	 * 
	 * String mid = request.getParameter("mid"); System.out.println(mid); String
	 * mpwd = request.getParameter("mpwd"); System.out.println(mpwd); String memail
	 * = request.getParameter("memail"); System.out.println(memail); String mimg =
	 * request.getParameter("mimg"); System.out.println(mimg);
	 * 
	 * //2. (선택) 객체화 MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
	 * 
	 * //3. Dao 에게 전달하고 결과 받는다 boolean result =
	 * MemberDao.getinstance().signup(memberDto);
	 * 
	 * //4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [response]
	 * response.setContentType("application/json;charset=UTF-8");
	 * response.getWriter().print(result); }
	 */

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

/*
 	용량단위
 	
 		bit : 0 or 1
 		byte : 01010101
 		kb : 1024byte
 */
