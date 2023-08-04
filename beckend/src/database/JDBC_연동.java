package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_연동 {

	public static void main(String[] args) {
		
	try {	
	//-----------------------------예외가 발생할것 같은 코드들을 try{} 안-----------------------------
		//1. p.908 : 현재 프로젝트에 JDBC 파일을 build path add 하기
		//2. p.909 : DB 연결하기위해 JDBC Driver 클래스를 찾아서 메모리 로딩 하기
		 //Class.forName("oracle.jdbc.OracleDriver");//오라클 기준
		Class.forName("com.mysql.cj.jdbc.Driver");//mysql 기준
			//만약애 해당 JDBC 드라이버 클래스가 검색이 실패하면 예외발생 -> 예외처리
		//3. DB연결 [ DriverManager.getConnection() 메소드가 연결 성공하면 DB와 연결된 객체 리턴 -> 만약에 실패하면 예외발생 -> 예외처리
		//Connection conn = DriverManager.getConnection("DB주소" , "계정명" , "비밀번호");
			/*		
			  1. DB주소 : - jdbc:mysql://ip주소:port번호/db명
			  			 1. jdbc:oracle:thin@localhost:1521/orcl
						 2. jdbc:mysql://lovalhost:3306/orcl
			*/
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root" , "1234");
		System.out.println("안내) 연동 성공 " + conn );
	}//try
	//------------------------------만약에 try{} 에서 예외가 발생했으면 실행되는 catch 코드 ------------------//
	catch( Exception e ) {// Exception 클래스 : 모든 예외 정보를 담아주는 객체
		System.out.println("안내) 연동실패 사유 : "+ e); // 객체출력하면 왜 예외가 발생했는지 사유 출력됨
	}
	//-------------------------만약에 try{} 에서 예외가 발생했으면 실행되는 catch{} 코드----------------------//
	}
	
}
/*
 
 	예외처리 : 
 		- Exception 클래스
 		- 예외[오류] 발생했을때 흐름제어[ *만약에 오류 발생했을때 다른 코드로 흐름 처리 ]
 		- try{ } catch{ }
 			try{ 예외[오류]가 발생할것 같은 코드 }
 			catch( 예외클래스명 객체변수명 ){ 예외 발생했을때 실행할 코드 }
 			
 			* try{ } 안에서 예외가 발생하는 순간 바로 catch 이동하기 때문에 예외 발생한 코드 아래로는 실행 안됨!
 			
 		- 예외[오류]가 발생할것 같은 코드 
 			- 일반예외 : 컴파일 과정에서 체크	 [ -컴파일러가 체크하기때문에 미리 처리 가능 ] 
 				- 파일처리 , DB연동 , 입출력 등등
 			- 실행예외 : 실행 도중에 발생하는 예외 [ - 개발자 경험으로 판단 ] - 프로그램 안정성 보장
 				- 실행중 각종 오류 [ 타입에러 , 인덱스부족 등등 ]
 *
 */


