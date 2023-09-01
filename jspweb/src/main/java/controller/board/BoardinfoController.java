package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

@WebServlet("/BoardinfoController")
public class BoardinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardinfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		// 2. 유효성검사 / 객체화
		// 3. DAO 
		ArrayList<BoardDto> result = BoardDao.getinstance().getList();
		System.out.println(result);
		
		// 4. 응답
		
		
	}
	// 2. 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 첨부파일 업로드 [ cos.jar -> MultipartRequest 클래스 ]
		MultipartRequest multi = new MultipartRequest(
										request,
										request.getServletContext().getRealPath("/board/upload") ,	//저장경로
										1024*1024*10 , 	// 업로드 허용용량 [바이트] 10MB
										"UTF-8" ,		//인코딩타입
										new DefaultFileRenamePolicy()
										);
		// * 업로드가 잘 되었는지 확인하기 위한 서버경로 확인
		System.out.println( request.getServletContext().getRealPath("/board/upload") );
		
		// 1.(입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile"); //첨부파일명은 getFileststemName()
		
			//작성자(mno) 는 입력x /mno는 세션에 저장되어있는 상태
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		System.out.println("mno는 "+mno);
		int bcno = Integer.parseInt(multi.getParameter("bcno") );
		
		// 2. 유효성검사/객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent , bfile , mno ,bcno);
		System.out.println( boardDto );
		// 3. Dao 처리
		boolean result = BoardDao.getinstance().bwrite(boardDto);
		// 4. (Dao 결과) 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
