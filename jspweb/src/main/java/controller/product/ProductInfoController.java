package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.XMLObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 1. 제품등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//* commons.jar 이용한 업로드 구현
		// commons.io.jar , commons-fileupload.jar 별도 필요!!!!
		
		// 1. 저장경로 [ 첨부파일이 저장될 폴더 위치 ]
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		// 2. 파일 아이템 저장소 객체 : 업로드 할 옵션 [ import org.apache.commons.fileupload.FileItem; ]
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository( new File( uploadPath ) ); // 2.저장위치 [ File 타입 ]
		itemFactory.setSizeThreshold(1024 * 1024 * 1024);	// 3.용량
		itemFactory.setDefaultCharset("UTF-8"); // 4.한글 인코딩
		
		// 3. 파일 업로드 객체 [ import org.apache.commons.fileupload.servlet.ServletFileUpload; ]
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		
		// 4. 파일업로드 요청 [ 요청방식 : request ]
		try {
			Map<Integer, String> imgList = new HashMap<>(); // 업로드된 파일명 들을 저장하기 위한 map 컬렉션
			
										//form 전송시 input/select/textarea 태그 모든 데이터 한번에 요청해서 결과를 List 반환
			List<FileItem> fileList = fileUpload.parseRequest(request);
				//FileItem : 각 요청한 데이터
			
			//업로드 실행
			int i = 0;
			for( FileItem item : fileList) { // 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기
				// 1. 일반필드 [ isFormField() : 만약에 일반 폼 필드이면 true / 아니고 첨부파일 필드이면 false ]
				if( item.isFormField()) {
					System.out.println( item.getString() ); // .getString() : 해당 요청 input의 value 호출
				}
				else{// 2. file 필드 
					
					// 만약에 파일 필드이면 업로드 진행
					System.out.println("업로드 할 파일명 : " + item.getName() ); // .getName() 
					
					// 6. 업로드 경로 + 파일명 [ 조합 ]
					
						//파일명에 중복이 있을때 식별 생성
						UUID uuid = UUID.randomUUID();
							// UUID 클래스 : 고유성을 보장하는 ID를 만들기위한 식별자 표준 규약
						String filename = uuid+"-"+item.getName().replaceAll("-", "_");
													// 만약에 파일명에 - 하이픈 존재하면 _언더바로 변경
													// 왜 ?? 파일명과 UUID 간의 식별하기 위해 구분 -하이픈 사용하기때문에
													// 추후에 파일명만 추출시 사용자가 파일명에 - 이 있으면 파일명 추출시 쪼개기가 힘듦
						//UUID[- - -] - 파일명 : 추후에 파일명만 추출시 -하이픈 기준으로 쪼개기
					File fileUploadPath = new File( uploadPath + "/" + filename );
					System.out.println("업로드경로와 파일명이 조합된 경로 : " + fileUploadPath );
					
					item.write( fileUploadPath );//.write("저장할 경로[파일명포함]) 파일 업로드할 경로를 file 타입으로 제공
					// 7. 업로드 된 파일명을 Map 에 저장 [ -DB 에 저장하려고 ]
					i++ ;
					imgList.put( i , filename ); // 저장시에는 이미지 번호가 필요 없음
				}
				
			}// for end
		
			// 회원번호 
			Object object = request.getSession().getAttribute("loginDto");
			MemberDto memberDto = (MemberDto)object;
			int mno = memberDto.getMno();
			
			ProductDto productDto = new ProductDto(
									// fileList.get(0) : name = pcno 호출
									Integer.parseInt( fileList.get(0).getString() ),
									// fileList.get(1) : name = pcname 값 호출
									fileList.get(1).getString() ,
									// fileList.get(2) : pcontent 값 호출
									fileList.get(2).getString() ,
									// fileList.get(3) : pprice 값 호출
									Integer.parseInt( fileList.get(3).getString() ) ,
									fileList.get(4).getString() ,
									fileList.get(5).getString() ,
									mno , // 현재 로그인된[제품 등록한] 회원의 번호 호출
									// 여러개 이미지는 위에서 리스트로 구성후 대입
									// 업로드한 파일명의 개수만큼 MAP 리스트
									imgList);
			System.out.println( productDto );
			
			boolean result = ProductDao.getinstance().register(productDto);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// 옵션  1.요청방식 2.저장위치 3.용량 4.한글인코딩 5.파일명 중복일떄
		
		

	}

	// 2. 제품 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		String json = "";
		
		ObjectMapper mapper = new ObjectMapper();  
		
		if( type.equals("findByTop") ) {
			
			int count = Integer.parseInt(request.getParameter("count"));
			
			List<ProductDto> result = ProductDao.getinstance().findByTop(count);
			
			json = mapper.writeValueAsString(result);
			
		}
		else if( type.equals("findByLatLng") ) {
			
			String east = request.getParameter("east");
			String west = request.getParameter("west");
			String south = request.getParameter("south");
			String north = request.getParameter("north"); 
			
			List<ProductDto> result = ProductDao.getinstance().findByLatLng(east, west, south, north);
		
			json = mapper.writeValueAsString(result);
			
		} 
		else if( type.equals("findByPno") ) {
			
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			ProductDto result = ProductDao.getinstance().findByPno(pno);
			
			json = mapper.writeValueAsString(result);
			
		}
		else if( type.equals("findByAll") ) {
			
			
			List<ProductDto> result = ProductDao.getinstance().findByAll();
			
			json = mapper.writeValueAsString(result);
			
		}
	
		response.setContentType("application/json;charset=UTF-8");;
		response.getWriter().print(json);
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	// 4. 제품삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}


/*
  		MultipartRequest multi = new MultipartRequest(request, 
													request.getServletContext().getRealPath("/product/img") ,
													1024 * 1024 * 10 ,
													"UTF-8" ,
													new DefaultFileRenamePolicy()
													);
		String pcno = multi.getParameter("pcno");
		String pname = multi.getParameter("pname");
		String pcontent = multi.getParameter("pcontent");
		String pprice = multi.getParameter("pprice");
			//* 만약에 첨부파일 2개 이상 했을때 파일명 여러개 호출
		Enumeration pimg = multi.getFileNames();
		System.out.println(pimg);

			//getFilesystemName() : 첨부된 하나의 파일명 호출
  
 */

//post
/*
 * //form 태그 없는경우 1
 * 
 * String pname1 = request.getParameter("pname1"); String pcontent1 =
 * request.getParameter("pcontent1"); System.out.println( pname1 );
 * System.out.println( pcontent1 );
 * 
 * // form 태그 이용하는 경우 2 - form 전송시[ 첨부파일 있으나 없으나 MultipartRequest ]
 * MultipartRequest multi = new MultipartRequest(request,
 * request.getServletContext().getRealPath("/product"));
 * 
 * String pname2 = multi.getParameter("pname2"); String pcontent2 =
 * multi.getParameter("pcontent2"); System.out.println(pname2);
 * System.out.println(pcontent2);
 */
