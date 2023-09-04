package controller.board;

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
    // type : 1. 전체 조회 , 2.개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		String type = request.getParameter("type");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		if( type.equals("1")) {//전체조회 로직
		
			ArrayList<BoardDto> result = BoardDao.getinstance().getList();
			System.out.println(result);
			
			json = objectMapper.writeValueAsString( result );
			
		}
		
		else if (type.equals("2")) {//개별조회 로직
			
			// 매개변수 요청
			int bno = Integer.parseInt( request.getParameter("bno"));
			// DAO 처리
			BoardDto result = BoardDao.getinstance().getBoard( bno );
			
			// 3. 만약에 (로그인 혹은 비로그인) 요청한 사람과 게시물 작성한 사람과 동일 하면
			Object object = request.getSession().getAttribute("loginDto");
			//로그인 정보[세션]
			if( object == null ) {//비로그인
				result.setIshost(false);
			}
			else {//로그인
				MemberDto login = (MemberDto)object;
				//내가쓴글
				if(login.getMno() == result.getMno()) {
					result.setIshost(true);
				}
				else { result.setIshost(false); }
			}
			json = objectMapper.writeValueAsString( result );
			
		}
		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json ); 
		
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
	//수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("put 컨트롤러 들어옴");
		//1. 수정할 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
											request,
											request.getServletContext().getRealPath("/board/upload") ,
											1024*1024*10 ,
											"UTF-8" ,
											new DefaultFileRenamePolicy()
											);
									
		//2. 수정할 데이터 요청
		int bcno = Integer.parseInt( multi.getParameter("bcno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getParameter("bfile");
		
		//2. * 수정할 게시물 식별키
		int bno = Integer.parseInt( multi.getParameter("bno"));
		BoardDto boardDto = new BoardDto(bno, btitle, bcontent, bfile, bcno);
			System.out.println("수정된 Dto : " + boardDto);
		
		//* 만약에 새로운 첨부파일이 없으면 기존 첨부파일 그대로 사용
		if( boardDto.getBfile() == null) {
			//기존 첨부파일
			boardDto.setBfile( BoardDao.getinstance().getBoard(bno).getBfile() );
		}
		
		//3. Dao
		boolean result = BoardDao.getinstance().onUpdate(boardDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}
	//삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		//2. Dao
		boolean result = BoardDao.getinstance().ondelete(bno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
