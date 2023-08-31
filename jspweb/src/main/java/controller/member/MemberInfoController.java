package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	//1.[C] (첨부파일 있을때 form)회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//첨부파일 저장할 폴더의 절대 경로
	
		// 1. 개발자 pc 경로 업로드 [문제 발생 : 개발자 pc 에 업로드 하면 업로드 파일을 서버로 빌드]
		//String uploadpath = "C:\\Users\\504\\git\\Pminjae\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
		
		// 2. 서버 pc 경로 업로드 [ 사용자는 바로 서버pc 업로드 ]
		//String uploadpath = "C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"; // 첨부파일 저장할 경로
		
		//3. 서버 pc 경로 (상대경로 = 서버경로 찾아주는 함수)
			// 서버에 build(배포) 된 파일/폴더 의 경로 찾기
			//request.getSession().getServletContext().getRealPath("프로젝트명 이하 경로");
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
		System.out.println("member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath);
		//C:\Users\504\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jspweb\member\img
		
		
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
	
		if(mimg==null) { mimg = "default.webp"; }
		
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

	
    // 2. 회원정보 호출 // 로그아웃(세션초기화) 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 요청한다. [x]
		String type = request.getParameter("type");
			//* 만약에 type이 info이면
		if(type.equals("info")) {
		
			// *세션에 저장된 로그인 객체를 꺼내기
					//1. 세션 호출한다. [세션타입은 Object]
			Object session = request.getSession().getAttribute("loginDto"); 	
					//2. 타입변환한다. [ 부 -> 자 (캐스팅/강제타입변환) ]
			MemberDto loginDto = (MemberDto)session;
					// - DTO는 JS가 이해할수 없는 언어 이므로 JS 가 이해할수 있게 JS 언어로 변환 [ jackson 라이브러리 ]
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
			
			//4. 응답한다.
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print( json );
		}
		else if(type.equals("logout")) {
			//*세션에 저장된 로그인 객체를 없애기/초기화/지우기/삭제 
			// 방법 1 : (세션의 모든 속성) 초기화하는 함수
			// request.getSession().invalidate(); //로그인 정보 뿐만 아니라 모두 삭제
			
			// 방법 2 : (세션의 특정 속성) JVM GC(쓰레기 수집기 = 해당 객체를 아무도 참조하고 있지 않으면 삭제)
				//삭제할 세션 속성명과 동일하게 null대입
			request.getSession().setAttribute("loginDto", null);
		}
		//2. 유효성/객체화 [x]
		//3. Dao 처리[x]

	
	}
	//3. 회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//multipart/form-data 전송요청 // cos.jar[MultipartRequest클래스]
		
		MultipartRequest multi = new MultipartRequest(
											request,
											request.getServletContext().getRealPath("/member/img") ,
											1024*1024*10 ,
											"UTF-8" ,
											new DefaultFileRenamePolicy()
											);
		//--------------------DB 업데이트----------------------------------
		//*form 전송일때는 input의 데이터 호출시
			// 일반 input : multi.getParameter("input name")
			// 첨부 input : multi.getFileststemName("input name 속성명")
		String mimg = multi.getFilesystemName("mimg");
		String mpwd = multi.getParameter("mpwd");
		String newpwd = multi.getParameter("newpwd");
		
		//Dao[ 로그인된 회원번호 , 수정할 값 ]
		Object object = request.getSession().getAttribute("loginDto");
		MemberDto memberDto = (MemberDto)object;
		int loginMno = memberDto.getMno();
		
		//만약에 수정할 첨부파일 이미지 없으면
		if(mimg == null) {
			mimg = memberDto.getMimg(); // 세션에 있던 이미지 그대로 대입
		}
		if(mpwd.length()<5 || newpwd.length()<5) {
		boolean result = MemberDao.getinstance().mupdate(loginMno, mimg);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		}
		else {
			boolean result = MemberDao.getinstance().mallupdate(loginMno, mimg , mpwd , newpwd);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
		}
	}

	//4. 회원삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청한다
		String mpwd = request.getParameter("mpwd"); System.out.println(mpwd);
		//2. 유효성검사/객체화
		//3. DAO 처리 [ 현재 로그인된 회원번호 pk , 입력받은 패스워드[mpwd]
			//1. 현재 로그인된 회원정보 => 세션
				//int loginMno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
			Object object = request.getSession().getAttribute("loginDto");
			MemberDto memberDto = (MemberDto)object; //타입변환한다.
			
			int loginMno = memberDto.getMno(); // 3. 로그인 객체에 회원번호만 호출한다.
			System.out.println(loginMno);
			//2. Dao 전달
			boolean result = MemberDao.getinstance().mdelete(loginMno, mpwd);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result); // 응답한다.
			
		//4. 응답한다.
	}

}

/*
 	용량단위
 	
 		bit : 0 or 1
 		byte : 01010101
 		kb : 1024byte
 */
