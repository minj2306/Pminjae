package model.dao;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	// 제품 최신순 출력 
	public List<ProductDto> findByTop ( int count ){
		
		return null;
		
	}
	
	// 제품 범위만큼 출력
	public List<ProductDto> findByLatLng( String east , String west , String south , String north ){
		
		return null;
	}
	
	// 제품 개별 출력
	public ProductDto findByPno( int pno ) {
		
		return null;
	}
	
	// 관리자 출력
	public List<ProductDto> findByAll( ){
		
		return null;
	}
	
	// 3. 제품 개별 조회 
		
	// 4. 제품 수정 
		
	// 5. 제품 삭제 
}
