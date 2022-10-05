package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.Controller;
import Controller.WorkController;
import Model.Dao.Dao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;
import Model.Dto.WorkDto;

public class Workpage {

	// 현재 페이지 객체 선언
	private static Workpage workpage = new Workpage();
	
	// 빈생성자
	private Workpage() {
	}
	
	// 싱글톤 메소드
	public static Workpage getInstance() {
		return workpage;
	}	
	
	// 스캐너 선언	
	Scanner scanner = new Scanner(System.in);

	//////////////////////////////상담사 /////////////////////////////////////

	
	//상담사 리스트 출력
	void work() {
		while (true) {
			worklist();
			System.out.println("1.상담사 추가. 2. 상담사 삭제 0. 뒤로가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				view_regist();
			} else if (btn == 2) {
			} else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}

	//상담사 리스트
	public void worklist() {
		ArrayList<WorkDto> listworker = WorkController.getInStance().workerlist();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호\t\t\t 상담사 이름");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listworker) {
			System.out.print("  " + dto.getW_num() + "\t\t\t");
			System.out.print("  " + dto.getW_name() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
	}

	//상담사 추가
	void view_regist() {
		System.out.println(">>> 상담사 추가 ");
		System.out.print(" 이름 : ");
		String w_name = scanner.next();
		// 1. 메소드 호출[ 통신 ] 
		boolean result = WorkController.w_regist(w_name);
		// 2. 메소드 호출한 결과
		if (result) {
			System.out.println("안내) 상담사 등록 완료 ");
		} else {
			System.out.println("안내) 상담사 등록 오류 [ 관리자에게 문의 ] ");
		}
		return;
	}

	String phone1;

	void category() {
		while (true) {
			System.out.println("1.암보험 2.손해보험 3.치아보험");
			int btn = scanner.nextInt();
			if (btn == 1) {
				listinsurance();
			} else if (btn == 2) {
				listinsurance2();
			} else if (btn == 3) {
				listinsurance3();
			}
		}
	}
	
	//고객 히스토리 출력
	void c_category() {
		while (true) {
			System.out.println("1.암보험 2.손해보험 3.치아보험");
			int btn = scanner.nextInt();
			if (btn == 1) {
				c_listinsurance();
			} else if (btn == 2) {
				listinsurance2();
			} else if (btn == 3) {
				listinsurance3();
			}
		}
	}

	//암보험 리스트
	public void listinsurance() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				listadd();
				break;
			} else if (btn == 2) {
				listdelete();
				break;
			} else if (btn == 3) {
			} else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}

