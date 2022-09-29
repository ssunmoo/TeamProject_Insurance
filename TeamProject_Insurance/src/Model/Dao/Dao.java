package Model.Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	// 현재 페이지 객체 선언
	private static Dao dao = new Dao();

	// 싱글톤 메소드
	public static Dao getInstance() {
		return dao;
	}
	
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 생성자
	private Dao() {
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Insurance_DB",
				"root",
				"1234");
		} // try 종료
		
		catch (Exception e) {
			System.out.println( e );
		} // catch 종료
		
		// 메소드
			// 회원가입등록 메소드
		
		
		
	} // Dao 메소드 종료
	

	
	
	
	
	
	
	
	
	
	
	
	
} // class 종료
