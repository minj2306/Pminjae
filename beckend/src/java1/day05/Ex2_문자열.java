package java1.day05;

public class Ex2_문자열 {
	
	public static void main(String[] args) {
		
		//[p.153]
		String name1 = "홍길동";
		String name2 = "홍길동";
			// ????? : 두 스택 영역의 지역 변수가 참조하는 주소는 같을까? 문자 리터럴 " "
		System.out.println( name1==name2 ); // 같다 true
		
		String name3 = new String("홍길동"); //11번지
		String name4 = new String("홍길동"); //21번지
			// " " : 문자열 리터럴 아닌 new 연산자를 이용한 객체 생성시에는 같을까?
		System.out.println( name3==name4 ); // 다르다 false
		
		//[p.156]
		
		if( name1.equals(name2) ) {//" " 문자열리터럴 생성된 문자열객체 비교
			System.out.println(" 두 문자열 같습니다. ");
		}
		else {System.out.println(" 두 문자열 다릅니다. ");}
		
		if( name3 == name4 ) {System.out.println(" 두 문자열 같습니다. ");}
		else {System.out.println(" 두 문자열 다릅니다.");}
		
		//[p.157] 문자열 내에서 특정문자 추출/꺼내기
		String ssn = "95062412301213"; // 문자열 객체 선언 // 글자수 13 인덱스 0~12
		char sex = ssn.charAt(6);	//9[0]5[1]0[2]6[3]2[4]4[5]1[6]~~~~3[12]
		
		if(sex == '1' || sex == '3') System.out.println("남자입니다.");
		else System.out.println("여자입니다.");

		//[p.158].length( ) 문자열의 길이 구하기
		System.out.println("주민등록번호 길이 : "+ssn.length() );
	
		//[p.159] .replace( ) 문자열내 특정 문자열 교환/ 치환 / 대체
		String oldStr = "자바 문자열은 불변입니다. 자바문자열은 String입니다.";
		//문자열내 "자바" -->"JAVA" 로 교체후 교체된 문자열 반환
		String newStr = oldStr.replace("자바", "JAVA"); //치환된 결과를 새로운 변수에 저장
		System.out.println(oldStr);
		System.out.println( newStr );
		
		//[p.160] .substring( ) : 문자열 자르기
		String ssn2 = "880815-1234567";
		String secondNum = ssn2.substring( 7 ); //인덱스 7부터 마지막까지 추출
		System.out.println( secondNum );
		
		String firstNum = ssn2.substring( 0 , 6 ); // 0번인덱스부터 6번인덱스 전 까지 추출(0~5)
		System.out.println( firstNum );
		
		//[p.164] .split( )	: 문자열분리
			//ssn2.split("-") : - 기준으로 분리
				//880815-1234567 --> -분리 { 880815 , 1234567 }
		System.out.println( ssn2.split(",")[0] );//880815
		System.out.println( ssn2.split(",")[1] );//1234567
	
		//[p.162] .indexOf()	: 문자찾기
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍"); // "자바 프로그래밍" 문자열 내 "프로그래밍" 문자열 찾기
		//찾은 문자열의 위치[인덱스] 반환 / 없으면-1
		if( location == -1 ) {// -1이면 못찾았다.
			System.out.println("프로그래밍 책이 아닙니다.");
		}
		else {//-1이 아니면 찾았다
			System.out.println("프로그래밍 책이군요");
		}
		
		
		
		
		
	}
}

/*
		자바 문자열 사용하는 방법
			1. String 변수명 = "문자열"
 			2. String 변수명 = new String("문자열");
 		
 		자바 문자열에서 제공해주는 라이브러리 = 미리 만들어진 함수들
 			문자열객체.메소드명( )
 			1. 문자열객체1.equals( 문자열객체2 )	: 두 문자열 객체내 문자열이 동일하면 true 아니면 false 반환 [주소X]
 			
 			2. 문자열객체.charAt( 인덱스 )		: 문자열 내 해당 인덱스의 문자1개 추출 [ 첫번째 글자 = 인덱스0 ]
 			
 			3. 문자열객체.length( )			: 문자열에서 문자의 개수 반환 
 				vs 배열명.length
 			
 			4. 문자열객체.replace( "기존문자열" , "새로운문자열" )	: 문자열내 기존문자열이 존재하면 새로운 문자열로 치환해서 반환
			
			5. 문자열객체.substring( 인덱스 )	: 해당인덱스부터 마지막 인덱스까지 문자열 추출
				문자열객체.substring( 시작인덱스 , 마지막인덱스 )	: 시작인덱스부터 마지막인덱스 전까지 문자열 추출
 				문자열객체.split("분리기준문자")	: 문자열내 분리기준 문자로 분리해서 배열로 반환
 					문자열객체.split("분리기준문자")[인덱스] : 분리후 분리된 인덱스 1개 호출
 			
 			6. 문자열객체.indexOf( "찾을문자열" ) : 문자열내 찾을 문자열이 존재하면 찾은 문자열 인덱스 반환 / 없으면 -1
 
 			7. 문자열객체.getBytes
 */

