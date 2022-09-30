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
			System.out.println("오루" + e);
		} // catch 종료

		// 메소드
		// 회원가입등록 메소드

	} // Dao 메소드 종료

	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist(Dto dto) {
		String sql = "insert into board values(  ? , ? , ? , ? , ? )";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getB_pw());
			ps.executeUpdate();
			return true;

		} // try 종료
		catch (Exception e) {
			System.out.println("오류1"+e);
		} // catch 종료
		return false;
	} // regist 메소드 종료

	// 2. 게시판 보기
	public ArrayList<Dto> board() {

		ArrayList<Dto> list = new ArrayList<>();
		String sql = " select * from member where phone = ? ";

		try {

			// Dto dto = new Dto();

			ps = con.prepareStatement(sql);
			ps.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				list.add(dto);
			} // while 종료
			return list;
			// 쿼리문 하나 더 작성해서 원하는 항목만 dto에 저장하ㄱㅣ 저장한걸 한번에 rs.next() 로 출력하기

		} catch (Exception e) {
			System.out.println("오류"+e);
		}
		return list;

	} // board 메소드 종료
	
	
	
	//////////////////////가입하기&& 접속경로////////////////////////
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
		} catch (Exception e) {System.out.println("singup오류"+e);}
		return false;
		}
	//////////////////////////////////////////////////////////
	
	
	
	
	
} // class 종료
