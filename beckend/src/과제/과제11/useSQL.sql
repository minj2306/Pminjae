drop database if exists sqldb4wep;
create database sqldb4web;
use sqldb4web;
drop table if exists member;
create table member( mno int not null unique auto_increment , 
					 mid varchar(20) not null unique , 
                     mpassword varchar(20) not null , 
                     mname varchar(20) not null , 
                     mphone varchar(20) not null unique , 
                     primary key(mno)
                     );
