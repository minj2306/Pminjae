package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


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

		//1. 매개변수 요청
		
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		//2. (객체화//유효성검사)
		//3. DAO 에게 전달후 결과 받기
		boolean result = MemberDao.getinstance().login(mid, mpwd);
		
		// - 만약에 로그인 성공하면 세션에 로그인한 정보를 담기..
		if(result==true) {
			//1. 세션에 저장할 데이터를 만든다.
			MemberDto loginDto = MemberDao.getinstance().info(mid);
			//2. 세션에 저장한다.
			request.getSession().setAttribute("loginDto", loginDto);
			//* 세션상태 왁인
			MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
			System.out.println(dto);
		}
		
		//4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}

/*
 	-저장소
 		1. JAVA/JS 메모리
 			- JAVA 종료되거나 JS 종료/페이지전환/새로고침 되면 휘발성/초기화/사라짐
 			- DTO 이동객체 , 로직 필요한 변수들 ( 생성조건에 따라 사용 범위가 다름 )
 			
 			세션( static ) 
 				- 장점 : 모든곳에서 동일한 메모리 (동일한 주소값) 사용
 				- 단점 : 프로그램/서버 가 종료될때 까지 유지(메모리)

 				- 로그인 정보 : 페이지전환 되더라도 로그인상태 유지
 				
 		2. DB메모리
 			- 영구저장 [ 논리구조(관계현/표)저장 ]
 			- 회원정보 , 게시판정보 , 제품정보 , 등등
 			- 실제 데이터
 			
 		3. 파일
 			-영구저장 [ 문자열 저장 ]
 			- 로그/기록(예외처리 오류정보 , 접속수 , 최상위 보안자료 )
 		4. 세션
 	
 	로그인 했다는 증거 => 인증 [ 인증서 -> 세션 저장 ]
 		
 		-세션 : 미리 만들어진 전역메모리/변수
 	
 		JS : sessionStorage : 모든 JS에서 사용 가능한 메모리 공간 [ 문자열 타입 ]
 			세션타입 : 문자열타입 (타입변환 필수)
 			세션저장 : sessionStorage.setItem(키,데이터);
 			세션호출 : sessionStorage.getIten(키);
 			
 		JAVA(서블릿) : request.getSession() : 모든 서블릿에서 사용 가능한 메모리공간
 			세션저장 : request.getSession().setAttribute("속성명" , 데이터);
 			세션호출 : request.getSession().getAttribute("속성명");
 	서블릿클래스
 		내장객체
 			request : 요청객체
 				request.getParameter() : ajax으로부터 전달된 데이터 요청
 				request.getServletContext().getRealPath() : 서블릿 저장소의 실제(c:) 결로 탐색
 				request.getSession() : 서버내 세션객체 호출
 				
 			response : 응답객체
 				response.getWriter().print() : ajax에게 전달할 데이터 응답
 				[ 데이터 타입설정 ]
 				response.setContentType("application/json;charset=UTF-8");
 				
 */
