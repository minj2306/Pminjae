package java2.day27_컬렉션프레임워크2.Ex1_Hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {

	public static void main(String[] args) {
		
		//1. Set 컬렉션의 HashSet 객체 선언
		Set<String> set = new HashSet<>();
			//set 객체(컬렉션 프레임 워크) 에 <String> 객체를 여러개 저장 가능
			System.out.println("set 상태 : " + set);
		//2. set 객체에 String 객체 저장
		set.add("Java"); System.out.println("set 상태 : " + set);
		set.add("JDBC"); System.out.println("set 상태 : " + set);
		set.add("JSP"); System.out.println("set 상태 : " + set);
		set.add("Java"); //중복 발생 !! list 는 가능하지만 , set는 불가능
		System.out.println("set 상태 : " + set);
		set.add("Spring"); System.out.println("set 상태 : " + set);
		
		//3. set 객체내 String 객체 수
		System.out.println("set객체 내 객체수 : " + set.size() );
		
		//4. set/list 와 for 문 관계 [ * 배열/컬렉션 내 저장된 데이터들을 순회 하려고 ]
			//1. for 문 [ list 인덱스가 존재하므로 가능하지만 , set 불가능.. ]
			for( int i = 0 ; i<set.size() ; i++) { }
			//2. 향상된 for문 [ list , set 가능 ]
				// for( 반복변수 : 컬렉션 객체 ) { }
				//1. 반복변수란 : 컬렉션객체에 저장된 타입 <String>
			for(String s : set) { System.out.println( s ); }
			//3. forEach() 함수를 이용한 람다식 표현 (화살표 함수 = [ java -> / js => ] )
			set.forEach( s -> { System.out.println( s ); } );
		
		//----------------------------------
		
			//객체내 중복여부 체크
				//객체가 String 이면 String 기준으로 중복제거
				//객체[ String , int ] 가 2개 이상의 필드를 가지고 있으면 중복기준이 명확하지 않기 떄문에
				//hashCode() , equals() 재정의 이용한 중복기준 만들기
			
			
		//1. set 객체 선언
		Set<Member> set2 = new HashSet<>();
		
		//2. set 객체에 member 객체 저장
		set2.add(new Member("홍길동" , 30) );
		set2.add(new Member("홍길동" , 30) );
		set2.add(new Member("강호동" , 30) );
		set2.add(new Member("홍길동" , 40) );
		set2.add(new Member("신동엽" , 50) );
		
		//3. set 객체내 member 객체 수
		System.out.println("set 객체 내 member객체수 : " + set2);
	
		//4. iterator() 메소드 제공
		Iterator<Member> iterator = set2.iterator();
		
		while ( iterator.hasNext() ) {// .hasNext() : 다음 객체가 있으면 true / 없으면 false
			Member element = iterator.next(); // next() : set객체내 객체 호출
			System.out.println( element );
			if(element.name.equals("강호동") ) {
				iterator.remove(); // .remove : set객체내 해당 객체 삭제
			}
		}
		System.out.println("set 객체 내 member객체수 : " + set2);
	
		//4. 향상된 for 문( interator 를 사용하는 배열 / 컬렉션 프레임 워크의 객체이면 사용가능)
		for( Member m : set2 ) { System.out.println( m ); }
		
		//4. forEach ( interator 를 사용하는 컬렉션 프레임워크의 객체이면 사용가능 ) 
		set2.forEach( m -> { System.out.println( m ); } );
	
	}//main end

	
}
