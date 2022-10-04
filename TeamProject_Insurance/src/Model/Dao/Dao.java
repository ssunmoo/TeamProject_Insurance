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
			System.out.println("오류"+e);
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
	} // getsingup 메소드 종료

	// --- 로그인 --- //
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
	// 1. 로그인 후 상태
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
	} // loginnext 메소드 종료
	
	
	// 2. 회원수정 및 탈퇴
	public boolean result_update(Dto dto) {
		String sql = "update member set name = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getL_name());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트" + e);
		}
		return false;
		
	} // result_update 메소드 종료
	
	// 3. 비밀번호수정
	public boolean result_update_pw(Dto dto) {
		String sql = "update member set pw = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getPw());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1" + e);
		}
		return false;
		
	} // result_update_pw 메소드 종료
	
	// 4. 회원탈퇴
	public boolean delete(Dto dto) {
		String sql = "delete from member where phone = ? and name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(2, dto.getL_name());
			ps.setString(1,dto.getL_phone());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1" + e);
		}
		return false;

	}
	
	//////////////////가입 내역////////////
//	ArrayList<Dto>myinsurance(){
//		ArrayList<Dto>list = new ArrayList<>();
//		String sql = "select * from history";
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(rs.getString(1));
//			}
//			return list;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return list;
//		
//	}
	


	// --- 보험가입 --- //
	public ArrayList<Dto> list(){
		ArrayList<Dto>list = new ArrayList<>();
		String sql = "select c_title from sublist where c_num = ?;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto(rs.getInt(1));
				list.add(dto);
			} 
			return list;
		}
		catch (Exception e) {System.out.println("list11"+e);
				return list;
		}
		
	} // list 메소드 종료
		
	///////////가입 보험 표시/////////////
	
	public ArrayList<Dto>myinsur(){
		ArrayList<Dto>myinsur =new ArrayList<>();
		String sql = "select* from history ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(rs.getString(1),rs.getString(2),rs.getString(3));
				myinsur.add(dto);
			}
			return myinsur;
		} catch (Exception e) {
			System.out.println("myinsur"+e);
		}
		return myinsur;	
	}
	
} // class 종료
