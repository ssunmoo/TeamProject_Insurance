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

public class Dao {

	// 현재 페이지 객체 선언
	private static Dao dao = new Dao();

	// 싱글톤 메소드
	public static Dao getInstance() {
		return dao;
	}

	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 생성자
	private Dao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance_DB", "root", "1234");
		} // try 종료

		catch (Exception e) {
			System.out.println(e);
		} // catch 종료

	} // Dao 메소드 종료

	////////////////////// 가입하기&& 접속경로 ////////////////////////
	public boolean getsingup(Dto dto) {
		String sql = "insert into member values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getSsn());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("singup오류" + e);
		}
		return false;
	}

	/////////////////////////로그인/////////////////////////////////
	public boolean login(Dto dto) {
		String sql = "select  * from member where name = ? and phone = ?"; // select name ,phone from member
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_name());
			ps.setString(2, dto.getL_phone());
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("singup오류" + e);
		}
		return false;
	}
	///////////////////로그인 후 상태//////////////////////////
	public boolean loginnext(Dto dto) {
		String sql = "select  * from member where name = ? and pw =? and phone = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getPhone());
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

			
		} catch (Exception e) {System.out.println("loginnext"+e);}
		return false;
	}
	////////////////////////////회원수정 및 탈퇴
	public boolean result_update(Dto dto) {
		String sql = "update member set name = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getL_name());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트"+e);
		}
		return false;
		
	}
	//////////////////////////비밀번호수정////////////////////
	public boolean result_update_pw(Dto dto) {
		String sql = "update member set pw = ? where phone = ?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getL_phone());
			ps.setString(2, dto.getPw());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1"+e);
		}
		return false;
		
	}
	//////////////////////회원탈퇴//////////////////
	public boolean delete(Dto dto) {
		String sql = "delete from member where phone = ? and name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(2, dto.getL_name());
			ps.setString(1,dto.getL_phone());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("오류업데이트1"+e);
		}
		return false;
		
	}
	// --- 게시판 --- //
	// 1. 문의글 등록
	public boolean regist(BoardDto dto) {
		String sql = "insert into board values( null, ?, ?, ?, ? )";
		// System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setString(4, dto.getPhone());
			ps.setString(3, dto.getB_pw());
			ps.executeUpdate();
			return true;

		} // try 종료
		catch (Exception e) {
			System.out.println(e);
		} // catch 종료
		return false;
	} // regist 메소드 종료

	// 2. 게시판 보기
	public ArrayList<BoardDto> board() {

		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select b.b_num , b.b_title , b.b_content , m.name , m.phone from member m , board b where m.phone = b.phone ORDER BY (b.b_num);";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(dto);
			} // while 종료
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // board 메소드 종료

	// 3. 게시글 수정
	public boolean update( BoardDto dto ) {
		String sql = "update board set b_title = ?, b_content = ? where b_num = ? ";
		// 게시글 번호를 선택해서 타이틀이랑 내용을 바꾼다
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getB_title());
			ps.setString(2, dto.getB_content());
			ps.setInt(3, dto.getB_num());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	} // update 메소드 종료

	// 4. 게시글 삭제
	public boolean delete( BoardDto dto ) {
		String Sql = "delete from board where b_pw = ? ";
		// System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(Sql);
			ps.setString(1, dto.getB_pw());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	} // delete 메소드 종료

	// 5. 게시글 상세보기
	public BoardDto board_view(int b_num) {
		BoardDto dto = null;
		String sql = "select * from board where b_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs = ps.executeQuery();

			if ( rs.next() ) {
				dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				return dto;
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	
	} // board_view 메소드 종료

	// 6. 상담사 답글 쓰기
	public boolean reply(BoardDto dto) {
		String sql = "insert into subworker values( ?, ?, ? )";
		System.out.println(dto.toString());
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getW_reply());
			ps.setString(2, dto.getW_name());
			ps.setInt(3, dto.getB_num());
			ps.executeUpdate();
			return true;

		} // try 종료
		catch (Exception e) {
			System.out.println(e);
		} // catch 종료
		return false;
	} // reply 메소드 종료

	// 7. 상담사 답글 보기
	public ArrayList<BoardDto> reply_view( int b_num ) {
		// String sql = "select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw , board b where b.b_num = ? ";
		String sql = "select sw.w_reply, w.w_name, sw.b_num\r\n"
				+ "from subworker as sw\r\n"
				+ "inner join worker as w\r\n"
				+ "on sw.w_name = w.w_name\r\n"
				+ "where sw.b_num = ? ";
		
		ArrayList<BoardDto> list = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getString(1), rs.getString(2));

				list.add(dto);
			} // while 종료
			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // reply_view 메소드 종료

