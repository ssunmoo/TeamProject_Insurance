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

	//////////////////////////////////////////////////////////
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

	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist(BoardDto dto) {
		String sql = "insert into board values( null, ?, ?, ?, ? )";
		// System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setString(4, dto.getPhone());
			ps.setString(3, dto.getB_pw());
			ps.executeUpdate();
			return true;

		} // try 종료
		catch (Exception e) {
			System.out.println(e);
		} // catch 종료
		return false;
	} // regist 메소드 종료

	// 2. 게시판 보기
	public ArrayList<BoardDto> board() {

		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select b.b_num , b.b_title , b.b_content , m.name , m.phone from member m , board b where m.phone = b.phone ORDER BY (b.b_num);";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(dto);
			} // while 종료
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // board 메소드 종료

	// 3. 게시글 수정
	public void update() {

	} // update 메소드 종료

	// 4. 게시글 삭제
	public void delete() {

	} // delete 메소드 종료

	// 5. 게시글 상세보기
	public BoardDto board_view(int b_num) {
		
		BoardDto dto = null;
		
		String sql = "select * from board where b_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs = ps.executeQuery();

			if ( rs.next() ) {
				dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				return dto;
			} 

		} catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	
	} // board_view 메소드 종료

	// 6. 상담사 답글 쓰기
	public boolean reply(BoardDto dto) {
		String sql = "insert into subworker values( null, ? )";
		System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getW_reply());
			ps.executeUpdate();
			return true;

		} // try 종료
		catch (Exception e) {
			System.out.println(e);
		} // catch 종료
		return false;
	} // reply 메소드 종료

	// 7. 상담사 답글 보기
	public ArrayList<BoardDto> reply_view( int b_num ) {
		String sql = "select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw , board b where b.b_num = ? ";

		ArrayList<BoardDto> list = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getString(2), rs.getString(3));

				list.add(dto);
			} // while 종료
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // reply_view 메소드 종료

	
	
	
	
	
	
} // class 종료
