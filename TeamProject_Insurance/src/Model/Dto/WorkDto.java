package Model.Dto;

public class WorkDto {
	
	// 필드
	// 회원
	private String name;		// 이름
	private String pw;			// 비밀번호
	private String phone;		// 연락처(식별자 PK)
	private String ssn;			// 주민번호
	private String phone1;
	
	private String l_name;		// 로그인 이름
	private String l_phone;		// 로그인 번호
	
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
	private int age;
	
	// 상담사
	private int w_num;			// 상담사 번호
	private String w_name;		// 상담사 이름
	private String w_reply;		// 답글
	
	public WorkDto(String phone1) {
		super();
		this.phone1 = phone1;
	}
	
	   // 보험 리스트 보기
	  public WorkDto(int s_num, String s_name, String s_text, int age) {
	     this.s_num = s_num;
	     this.s_name = s_name;
	     this.s_text = s_text;
	     this.age = age;
	   }
	public WorkDto(int c_num, int s_num, String s_name, String s_text, int age) {
		super();
		this.c_num = c_num;
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_text = s_text;
		this.age = age;
	}
	
	public WorkDto(int w_num, String w_name) {
		super();
		this.w_num = w_num;
		this.w_name = w_name;
	}
	
	public WorkDto(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	
	@Override
	public String toString() {
	return "Dto [name=" + name + ", pw=" + pw + ", phone=" + phone + ", ssn=" + ssn + ", b_num=" + b_num
	+ ", b_title=" + b_title + ", b_content=" + b_content + ", b_pw=" + b_pw + ", c_num=" + c_num
	+ ", c_title=" + c_title + ", s_num=" + s_num + ", s_name=" + s_name + ", s_text=" + s_text + ", w_num="
	+ w_num + ", w_name=" + w_name + ", w_reply=" + w_reply + "]";
	}
	
	// 빈생성자
	public void Dto() { }
	
	// 가입 생성자
	public void Dto(String name, String pw, String phone, String ssn) {
	this.name = name;
	this.pw = pw;
	this.phone = phone;
	this.ssn = ssn;
	}
	
	// 로그인 생성자
	public void Dto(String l_name, String l_phone) {
	this.l_name = l_name;
	this.l_phone = l_phone;
	}
	
	public WorkDto(int s_num, String s_name, String s_text) {
		
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_text = s_text;
	}

	// getter, setter
	public String getName() {
	return name;
	}
	
	public String getPhone1() {
		return phone1;
	}
	
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getL_name() {
	return l_name;
	}
	
	public void setL_name(String l_name) {
	this.l_name = l_name;
	}
	
	public String getL_phone() {
	return l_phone;
	}
	
	public void setL_phone(String l_phone) {
	this.l_phone = l_phone;
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
	
	public String getW_reply() {
	return w_reply;
	}
	
	public void setW_reply(String w_reply) {
	this.w_reply = w_reply;
	}
}