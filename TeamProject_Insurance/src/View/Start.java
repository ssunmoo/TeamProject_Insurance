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

	// --- 게시판 --- //
	// 1. 문의글 등록
	
//	public void regist() {
//		Mainpage.getInstance().board();
//		getsingup();
//		Mainpage.getInstance().regist();
//	}
	
	//가입하기
	public void getsingup() {
		Mainpage.getInstance().getsingup();
	}
	
	
	
	
	
} // class 종료




