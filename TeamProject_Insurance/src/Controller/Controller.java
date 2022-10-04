package Controller;

import java.util.ArrayList;

import Model.Dao.Dao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;
import Model.Dto.WorkDto;

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
	//마이페이지
	public boolean loginnext(String name,String pw, String phone) {
		Dto dto = new Dto(name,pw,phone);
		return Dao.getInstance().loginnext(dto);
	}
	public boolean result_update( String l_phone,String l_name) {
		Dto dto = new Dto(l_phone , l_name);
		return Dao.getInstance().result_update(dto);
	}
	public boolean delete(String delete_name ,String delete_num) {
		Dto dto = new Dto(delete_name, delete_num); 
		return Dao.getInstance().delete(dto);
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

	
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////

// 상담사 리스트 보기
public ArrayList< WorkDto > workerlist() {
return Dao.getInstance().workerlist();
}

// 상담사 추가
public static boolean w_regist(String w_name) {
return  Dao.getInstance().w_regist(w_name);
}
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////	


// 보험 리스트
//암
	public ArrayList< WorkDto > listinsurance() {
		return Dao.getInstance().listinsurance();
	}
//손해
	public ArrayList< WorkDto > listinsurance2() {
		return Dao.getInstance().listinsurance2();
	}
//치아
	public ArrayList< WorkDto > listinsurance3() {
		return Dao.getInstance().listinsurance3();
	}


// 암 리스트 추가
	public static boolean listadd(String s_name , String s_text) {
		return  Dao.getInstance().listadd(s_name,s_text);
	}
// 손해 리스트 추가
	public static boolean listadd2(String s_name , String s_text) {
		return  Dao.getInstance().listadd2(s_name,s_text);
	}
// 치아 리스트 추가
	public static boolean listadd3(String s_name , String s_text) {
		return  Dao.getInstance().listadd3(s_name,s_text);
	}



// 암 list 삭제  
	public static boolean listdelete( int s_num ) {
		return Dao.getInstance().listdelete( s_num );
	}
// 손해 list 삭제  
	public static boolean listdelete2( int s_num ) {
		return Dao.getInstance().listdelete2( s_num );
	}
// 치아 list 삭제  
	public static boolean listdelete3( int s_num ) {
		return Dao.getInstance().listdelete3( s_num );
	}

// 나이 출력
	public static WorkDto age(String phone1) {
		return  Dao.getInstance().age(phone1);
	}
// 동년배 보험 추천
	public ArrayList< WorkDto > recommend( int age) {
		return Dao.getInstance().recommend( age);
	}

	
} // class 종료
