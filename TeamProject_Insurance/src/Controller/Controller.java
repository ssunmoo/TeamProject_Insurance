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
		Dto dto = new Dto( 0, b_title, b_content, phone, b_pw );
		return Dao.getInstance().regist(dto);
				
	}

	// 2. 게시판 보기
	public ArrayList< Dto > board() {
		return Dao.getInstance().board();
	}
	
//	public ArrayList< Dto > board2( String phone ) {
//		Dto dto = new Dto( phone );
//		return Dao.getInstance().board2(dto);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class 종료
