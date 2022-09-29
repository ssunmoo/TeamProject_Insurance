package Start;

import Controller.Controller;
import Model.Dao.Dao;
import View.Mainpage;

public class Start {

	public static void main(String[] args) {
		// Mainpage에 있는 첫 시작 메소드 호출만
	
		Start start = new Start();
		start.regist();

	} // main 종료
	
	
	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	
	public void regist() {
		Mainpage.getInstance().board();
		Mainpage.getInstance().regist();
		
	}
	
	
	
	
	
	
} // class 종료




