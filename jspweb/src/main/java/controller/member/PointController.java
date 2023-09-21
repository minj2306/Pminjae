package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PointController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");

		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();

		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		
		if(type.equals("getPoint")) {
			
			long result = MemberDao.getinstance().getPoint(mno);
		
			json = mapper.writeValueAsString(result);
			
		}
		else if(type.equals("getPointList")) {
		
			List<MpointDto> result = MemberDao.getinstance().getPointList(mno);
		
			json = mapper.writeValueAsString(result);
			
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. UUID 만들어서 포인트 내역 식별자로 사용
		String mpno = UUID.randomUUID().toString(); // 포인트내역 식별번호 구성 [ UUID ]
			// UUID.randomUUID() : (s) UUID 고유성을 보장하는 ID [식별자] 만들기 위한 표준 규약
			System.out.println( mpno );
		
		// 2. 로그인된 [ 세션에 저장된 ] 회원정보에서 회원번호만 출력
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		
		// 3. 포인트 수량 / 지급 내역은 JS에서 전달받음
		long mpamount = Long.parseLong( request.getParameter("mpamount") );
		
		String mpcomment = request.getParameter("mpcomment");
		
		MpointDto mpointDto = new MpointDto(mpno , mno , mpamount , mpcomment , null);
		
		boolean result = MemberDao.getinstance().setPoint( mpointDto );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