	// 손해보험 리스트
	public void listinsurance2() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance2();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				listadd2();
				break;
			} else if (btn == 2) {
				listdelete2();
				break;
			} else if (btn == 3) {
			} else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}

	// 치아보험 리스트
	public void listinsurance3() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance3();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				listadd3();
				break;
			} else if (btn == 2) {
				listdelete3();
				break;
			} else if (btn == 3) {
			} else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}

	// [고객] 암보험 리스트
	public void c_listinsurance() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.가입 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				c_listadd();
				break;
			}
			  else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}
	// [고객] 손해보험 리스트
	public void c_listinsurance2() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance2();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.가입 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				c_listadd();
				break;
			}
			  else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}
	// [고객] 치아보험 리스트
	public void c_listinsurance3() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().listinsurance3();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.가입 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				c_listadd();
				break;
			}
			  else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}
	}
	// [ 고객 ] history 리스트
	public void history() {
		ArrayList<WorkDto> listinsurance = WorkController.getInStance().history();
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto : listinsurance) {
			System.out.print("  " + dto.getS_num() + "\t");
			System.out.print("  " + dto.getS_name() + "\t");
			System.out.print("  " + dto.getS_text() + "\t");
			System.out.print("  " + dto.getC_num() + "\t");
			System.out.print("  " + dto.getAge() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.삭제 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				c_delete();
				break;
			} 
			 else if (btn == 0) {
			} else {
				System.out.println("잘못된 입력값 입니다.");
				break;
			}
		}
	}

	// [ 고객 ] history list 추가
	void c_listadd() {
		System.out.println("가입할 보험 번호를 입력해주세요 ");
		System.out.print(" 번호 : ");
		int choice = scanner.nextInt();
		boolean result = WorkController.c_listadd(choice);
		if (result) {
			System.out.println("안내) 암 보험 가입 완료 ");
		} else {
			System.out.println("안내) 암 보험 가입 오류 [ 관리자에게 문의 ] ");
		}
		return;
	}
	
	//[ 고객 ] history list 삭제  
	void c_delete() {
		System.out.print(" 삭제할 번호 : ");
		int delete = scanner.nextInt();
		boolean result = WorkController.c_delete(delete);
		if (result) {
			System.out.println("리스트 삭제 성공");
		} else {
			System.out.println("리스트 삭제 실패");
		}
	}
		
	//암 list 추가
   void listadd() {
      System.out.println(">>> 암 list 추가 ");
      System.out.print(" 명칭 : ");
      String s_name = scanner.next();
      System.out.print(" 내용 : ");
      String s_text = scanner.next();
      System.out.println(" 보장 나이 : ");
      int age = scanner.nextInt();
      
      boolean result = WorkController.listadd(s_name, s_text, age);
      if (result) {
         System.out.println("안내) 암 등록 완료 ");
      } else {
         System.out.println("안내) 암 등록 오류 [ 관리자에게 문의 ] ");
      }
      return;
   }

   //손해 list 추가
   void listadd2() {
      System.out.println(">>> 손해 list 추가 ");
      System.out.print(" 명칭 : ");
      String s_name = scanner.next();
      System.out.print(" 내용 : ");
      String s_text = scanner.next();
      System.out.println(" 보장 나이 : ");
      int age = scanner.nextInt();
      
      boolean result = WorkController.listadd2(s_name, s_text, age);
      if (result) {
         System.out.println("안내) 손해 등록 완료 ");
      } else {
         System.out.println("안내) 손해 등록 오류 [ 관리자에게 문의 ] ");
      }
      return;
   }
   
   //치아 list 추가
   void listadd3() {
      System.out.println(">>> 치아 list 추가 ");
      System.out.print(" 명칭 : ");
      String s_name = scanner.next();
      System.out.print(" 내용 : ");
      String s_text = scanner.next();
      System.out.println(" 보장 나이 : ");
      int age = scanner.nextInt();
      
      boolean result = WorkController.listadd3(s_name, s_text, age);
      if (result) {
         System.out.println("안내) 치아 등록 완료 ");
      } else {
         System.out.println("안내) 치아 등록 오류 [ 관리자에게 문의 ] ");
      }
      return;
   }

   //암 list 삭제  
	void listdelete() {
		System.out.print(" 삭제할 번호 : ");
		int s_num = scanner.nextInt();
		boolean result = WorkController.listdelete(s_num);
		if (result) {
			System.out.println("리스트 삭제 성공");
		} else {
			System.out.println("리스트 삭제 실패");
		}
	}

	//손해 list 삭제  
	void listdelete2() {
		System.out.print(" 삭제할 번호 : ");
		int s_num = scanner.nextInt();
		boolean result = WorkController.listdelete2(s_num);
		if (result) {
			System.out.println("리스트 삭제 성공");
		} else {
			System.out.println("리스트 삭제 실패");
		}
	}

	//치아 list 삭제  
	void listdelete3() {
		System.out.print(" 삭제할 번호 : ");
		int s_num = scanner.nextInt();
		boolean result = WorkController.listdelete3(s_num);
		if (result) {
			System.out.println("리스트 삭제 성공");
		} else {
			System.out.println("리스트 삭제 실패");
		}
	}

	// 추천보험
	public void age() {
		int birth = Integer.parseInt(phone1);
		int age = (2022 - 1900 - birth + 1);
		ArrayList<WorkDto> recommend = WorkController.getInStance().recommend(age);
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println(" 번호   \t    명칭    \t 내용    \t    금액");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		for (WorkDto dto1 : recommend) {
			System.out.print("  " + dto1.getS_num() + "\t");
			System.out.print("  " + dto1.getS_name() + "\t");
			System.out.print("  " + dto1.getS_text() + "\t");
			System.out.print("  " + dto1.getC_num() + "\t");
			System.out.println("\n-------------------------------------------------");
		}
		while (true) {
			System.out.println("1.추가 2.삭제 3.수정. 0.돌아가기");
			int btn = scanner.nextInt();
			if (btn == 1) {
				listadd2();
				break;
			} else if (btn == 2) {
				listdelete3();
				break;
			} else if (btn == 3) {
			} else if (btn == 0) {
				break;
			} else {
				System.out.println("잘못된 입력값 입니다.");
			}
		}

	} 

}
