package controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownLoad
 */
@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ----------------------------------1. 다운로드 할 파일 경로 찾기------------------
			// 1. 다운로드 할 파일명 요청
		String filename = request.getParameter("filename");
			// 2. 첨부파일 폴더의 경로
		String uploadpath = request.getServletContext().getRealPath("/board/upload");
			// 3. 다운로드 할 파일의 전체 경로
		String filepath = uploadpath+"/"+filename;
		
		// ----------------------------------2. 응답 : 다운로드 시 옵션 ------------------
		response.setHeader(// Header = HTTP 응답 옵션
						"Content-Disposition" ,
						"attachment;filename="+URLEncoder.encode( filename , "UTF-8") // 다운로드시 다운로드 파일명 옵션 추가 [ 서블릿 이용 ]
						);
						//URLEncoder 클래스 : import java.net.URLEncoder;
							//.encode( 텍스트 , "인코딩타입" ) // URL(HTTP주소)의 한글 깨짐 방지 [ 한글 지원 ]
		
		// ----------------------------------3. 파일 내보내기------------------
		// 1. 파일 객체 [ 해당 경로의 파일을 객체화 했을떄 다양한 메소드 제공 .length() ]
		File file = new File(filepath); //해당 경로의 파일 객체화
		// 2. 파일 입력 스트림 객체 [ 파일 바이트로 읽어오기 ]
			//1. 입력객체
		FileInputStream fin = new FileInputStream(file);
			//2. 읽어온 바이트를 저장할 배열 선언
		byte[] bytes = new byte[(int)file.length()];
			//3. 바이트를 읽어서 배열에 저장하기
		fin.read(bytes);
		
		//3. 파일 출력 스트림 객체
			//1. 파일 출력 스트림 객체 [ 출력할 위치가 response ]
		BufferedOutputStream oin = new BufferedOutputStream( response.getOutputStream() );
			//2. 파일 내보내기
		oin.write(bytes);
		
		//4. 대용량 전송시 안전하게 스트림(바이트 이동 통로) 닫기
		fin.close(); oin.flush(); oin.close();
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}//class end

/*
  	Stream : 바이트(데이터) 단위 이동하는 통로
  	
  	
  	JAVA	----> 외부파일(프로젝트 밖 경로)/ 네트워크 /키보드 등등 에서 스트림 사용
 
 	크롬(브라우저/유저)								톰캣(서버)							업로드폴더( 서버PC )
 			/jspweb/FileFownLoad?filename=사진명.jsp
 					--------request-------->
 											1. filename 요청
 											2. filename 파일을 업로드 폴더 경로 찾기		wtpwebapps/jspweb/board/upload
 											3. 다운로드 파일의 바이트 읽어오기
 																	<-----FileInputStream------
 																		.read()
 											4. 읽어온 바이트를 byte[] bytes 배열에 저장
 											
 											5. 읽어온 바이트들을 byte 배열에 요청한
 					<-------response-------
 						response.getOutputStream()
 							.write( bytes )
	-------------------------------------------------------------------
	
	다운로드 게이지 => 바이트가 스트림을 통해 들어오는 중 
 */
