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

	
	// ---가입하기 && 접속 경로 --- //

	void getsingup() {

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

					boolean result = Controller.getInStance().getsingup( name, pw, phone, ssn );

					if (result) {
						System.out.println(" [안내] 회원가입이 완료되었습니다. ");
						state = 1;
					} else {
						System.err.println(" [안내] 회원가입이 실패되었습니다. ");
					}
				} // ch 1 회원가입 if 종료
			
				////////////////////////////////////로그인///////////////////////////////////////////

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
							System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬로그인 되었습니다▬▬▬▬▬▬▬▬▬▬▬▬");
							state = 2;
								if(result1 ==true) {
									System.out.println("\t\t\t"+l_name+"님 반갑습니다.");
									loginnext();
								}
						} else {
							System.err.println("[안내]로그인 실패하였습니다.존재하지 않는 계정입니다 ");
							System.out.println("다시 선택해주세요");
							continue;
						}
					} else {
						System.err.println("[취소] 알 수 없는 실행입니다.");continue;
					}
				} break;
			}

			else if (btn == 2) {
				while( true ) {
					System.out.println(" 1. 게시판 확인  2. 상담사 관리 3. 보험내역 관리 4. 가입내역 확인");
					int menu_ch = scanner.nextInt();
					
					if ( menu_ch == 1 ) {
						Boardpage.getInstance().board_view();
						continue;
					}
					else if ( menu_ch == 2 ) {
						// 상담사 관리 메소드
						continue;
					}
					else if ( menu_ch == 3 ) {
						// 보험내역 관리 메소드
						continue;
					}
					else if ( menu_ch == 4 ) {
						// 가입내역 확인 메소드
						continue;
					}
					else {
						System.err.println(" ▶ [오류] 잘못된 번호입니다.");
						
					}
				} // while 종료
			} else {
				System.err.println("▶ [오류] 잘못된 번호입니다.");
			}
			
			
		} // while 종료
	} // getsingup 메소드 종료

	
	// ---로그인 후 보험가입 & 마이페이지 --- //
	
	void loginnext() {
		while(true) {
			if(state==2) {
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬[선택이용]▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				System.out.println("[1.보험가입 2.가입한 보험내역 확인 3.게시판이용]");
				System.out.println("========[4.로그아웃][5.마이페이지]========");
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

				System.out.println("선택 ▶  ");int ch2 = scanner.nextInt();
					if(ch2==1) {
						list();
					}
					else if(ch2==2){myinsurance();}
					else if(ch2==3) {
						
						Boardpage.getInstance().board();
						System.out.println();
						System.out.println("1. 문의글 등록  2. 문의글 수정 3. 문의글 삭제");
						int board_ch = scanner.nextInt();
						
						if( board_ch == 1 ) {
							System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 등록하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
							Boardpage.getInstance().regist();
						}
						else if ( board_ch == 2 ){
							System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 수정하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
							Boardpage.getInstance().update();
						}
						else if ( board_ch == 3 ) {
							System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 삭제하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
							Boardpage.getInstance().delete();
						}
					} // ch2 == 3 종료
					else if(state==2&&ch2==4) {
						System.out.println("다음에 또 만나요");
						state = 0;
						getsingup();break;}
				else if (ch2==5) {
						System.out.print("이름을 입력해주세여:");
						String name = scanner.next();
						System.out.print("비밀번호를 입력해주세요:");
						String pw = scanner.next();
						System.out.print("전화번호를 입력해주세요:");
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
		} // while 종료
	} // loginnext 메소드 종료
	
	
	//////////////////////보험가입////////////////////////
	void list() {
		while( true ) {
			System.out.println("[안내] 가입하려는 보험의 카테고리를 선택해주세요 ");
			System.out.println("1.암보험 2.종합보험 3.운전자보험 4.치아보험 : ");
			int cl = scanner.nextInt();
			if( cl == 1 ) {
			
			}
			else if( cl == 2 ) {
				
			}
			else if( cl == 3 ) {
				
			}
			else if( cl == 4 ) {
			}
			else { System.err.println("알 수 없는 번호입니다."); }
			
			ArrayList< Dto> list = Controller.getInStance().list();
		}
	}
	

	//////////////////////////////////////////////수정&탈퇴///////////////////////////////

	void mypage() {
		while(true) {
			if(state == 3 ) {
				System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬[선택이용]▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				System.out.println("==1.[회원정보수정]=============2.[회원탈퇴]=="); 
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
									else {System.err.println("전화번호가 틀렸습니다.");}
							
							}
							else if (update == 2&& state == 3) {
								System.out.println("[계정 인증]수정할 계정의 전화번호를 입력해주세요"); String phone = scanner.next();
								System.out.println("변경할 이름을 입력해주세요");String update_pw = scanner.next();
									boolean result_update_pw = Controller.getInStance().result_update(phone, update_pw);
										if(result_update_pw) {System.out.println("수정이 완료되었습니다.");}
										else {System.err.println("전화번호가 틀렸습니다.");}
							}
							else {System.out.println("선택할 수 없습니다.");}
						
					} // mypage == 1 if 종료
					else if(mypage == 2) {
						System.out.println("탈퇴할 계정의 이름을 입력해주세요"); String delete_name = scanner.next();
						System.out.println("탈퇴할 계정의 전화번호를 입력해주세요"); String delete_num = scanner.next();
						System.out.println("탈퇴할 계정의 비밀번호를 입력해주세요"); String delete_pw = scanner.next();
						System.out.println(delete_name+"님 맞습니까?");
						System.out.println("탈퇴 하시겠습니까?[Y/N]"); String ch = scanner.next();
							if(ch.equals("y")|| ch.equals("Y")) {
								System.out.println("[안내] 탈퇴하겠습니다.");
								boolean  delete = Controller.getInStance().delete(delete_name,delete_num);

									if(delete) {System.out.println("탈퇴가 완료되었습니다");
												System.out.println("메인화면으로 넘어갑니다.");
												getsingup();
									}
									
									else {System.out.println("탈퇴가 실패하였습니다.[계정없음]");continue;}

								}else {System.out.println("취소하겠습니다");}
							}
					else{System.out.println("선택할 수 없습니다");}
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");return;
					
				}
			} // state == 3 if 종료
		} // while 종료
	} // mypage 메소드 종료


///////////////////////////////////보험 내역 확인//////////////////////////////////////////////////
	void myinsurance() {
		while(true) {
			
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬가입된 보험 리스트▬▬▬▬▬▬▬▬▬▬▬▬▬");
			System.out.println("순서\t"+"\t종류\t\t담당상담사");
			
			
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
			System.out.println("확인할 보험을 선택해주세요"); int choice = scanner.nextInt();
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
				
			}
		
	}
	
	

		
		
		
		
		
		
	

} // class 종료
