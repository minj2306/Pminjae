package java2.day21;

public class Ex1_예외처리 {

	public static void printLenth(String data) {
		//p. 467 : 예외처리
		try {//예외 발생할것 같은 코드
		
			int result = data.length(); // 1. ThisIsJava => String 객체의 주소값 // 2. null => 객체의 주소값 없음
			System.out.println("문자수 : " + result);
		
		} catch (NullPointerException e) { // 예외 발생하면 이곳으로 이동하고 예외정보를 *객체 내 저장
			//NullPointerException : 처음에는 모르지만.. 실행한 결과(경험한 결과) NullPointerException 예외 발생했다는 경험 때문에
			System.out.println( e.getMessage() );//e 객체 : 예외 발생에 관련된 정보 들어있는 객체 [ Cannot invoke "String.length()" because "data" is null ]
			System.out.println(e); // 실무 : 오류정보를 파일처리해서 추후에 문제 발생한 것들을 개발자 업데이트/유지보수
			
		}
		finally { // 예외 발생 하던 안하던 무조건 실행되는 코드
			System.out.println("마무리 실행");
		}
		
	}
	
	public static void main(String[] args) {
		
		//p.466 실행예외 [ 실행후 예외 발생하기 때문에 예외처리는 경험 / 테스트 후에 ]
		System.out.println("프로그램 시작");
		printLenth("ThisIsJava"); // 정상실행
		printLenth(null); // 예외발생 NullPointerException => 프로그램 강제종료 =>아래코드 실행X
		System.out.println("프로그램 종료");
	
		//p.468 : 일반예외 [ 실행전부터 컴파일러가 예외검사 하기때문에 예외 필수! ]
		try {
		
			Class.forName("java.lang.String"); // Class.forName : 클래스 찾기 // java.lang.String
			//ClassNotFoundException : 만약에 클래스를 못찾았을때 예외처리 미리
			System.out.println("java.lang.String 클래스가 존재합니다.");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//
		try {
			
			Class.forName("java.lang.String2"); // java.lang.String2 클래스는 존재하지 않으므로 예외발생 catch 이동
			//ClassNotFoundException : 만약에 클래스를 못찾았을때 예외처리 미리
			System.out.println("java.lang.String2 클래스가 존재합니다.");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
/*
 	에러 : 컴퓨터의 하드웨어 고장으로 인해 실행오류가 발생
 	예외 : 에러이외
 		*프로그램에 예외가 발생했을때 정상적인 실행 유지할수 있도록
 		-1. 일반예외 : 컴파일러가 예외처리 코드 여불를 검사하는 예외.
 			-외부입출력 관련 : 파일처리 , JDBC(DAO) , 네트워크 , 입출력
 			
 		-2. 실행예외 : 컴파일러가 예외처리코드 여부를 검사하지 않는 예외를 말함.
 			- 실행 도중에 오류가 발생하는 것 : - 개발자의 경험에 의존
 			- 타입오류 , 배열인덱스 , NULL(객체없다.메소드사용X)
 	
 	예외처리
 		try{ 예외가 발생할 것 같은 코드 }
 		catch(예외클래스 변수객체){ 예외가 발생했을때 코드 }
 		finally{ 예외와 상관없이 항상 실행코드 }
 		
 */
