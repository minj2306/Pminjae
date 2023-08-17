package jspweb.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test02") // @ : 어노테이션 // 해당클래스의 URL 매핑 연결해주는 어노테이션
public class Test02 extends HttpServlet { 
//HttpServlet 클래스로부터 상속 받으면 해당 웹 관련 기능 제공 [1.멀티스레드 2.예외처리 3. HTTP get , post , put , delete ]
	
	//HTTP : HyperText Transfer Protocol : 문서 교환 규칙/약속/규약/방법
		//HTTP 메소드 : get : 호출 / post : 저장 / put : 수정 / delete : 삭제
		//HTTP Body : 
	//브라우저[크롬 , 엣지 등] 에서 주소 입력해서 웹 사이트 접속하는 방식
		//주소창 www.naver.com =>get 방식
	
	private static final long serialVersionUID = 1L;

    public Test02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 콘솔출력
		System.out.println("Test Hello JS");
		//2. 웹출력
		response.getWriter().print("Test Hello JS");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
