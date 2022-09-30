package View;

import java.util.Scanner;
import Controller.Controller;
import Model.Dao.Dao;


public class Start {

	Scanner scanner = new Scanner(System.in);
	
	// 메소드
	public static void main(String[] args) {
		// Mainpage에 있는 첫 시작 메소드 호출만
		// Mainpage.getInstance().index();

		Start start = new Start();
		// start.reply_view();
		start.signup();
		// start.board_view();
		// start.regist();
		
		
		
	} // main 종료
	
	
	// 첫화면
	public void signup() {
		Mainpage.getInstance().signup();
		
	
	}
	

	// --- 게시판 --- //
	// 1. 문의글 등록
	
	public void regist() {
		Mainpage.getInstance().board();
		Mainpage.getInstance().regist();
		
	}
	
	public void board_view() {
		Mainpage.getInstance().board_view();
	}
	
	public void reply_view() {
		Mainpage.getInstance().reply_view();
	}
	
} // class 종료




