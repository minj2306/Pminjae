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
import model.dto.PageDto;
import service.FileService;

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
			
			//--------------------------7. 검색처리 ------------------------
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			
			//--------------------------1. 카테고리 ----------------------------
			int bcno = Integer.parseInt( request.getParameter("bcno") );
			
			//--------------------------2. 출력할 게시물 수/하나의 페이지의 최대 게시물 수 ---------
			int listsize = Integer.parseInt( request.getParameter("listsize") );
			
			//--------------------------3. 페이징 처리하기---------
			int page = Integer.parseInt( request.getParameter("page") );
				//1. 페이지별 레코드의 시작번호
			int startrow = (page-1) * listsize; //페이지번호 * 최대 게시물수
			
			//--------------------------4. 마지막 페이지 번호---------
				//1. 마지막 페이지 번호 = 총페이지수 = 전체게시물 수 / 페이지별 최대 게시물 수( listsize )
				//2. 전체 게시물수
			int totalsize = BoardDao.getinstance().getTotalsize( bcno , key , keyword);
				//3. 마지막 페이지 번호 
			int totalpage = totalsize%listsize == 0 ? //만약에 나머지가 없으면
								totalsize/listsize :	//몫
									totalsize/listsize+1; //몫 + 1
					// 게시물수 : 10 , 페이지별 2개씩 출력 = > 총 페이지수 5 [몫]
					// 게시물수 : 20 , 페이지별 3개씩 출력 = > 총 페이지수 6 [몫] + 1 (나머지 페이지 수를 표시할 페이지 1개 추가)
			
			ArrayList<BoardDto> result = BoardDao.getinstance().getList( bcno , listsize , startrow , key , keyword );
			System.out.println(result);
			
			//--------------------------5. 페이지 번호 버튼 , 시작번호 , 마지막번호---------
				//5개씩	: 1-5페이지( 1, 5 ) , 6-10페이지( 6 , 10 ) , 11-15( 11 , 15 )
				//10개씩	: 1-10페이지( 1 , 10 ) , 11-20( 11 , 20 ) , 21-30( 21 , 30 )
				//15개씩	: 1-15페이지( 1 , 15 ) , 16-30( 16 , 30 ) , 31-45( 31 , 45 )
			
				// 1. 페이지버튼 번호의 최대 개수
			int btnsize = 5;
				// 2. 페이지버튼 번호의 시작번호
			int startbtn = ( (page-1)/btnsize )* btnsize + 1; System.out.println( "startbtn : "+ startbtn ); 
				
				// 3. 페이지 버튼 번호의 마지막번호
			int endbtn = startbtn+( btnsize - 1 );
				// * 단 마지막 번호는 총 페이지수보다 커질수 없음
				// 만약에 마지막 번호가 총 페이지수보다 크면 총 페이지 수로 제한 두기
			if( endbtn >= totalpage ) { endbtn = totalpage; }
			//--------------------------6. pageDto 구성---------
			
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpage , startbtn , endbtn , result);
			
			json = objectMapper.writeValueAsString( pageDto );
			
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
		}else { // 만약에 수정할 첨부파일 있으면 기존 첨부파일은 서버 업로드 폴더에서 삭제
			
			String filename = BoardDao.getinstance().getBoard(bno).getBfile();
			filename = request.getServletContext().getRealPath("board/upload")+ "/"+filename;
			FileService.fileDelete(filename);
			
			
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
		
		// 레코드 삭제 전에 파일 이름 꺼내두기 [ 삭제후 파일 이름 호출이 불가능 하니까 ]
		String filename = BoardDao.getinstance().getBoard(bno).getBfile();

		//2. Dao
		boolean result = BoardDao.getinstance().ondelete(bno);
		
			// 만약에 게시물 삭제가 성공되면.. 서버의 업로드된 파일도 같이 삭제
			if( result ) {//만약에 게시물 삭제 성공이면
				filename = request.getServletContext().getRealPath("/board/upload")+ "/" + filename;
				FileService.fileDelete(filename);
			}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}
	
}
