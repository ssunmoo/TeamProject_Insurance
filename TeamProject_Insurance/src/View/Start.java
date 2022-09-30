package View;

import java.util.Scanner;
import Controller.Controller;
import Model.Dao.Dao;


public class Start {

	Scanner scanner = new Scanner(System.in);
	
	// 메소드
	public static void main(String[] args) {
		// Mainpage에 있는 첫 시작 메소드 호출만

		Start start = new Start();

		start.getsingup();

	} // main 종료

	
	
	// 첫화면
	public void signup() {
		Mainpage.getInstance().signup();
	}
	
	//가입하기
	public void getsingup() {
		Mainpage.getInstance().getsingup();
	}

	// 게시판 보기
	public void board_view() {
		Mainpage.getInstance().board_view();
	}
	// 답글 보기
	public void reply_view() {
		Mainpage.getInstance().reply_view();
	}

} // class 종료




