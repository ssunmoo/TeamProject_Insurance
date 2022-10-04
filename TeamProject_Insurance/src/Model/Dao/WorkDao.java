package Model.Dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Controller.Controller;
import Model.Dto.BoardDto;
import Model.Dto.Dto;
import Model.Dto.WorkDto;

public class WorkDao {

	// 현재 페이지 객체 선언
	private static WorkDao workDao = new WorkDao();

	// 싱글톤 메소드
	public static WorkDao getInstance() {
		return workDao;
	}

	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 생성자
	private WorkDao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance_DB", "root", "1234");
		} // try 종료

		catch (Exception e) {
			System.out.println(e);
		} // catch 종료

	} // WorkDao 메소드 종료


	
	
	// --- 상담사 --- //
		// --- 상담사 --- //
		// --- 상담사 --- //
		
		// 상담사 리스트. 
		public ArrayList< WorkDto > workerlist() {
				ArrayList< WorkDto > listworker = new ArrayList<>();
				String sql = "select * from worker;";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						WorkDto dto = new WorkDto(
								rs.getInt(1),rs.getString(2)
								);
						listworker.add(dto);
					} 
					return listworker;
				} catch (Exception e) {System.out.println( e );}
				return listworker;
			}
		
		// 상담사 추가
		public boolean w_regist (String w_name) {
			String sql = "insert into worker values ( null, ?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, w_name);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println("경고) 상담사 추가 실패 : " + e);}
				return false;
		}
	
	
	
	// --- 보험 --- //
	// --- 보험 --- //
	// --- 보험 --- //
	
	// 1. 보험 리스트
	// 1. 보험 리스트
	// 1. 보험 리스트
	   // 암보험
	   public ArrayList<WorkDto> listinsurance() {
	      ArrayList<WorkDto> listinsurance = new ArrayList<>();
	      String sql = "select s_num, s_name, s_text, age from sublist";
	      System.out.println(listinsurance.toString());
	      try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            WorkDto dto = new WorkDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	            
	            listinsurance.add(dto);
	         }
	         return listinsurance;
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      return listinsurance;
	   }

	   // 손해보험
	   public ArrayList<WorkDto> listinsurance2() {
	      ArrayList<WorkDto> listinsurance = new ArrayList<>();
	      String sql = "select s_num, s_name, s_text, age from sublist2";
	      try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            WorkDto dto = new WorkDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	            listinsurance.add(dto);
	         }
	         return listinsurance;
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      return listinsurance;
	   }

	   // 치아보험
	   public ArrayList<WorkDto> listinsurance3() {
	      ArrayList<WorkDto> listinsurance = new ArrayList<>();
	      String sql = "select s_num, s_name, s_text, age from sublist3";
	      try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            WorkDto dto = new WorkDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	            listinsurance.add(dto);
	         }
	         return listinsurance;
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      return listinsurance;
	   }


		  

	// 2. 보험 리스트 추가	
	// 2. 보험 리스트 추가
	
	// [ 고객 ] history list 추가
		public boolean c_listadd(int choice) {
			String sql = "insert into history select * from sublist where s_num = ? ;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, choice);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				System.out.println("경고) 암보험 추가 실패 : " + e);
			}
			return false;
		}
		
	// [ 고객 ] history list 삭제  
		public boolean c_delete(int delete) {
			String sql = "delete from history where s_num = ?;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, delete);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
			}
			return false;
		}
		
	// [ 고객 ] history 출력
		public ArrayList<WorkDto> history() {
			ArrayList<WorkDto> listinsurance = new ArrayList<>();
			String sql = "select * from history;";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					WorkDto dto = new WorkDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					listinsurance.add(dto);
				}
				return listinsurance;
			} catch (Exception e) {
				System.out.println(e);
			}
			return listinsurance;
		}
		
		
	 // 2. 보험 리스트 추가
	   // 암 list 추가
	   public boolean listadd(String s_name, String s_text, int age) {
	      String sql = "insert into sublist values ( null, ? , ? , null, ? )";
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, s_name);
	         ps.setString(2, s_text);
	         ps.setInt(3, age);
	         ps.executeUpdate();
	         return true;
	      } catch (Exception e) {
	         System.out.println("경고) 암보험 추가 실패 : " + e);
	      }
	      return false;
	   }

	   // 손해 list 추가
	   public boolean listadd2(String s_name, String s_text, int age) {
	      String sql = "insert into sublist2 values ( null, ? , ? , null, ?)";
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, s_name);
	         ps.setString(2, s_text);
	         ps.setInt(3, age);
	         ps.executeUpdate();
	         return true;
	      } catch (Exception e) {
	         System.out.println("경고) 손해보험 추가 실패 : " + e);
	      }
	      return false;
	   }

	   // 치아 list 추가
	   public boolean listadd3(String s_name, String s_text, int age) {
	      String sql = "insert into sublist3 values ( null, ? , ? , null, ?)";
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, s_name);
	         ps.setString(2, s_text);
	         ps.setInt(3, age);
	         ps.executeUpdate();
	         return true;
	      } catch (Exception e) {
	         System.out.println("경고) 치아보험 추가 실패 : " + e);
	      }
	      return false;
	   }

	// 암 list 삭제  
	public boolean listdelete(int s_num) {
		String sql = "delete from sublist where s_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, s_num);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 손해 list 삭제  
	public boolean listdelete2(int s_num) {
		String sql = "delete from sublist where s_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, s_num);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 치아 list 삭제  
	public boolean listdelete3(int s_num) {
		String sql = "delete from sublist where s_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, s_num);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 보험 추천
	// 나이 출력
	public WorkDto age(String phone1) {
		String sql = "select substring( ssn , 1, 2) as age  from member where phone = ?;";
		WorkDto dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, phone1);
			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new WorkDto(rs.getString(1));
				return dto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	}

	// 해당 나이 추천 보험 출력
	public ArrayList<WorkDto> recommend(int age) {
		ArrayList<WorkDto> recommend = new ArrayList<>();
		String sql = "select *  from sublist a, sublist2 b, sublist3 c where a.age and b.age and c.age like ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, age + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				WorkDto dto1 = new WorkDto(rs.getInt(1), rs.getInt(4), rs.getString(3), rs.getString(2), rs.getInt(5));
				recommend.add(dto1);
			}
			return recommend;
		} catch (Exception e) {
			System.out.println(e);
		}
		return recommend;
	}

}
