package model.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getinstance() { return productDao; }
	
	// 1. 제품등록
	public boolean register( ProductDto dto) {
		
		try {
			
			//1-1 [제품등록]
			
			String sql = "insert into product "
					+ "( pcno , pname , pcontent , pprice , plat , plng , mno ) "
					+ "values( ? , ? , ? , ? , ? , ? , ? )";
			
			// * sql insert 후 자동생성된 pk를 반환하는 방법
				// conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS ) : 생성된 식별키를 반환
				// ps.getrGeneratedKeys() : 식별키 반환하는 함수
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
			
			ps.setInt(1, dto.getPcno());
			ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcontent()); 
			ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat());
			ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			
			int count = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk] 반환해서 resultset[ps] 에 대입
			rs.next(); // resultset null --->next()--> 결과레코드1 --next()-->결과레코드2
			
			if(count == 1) {
			
				//1-2 제품등록 후 생성된 제품 pk를 가지고 [이미지 등록]
					//1. dto 에 저장된 이미지 개수만큼
				// Map< Integer , String > 	: Map객체명.keySet() : map객체내 모든 키 호출
				// -------get( 인덱스 )  : List 컬렉션은  인덱스 사용
				// -------get( 키 ) : SET 컬렉션 MAP 컬렉션은 인덱스가 없으므로 키 값으로 호출
				for( String img : dto.getImgList().values() ) {
					
					sql = "insert into productimg( pimg , pno ) values( ? , ? )";
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, img );
					ps.setInt( 2 , rs.getInt( 1 ) ); // ??? 위에서 insert된 제품번호
					
					ps.executeUpdate();
				}
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 2. 제품 전체 출력 
	
	// 0. 
	public Map<Integer, String > getProductImg( int pno ){
	
		try {
			
			Map<Integer, String> imglist = new HashMap<>();
			
			String sql = "select * from productimg where pno = "+ pno;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				imglist.put( rs.getInt("pimgno") , rs.getString("pimg") );
			}
			return imglist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 3. 선택된 제품 번호에 해당하는 제품 출력함수
	public ProductDto findByPno( int pno ) {
		
		try {
			
			String sql = "select * from product p natural join pcategory pc natural join member m where p.pno = "+pno;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ProductDto productDto = new ProductDto(
						rs.getInt("pcno") , rs.getString("pcname") ,
						rs.getInt("pno") , rs.getString("pname") ,
						rs.getString("pcontent") , rs.getInt("pprice") ,
						rs.getInt("pstate") , rs.getString("pdate") ,
						rs.getString("plat") , rs.getString("plng") ,
						rs.getInt("mno") , getProductImg( rs.getInt("pno") ) ,
						rs.getString("mid")
						);
				return productDto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	// 1. N개 제품들을 최신순으로 출력함수 
	public List<ProductDto> findByTop ( int count ){
		
		List<ProductDto> list = new ArrayList<>(); 
		
		try {
		
			String sql = "select * from product order by pdate desc limit "+ count;
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add( findByPno( rs.getInt("pno") ) );
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
		
	}
	
	// 2. 현재 카카오지도 내 보고있는 동서남북 기준 내 제품들을 출력함수
	public List<ProductDto> findByLatLng( String east , String west , String south , String north ){

		List<ProductDto> list = new ArrayList<>(); 

		try { //제품의 경도가 '동쪽' 보다 작고 경도가 '서쪽' 보다 크고 위도가 '남쪽' 보다 작고 '북쪽' 보다 크다.
			
				// 동 경도보다 크고 서 경도보다 작고 남 위도보다 크고 북 위도보다 작고
			String sql = "select * from product where "
						 +"plat <= ? and "
						 +"plat >= ? and "
						 +"plng >= ? and "
						 +"plng <= ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, east);
			ps.setString(2, west);
			ps.setString(3, south);
			ps.setString(4, north);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add( findByPno( rs.getInt("pno") ) );
			}
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	

	
	// 4. 관리자 출력
	public List<ProductDto> findByAll( ){
		
		List<ProductDto> list = new ArrayList<>(); 
		
		try {
			
			String sql = "select * from product";

			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add( findByPno( rs.getInt("pno") ) );
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
 
	// 제품 찜하기 등록(=찜하기상태가 아닐떄 = 레코드가 없을떄) / 취소(=찜하기 상태일때 = 조건에 따른 레코드가 있을때
	public boolean setWish( int mno , int pno) {
		
		try {
			
			String sql = getWish(mno , pno) ?  
							"delete from pwishlist where mno = ? and pno = ?" :
								"insert into pwishlist values( ? , ? ) ";
					
			
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			
			int count = ps.executeUpdate();
			
			if( count == 1) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("setWish : " + e);
		}
		return false;
	}
		
	// 제품 찜하기 상태 출력
	public boolean getWish( int mno , int pno ){
		
		try {
			
			String sql = "select * from pwishlist where mno = ? and pno = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println( "getWish" + e);
		}
		
		return false;
		
	}
	
	// 현재 로그인된 회원의 찜한 제품[여러개] 정보를 출력하는 함수
	public List<ProductDto> getWishProductList( int mno ){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			
			String sql = "select pno from pwishlist where mno = " + mno; // 현재 회원의 찜하기 제품번호 목록 찾기
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			//현재 회원이 찜한 제품번호의 레코드 반환
				// 찾은 제품번호 하나씩 findByPno() 함수에게 전달해서 제품정보를 list 담기
			while (rs.next() ) {
				list.add( findByPno( rs.getInt("pno") ) );
			}
			return list;
		} catch (Exception e) {
			System.out.println( "getWishProductList" + e);
		}
		return list;
	}
	
}
