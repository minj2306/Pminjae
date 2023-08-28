package java2.day27_컬렉션프레임워크2.Ex2_HashMap;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;


public class Ex2_예제 {

	public static void main(String[] args) {
		
		//1. map 컬랙션 객체 내 < String , Integer > 2개 객체를 저장할 컬렉션객체 선언
		Map<String , Integer> map = new HashMap<>();
		
		//2. 객체저장 .put(key , value )
		map.put("신용권", 85 ); //key : "신용권" , value : 85
		map.put("홍길동", 90 );
		map.put("동장군", 80 );
		map.put("홍길동", 95 ); // key 중복 불가능 , value : 중복가능 // key 중복일경우 새로운 값으로 대체 [ "홍깅동" , 90 ] 삭제
		System.out.println("map 상태 : " + map);
		
		//3. map 객체 호출 .get(key)
		System.out.println("홍길동 value : " + map.get("홍길동") );
		
		//4. map 객체 내 모든 key 호출
		System.out.println("map 객체 내 모든 key : " + map.keySet() );
		System.out.println("map 객체 내 모든 values : " + map.values() );
		
		//-----------------------> key 이용한 value 호출 가능 // value 이용한 key 호출 불가능
		
		//5. 향상된 for 문 [ map.keySet() : 모든 key 호출 ]
		for( String key : map.keySet() ) { System.out.printf( " key : %s value : %d \n" , key , map.get( key ) ); }
	
		//
		map.keySet().forEach( key -> {
			 System.out.printf( " key : %s value : %d \n" , key , map.get( key ) );		});
	
		//-----------------------> 엔트리< key , value > 호출
		for( Entry<String , Integer> entry : map.entrySet() ) {
			System.out.println(entry);
			System.out.println(entry.getKey() );
			System.out.println(entry.getValue() );
		}
		map.entrySet().forEach( entry -> {
			System.out.println(entry);
			System.out.println(entry.getKey() );
			System.out.println(entry.getValue());
		});
	}//main end
	
}
