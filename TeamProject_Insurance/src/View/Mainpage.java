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
	
	
	// --- 회원가입 --- //
	public void signup() {
		int state = 0; // 
		
		while( true ) {
			System.out.println(" [안내] 접속하려는 경로를 선택해주세요.\n");
			System.out.println(" 1.고객 2.보험사 : ");
			int btn = scanner.nextInt();
				
				if( btn == 1 ) { // 가입자 선택
					System.out.println("1.회원가입 2.로그인 :  ");
					int ch = scanner.nextInt();
					
					if( ch == 1 ) { // 회원가입 선택
					
						System.out.println(" ▬▬▬▬▬▬▬▬▬▬▬▬▬▬ 회원가입 페이지 ▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				
						System.out.print(" 이름[아이디] 입력: ");
						String name = scanner.next();
						
						System.out.print(" 비밀번호 입력: ");
						String pw = scanner.next();
						
						System.out.print(" 전화번호 입력: ");
						String phone = scanner.next();
						
						System.out.print(" 주민등록번호 입력: ");
						String ssn = scanner.next();
						
						boolean result = Controller.getInStance().signup( name, pw, phone, ssn );
						
						if( result ) {
							System.out.println(" [안내] 회원가입이 완료되었습니다. "); state = 1;
						}
						else {
							System.out.println(" [안내] 회원가입이 실패되었습니다. ");
						}
						
					}
					else if( ch == 2 ) { // 로그인 선택
						
						System.out.println(" ▬▬▬▬▬▬▬▬▬▬▬▬▬▬ 로그인 페이지 ▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
						
					}
					
					else if( btn == 2 ) {} // 보험사 선택
					else { System.out.println(" [안내] 알 수 없는 번호입니다. "); }
				
				} // if end
				
		}// while end
				
	} // signup end
	
	
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
		String name = scanner.next();
		
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

