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
		//start.board();
		//start.board_view();
		start.getsingup();

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
		Mainpage.getInstance().list();
	}
	
	// 게시판 보기
	public void board() {
		Boardpage.getInstance().board();
		Boardpage.getInstance().regist();
	}
	
	// 게시판 상세 보기
	public void board_view() {
		Boardpage.getInstance().board_view();
	}
	// 답글 보기
	public void reply_view() {
		Boardpage.getInstance().reply_view( 0 );
	}

	//////////////////////////////////////////////////////////////
	
	// 상담사 리스트
	public void worklist() {
		Workpage.getInstance().worklist();
	}
	// 상담사 추가
	public void view_regist() {
		Workpage.getInstance().view_regist();
	}

	//////////////////////////////////////////////////////////////
	// 보험리스트 출력
	
	//암보험 리스트
	public void listinsurance() {
		Workpage.getInstance().listinsurance();
	}
	//손해보험 리스트
	public void listinsurance2() {
		Workpage.getInstance().listinsurance2();
	}
	//치아보험 리스트
	public void listinsurance3() {
		Workpage.getInstance().listinsurance3();
	}
	//암 리스트
	public void listadd() {
		Workpage.getInstance().listadd( );
	}
	//손해 리스트
	public void listadd2() {
		Workpage.getInstance().listadd2();
	}
	//치아 리스트
	public void listadd3() {
		Workpage.getInstance().listadd3();
	}
	
	//암 리스트 삭제
	public void listdelete() {
		Workpage.getInstance().listdelete();
	}
	//손해 리스트 삭제
	public void listdelete2() {
		Workpage.getInstance().listdelete2();
	}
	//치아 리스트 삭제
	public void listdelete3() {
		Workpage.getInstance().listdelete3();
	}
	
	// 추천
	public void age() {
		Workpage.getInstance().age();
	}

} // class 종료




