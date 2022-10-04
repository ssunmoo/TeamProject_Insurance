package Model.Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Controller.Controller;
import Model.Dto.BoardDto;
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance_DB", "root", "1234");
		} // try 종료

		catch (Exception e) {
			System.out.println(e);
		} // catch 종료
	} // Dao 메소드 종료

	////////////////////// 가입하기&& 접속경로 ////////////////////////
	public boolean getsingup(Dto dto) {
		String sql = "insert into member values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getSsn());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("singup오류" + e);
		}
		return false;
	}

	/////////////////////////로그인/////////////////////////////////
	public boolean login(Dto dto) {
		String sql = "select  * from member where name = ? and phone = ?"; // select name ,phone from member
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_name());
			ps.setString(2, dto.getL_phone());
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("singup오류" + e);
		}
		return false;
	}
	///////////////////로그인 후 상태//////////////////////////
	public boolean loginnext(Dto dto) {
		String sql = "select  * from member where name = ? and pw =? and phone = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getPhone());
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

			
		} catch (Exception e) {System.out.println("loginnext"+e);}
		return false;
	}
	////////////////////////////회원수정 및 탈퇴
	public boolean result_update(Dto dto) {
		String sql = "update member set name = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getL_name());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트"+e);
		}
		return false;
		
	}
	//////////////////////////비밀번호수정////////////////////
	public boolean result_update_pw(Dto dto) {
		String sql = "update member set pw = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getPw());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1"+e);
		}
		return false;
		
	}
	//////////////////////회원탈퇴//////////////////
	public boolean delete(Dto dto) {
		String sql = "delete from member where phone = ? and name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(2, dto.getL_name());
			ps.setString(1,dto.getL_phone());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1"+e);
		}
		return false;
		
	}

	
	// --- 회원가입 --- //
		// 1. 가입 개인정보 입력
	public boolean signup( Dto dto ) {
		String sql = "insert into member values(?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			//
			ps.setString( 1 , dto.getName() );
			ps.setString( 2 , dto.getPw() );
			ps.setString( 3 , dto.getPhone() );
			ps.setString( 4 , dto.getSsn() );
			ps.executeUpdate();
			return true;
		}catch( Exception e ) {
			System.out.println( "0"+e );
		}
		return false;
	} // signup end
	
	
} // class 종료
