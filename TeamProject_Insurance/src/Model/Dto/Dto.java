package Model.Dto;

public class Dto {
	
	// 필드
								// 회원
	private String name;		// 이름
	private String pw;			// 비밀번호
	private String phone;		// 연락처(식별자 PK)
	private String ssn;			// 주민번호
	
								// 게시판
	private int b_num;			// 게시판 번호
	private String b_title;		// 게시글 제목
	private String b_content;	// 게시글 내용
	private String b_pw;		// 게시글 비밀번호
		
								// 보험 종류
	private int c_num;			// 보험 대분류 번호
	private String c_title;		// 보험 대분류 이름
	private int s_num;			// 보험 소분류 번호
	private String s_name;		// 보험 소분류 이름
	private String s_text;		// 보험 소분류 세부내용
		
								// 상담사
	private int w_num;			// 상담사 번호
	private String w_name;		// 상담사 이름
	
	
	
	// 빈생성자
	public Dto() { }

	// 게시글 등록 생성자
	public Dto(int b_num, String b_title, String b_content, String name, String phone, String b_pw ) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.name = name;
		this.phone = phone;
		this.b_pw = b_pw;
	}
	
	// 게시판 리스트 출력 생성자
	public Dto(int b_num, String b_title, String b_content, String name, String phone ) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.name = name;
		this.phone = phone;
	}
	
	// 가입
	public Dto(String name, String pw, String phone, String ssn) {
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.ssn = ssn;
		
	}

	// getter, setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public int getB_num() {
		return b_num;
	}



	public void setB_num(int b_num) {
		this.b_num = b_num;
	}



	public String getB_title() {
		return b_title;
	}



	public void setB_title(String b_title) {
		this.b_title = b_title;
	}



	public String getB_content() {
		return b_content;
	}



	public void setB_content(String b_content) {
		this.b_content = b_content;
	}



	public String getB_pw() {
		return b_pw;
	}



	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}



	public int getC_num() {
		return c_num;
	}



	public void setC_num(int c_num) {
		this.c_num = c_num;
	}



	public String getC_title() {
		return c_title;
	}



	public void setC_title(String c_title) {
		this.c_title = c_title;
	}



	public int getS_num() {
		return s_num;
	}



	public void setS_num(int s_num) {
		this.s_num = s_num;
	}



	public String getS_name() {
		return s_name;
	}



	public void setS_name(String s_name) {
		this.s_name = s_name;
	}



	public String getS_text() {
		return s_text;
	}



	public void setS_text(String s_text) {
		this.s_text = s_text;
	}



	public int getW_num() {
		return w_num;
	}



	public void setW_num(int w_num) {
		this.w_num = w_num;
	}



	public String getW_name() {
		return w_name;
	}



	public void setW_name(String w_name) {
		this.w_name = w_name;
	}

	
	
	



	
	
	
	
	
	
} // class 종료
