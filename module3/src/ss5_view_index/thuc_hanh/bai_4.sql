use classcustomersicmodels;

create view view_customers
as
select customers.customerNumber, 
	   customers.customerName,
       customers.phone
from customers;

select * from view_customers;

-- cập nhật view_customers

create or replace view view_customers 
as
select  customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = "Nantes";

select * from view_customers;

-- Xóa view 
drop view view_customers;
