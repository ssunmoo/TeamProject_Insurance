drop database if exists Insurance_DB;
create database Insurance_DB;
use Insurance_DB;


create table member( -- 회원가입
	
    name char(6) not null,
    pw varchar(10) not null,
    phone varchar(15) not null primary key,
    ssn varchar(14) not null

);

-- ★★★ 게시판 테이블 순서만 변경 ★★★
create table board( -- 게시판

	b_num int primary key auto_increment,
	b_title varchar(30) not null,
    b_content varchar(100) not null,
    b_pw varchar(10) not null,
	phone varchar(15) not null,
    foreign key (phone) references member(phone)
);


-- --------------------------------------------------보험사--------------------------------------

create table list( -- 보험 종류 카테고리
	
    c_num int auto_increment primary key,
    c_title varchar(10)
    
); 

-- ★★★ age 필드 추가 ★★★
create table sublist( -- 보험 종류 세부내역 (암)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int ,
	 age int ,
	 foreign key (c_num) references list(c_num)

);

-- ★★★ 보험 세부내역 테이블 추가 & age 필드 추가 ★★★
create table sublist2( -- 보험 종류 세부내역 (손해)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int , 
	 age int ,
	 foreign key (c_num) references list(c_num)

);

-- ★★★ 보험 세부내역 테이블 추가 & age 필드 추가 ★★★
create table sublist3( -- 보험 종류 세부내역 (치아)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int , 
	 age int , 
	 foreign key (c_num) references list(c_num)

);

-- ★★★ w_name 에 unique not null 속성 추가 (댓글 기능에 이름만 필요해서 추가함!) ★★★
create table worker( -- 상담사 카테고리 리스트

	w_num int auto_increment primary key,
	w_name varchar(10) unique not null

);

-- ★★★ w_reply, b_num 필드 추가, phone 필드 삭제 ★★★
create table subworker( --  상담직원 상세내용 

	w_reply varchar(100) ,
    w_name varchar(10) ,
	b_num int ,	
	foreign key (b_num) references board(b_num) ,
    CONSTRAINT subworker_worker_FK foreign key (w_name) references worker(w_name)

);

create table mypage( -- 나의 페이지

	c_num int,
	-- s_num int,
    phone varchar(15) ,
	foreign key (c_num) references list(c_num),
	-- foreign key (s_num) references sublist(s_num),
    foreign key (phone) references member(phone)
    
);

-- ★★★ 테이블 신규 추가 ★★★
create table history( -- 가입 세부내역
	
     s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int ,
	 age int ,
	 foreign key (c_num) references list(c_num)
	
);

