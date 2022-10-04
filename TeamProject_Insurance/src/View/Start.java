package View;

import java.util.Scanner;
import Controller.Controller;
import Model.Dao.Dao;


public class Start {

	Scanner scanner = new Scanner(System.in);
	
	// 메인 머지 후 메인 당겨옴 220930_19:41
	
	// 메소드
	public static void main(String[] args) {
		// Mainpage에 있는 첫 시작 메소드 호출만

		Start start = new Start();
		//start.board();
		//start.board_view();
		start.work();

	} // main 종료
	
	
	
	// 첫화면
	public void signup() {
		Mainpage.getInstance().getsingup();
	}
	
	//가입하기 및 로그인
	public void getsingup() {
		Mainpage.getInstance().getsingup();
		loginnext();
	}
	//로그인후 상태
	public void loginnext() {
		Mainpage.getInstance().loginnext();
		Mainpage.getInstance().mypage();
	}
	
	
	
	// 게시판 보기
	public void board() {
		Mainpage.getInstance().board();
		Mainpage.getInstance().regist();
	}
	
	// 게시판 상세 보기
	public void board_view() {
		Mainpage.getInstance().board_view();
	}
	// 답글 보기
	public void reply_view() {
		Mainpage.getInstance().reply_view( 0 );
	}
	
	
	
	public void work() {
		Mainpage.getInstance().age();
		Mainpage.getInstance().category();
	}
	
	public void category() {
		Mainpage.getInstance().category();
	}

} // class 종료




