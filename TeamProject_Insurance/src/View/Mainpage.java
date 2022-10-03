package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.Controller;
import Model.Dao.Dao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;

public class Mainpage {
	int state = 0;//로그인 상태표시
	// 현재 페이지 객체 선언
	private static Mainpage Mpage = new Mainpage();

	// 빈생성자
	private Mainpage() {
	}

	// 싱글톤 메소드
	public static Mainpage getInstance() {
		return Mpage;
	}

	// 스캐너 선언
	Scanner scanner = new Scanner(System.in);

	
/////////////// 가입하기 && 접속 경로 ///////////////////////////////////////////////////

	void getsingup() {
		 //

		while (true) {
			System.out.println(" [안내] 접속하려는 경로를 선택해주세요.\n");
			System.out.println(" 1.고객 2.보험사 : ");
			int btn = scanner.nextInt();

			if (btn == 1) { // 가입자 선택
				System.out.println("1.회원가입 2.로그인 :  ");
				int ch = scanner.nextInt();

				if (ch == 1) { // 회원가입 선택

					System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬ 회원가입 페이지 ▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

					System.out.print(" 이름[아이디] 입력: ");
					String name = scanner.next();

					System.out.print(" 비밀번호 입력: ");
					String pw = scanner.next();

					System.out.print(" 전화번호 입력: ");
					String phone = scanner.next();

					System.out.print(" 주민등록번호 입력: ");
					String ssn = scanner.next();

					boolean result = Controller.getInStance().getsingup(name, pw, phone, ssn);

					if (result) {
						System.out.println(" [안내] 회원가입이 완료되었습니다. ");
						state = 1;
					} else {
						System.out.println(" [안내] 회원가입이 실패되었습니다. ");
					}

				}
				///////////////////////////////////////////////////////////////////////////////

				if (state == 1 || ch == 2) {
					System.out.println("===============로그인 페이지===============");
					System.out.println("▬▬▬▬▬▬▬▬[안내]로그인하시겠습니까?[Y/N]▬▬▬▬▬▬▬▬");
					System.out.println("=======================================");
					String loginsign = scanner.next();
					if (loginsign.equals("Y") || loginsign.equals("y")) {
						System.out.print("이름을 입력해주세요 : ");
						String l_name = scanner.next();
						System.out.print("전화번호를 입력해주세요 : ");
						String l_phone = scanner.next();
						boolean result1 = Controller.getInStance().login(l_name, l_phone);
						if (result1) {
							System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬로그인되었습니다▬▬▬▬▬▬▬▬▬▬▬▬");
							state = 2;
								if(result1 ==true) {
									System.out.println("\t\t\t"+l_name+"님 반갑습니다.");
								}
						} else {
							System.out.println("[안내]로그인실패하였습니다.존재하지 않는 계정입니다 ");
							System.out.println("다시 선택해주세요");
							continue;
						}
					} else {
						System.out.println("[취소]처음으로 돌아갑니다.");continue;
					}
				}break;

			}
			else if (btn == 2) {}
		    else {System.out.println("경로가 없습니다.");}
		}

	} // getsingup 메소드 종료

	
	////////////////////////////////로그인이후 상태선택//////////////
	
