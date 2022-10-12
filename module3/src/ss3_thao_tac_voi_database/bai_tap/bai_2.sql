create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer (
customer_id int auto_increment primary key,
customer_name varchar(50),
customer_age int
);

create table product(
product_id int auto_increment primary key,
product_name varchar(50),
product_price double
);

create table `order` (
order_id int auto_increment primary key,
order_date date,
order_total_price double,
customer_id int,
foreign key (customer_id) references customer(customer_id)
);

create table order_detail(
order_id int,
product_id int,
odQTY varchar(50),
primary key(order_id,product_id),
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references product(product_id)
);

-- Thay đổi kiểu dữ liệu của odQTY từ varchar sang int
alter table order_detail modify column odQTY int;

-- Thêm thông tin cho table cuctomer
insert into customer(customer_name,customer_age) values ("Minh Quan",10),
														("Ngoc Oanh",20),
														("Hong Ha",50);
													
-- Thêm thông tin cho table order
insert into `order`(customer_id,order_date,order_total_price) values (1,"2006-03-21",null),
																     (2,"2006-03-23",null),
																     (1,"2006-03-16",null);
                                                                     
 -- Thêm thông tin cho table product                                                                    
insert into product(product_name,product_price) values ("May Giat",3),
													   ("Tu Lanh",5),
													   ("Dieu Hoa",7),
													   ("Quat",1),
													   ("Bep Dien",2);

 -- Thêm thông tin cho table order_detail                                                                    
insert into order_detail values (1,1,3),
								(1,3,7),
								(1,4,2),
								(2,1,1),
								(3,1,8),
								(2,5,4),
								(2,3,3);
													  
-- Hiển thị các thông tin gồm order_id, order_date, order_total_price của tất cả các hóa đơn trong bảng Order
select `order`.order_id, `order`.order_date, `order`.order_total_price 
from `order`;			

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select `order`.order_id, customer.customer_id,customer.customer_name,product.product_name
from customer
join `order` 
on customer.customer_id = `order`.customer_id	
join order_detail	
on order_detail.order_id = `order`.order_id
join product
on product.product_id = order_detail.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào.
select `order`.order_id, customer.customer_id,customer.customer_name
from customer
left join `order` 
on customer.customer_id = `order`.customer_id	
where `order_id` is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.order_id,`order`.order_date, sum(odQTY*product_price) as order_id_price
from `order`
join order_detail	
on order_detail.order_id = `order`.order_id
join product
on product.product_id = order_detail.product_id
group by `order`.order_id;