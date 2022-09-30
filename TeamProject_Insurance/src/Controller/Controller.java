package Controller;

import java.util.ArrayList;

import Model.Dao.Dao;
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

	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist( String b_title, String b_content, String phone, String b_pw) {
		Dto dto = new Dto( b_title, b_content, phone, b_pw );
		// System.out.println( dto.toString() );
		return Dao.getInstance().regist(dto);
	}

	// 2. 게시판 보기
	public ArrayList< Dto > board() {
		return Dao.getInstance().board();
	}
	
	// 3. 게시글 수정
	public void update() {
		
	}
		
	// 4. 게시글 삭제
	public void delete() {
		
	}
	
	// 5. 게시글 상세보기
	public ArrayList< Dto > board_view( int b_num ) {
		return Dao.getInstance().board_view( b_num );
	}
	
	// 6. 상담사 답글 쓰기
	public boolean reply( String w_reply ) {
		Dto dto = new Dto( w_reply );
		return Dao.getInstance().reply( dto );
		
	} // reply 종료
	
	// 7. 상담사 답글 보기
	public ArrayList< Dto > reply_view() {
		return Dao.getInstance().reply_view();
	}

	
	
	
	
	
	
	
} // class 종료
