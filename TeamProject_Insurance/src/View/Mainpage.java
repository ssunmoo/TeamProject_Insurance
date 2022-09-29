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
	
	
	
	
	
	///////////////가입하기 && 접속 경
	
		void getsingup() {
			int state = 0;
			while(true) {
			System.out.println("\t[안내]\t접속하려고 하는 경로를 선택해주세요\n");
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬1.고객▬▬▬▬▬▬▬2.보험사▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"); int user = scanner.nextInt();
			if(user ==1 ) {
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬1.가입하기 ____ 2.로그인하기▬▬▬▬▬▬▬▬▬▬▬▬▬▬"); int singup = scanner.nextInt();
				if(singup == 1) {
				System.out.print("성명을 작성 : ");		String name = scanner.next();
				System.out.print("비밀번호 작성 : ");		String pw = scanner.next();
				System.out.print("전화번호 작성: ");		String phone = scanner.next();
				System.out.print("주민등록번호 작성 : ");	String ssn = scanner.next();
				
				boolean result= Controller. getInStance().getsingup(name,pw,phone,ssn);
				
					if(result){System.out.println("가입성공하였습니다"); state = 1;}
					
					else {System.out.println("가입실패");}//가입 실패시
				}
				
				
				if(state == 1) { 
					System.out.println("로그인하시겠습니까?[Y/N]"); String loginsign = scanner.next();
						if(singup ==2 || loginsign=="Y"&&loginsign=="y"){
							System.out.println("이름 : ");	String l_name = scanner.next();
							System.out.print("전화번호 : ");	String l_phone = scanner.next();
						
						}
			 		else {System.out.println("처음으로 돌아갑니다.");}
						
				}
			}
			
			else if(user == 2) {}
			else {System.out.println("경로가 없습니다.");}
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class 종료

