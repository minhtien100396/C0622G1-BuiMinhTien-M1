create database textc06;
use textc06;

create table products  (
id int auto_increment,
product_code varchar(10),
product_name varchar(50),
product_price double,
product_amount int,
product_description text,
product_status bit,
primary key (product_name,product_price)
);

insert into products (product_code,product_name,product_price,product_amount,product_description,product_status) values
("M-01","Bánh",10000,2,"Bánh ngọt",0),
("M-02","Kẹo",5000,10,"Kẹo ngọt",1),
("M-03","Sữa",2000,3,"Sữa Tươi",1);

create unique index index_products_name
on products(product_name);

-- UNIQUE INDEX
explain select * from products where product_name ="Kẹo";

-- DROP INDEX
alter table products drop index index_products_name;

--  Composite Index
explain select * from products where product_name ="Kẹo";

-- Kết luận: sử dụng INDEX tăng tốc độ truy vấn

-- VIEW
create view products_view
as
select product_code,product_name,product_status
from products;
select * from products_view;

-- cập nhật view

create or replace view products_view
as
select product_code,product_name,product_status, product_amount
from products;
select * from products_view;

-- xóa view 
drop view products_view;

-- STORED PROCEDURE
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure select_all_products()
begin
		select *
		from products;	 
end;
// delimiter ;

-- xóa store procedure
drop procedure select_all_products;
-- gọi store procedure
call select_all_products();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_one_products(p_code varchar(10),p_name varchar(50),p_price double,p_amount int,p_description text,p_status bit)
begin
		insert into products (product_code,product_name ,product_price ,product_amount ,product_description ,product_status) values
		(p_code,p_name ,p_price ,p_amount ,p_description ,p_status);
end;
// delimiter ;

-- xóa store procedure
drop procedure add_one_products;
-- gọi store procedure
call add_one_products("M-04","Socola",5000,23,"Kit-kat",1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_products_by_id(p_id int, p_code varchar(10),p_name varchar(50),p_price double,p_amount int,p_description text,p_status bit)
begin
		update products
        set product_code = p_code,
			product_name = p_name,
            product_price = p_price,
            product_amount = p_amount,
            product_description = p_description,
            product_status = p_status
		where id = p_id;
end;
// delimiter ;
-- xóa store procedure
drop procedure edit_products_by_id;
-- gọi store procedure
call edit_products_by_id(7,"M-10","Bánh bao",200,10,"Bánh bao nhân thịt",1);


-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_products_by_id(p_id int)
begin
		delete 
        from products
		where id = p_id;
end;
// delimiter ;
-- xóa store procedure
drop procedure delete_products_by_id;
-- gọi store procedure
call delete_products_by_id(7);