package Model.Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Controller.Controller;
import Model.Dto.Dto;

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
	

	
	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist( Dto dto ) {
		String sql = "insert into board values( null , ? , ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getB_pw());
			ps.executeUpdate();
			return true;
			
		} // try 종료
		catch (Exception e) {
			System.out.println( e );
		} // catch 종료
		return false;
	} // regist 메소드 종료
	
	
	// 2. 게시판 보기
	public ArrayList< Dto > board() {
		
		ArrayList< Dto > list = new ArrayList<>();
		String sql = "select b.b_num , b.b_title , b.b_content , a.name , a.phone from member a , board b where a.phone = b.phone;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Dto dto = new Dto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));
				
				list.add(dto);
			} // while 종료
			return list;
			
		} catch (Exception e) {
			System.out.println( e );
		}
		return list;
	} // board 메소드 종료
	
//	// 2. 게시판 보기
//	public ArrayList< Dto > board() {
//		
//		ArrayList< Dto > list = new ArrayList<>();
//		String sql = "select * from board";
//		
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				Dto dto = new Dto(
//						rs.getInt(1), rs.getString(2),
//						rs.getString(3), rs.getString(4));
//				
//				list.add(dto);
//			} // while 종료
//			return list;
//			
//		} catch (Exception e) {
//			System.out.println( e );
//		}
//		return list;
//	} // board 메소드 종료
	
	

//	// 2. 게시판보기 - 이름 불러오기
//	public ArrayList< Dto > board2() {
//			
//		ArrayList< Dto > list = new ArrayList<>();
//		String sql = "select name from member where phone = ? ";
//		
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				Dto dto = new Dto(
//						rs.getString(1));
//				list.add(dto);
//			} // while 종료
//			return list;
//			
//		} catch (Exception e) {
//			System.out.println( e );
//		}
//		return list;
//	} // board2 메소드 종료
	
	
//	// 2. 게시판보기 - 이름 불러오기
//	public ArrayList< Dto > board2( Dto dto ) {
//			
//		ArrayList< Dto > list = new ArrayList<>();
//		String sql = "select name, phone from member where phone = ?";
//		
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, dto.getPhone());
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				Dto a = new Dto(
//						rs.getString(1));
//				list.add(a);
//			} // while 종료
//			return list;
//			
//		} catch (Exception e) {
//			System.out.println( e );
//		}
//		return list;
//	} // board2 메소드 종료	
	
	
	
	
	
	
	
	
} // class 종료
