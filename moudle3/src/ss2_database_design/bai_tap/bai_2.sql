create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer (
customer_id int auto_increment not null primary key,
customer_name varchar(50),
customer_age int
);

create table product(
product_id int auto_increment not null primary key,
product_name varchar(50),
product_price double
);

create table `order` (
order_id int auto_increment not null primary key,
order_date date,
order_total_price double,
customer_id int,
foreign key (customer_id) references customer(customer_id)
);

create table order_detail(
odQTY varchar(50),
order_id int,
product_id int,
primary key(order_id,product_id),
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references product(product_id)
);

