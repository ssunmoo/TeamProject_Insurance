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
	
	// --- 보험가입 --- //
	public ArrayList<Dto>list() {
		return Dao.getInstance().list();
	}
	
	///////////////////////////////보험내역확인//////////////////////
	
	

	
	
	
	


	
	
	
} // class 종료
