
-- JOIN

-- Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
-- Lúc lấy thông tin ở 2 bảng khác nhau phải sử dụng join để kết nối 2 bảng này lại để lấy thông tin.

-- Khi viết câu lệnh truy vấn , tới từ khóa thì xuống đòng
-- Chọn ra những thuộc tính muốn hiển thị ra ở sau select
-- as: Đổi tên thuộc tính bị trùng
select student.id, student.name as studen_name , class.name as class_name, class_id
-- Bắt đầu từ bảng student (tính từ bảng table 1 phía bên trái)
from student
-- inner join class : lấy các dòng chung của student và class
inner join class
-- on: như 1 điều kiện, muốn join nó thông qua thuộc tính nào class_id là khóa ngoại của bảng student -> dùng thuộc tính là khóa ngoại để join
on student.class_id = class.id;

--  Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào, lớp đó thuộc loại lớp nào.

select student.id, student.name as studen_name , class.name as class_name, class_id, type_of_class.name
from student
inner join class
on student.class_id = class.id
-- Từ class join tiếp qua type_of_class , trong My SQL để join mặc định là inner join
join type_of_class
on class.type_of_class_id = type_of_class.id;

-- Lấy ra thông tin các học viên kể cả các học viên không theo học lớp nào

select student.id, student.name as studen_name , class.name as class_name
-- left join : 
from student left join class
on student.class_id = class.id;

-- full join 
-- My SQL không hỗ trợ full join
-- nhưng có thể sử dụng left join và right join kết hợp lại để thành full join
select student.id, student.name as studen_name , class.name as class_name
-- left join : 
from student left join class
on student.class_id = class.id
-- sử dụng câu lệnh union để kết hợp câu lệnh right join và left join , loại bỏ dữ liệu trùng lặp và kết hợp 2 câu lệnh truy vấn
union 
select student.id, student.name as studen_name , class.name as class_name
-- right join : 
from student right join class
on student.class_id = class.id;



-- WHERE
-- where tương đương với if, from tương đương với vòng lặp for, select hiển thị bản ghi
-- thứ tự hoạt động của 3 từ khóa: from -> where -> select
-- lấy toàn bộ thông tin của bảng student
select * from student;

-- chỉ muốn lấy thông tin của học viên có id =4 
select * from student where student.id = 4;
select * from student where class.id =2 ;

-- Lấy thông tin của các học viên tên 'Tien' và 'Toan’.
-- where - in : câu truy vấn con
select * from student where `name` in ("Tien", " Toan") ;



-- GROUP BY

select * from student where `name` in ("Tien") 
group by `name` ;

-- HAVING: thực hiện sau group by
select * from student 
group by `name` having name ="Tiến" ;



-- LẤy ra số lượng học viên cho từng lớp
select count(student.id), class.name
from student join class 
on student.class_id = class.id
group by class.name;



-- ORDER BY:
-- mặc định asc : sắp xếp tăng dần
select * from student order by name desc, id desc;
-- trường hợp name giống nhau thì sắp xếp theo id


-- Lấy ra thông tin các học viên đang theo học tại lớp và lớp đó do giảng viên nào dạy

select student.id, student.name,class.name, instructor.name
from student join class
on student.class_id = class.id
join instructor_teach_class
on class.id = instructor_teach_class.class_id
join instructor
on instructor.id = instructor_teach_class.instructor_id;