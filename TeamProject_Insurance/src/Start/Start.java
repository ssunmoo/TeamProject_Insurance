package Start;

import java.util.Scanner;
import View.Mainpage;


public class Start {

	Scanner scanner = new Scanner(System.in);
	
	// 메소드
	public static void main(String[] args) {
		// Mainpage에 있는 첫 시작 메소드 호출만
		// Mainpage.getInstance().index();

		Start member = new Start();
		member.signup();
	}
	
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
				if( ch == 2 ) { System.out.println(" tjsxor ");}
				
				else{ System.out.println("알 수 없는 번호입니다."); }
			 // if
				
		} // while end
		
	} // signup end


	
} // class 종료
