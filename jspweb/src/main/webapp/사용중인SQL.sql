drop database if exists jspweb;
create database jspweb;

#방문록
drop table if exists visitlog;
create table visitlog(
	vno int auto_increment , # 식별번호 자동번호 부여
    vwriter varchar(30) not null , # 방문록작성자명 , 공백 불가능
    vpwd varchar(10) not null , #방문록 비밀번호 , 공백 불가능
    vcontent text not null , # 방문록 내용
    vdate datetime default now() , #방문록 작성일/시간 , 생략시 자동날짜 / 시간 등록
    primary key(vno)
);

#가계부
drop table if exists accountbook;
create table accountbook(
					 ano int auto_increment ,
                     atext varchar(20) not null ,
                     anumber int not null ,
                     adate date not null ,
                     primary key(ano)
                     );
                     
#회원가입
drop table if exists member;
create table member(
					mno int auto_increment ,			--식별번호(회원번호) , 자동번호 부여
                    mid varchar(50) not null unique ,	--(회원아이디) , 공백불가능 , 중복불가
                    mpwd varchar(20) not null ,			--(회원비밀번호) , 공백불가능
                    memail varchar(50) not null unique ,--(회원이메일) , 공백불가능
                    mimg longtext , 					--( 회원 프로필 이미지사진 이름 )
                    primary key(mno)
                    ); 
# 직원 등록          
drop table if exists hrm;
create table hrm(
				 hno int auto_increment ,
                 hname varchar(10) not null ,
                 hphone varchar(13) not null unique ,
                 hposition varchar(10) not null,
                 hdate date default (current_date()) ,
                 himg longtext ,
                 primary key(hno)
                 );

# 카테고리
drop table if exists bcategory;
create table bcategory(
						bcno int auto_increment ,
                        bcname varchar(30) not null ,
                        primary key(bcno)
                        );

insert into bcategory values ( 1 , '공지사항' );
insert into bcategory values ( 2 , '자유게시판' );
insert into bcategory values ( 3 , '노하우' );

select * from bcategory;

# 게시판
drop table if exists board;
create table board(
					bno int auto_increment ,
                    btitle varchar(30) not null ,
                    bcontent longtext ,
                    bfile longtext ,
                    bdate datetime default now() ,
                    bview int default 0 ,
                    mno int ,
                    bcno int ,
                    primary key (bno) ,
                    foreign key(mno) references member (mno) on delete cascade , -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
                    foreign key(bcno) references bcategory(bcno) on delete cascade on update cascade -- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시 fk도 같이 변경
                    );
                    
#--------------------------------제품--------------------------------------------------------

#제품 카테고리 테이블

use jspweb;
#pk[ 상위 ] 테이블 먼저 생성

# 1. 제품 카테고리
drop table if exists pcategory;
create table pcategory(
					  pcno int auto_increment ,
                      pcname varchar(100) not null ,
                      primary key(pcno)
					 );
# 샘플
insert into pcategory( pcname ) values( '노트북' );
insert into pcategory( pcname ) values( '테블릿' );
insert into pcategory( pcname ) values( '냉장고' );

# 2. 제품
drop table if exists product;
create table product(
					pno int auto_increment ,
                    pname varchar(100) not null ,
                    pcontent longtext ,
                    pprice int unsigned , # signed( 기본값 : 음수사용 +-21억 ) / unsigned ( 음수사용 x - 음수만큼읨 메모리를 양수로 사용 0~42억 정도 ) : 음수 사용 여부 
					pstate tinyint default 0 , # [ 0 : 판매중(기본값) , 1: 거래중 , 2: 판매대기 3. 판매완료 ]
                    pdate datetime default now() ,
                    plat varchar(30) ,
                    plng varchar(30) ,
                    pcno int ,
                    mno int ,
                    primary key(pno) ,
                    foreign key(pcno) references pcategory(pcno) on delete set null on update cascade ,
                    foreign key(mno) references member (mno) on delete set null on update cascade
                    );
                    
# 3. 제품 사진
drop table if exists productimg;
create table productimg(
						pimgno int auto_increment ,
                        pimg longtext ,
                        pno int ,
                        primary key(pimgno) ,
                        foreign key (pno) references product (pno) on delete cascade on update cascade 
                        );

# 찜하기
drop table if exists pwishlist;
create table pwishlist(
						mno int not null ,
                        pno int not null ,
                        foreign key(mno) references product(mno) on delete cascade on update cascade , -- 회원이 탈퇴하면 찜하기 목록 같이 삭제
                        foreign key(pno) references product(pno) on delete set null on update cascade -- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 표시하기 위한 null 대입
						);