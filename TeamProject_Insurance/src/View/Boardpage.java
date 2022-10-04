package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.BoardController;
import Controller.Controller;
import Model.Dto.BoardDto;

public class Boardpage {

	// 현재 페이지 객체 선언
	private static Boardpage boardpage = new Boardpage();

	// 빈생성자
	private Boardpage() {
	}

	// 싱글톤 메소드
	public static Boardpage getInstance() {
		return boardpage;
	}

	// 스캐너 선언
	Scanner scanner = new Scanner(System.in);
	
	// --- 게시판 --- //
	
	int selectNum = 0;
	
	// 1. 문의글 등록
	public void regist() {
		
		System.out.println(" 제목 : ");
		String b_title = scanner.next();
		
		scanner.nextLine();
		System.out.println(" 내용 : ");
		String b_content = scanner.nextLine();
		
		System.out.println(" 연락처 : ");
		String phone = scanner.next();
		System.out.println( phone );
		
		System.out.println(" 비밀번호 : ");
		String b_pw = scanner.next();
		System.out.println( b_pw );
		
		boolean result = BoardController.getInStance().regist( b_title, b_content, phone, b_pw );
		
		if( result ) {
			System.out.println(" ▶ [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" ▶ [안내] 문의글 등록이 실패하였습니다 ");	
		}
		
	} // regist 메소드 종료

	
	// 2. 게시판 보기
	public void board() {
		ArrayList< BoardDto > list = BoardController.getInStance().board();
		
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호\t제목\t이름\t연락처");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for( BoardDto dto : list ) {
		
			System.out.print("  "+ dto.getB_num() + "\t");
			System.out.print(dto.getB_title() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getPhone() + "\t");
			System.out.println("\n-----------------------------------");
		}
	} // board 메소드 종료
	
	
	// 3. 게시글 수정
	public void update() {
		System.out.println(" ▶ [안내] 수정할 게시글을 선택해주세요");
		int b_num = scanner.nextInt();
		
		System.out.println(" ▶ [안내] 비밀번호를 입력해주세요");
		String b_pw = scanner.next();
		
		System.out.println(" ▶ [안내] 수정할 제목을 입력해주세요");
		String b_title = scanner.next();
		
		System.out.println(" ▶ [안내] 수정할 내용을 입력해주세요");
		String b_content = scanner.next();
		
		BoardDto dto = new BoardDto(b_num, b_title, b_content, b_pw);
		if ( dto.getB_pw().equals(b_pw) ) {
			boolean result = BoardController.getInStance().update( b_num, b_title, b_content, b_pw );
			if( result ) {
				System.out.println(" ▶ [안내] 게시글 수정이 완료되었습니다. ");
			}
			else {
				System.out.println(" ▶ [오류] 게시글 수정 오류입니다.");
			}
		}
		else {
			System.out.println(" ▶ [오류] 비밀번호가 틀렸습니다. ");
		}
	} // update 메소드 종료
		
	
	// 4. 게시글 삭제
	public void delete() {
		System.out.println(" ▶ [안내] 삭제할 게시글을 선택해주세요");
		int b_num = scanner.nextInt();
		
		System.out.println(" ▶ [안내] 비밀번호를 입력해주세요");
		String pw = scanner.next();
		
		BoardDto dto = new BoardDto( b_num, pw );
		if ( dto.getB_pw().equals(pw) ) {
			boolean result = BoardController.getInStance().delete( b_num, pw );
			if( result ) {
				System.out.println(" ▶ [안내] 게시글이 삭제 되었습니다. ");
			}
			else {
				System.out.println(" ▶ [오류] 게시글 삭제 오류입니다.");
			}
		}
		else {
			System.out.println(" ▶ [오류] 비밀번호가 틀렸습니다. ");
		}
	} // delete 메소드 종료
	
	
	// 5. 게시글 상세보기
	public void board_view() {
		board();
		
		System.out.println(" ▶ [안내] 확인할 게시글 번호를 선택해주세요");
		int b_num = scanner.nextInt();
		selectNum = b_num;	// 다른 메소드 사용하기위해..
		
		BoardDto dto = BoardController.getInStance().board_view(b_num);
		if( dto == null ) {
			System.out.println(" ▶ [안내] 게시글이 없습니다");
			return;
		}
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 제목 : " + dto.getB_title());
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 내용 : " + dto.getB_content() + "\n");
		System.out.println("\n-----------------------------------");

		
		reply_view(b_num);
		System.out.println("1. 답글 등록하기 2. 돌아가기");
		int ch = scanner.nextInt();
		if( ch == 1 ) {
			reply();
		}
		else if ( ch == 2) {
			return;
		}
		else {
			System.out.println(" ▶ [안내] 잘못된 번호입니다 다시 선택해 주세요");
		}
	} // board_view 메소드 종료
	
	
	// 6. 상담사 답글 쓰기
	public void reply() {
		scanner.nextLine();
		System.out.println("답글 내용 : ");
		String w_reply = scanner.nextLine();
		
		System.out.println("상담사 이름 :");
		String w_name = scanner.next();
		
		boolean result = BoardController.getInStance().reply( w_reply , w_name, selectNum ); 
		
		if( result ) {
			System.out.println(" ▶ [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" ▶ [안내] 문의글 등록이 실패하였습니다 ");	
		}
	} // reply 종료
	
	// 7. 상담사 답글 보기
		public void reply_view( int b_num ) {
			ArrayList< BoardDto > list = BoardController.getInStance().reply_view( b_num );
			for( BoardDto dto : list ) {
				System.out.println(" ↪ re: " + dto.getW_reply() + "\n");
				System.out.println("\t\t\t    [" + dto.getW_name()+"]");
				System.out.println("-----------------------------------");
			} 
	} // reply_view 메소드 종료
	
}
