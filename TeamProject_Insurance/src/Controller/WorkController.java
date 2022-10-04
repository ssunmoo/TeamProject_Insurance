package Controller;

import java.util.ArrayList;
import Model.Dao.Dao;
import Model.Dao.WorkDao;
import Model.Dto.BoardDto;
import Model.Dto.Dto;
import Model.Dto.WorkDto;

public class WorkController {

	// 현재 페이지 객체 선언
	private static WorkController workController = new WorkController();

	// 빈생성자
	private WorkController() {
	}

	// 싱글톤 메소드
	public static WorkController getInStance() {
		return workController;
	}

	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////

	// 상담사 리스트 보기
	public ArrayList<WorkDto> workerlist() {
		return WorkDao.getInstance().workerlist();
	}

	// 상담사 추가
	public static boolean w_regist(String w_name) {
		return WorkDao.getInstance().w_regist(w_name);
	}
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////

	// 보험 리스트
	// 암
	public ArrayList<WorkDto> listinsurance() {
		return WorkDao.getInstance().listinsurance();
	}

	// 손해
	public ArrayList<WorkDto> listinsurance2() {
		return WorkDao.getInstance().listinsurance2();
	}

	// 치아
	public ArrayList<WorkDto> listinsurance3() {
		return WorkDao.getInstance().listinsurance3();
	}

	// 암 리스트 추가
	public static boolean listadd(String s_name, String s_text, int age ) {
		return WorkDao.getInstance().listadd(s_name, s_text, age);
	}

	// 손해 리스트 추가
	public static boolean listadd2(String s_name, String s_text, int age) {
		return WorkDao.getInstance().listadd2(s_name, s_text, age);
	}

	// 치아 리스트 추가
	public static boolean listadd3(String s_name, String s_text, int age) {
		return WorkDao.getInstance().listadd3(s_name, s_text, age);
	}

	// 암 list 삭제
	public static boolean listdelete(int s_num) {
		return WorkDao.getInstance().listdelete(s_num);
	}

	// 손해 list 삭제
	public static boolean listdelete2(int s_num) {
		return WorkDao.getInstance().listdelete2(s_num);
	}

	// 치아 list 삭제
	public static boolean listdelete3(int s_num) {
		return WorkDao.getInstance().listdelete3(s_num);
	}

	// 나이 출력
	public static WorkDto age(String phone1) {
		return WorkDao.getInstance().age(phone1);
	}

	// 동년배 보험 추천
	public ArrayList<WorkDto> recommend(int age) {
		return WorkDao.getInstance().recommend(age);
	}

}
