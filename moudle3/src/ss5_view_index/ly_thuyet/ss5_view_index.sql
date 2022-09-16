create database if not exists c0622g1;
use c0622g1;
create table class(
id int primary key auto_increment,
name varchar(20)
);
create table room(
id int primary key auto_increment,
name varchar(20),
class_id int,
foreign key(class_id) references class(id)
);
create table jame(
`account` varchar(50) primary key,
`password` varchar(50)
);
create table student(
id int primary key auto_increment,
name varchar(50),
birthday date,
gender boolean,
email varchar(50),
`point` float,
class_id int,
`account` varchar(50) unique,
foreign key (class_id) references class(id),
foreign key (`account`) references jame(`account`)
);

create table instructor(
id int primary key auto_increment,
name varchar(50),
birthday date,
salary double
);

create table instructor_class(
 class_id int,
 instructor_id int,
 start_time date,
 end_time date,
 primary key (class_id, instructor_id),
 foreign key(class_id) references class(id),
 foreign key(instructor_id) references instructor(id)
);

insert into class (name) values ('c1121g1'), ('c1221g1'),('a0821i1'),('a0921i1');
insert into room(name,class_id) values ('Ken',1), ('Jame',1),('Ada',2),('Andy',2);

insert into jame(`account`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into jame(`account`,`password`)
 values('anv','12345'),('bnv','12345');

 
insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructor(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);

 
 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');

 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen van a','1981-12-12',1,8,null,'anv'),('tran van b','1981-12-12',1,5,null,'bnv');

 insert into instructor_class(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

select * from room;
select* from class;
select* from student;
select* from jame;
select* from instructor;
select * from instructor_class;

select c.name,group_concat(r.name separator "&") as room from class c join room r on c.id=r.class_id group by c.name;
select id,name, ifnull(email,"khong có email") from student;

-- ss3 thao tác với csdl

-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select s.id, s.name, s.point, c.name as class_name from student s
join class c on s.class_id=c.id;

-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học.
select s.id, s.name, s.point, ifnull(c.name,'chưa có lớp') as class_name from student s
left join class c on s.class_id=c.id;

-- 3. Lấy thông tin của các học viên tên 'nguyen minh hai'.
select * 
from student where name ='nguyen minh hai';
-- 4. Lấy ra học viên có họ là “nguyen”
select * 
from student where name like 'nguyen%';

-- 5. Lấy thông tin của các học viên tên 'hai' hoặc 'huynh’.
select * 
from student where name like '% hai' or name like '% huynh';

-- lấy các học viên có tên bắt đầu bằng chữ h => regexp
select * from student where name  regexp '(^[a-zA-Z\\s]+\\sh[a-z]+$)';

-- 6. Lấy ra các học viên có điểm lớn hơn 5 .
select * from student where point >5;
-- 7. lấy ra thông tin các học viên có điểm 4,6,8
select * from student where point in(4,6,8);

-- 8. Thông kế số lượng học sinh theo từng loại điểm.
select point, count(point) as so_luong from student s 
group by point;

-- 9 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn = 5
select point, count(point) as so_luong from student s 
group by point
having point>=5;
select point, count(point) as so_luong from student s 
where point>=5
group by point;

-- 10. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select point, count(point) as so_luong from student s 
where point>=5
group by point
having so_luong>2;
select * from student
where point>=5;

-- 11. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp  học viên theo point giảm dần,
-- nếu point bằng nhau thì sắp xếp theo tên giảm dần theo anphal.
select * from student s
join class c on s.class_id=c.id where c.name='c1121g1'
order by s.point desc, s.name desc;

-- Lấy ra số lượng học viên của từng lớp

select class.id as class_id, class.name as class_name, student.name as student_name, ifnull(count(student.class_id),0) as so_luong_hoc_sinh
from student 
right join class on student.class_id = class.id
group by student.class_id;

-- Lấy ra toàn bộ student và instructor
select id, name, birthday, "hoc_vien" as "nghe_nghiep"
from student
union
select id, name, birthday, "giao_vien" as "nghe_nghiep"
from instructor;

-- lấy ra 3 hoc vien trẻ nhất
select *
from student 
order by birthday desc
limit 3;

-- Dùng câu truy vấn con lấy ra các lớp không có học sinh
select class.id, class.`name`
from class 
where class.id not in (
		select student.class_id
		from student
		where student.class_id is not null
);


select class.id, class.`name`
from class 
where not exists (
		select student.class_id
		from student
		where class.id = student.class_id
);

-- Tạo index để tìm kiếm nhanh hơn
create index index_student_name
on student(`name`);
 
 select student.name 
 from student
 where (student.name = "le hai chung");
 
-- VIEW
create view view_student_instructor
as
select id,name,birthday
from student
union all
select id,name,birthday
from instructor;

select *
from view_student_instructor;


-- STORED PROCEDURE
-- Tạo procedure

-- IN
-- truyền vào 1 tham số như tham trị
delimiter //
create procedure find_by_name (in p_keyword varchar(10))
begin
	select id, `name`, birthday
    from student 
    where `name` like concat("%",p_keyword,"%");
end;
// delimiter ;
-- Xóa procedure
drop procedure find_by_name;
-- Gọi procedure
call find_by_name ("o");

-- OUT
-- truyền vào 2 tham só 1 là kí tự cần tìm kiếm, 2 là đếm số lần xuất hiện của kí tự đó
delimiter //
create procedure find_by_name_out(p_keyword varchar(10), out p_result int)
begin
	set p_result = (  -- set : để gán giá trị 
		select count(*)
		from student 
		where `name` like concat("%",p_keyword,"%")
	);
end;
// delimiter ;

call find_by_name_out("a",@v_abc);
select @v_abc;


-- INOUT
-- p_keyword_result : đóng 2 vai trò là tham số đi vào và kết quả lấy ra
delimiter //
create procedure find_by_name_inout(inout p_keyword_result varchar(10))
begin
	set p_keyword_result = (  -- set: để gán giá trị
		select count(*)
		from student 
		where `name` like concat("%",p_keyword_result,"%")
	);
end;
// delimiter ;
drop procedure find_by_name_inout;
set @v_inout ="t";
call find_by_name_inout(@v_inout);
select @v_inout;

-- FUNCTION

delimiter //
create function sum2num (num1 int, num2 int)
returns int -- Hàm trả về kiểu dữ liệu số nguyên
deterministic -- Khi tạo hàm phai có từ khóa này
begin
	declare total int; -- Khi tạo biến phải dùng declare
    set total = num1+num2; -- Gán phải dùng set
    return total;
end;
// delimiter ;

select sum2num(6,4) as "sum";



-- TRIGGER
-- trigger nằm trong bảng 
-- view, function, stored procedures nằm ngang hàng với bảng

delimiter //
create trigger save_account_james
before insert -- định nghĩa sẵn trước khi thêm 1 dòng vào bảng student thì trigger sẽ hoạt động
on student for each row -- on student : nằm trên bảng studen, for each row: hoạt động trên từng dòng tức là khi có dòng được thêm vào hay xóa đi thì trigger sẽ hoạt động
-- Khi một dòng được thêm vào thì khối lệnh trong begin sẽ hoạt động
begin
	insert into account_james
    values (lcase(new.email),"12345678");
    
    if new.account_james_account is null then
    set new.account_james_account = new.email;
    end if;
end;
//delimiter ;






