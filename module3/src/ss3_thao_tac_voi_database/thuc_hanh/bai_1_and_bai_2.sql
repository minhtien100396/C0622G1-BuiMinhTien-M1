use quan_ly_sinh_vien;

-- Thêm dữ liệu cho table class

insert into class (class_name,star_date,`status`) values ('A1', '2008-12-20', 1),
														 ('A2', '2008-12-22', 1),
                                                         ('B3', current_date, 0);

-- Thêm dữ liệu cho table student

insert into student (student_name,address,phone,`status`,class_id) values ('Hung', 'Ha Noi', '0912113113', 1, 1),
																		  ('Hoa', 'Hai phong', null, 1, 1),
                                                                          ('Manh', 'HCM', '0123123123', 0, 2);
                                                                          
-- Thêm dữ liệu cho table subject

insert into `subject` (sub_name,credit,`status`) values ('CF', 5, 1), 
														('C', 6, 1), 
														('HDJ', 5, 1), 
														('RDBMS', 10, 1);

-- Thêm dữ liệu cho table market

insert into mark (sub_id,student_id,mark,exam_times) values (1, 1, 8, 1),
															(1, 2, 10, 2),
															(2, 1, 12, 1);
                                                            
-- Hiển thị danh sách tất cả các học viên 
select * from student ;      

-- Hiển thị danh sách các học viên đang theo học.     
select * from student where `status` = true;       

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subject where credit < 10;     

-- Hiển thị danh sách học viên lớp A1;                              
select student.student_id, student.student_name, class.class_name 
from student 
join class
on student.class_id = class.class_id
where class.class_name = "A1";															


-- Hiển thị điểm môn CF của các học viên.

select student.student_id,student.student_name,subject.sub_name,mark.mark
from student
join mark
on student.student_id = mark.student_id
join subject
on subject.sub_id = mark.sub_id
where subject.sub_name = "CF";		

-- Hiển thị số lượng sinh viên ở từng lớp
select class.class_id, 
	   class.class_name,
       student.student_name,
       count(student.class_id) as number_of_student
from student 
right join class
on student.class_id = class.class_id
group by student.class_id;  

-- Tính điểm trung bình các môn học của mỗi học viên
select student.student_id, student.student_name,avg(mark.mark) as average
from student
join mark
on student.student_id = mark.student_id	
group by mark.student_id;	                                                         
							
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15	
select student.student_id, student.student_name,avg(mark.mark) as average
from student
join mark
on student.student_id = mark.student_id	 
group by mark.student_id having average > 15;	

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.student_id, student.student_name,avg(mark.mark) as average 
from student 
join mark
on student.student_id = mark.student_id	 
group by mark.student_id 
having average >= all(
	select avg(mark.mark)
	from mark
);