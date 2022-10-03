package Model.Dto;

public class BoardDto {

	
	// 필드
	// 회원
	private String name;		// 이름
	private String pw;			// 비밀번호
	private String phone;		// 연락처(식별자 PK)
	private String ssn;			// 주민번호
	
	// 로그인
	private String l_name;		// 로그인 이름
	private String l_phone;		// 로그인 번호
	
	// 게시판
	private int b_num;			// 게시판 번호
	private String b_title;		// 게시글 제목
	private String b_content;	// 게시글 내용
	private String b_pw;		// 게시글 비밀번호
	
	// 상담사
	private int w_num;			// 상담사 번호
	private String w_name;		// 상담사 이름
	private String w_reply;		// 답글
	
	
	@Override
	public String toString() {
		return "BoardDto [name=" + name + ", pw=" + pw + ", phone=" + phone + ", ssn=" + ssn + ", l_name=" + l_name
				+ ", l_phone=" + l_phone + ", b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_pw=" + b_pw + ", w_num=" + w_num + ", w_name=" + w_name + ", w_reply=" + w_reply + "]";
	}
	
	// 빈생성자
	public BoardDto() {
		
	}
	
	// 게시글 등록 생성자
	public BoardDto(int b_num, String b_title, String b_content, String name, String phone, String b_pw ) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.name = name;
		this.phone = phone;
		this.b_pw = b_pw;
	}
		
	// 게시판 리스트 출력 생성자
	public BoardDto(int b_num, String b_title, String b_content, String name, String phone ) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.name = name;
		this.phone = phone;
	}
	
	// 게시글 상세보기 생성자
	public BoardDto(int b_num, String b_title, String b_content) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
	}
	
	// 문의글 등록 생성자
	public BoardDto(String b_title, String b_content, String phone, String b_pw) {
		this.b_title = b_title;
		this.b_content = b_content;
		this.phone = phone;
		this.b_pw = b_pw;
	}

	// 게시글 번호 선택
	public BoardDto(int b_num) {
		this.b_num = b_num;
	}
	
	// 답글 등록 생성자
	public BoardDto( String w_reply, String w_name, int b_num ) {
		this.w_reply = w_reply;
		this.w_name = w_name;
		this.b_num = b_num;
	}

	// 답글 보기 생성자
	public BoardDto(String w_reply, String w_name ) {
		this.w_reply = w_reply;
		this.w_name = w_name;
	}
	
	// 게시글 삭제 생성자
	public BoardDto(int b_num, String b_pw) {
		this.b_pw = b_pw;
	}
	
	// 게시글 수정 생성자
	public BoardDto(int b_num, String b_title, String b_content, String b_pw) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_pw = b_pw;
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
