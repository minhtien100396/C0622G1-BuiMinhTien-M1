CREATE DATABASE demo;
USE demo;

CREATE TABLE users (
    id INT(3) NOT NULL AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120),
    PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

SELECT 
    *
FROM
    users
ORDER BY `name`;

-- STORED PROCEDURE
-- Tạo procedure

-- IN
-- truyền vào 1 tham số như tham trị
delimiter //
create procedure select_all_users ()
begin
	select *
    from `users`; 
end;
// delimiter ;
-- Xóa procedure
drop procedure select_all_users;
-- Gọi procedure
call select_all_users ;

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_user_by_id(p_id int,p_name varchar(50),p_email varchar(50),p_country varchar(50))
begin
UPDATE users 
SET 
    `name` = p_name,
    email = p_email,
    country = p_country
WHERE
    id = p_id;
end;
// delimiter ;
-- xóa store procedure
drop procedure edit_user_by_id;
-- gọi store procedure
call edit_user_by_id(16,"Tiến","minhtien@gmail.com","Việt Nam");

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_user_by_id(p_id int)
begin
		delete 
        from users
		where id = p_id;
end;
// delimiter ;
-- xóa store procedure
drop procedure delete_user_by_id;
-- gọi store procedure
call delete_user_by_id(17);