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
	
	
	
	
	
	//  --- 첫화면 --- // 
	
	// 선택
		void signup() {
			while( true ) {
				System.out.print("1.가입자 2.보험사 : ");
					int ch = scanner.nextInt();
					if( ch == 1 ) {
						System.out.println("이름 : ");		String name = scanner.next();
						System.out.println("비밀번호 : ");	String pw = scanner.next();
						System.out.print("전화번호 : ");		String phone = scanner.next();
						System.out.println("주민등록번호 : ");	String ssn = scanner.next();
						break;} 
					if( ch == 2 ) { 
						System.out.println(" ★★★ 보험사 ★★★ ");
						
						System.out.println("1. 게시판보기 2. 상담사관리 3. 보험내역관리 4. 가입자내역확인 ");
						int select = scanner.nextInt();
						
						if ( select == 1 ) {
							Mainpage.getInstance().board(); // 게시판 불러오기
							Mainpage.getInstance().board_view();
							
							
						}

						else if ( select == 2 ) {
							
						}
						
						else if ( select == 3 ) {
							
						}
						
						else if ( select == 4 ) {
							
						}
						
						else {
							System.out.println(" [안내] 잘못된 번호입니다 다시 선택해 주세요");
							continue;
						}
						
					}
					
					else{ System.out.println(" [안내] 잘못된 번호입니다 다시 선택해 주세요"); }
				 // if
					
			} // while end
			
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
		
		System.out.println("연락처 : ");
		String phone = scanner.next();
		System.out.println( phone );
		
		System.out.println("비밀번호 : ");
		String b_pw = scanner.next();
		System.out.println( b_pw );
		
		boolean result = Controller.getInStance().regist( b_title, b_content, phone, b_pw );
		
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
		
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호\t제목\t이름\t연락처");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for( Dto dto : list ) {
			System.out.print("  "+ dto.getB_num() + "\t");
			System.out.print(dto.getB_title() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getPhone() + "\t");
			System.out.println("\n-----------------------------------");
		}
	} // board 메소드 종료
	
	
	// 3. 게시글 수정
	public void update() {
		
	}
	
	// 4. 게시글 삭제
	public void delete() {
		
	}
	
	
	// 5. 게시글 상세보기
	public void board_view() {
		System.out.println("게시글 번호를 선택해주세요");
		int num = scanner.nextInt();
		ArrayList< Dto > list = Controller.getInStance().board_view(num);
		
		for( Dto dto : list ) {
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
			System.out.println(" 제목 : " + dto.getB_title());
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
			System.out.println(" 내용 : " + dto.getB_content() + "\n");
			System.out.println("\n-----------------------------------");
		}
		
		reply_view();
		System.out.println("1. 답글 등록하기 2. 돌아가기");
		int ch = scanner.nextInt();
		if( ch == 1 ) {
			reply();
		}
		else if ( ch == 2) {
			return;
		}
		else {
			System.out.println(" [안내] 잘못된 번호입니다 다시 선택해 주세요");
		}
	} // board_view 메소드 종료
	
	
	// 6. 상담사 답글 쓰기
	public void reply() {
		scanner.nextLine();
		System.out.println("답글 내용 : ");
		String w_reply = scanner.nextLine();
		System.out.println("상담사 이름 :");
		String w_name = scanner.next();
		
		boolean result = Controller.getInStance().reply( w_reply );
		
		if( result ) {
			System.out.println(" [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" [안내] 문의글 등록이 실패하였습니다 ");	
		}
	} // reply 종료
	
	// 7. 상담사 답글 보기
	public void reply_view() {
		ArrayList< Dto > list = Controller.getInStance().reply_view();
		for( Dto dto : list ) {
			System.out.println(" ↪ re: " + dto.getW_reply() + "\n");
			System.out.println("\t\t\t    [" + dto.getW_name()+"]");
			System.out.println("-----------------------------------");
		} 
	} // reply_view 메소드 종료
	
	
	
	
	
	
	
	
	
} // class 종료

