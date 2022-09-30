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
		
		// 출력형식 불러오기 ( Console창 )
		Start start = new Start();
		start.signup();		// 회원가입
		start.regist();		// 문의글 등록
		
		
	} // main 종료
	
	// --- 회원가입 --- //
		// 회원정보 입력
	public void signup() {
		Mainpage.getInstance().signup();
	}


	// --- 게시판 --- //
	// 1. 문의글 등록
	
	public void regist() {
		Mainpage.getInstance().board();
		Mainpage.getInstance().regist();
		
	}
	
} // class 종료




