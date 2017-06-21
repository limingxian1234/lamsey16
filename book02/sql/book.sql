create database bookstore;
use bookstore;
create table t_user(
	id int primary key AUTO_INCREMENT,
	username varchar(50) not null unique,
	password varchar(16) not null,
	email varchar(50) not null
);

insert into t_user(username,password,email) values ('lamsey','537423','1525657736@qq.com');