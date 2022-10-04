create database products;
use products;
create table product(
id int primary key auto_increment,
`name` varchar(50),
price double,
`description` varchar(50),
manufacture varchar(50)
);
insert into product values (1, "Nokia 222", 123, "des1", "nokia"),
						   (2, "Iphone 13", 456, "des2", "apple"),
						   (3, "LG 666", 666, "des3", "LG"),
						   (4, "Samsung E333", 777, "des5", "Samsung"),
						   (5, "Oppo 111", 888, "des6", "Oppo");

select * from product;

update product
set `name`= "Bánh", price = 1000, `description` = "ngon", manufacture = "HKT"
where id = 2;

delete from product where id = 6;

select * from product where `name` like "%n%";

set SQL_SAFE_UPDATES = 0 ;
delete from product;
set SQL_SAFE_UPDATES = 1 ;
