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
    foreign key (phone) references member(phone) ON DELETE CASCADE
    
);


-- --------------------------------------------------보험사--------------------------------------

create table list( -- 보험 종류 카테고리
	
    c_num int auto_increment primary key,
    c_title varchar(10)
    
); 

insert into list values( null, "암" );
insert into list values( null, "손해" );
insert into list values( null, "치아" );
-- drop table list;
-- select * from list;

-- ★★★ age 필드 추가 ★★★
create table sublist( -- 보험 종류 세부내역 (암)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int ,
	 age int ,
	 foreign key (c_num) references list(c_num)

);
insert into sublist values( null, "폐암", "폐 질환, 폐 수종, 폐기저질환", 1 , 20 );
insert into sublist values( null, "갑상선암", "갑상선 항진증, 갑상선 치료비", 1 , 30 );
-- select * from sublist;
-- drop table sublist;

-- ★★★ 보험 세부내역 테이블 추가 & age 필드 추가 ★★★
create table sublist2( -- 보험 종류 세부내역 (손해)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int , 
	 age int ,
	 foreign key (c_num) references list(c_num)

);
insert into sublist2 values( null, "상해", "상해 사망, 기타 상해     ", 2 , 20 );
insert into sublist2 values( null, "질병", "질병 입원비, 질병 수술비", 2 , 30 );


-- ★★★ 보험 세부내역 테이블 추가 & age 필드 추가 ★★★
create table sublist3( -- 보험 종류 세부내역 (치아)
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int , 
	 age int , 
	 foreign key (c_num) references list(c_num)
);
insert into sublist3 values( null, "충치", "신경치료, 발치, 크라운", 3 , 20 );
insert into sublist3 values( null, "임플란트", "고정성, 가공의치(브릿지)", 3 , 30 );

-- ★★★ w_name 에 unique not null 속성 추가 (댓글 기능에 이름만 필요해서 추가함!) ★★★
create table worker( -- 상담사 카테고리 리스트

	w_num int auto_increment primary key,
	w_name varchar(10) unique not null

);

-- select * from worker;
insert into worker values( null , "상담사A");
insert into worker values( null , "상담사B");
insert into worker values( null , "상담사C");
insert into worker values( null , "상담사D");

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

-- drop table history;
-- ★★★ 테이블 신규 추가 ★★★
create table history( -- 가입 세부내역
	
     s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int ,
	 age int ,
	 foreign key (c_num) references list(c_num)
	
);

