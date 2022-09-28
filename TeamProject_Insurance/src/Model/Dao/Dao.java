package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Dto.Dto;

public class Dao {
	
	// 현재 페이지 객체 선언
	private static Dao dao = new Dao();

	// 싱글톤 메소드
	public static Dao getInstance() {
		return dao;
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	

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
	} // Dao 메소드 종료
	

	
	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist( Dto dto ) {
		String sql = "insert into board values( null , ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setString(3, dto.getB_pw());
			return true;
			
		} // try 종료
		catch (Exception e) {
			System.out.println( e );
		} // catch 종료
		return false;
	} // regist 메소드 종료
	
	
	
	
	
	
	
	
} // class 종료
