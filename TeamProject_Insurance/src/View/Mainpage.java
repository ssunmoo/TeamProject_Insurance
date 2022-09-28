package View;

import java.util.Scanner;
import Controller.Controller;


public class Mainpage {
	
	// 현재 페이지 객체 선언
	private static Mainpage Mpage = new Mainpage();
	// 빈생성자
	private Mainpage() { }
	// 싱글톤 메소드
	public static Mainpage getInstance() {
		return Mpage;
	}
	
	// 스캐너 선언
	Scanner scanner = new Scanner(System.in);
		
	
	
	
	
	
	
	
	
	// --- 게시판 --- //
	// 1. 문의글 등록
	public void regist() {
		
		System.out.println("문의글 등록하기 >> ");
		System.out.println("제목 : ");
		String b_title = scanner.next();
		
		scanner.nextLine();
		System.out.println("내용 : ");
		String b_content = scanner.nextLine();
		
		System.out.println("비밀번호 : ");
		String b_pw = scanner.next();
		
	} // regist 메소드 종료
	

	
	
	
	
	
	

	
	
	
} // class 종료
