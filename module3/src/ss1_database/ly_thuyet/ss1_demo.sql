create database demo;
use demo;
create table class(
class_id int primary key auto_increment,
class_name varchar(45)
);

create table students(
id int primary key auto_increment,
`name` varchar(45),
age int,
class_id int,
foreign key(class_id) references class(class_id)
);



select * from students;
select * from class;

insert into students(name,age,class_id) values ("Tiến", 26,1);
insert into class values (1, "1");
delete from students where id = 11;
update  students set name = "Dũng", age = 29 where id = 2;
alter table students add aaa varchar(45) ;
truncate table students;
truncate table class;