	void loginnext() {
		while(true) {
			if(state==2) {
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬[선택이용]▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				System.out.println("[1.보험가입 2.가입한 보험내역 확인 3.게시판이용]");
				System.out.println("========[4.로그아웃][5.마이페이지]========");
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				System.out.println("선택란 : ");int ch2 = scanner.nextInt();
					if(ch2==1) {}
					else if(ch2==2){}
					else if(ch2==3) {board();}
					else if(state==2&&ch2==4) {
							System.out.println("다음에 또 만나요");
							state = 0;
							getsingup();break;}
					else if (ch2==5) {
						System.out.print("▬▬▬▬▬▬▬▬▬▬▬▬이름을 입력해주세여:▬▬▬▬▬▬▬▬▬▬▬▬");
						String name = scanner.next();
						System.out.print("▬▬▬▬▬▬▬▬▬▬▬▬비밀번호를 입력해주세요:▬▬▬▬▬▬▬▬▬");
						String pw = scanner.next();
						System.out.print("▬▬▬▬▬▬▬▬▬▬▬▬전화번호를 입력해주세요:▬▬▬▬▬▬▬▬▬");
						String phone = scanner.next();
						boolean result1 = Controller.getInStance().loginnext(name,pw,phone);
						if(result1) {
							System.out.println("[안내]확인되었습니다");
							state = 3;
						}else {System.out.println("[안내]계정인증이 잘못되었습니다");
							System.out.println("다시 입력해주세요");
							continue;
						}
					}		
					else {System.out.println("다시선택해주세요");ch2 = scanner.nextInt();}
			}
			break;
		}
		
	}
	void mypage() {
		while(true) {
			if(state ==3 ) {
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬[선택이용]▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				System.out.println("▬▬▬▬▬▬1.[회원정보수정]▬▬▬▬▬▬2.[회원탈퇴]▬▬▬▬▬▬"); 
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				try {
					int mypage = scanner.nextInt();
					if(mypage == 1) {
						System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬수정할 항목 선택▬▬▬▬▬▬▬▬▬▬▬▬");
						System.out.println("▬▬▬▬▬▬1.[이름]▬▬▬▬▬▬▬2.[비밀번호]▬▬▬▬▬▬");
						System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"); int update = scanner.nextInt();
							if(update == 1 && state == 3) {
								System.out.println("[계정 인증]변경할 계정의 전화번호를 입력해주세요"); String phone = scanner.next();
								System.out.println("변경할 이름을 입력해주세요");String update_name = scanner.next();
								
								boolean result_update = Controller.getInStance().result_update(phone, update_name);
									if(result_update) {System.out.println("수정이 완료되었습니다.");}
									else {System.out.println("전화번호가 틀렸습니다.");}
							
							}
							else if (update == 2&& state == 3) {
								System.out.println("[계정 인증]수정할 계정의 전화번호를 입력해주세요"); String phone = scanner.next();
								System.out.println("변경할 이름을 입력해주세요");String update_pw = scanner.next();
									boolean result_update_pw = Controller.getInStance().result_update(phone, update_pw);
										if(result_update_pw) {System.out.println("수정이 완료되었습니다.");}
										else {System.out.println("전화번호가 틀렸습니다.");}
							}
							else {System.out.println("선택할 수 없습니다.");}
						
					}
					else if(mypage == 2) {
						System.out.println("탈퇴할 계정의 이름을 입력해주세요"); String delete_name = scanner.next();
						System.out.println("탈퇴할 계정의 전화번호를 입력해주세요"); String delete_num = scanner.next();
						System.out.println("탈퇴할 계정의 비밀번호를 입력해주세요"); String delete_pw = scanner.next();
						System.out.println(delete_name+"님 맞습니까?");
						System.out.println("탈퇴하시겠습니까?[Y/N]"); String ch = scanner.next();
							if(ch.equals("y")|| ch.equals("Y")) {
								System.out.println("[안내]탈퇴하겠습니다.");
								boolean  delete = Controller.getInStance().delete(delete_name,delete_num);
									if(delete) {System.out.println("탈퇴가 완료되었습니다");}
									else {System.out.println("탈퇴가 실패하였습니다.[계정없음]");continue;}
								
								}else {System.out.println("취소하겠습니다");}
							}
					else {System.out.println("선택할 수 없습니다");}
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");return;
					
				}
								
				
			}
		}
		
		
	}

///////////////////////////////////////////////////

	
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
		ArrayList< BoardDto > list = Controller.getInStance().board();
		
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
		
	}
	
	// 4. 게시글 삭제
	public void delete() {
		
	}
	
	
	// 5. 게시글 상세보기
	public void board_view() {
		board();
		System.out.println(" [안내] 게시글 번호를 선택해주세요");
		int num = scanner.nextInt();
		ArrayList< BoardDto > list = Controller.getInStance().board_view(num);
		
		for( BoardDto dto : list ) {
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
			ArrayList< BoardDto > list = Controller.getInStance().reply_view();
			for( BoardDto dto : list ) {
				System.out.println(" ↪ re: " + dto.getW_reply() + "\n");
				System.out.println("\t\t\t    [" + dto.getW_name()+"]");
				System.out.println("-----------------------------------");
			} 
	} // reply_view 메소드 종료
	
	
		
		
		
		
		
		
		
		
	

} // class 종료
