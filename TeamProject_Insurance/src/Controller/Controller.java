package Controller;

import java.util.ArrayList;

import Model.Dao.Dao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;

public class Controller {

	// 현재 페이지 객체 선언
	private static Controller control = new Controller();
	// 빈생성자
	private Controller() { }
	// 싱글톤 메소드
	public static Controller getInStance() {
		return control;
	}

	
	
	// --- 회원가입 --- //	
	public boolean getsingup(String name,String pw, String phone, String ssn) {
		Dto dto = new Dto(name, pw, phone, ssn);
		return Dao.getInstance().getsingup(dto);
	}
	
	// --- 로그인 --- //	
	public boolean login(String l_name, String l_phone) {
		Dto dto = new Dto(l_name, l_phone);
		return Dao.getInstance().login(dto);
	}
	
	
	
	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist( String b_title, String b_content, String phone, String b_pw) {
		BoardDto dto = new BoardDto( b_title, b_content, phone, b_pw );
		// System.out.println( dto.toString() );
		return Dao.getInstance().regist( dto );
	}

	// 2. 게시판 보기
	public ArrayList< BoardDto > board() {
		return Dao.getInstance().board();
	}
	
	// 3. 게시글 수정
	public boolean update( int b_num, String b_title, String b_content, String b_pw ) {
		BoardDto dto = new BoardDto( b_num, b_title, b_content, b_pw );
		return Dao.getInstance().update(dto);
	}
		
	// 4. 게시글 삭제
	public boolean delete( int b_num, String pw ) {
		BoardDto dto = new BoardDto( b_num , pw );
		return Dao.getInstance().delete( dto );
	}
	
	// 5. 게시글 상세보기
	public BoardDto board_view( int b_num ) {
		return Dao.getInstance().board_view( b_num );
	}
	
	// 6. 상담사 답글 쓰기
	public boolean reply( String w_reply, String w_name, int b_num ) {
		BoardDto dto = new BoardDto( w_reply , w_name, b_num );
		return Dao.getInstance().reply( dto );
		
	} // reply 종료
	
	// 7. 상담사 답글 보기
	public ArrayList< BoardDto > reply_view( int b_num ) {
		return Dao.getInstance().reply_view( b_num );
	}

	
	
	
} // class 종료
