package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.Controller;
import Model.Dao.Dao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;
import Model.Dto.WorkDto;

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
					phone1 = phone;

					System.out.print(" 주민등록번호 입력: ");
					String ssn = scanner.next();

					boolean result = Controller.getInStance().getsingup( name, pw, phone, ssn );

					if (result) {
						System.out.println(" [안내] 회원가입이 완료되었습니다. ");
						state = 1;
					} else {
						System.out.println(" [안내] 회원가입이 실패되었습니다. ");
					}

				} // ch 1 회원가입 if 종료
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
				} break;
			}

			else if (btn == 2) {
				board();
				System.out.println();
				System.out.println("1. 문의글 등록  2. 문의글 수정 3. 문의글 삭제");
				int board_ch = scanner.nextInt();
				
				if( board_ch == 1 ) {
					System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 등록하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
					regist();
				}
				else if ( board_ch == 2 ){
					System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 수정하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
					update();
				}
				else if ( board_ch == 3 ) {
					System.out.println("▬▬▬▬▬▬▬▬▬▬▬ 문의글 삭제하기 ▬▬▬▬▬▬▬▬▬▬▬\n");
					delete();
				}
				else {
					System.out.println(" ▶ [오류] 잘못된 번호입니다.");
				}
			} else {
				System.out.println("경로가 없습니다.");
			}
		} // while 종료
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
		} // while 종료
	} // loginnext 메소드 종료
	
	void mypage() {
		while(true) {
			if(state == 3 ) {
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
						
					} // mypage == 1 if 종료
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
							} // mypage == 2 if 종료
					else {System.out.println("선택할 수 없습니다");}
				} catch (Exception e) {
					System.out.println("숫자를 입력해주세요");return;
					
				}
			} // state == 3 if 종료
		} // while 종료
	} // mypage 메소드 종료

