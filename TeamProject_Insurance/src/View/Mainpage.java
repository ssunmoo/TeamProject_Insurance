package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Controller;
import Model.Dao.Dao;
import Model.Dto.Dto;


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
	
		System.out.println();
		System.out.println("문의글 등록하기 ▶ ");
		
		System.out.println("제목 : ");
		String b_title = scanner.next();
		
		scanner.nextLine();
		System.out.println("내용 : ");
		String b_content = scanner.nextLine();
		
		System.out.println("이름 : ");
		String name = scanner.nextLine();
		
		System.out.println("연락처 : ");
		String phone = scanner.next();
		
		System.out.println("비밀번호 : ");
		String b_pw = scanner.next();
		
		boolean result = Controller.getInStance().regist( b_title, b_content, name, phone, b_pw );
		
		if( result ) {
			System.out.println(" [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" [안내] 문의글 등록이 실패하였습니다 ");	
		}
		
	} // regist 메소드 종료
	
	
	// 2. 게시판 보기
	public void board() {
		ArrayList< Dto > list = Controller.getInStance().board();
		
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호\t제목\t내용\t\t이름\t연락처");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for( Dto dto : list ) {
			System.out.print("  "+ dto.getB_num() + "\t");
			System.out.print(dto.getB_title() + "\t");
			System.out.print(dto.getB_content() + "\t\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getPhone() + "\t\n");
			System.out.println("-------------------------------------------------");
		}
		
	} // board 메소드 종료
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class 종료

