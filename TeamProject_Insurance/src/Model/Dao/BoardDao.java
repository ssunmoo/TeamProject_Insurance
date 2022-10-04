package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Dto.BoardDto;

public class BoardDao {

	// 현재 페이지 객체 선언
	private static BoardDao boardDao = new BoardDao();

	// 싱글톤 메소드
	public static BoardDao getInstance() {
		return boardDao;
	}

	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 생성자
	private BoardDao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance_DB", "root", "1234");
		} // try 종료

		catch (Exception e) {
			System.out.println(e);
		} // catch 종료

	} // Dao 메소드 종료
		
	
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
	public boolean update( BoardDto dto ) {
		String sql = "update board set b_title = ?, b_content = ? where b_num = ? ";
		// 게시글 번호를 선택해서 타이틀이랑 내용을 바꾼다
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setInt(3, dto.getB_num());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	} // update 메소드 종료
        
	// 4. 게시글 삭제
	public boolean delete( BoardDto dto ) {
		String Sql = "delete from board where b_pw = ? ";
		// System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(Sql);
			ps.setString(1, dto.getB_pw());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	} // delete 메소드 종료

	// 5. 게시글 상세보기
	public BoardDto board_view(int b_num) {
		BoardDto dto = null;
		String sql = "select * from board where b_num = ? ";
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
		String sql = "insert into subworker values( ?, ?, ? )";
		// System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getW_reply());
			ps.setString(2, dto.getW_name());
			ps.setInt(3, dto.getB_num());
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
		// String sql = "select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw , board b where b.b_num = ? ";
		String sql = "select sw.w_reply, w.w_name, sw.b_num\r\n"
				+ "from subworker as sw\r\n"
				+ "inner join worker as w\r\n"
				+ "on sw.w_name = w.w_name\r\n"
				+ "where sw.b_num = ? ";
		
		ArrayList<BoardDto> list = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getString(1), rs.getString(2));

				list.add(dto);
			} // while 종료
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // reply_view 메소드 종료
	
	
}
