create database ss12_exercise_2;
use ss12_exercise_2;
create table users (
id int primary key not null auto_increment,
`name` varchar(120) not null,
email varchar(120) not null,
country varchar(120)
);
insert into users (`name`, email, country)
values ("Bùi Minh Tiến", "minhtien100396@gmail.com", "Việt Nam"),
	   ("Nguyễn Thị Nguyệt", "nguyennho210899@gmail.com", "Nhật");
select id,`name`,email,country 
from users;

