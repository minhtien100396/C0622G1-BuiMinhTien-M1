use classicmodels;
select customers.customerName 
from customers
where customers.customerName ="Land Of Toys Inc.";

-- lệnh EXPLAIN: Bằng lệnh này bạn sẽ nhận ra được với câu Query của bạn, điều gì đang xảy ra và kiểu kết hợp (Join) nào đang diễn ra bên trong.
explain select customers.customerName 
from customers
where customers.customerName ="Land Of Toys Inc.";
-- EXPLAIN
-- table : Bảng nào đang liên quan đến output data
-- type : Đây là thông tin quan trọng, nó cho chúng ta biết kiểu query nào nó đang sử dụng. Mức độ từ tốt nhất đến chậm nhất như sau:
-- system, const, eq_ref, ref, range, index, all
-- Không có Possible_keys nào được sử dụng, MySQL phải duyệt qua 17123 bản ghi mới tìm ra cái ta cần

-- Thêm index cho bảng
alter table customers add index index_customers_name(customerName);
explain select customers.customerName 
from customers
where customers.customerName ="Land Of Toys Inc.";

-- EXPLAIN
-- possible_keys : Đưa ra những Index có thể sử dụng để query
-- key : và Index nào đang được sử dụng
-- key_len : Chiều dài của từng mục trong Index
-- ref : Cột nào đang sử dụng
-- rows : Số hàng (rows) mà MySQL dự đoán phải tìm
-- extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”


ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- Xóa index
ALTER TABLE customers DROP INDEX idx_full_name;