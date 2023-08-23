package AccountBook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import AccountBook.model.Dao.AccountBookDao;
import AccountBook.model.Dto.AccountBookDto;

@WebServlet("/AccountBook")
public class AccountBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountBook() {
        super();
        // TODO Auto-generated constructor stub
    }
    //출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AccountBookDto> result = AccountBookDao.getincetance().Aread();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	//저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textAcc = request.getParameter("textAcc");
		int numberAcc = Integer.parseInt(request.getParameter("numberAcc"));
		String dateAcc = request.getParameter("dateAcc");
		
		AccountBookDto accountBookDto = new AccountBookDto(textAcc, numberAcc , dateAcc);
		
		boolean result = AccountBookDao.getincetance().inputAccunt(accountBookDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	//수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int select = Integer.parseInt(request.getParameter("select"));
		
		if(select==1) {
			int ano = Integer.parseInt(request.getParameter("ano"));
			String date = request.getParameter("date");
			
			boolean result = AccountBookDao.getincetance().datemodify(ano, date);
	
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(result);
		}
		else if(select==2) {
			int ano = Integer.parseInt(request.getParameter("ano"));
			String atext = request.getParameter("atext");
			
			boolean result = AccountBookDao.getincetance().atextmodify(ano, atext);

			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(result);
		}
		else if(select==3) {
			int ano = Integer.parseInt(request.getParameter("ano"));
			int anumber = Integer.parseInt(request.getParameter("anumber"));
			
			boolean result = AccountBookDao.getincetance().anumbermodify(ano, anumber);

			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(result);
		}
	}

	//삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		System.out.println(ano);
		
		int result = AccountBookDao.getincetance().Adelete(ano);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

}
