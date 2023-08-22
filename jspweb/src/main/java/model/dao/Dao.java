package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection conn; // 연동 DB의 객체
	public PreparedStatement ps; // 연동된 DB에서 SQL 조작(매개변수 대입 , SQL 실행/결과 ) 하는 객체
	public ResultSet rs; // SQL 결과 조작하는 객체
	
	public Dao() { // 자식객체가 생성되명 부모객체도 같이 생성!!![ *자식객체가 생성되면 부모클래스의 생성자 호출된다.]
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb"
												, "root" ,"1234");
			System.out.println("DB 연동성공");
		} catch (Exception e) {
			System.out.println("DB 연동실패" + e);
		}
		
	}
	
}
