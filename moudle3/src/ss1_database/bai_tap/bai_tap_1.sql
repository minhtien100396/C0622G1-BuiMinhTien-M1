create database student_management;
use student_management;
create table student(
id int,
name varchar(45),
age int,
country varchar(45),
primary key(id)
);
create table class(
id int,
name varchar(45),
primary key(id)
);
create table teacher(
id int,
name varchar(45),
age int,
country varchar(45),
primary key(id)
);