///////////////////////////////////////////////////

	
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
		
		boolean result = Controller.getInStance().regist( b_title, b_content, phone, b_pw );
		
		if( result ) {
			System.out.println(" ▶ [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" ▶ [안내] 문의글 등록이 실패하였습니다 ");	
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
			boolean result = Controller.getInStance().update( b_num, b_title, b_content, b_pw );
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
			boolean result = Controller.getInStance().delete( b_num, pw );
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
		
		System.out.println(" ▶ [안내] 게시글 번호를 선택해주세요");
		int b_num = scanner.nextInt();
		selectNum = b_num;	// 다른 메소드 사용하기위해..
		
		BoardDto dto = Controller.getInStance().board_view(b_num);
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
		
		boolean result = Controller.getInStance().reply( w_reply , w_name, selectNum );
		
		if( result ) {
			System.out.println(" ▶ [안내] 문의글 등록이 완료되었습니다. ");
		}
		else {
			System.out.println(" ▶ [안내] 문의글 등록이 실패하였습니다 ");	
		}
		
		
	} // reply 종료
	
	// 7. 상담사 답글 보기
		public void reply_view( int b_num ) {
			ArrayList< BoardDto > list = Controller.getInStance().reply_view( b_num );
			for( BoardDto dto : list ) {
				System.out.println(" ↪ re: " + dto.getW_reply() + "\n");
				System.out.println("\t\t\t    [" + dto.getW_name()+"]");
				System.out.println("-----------------------------------");
			} 
	} // reply_view 메소드 종료
	
		
////////////////////////////// 상담사 /////////////////////////////////////
////////////////////////////// 상담사 /////////////////////////////////////
////////////////////////////// 상담사 /////////////////////////////////////
////////////////////////////// 상담사 /////////////////////////////////////


// 상담사 리스트 출력
void work() {
	while(true) {
	worklist();
	System.out.println("1.상담사 추가. 2. 상담사 삭제 0. 뒤로가기" );
	int btn = scanner.nextInt();
	if		( btn == 1 ) { view_regist(); }
	else if ( btn == 2 ) { }
	else if ( btn == 0 ) { break;}
	else 				 {System.out.println("잘못된 입력값 입니다.");}
	}
}


// 상담사 리스트
public void worklist() {
	ArrayList< WorkDto > listworker = Controller.getInStance().workerlist();
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	System.out.println(" 번호\t\t\t 상담사 이름");
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	for( WorkDto dto : listworker ) {
	System.out.print("  "+ dto.getW_num() + "\t\t\t");
	System.out.print("  "+ dto.getW_name() + "\t");
	System.out.println("\n-------------------------------------------------");
	}
}



// 상담사 추가
void view_regist() { 
	System.out.println(">>> 상담사 추가 "); 
	System.out.print(" 이름 : "); 		String w_name = scanner.next();
	// 1. 메소드 호출[ 통신 ] 
	boolean result = Controller.w_regist( w_name );
	// 2. 메소드 호출한 결과
	if( result ) {
	System.out.println("안내) 상담사 등록 완료 ");
	}else {
	System.out.println("안내) 상담사 등록 오류 [ 관리자에게 문의 ] ");
	}
	return;
}




////////////////////////////// 보험 ////////////////////////////////////
////////////////////////////// 보험 /////////////////////////////////////
////////////////////////////// 보험 /////////////////////////////////////
////////////////////////////// 보험 /////////////////////////////////////
String phone1;
// 보험 리스트 출력
// 보험 리스트 출력
// 보험 리스트 출력
void category() {
	while(true) {
	System.out.println("1.암보험 2.손해보험 3.치아보험");
	int btn = scanner.nextInt();
	if( btn == 1 ) 		{ listinsurance(); }
	else if( btn == 2 ) { listinsurance2();}
	else if( btn == 3 ) { listinsurance3();}
	}
}

// 암보험 리스트
public void listinsurance() {
	ArrayList< WorkDto > listinsurance = Controller.getInStance().listinsurance();
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	for( WorkDto dto : listinsurance ) {
	System.out.print("  "+ dto.getS_num() + "\t");
	System.out.print("  "+ dto.getS_name() + "\t");
	System.out.print("  "+ dto.getS_text() + "\t");
	System.out.print("  "+ dto.getC_num() + "\t");
	System.out.print("  "+ dto.getAge() + "\t");
	System.out.println("\n-------------------------------------------------");
	}
	while(true) {
	System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
	int btn = scanner.nextInt();
	if		( btn == 1 ) { listadd();	 break; }
	else if ( btn == 2 ) { listdelete(); break; }
	else if ( btn == 3 ) { }
	else if ( btn == 0 ) { break;}
	else 				 {System.out.println("잘못된 입력값 입니다.");}
	}
}

// 손해보험 리스트
public void listinsurance2() {
	ArrayList< WorkDto > listinsurance = Controller.getInStance().listinsurance2();
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	for( WorkDto dto : listinsurance ) {
	System.out.print("  "+ dto.getS_num() + "\t");
	System.out.print("  "+ dto.getS_name() + "\t");
	System.out.print("  "+ dto.getS_text() + "\t");
	System.out.print("  "+ dto.getC_num() + "\t");
	System.out.println("\n-------------------------------------------------");
	}
	while(true) {
	System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
	int btn = scanner.nextInt();
	if		( btn == 1 ) { listadd2(); break; }
	else if ( btn == 2 ) { listdelete3(); break;}
	else if ( btn == 3 ) { }
	else if ( btn == 0 ) { break;}
	else 				 {System.out.println("잘못된 입력값 입니다.");}
	}
}

// 치아보험 리스트
public void listinsurance3() {
	ArrayList< WorkDto > listinsurance = Controller.getInStance().listinsurance3();
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
	System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	for( WorkDto dto : listinsurance ) {
	System.out.print("  "+ dto.getS_num() + "\t");
	System.out.print("  "+ dto.getS_name() + "\t");
	System.out.print("  "+ dto.getS_text() + "\t");
	System.out.print("  "+ dto.getC_num() + "\t");
	System.out.println("\n-------------------------------------------------");
	}
	while(true) {
	System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
	int btn = scanner.nextInt();
	if	    ( btn == 1 ) { listadd3(); break; }
	else if ( btn == 2 ) { listdelete3(); break;}
	else if ( btn == 3 ) { }
	else if ( btn == 0 ) { break;}
	else 				 {System.out.println("잘못된 입력값 입니다.");}
	}
}

// 암 list 추가
void listadd() {
	System.out.println(">>> 암 list 추가 "); 
	System.out.print(" 명칭 : "); 		String s_name = scanner.next();
	System.out.print(" 내용 : "); 		String s_text = scanner.next();		
	boolean result = Controller.listadd( s_name, s_text);
	if( result ) {System.out.println("안내) 암 등록 완료 ");}
	else 		 {System.out.println("안내) 암 등록 오류 [ 관리자에게 문의 ] ");}
	return;
}
// 손해 list 추가
void listadd2() { 
	System.out.println(">>> 손해 list 추가 "); 
	System.out.print(" 명칭 : "); 		String s_name = scanner.next();
	System.out.print(" 내용 : "); 		String s_text = scanner.next();		
	boolean result = Controller.listadd2( s_name, s_text );
	if( result ) {System.out.println("안내) 손해 등록 완료 ");}
	else 		 {System.out.println("안내) 손해 등록 오류 [ 관리자에게 문의 ] ");}
	return;
}
// 치아 list 추가
void listadd3() { 
	System.out.println(">>> 치아 list 추가 "); 
	System.out.print(" 명칭 : "); 		String s_name = scanner.next();
	System.out.print(" 내용 : "); 		String s_text = scanner.next();		
	boolean result = Controller.listadd3( s_name, s_text );
	if( result ) {System.out.println("안내) 치아 등록 완료 ");}
	else 		 {System.out.println("안내) 치아 등록 오류 [ 관리자에게 문의 ] ");}
	return;
}

// 암 list 삭제  
void listdelete( ) { 
	System.out.print(" 삭제할 번호 : "); 	int s_num = scanner.nextInt();
	boolean result = Controller.listdelete( s_num );
	if( result  ) { System.out.println("리스트 삭제 성공");}
	else 		  { System.out.println("리스트 삭제 실패");}	}
// 손해 list 삭제  
void listdelete2( ) { 
	System.out.print(" 삭제할 번호 : "); 	int s_num = scanner.nextInt();
	boolean result = Controller.listdelete2( s_num );
	if( result  ) { System.out.println("리스트 삭제 성공");}
	else 		  { System.out.println("리스트 삭제 실패");}	}

// 치아 list 삭제  
void listdelete3( ) { 
	System.out.print(" 삭제할 번호 : "); 	int s_num = scanner.nextInt();
	boolean result = Controller.listdelete3( s_num );
	if( result  ) { System.out.println("리스트 삭제 성공");}
	else 		  { System.out.println("리스트 삭제 실패");}	}
	
		
	// 추천보험
	public void age() {
		int birth = Integer.parseInt(phone1);
		int age = (2022-1900-birth+1);
		ArrayList< WorkDto > recommend = Controller.getInStance().recommend(age);
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for( WorkDto dto1 : recommend ) {
		System.out.print("  "+ dto1.getS_num() + "\t");
		System.out.print("  "+ dto1.getS_name() + "\t");
		System.out.print("  "+ dto1.getS_text() + "\t");
		System.out.print("  "+ dto1.getC_num() + "\t");
		System.out.println("\n-------------------------------------------------");
		}
		while(true) {
			System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
			int btn = scanner.nextInt();
			if		( btn == 1 ) { listadd2(); break; }
			else if ( btn == 2 ) { listdelete3(); break;}
			else if ( btn == 3 ) { }
			else if ( btn == 0 ) { break;}
			else 				 {System.out.println("잘못된 입력값 입니다.");}
			}
		
	
		
	} // board_view 메소드 종료
	
		
		
		
		
		
		
	

} // class 종료