///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////

		// 상담사 리스트 보기
			public ArrayList< WorkDto > workerlist() {
				return Dao.getInstance().workerlist();
			}
		
		// 상담사 추가
			public static boolean w_regist(String w_name) {
				return  Dao.getInstance().w_regist(w_name);
			}
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
	
	
	
	
	
	// --- 보험 --- //
		// --- 보험 --- //
		// --- 보험 --- //
		
		// 1. 보험 리스트
		// 1. 보험 리스트
		// 암보험
			public ArrayList< WorkDto > listinsurance() {
				   ArrayList< WorkDto > listinsurance = new ArrayList<>();
			       String sql = "select * from sublist;";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						WorkDto dto = new WorkDto(
								rs.getInt(1),rs.getString(2),
								rs.getString(3),rs.getInt(4)
								);
						listinsurance.add(dto);
					} 
					return listinsurance;
				} catch (Exception e) {System.out.println( e );}
				return listinsurance;
			}
			
		// 손해보험
			public ArrayList< WorkDto > listinsurance2() {
			       ArrayList< WorkDto > listinsurance = new ArrayList<>();
				   String sql = "select * from sublist2;";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						WorkDto dto = new WorkDto(
								rs.getInt(1),rs.getString(2),
								rs.getString(3),rs.getInt(4)
								);
						listinsurance.add(dto);
					}
					return listinsurance;
				} catch (Exception e) {System.out.println( e );}
				return listinsurance;
			}
			
		// 치아보험
			public ArrayList< WorkDto > listinsurance3() {
				   ArrayList< WorkDto > listinsurance = new ArrayList<>();
				   String sql = "select * from sublist3;";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						WorkDto dto = new WorkDto(
								rs.getInt(1),rs.getString(2),
								rs.getString(3),rs.getInt(4)
								);
						listinsurance.add(dto);
					}
					return listinsurance;
				} catch (Exception e) {System.out.println( e );}
				return listinsurance;
			} 
		
		// 2. 보험 리스트 추가	
		// 2. 보험 리스트 추가
		// 암 list 추가
			public boolean listadd (String s_name, String s_text) {
				String sql = "insert into sublist values ( null, ? , ? , null)";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, s_name);
					ps.setString(2, s_text);
					ps.executeUpdate();
					return true;
				} catch (Exception e) {System.out.println("경고) 암보험 추가 실패 : " + e);}
				return false;
			}
			
		// 손해 list 추가
			public boolean listadd2 (String s_name, String s_text) {
				String sql = "insert into sublist2 values ( null, ? , ? , null)";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, s_name);
					ps.setString(2, s_text);
					ps.executeUpdate();
					return true;
				} catch (Exception e) {System.out.println("경고) 손해보험 추가 실패 : " + e);}
				return false;
			}
		// 치아 list 추가
			public boolean listadd3 (String s_name, String s_text) {
				String sql = "insert into sublist2 values ( null, ? , ? , null)";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, s_name);
					ps.setString(2, s_text);
					ps.executeUpdate();
					return true;
				} catch (Exception e) {System.out.println("경고) 치아보험 추가 실패 : " + e);}
				return false;
			}
			
			
		// 암 list 삭제  
			public boolean listdelete( int s_num ) {
				String sql ="delete from sublist where s_num = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt( 1 , s_num );
					ps.executeUpdate(); return true;
				}catch (Exception e) { }
				return false;
			}
		// 손해 list 삭제  
			public boolean listdelete2( int s_num ) {
				String sql ="delete from sublist where s_num = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt( 1 , s_num );
					ps.executeUpdate(); return true;
				}catch (Exception e) { }
				return false;
			}
		// 치아 list 삭제  
			public boolean listdelete3( int s_num ) {
				String sql ="delete from sublist where s_num = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt( 1 , s_num );
					ps.executeUpdate(); return true;
				}catch (Exception e) { }
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

						if ( rs.next() ) {
							dto = new WorkDto(rs.getString(1));
							return dto;
						} 
					} catch (Exception e) {
						System.out.println(e);
					}
					return dto;
			}
			// 해당 나이 추천 보험 출력
			public ArrayList< WorkDto > recommend( int age) {
				   ArrayList< WorkDto > recommend = new ArrayList<>();
			       String sql = "select *  from sublist a, sublist2 b, sublist3 c where a.age and b.age and c.age like ? ;";
			       try {
						ps = con.prepareStatement(sql);
						ps.setString( 1 , age+"%");
						rs = ps.executeQuery();
						while( rs.next() ) {
							WorkDto dto1 = new WorkDto(
									rs.getInt(1),rs.getInt(4),
									rs.getString(3),rs.getString(2),rs.getInt(5)
									);
							recommend.add(dto1);
						} 
						return recommend;
					} catch (Exception e) {System.out.println( e );}
					return recommend;
				}
	
	
} // class 종료
