-- Xây dựng quản lý lớp học và học viên Codedym
-- Có chức năng đăng nhập
-- Có chức năng quản lý lớp (CRUD)
-- Có chức năng quản lý học sinh
-- Có chức năng quản lý giảng viên
-- Thực thể: học viên, giảng viên, lớp , tài khoản .
-- Các quy tắc hình vẽ: 
-- Thực thể : Hình chữ nhật
-- Thuộc tính : elip
-- Thuộc tính khóa: elip có gạch dưới
-- Thuộc tính đa trị: elip lồng nhau (là thuộc tính có nhiều giá trị)
-- Hình thoi: thể hiên các mối quan hệ -> sử dung động từ
create database demo_c06;
use demo_c06;
create table tai_khoan(
-- not null: bắt buộc nhập thông tin khi thêm mới hoặc sửa
-- trường hợp trùng từ khóa với My SQL thì thêm ` ` ví dụ password.
usename varchar(15) primary key ,
`password` varchar(100) not null
);

create table lop_hoc(
ma_lop_hoc int primary key auto_increment,
ten_lop_hoc varchar(100)
);

create table giang_vien(
ma_giang_vien int primary key auto_increment,
ten_giang_vien varchar(100),
ngay_sinh date
);

create table hoc_vien(
-- auto_increment : tự động tăng chỉ áp dụng cho số
-- địa chỉ: thuộc tính đa trị sẽ thêm sau
ma_hoc_vien int primary key auto_increment,
ten_hoc_vien varchar(100),
ngay_sinh date,
email varchar(100),
-- Để thể hiện được mới quan hệ 1-1 cần 1 điều kiện unique : không được trùng lặp
usename varchar(15) unique,
ma_lop_hoc int,
foreign key (ma_lop_hoc) references lop_hoc(ma_lop_hoc),
foreign key (usename) references tai_khoan(usename)
);

  --   insert into lop_hoc(ten_lop_hoc) values ("C0622G1"); 
--    insert into tai_khoan values ("minhtien","123456"); 
--     insert into hoc_vien(ten_hoc_vien,ngay_sinh,email,usename,ma_lop_hoc) values ("Tiến","1996-03-10","minhtien@gmail.com","minhtien",1); 
--   insert into hoc_vien(ten_hoc_vien,ngay_sinh,email,usename,ma_lop_hoc) values ("Tiến","1996-03-10","minhtien@gmail.com","minhtien",2); 

create table dia_chi(
-- phân tích xem thuộc tính đa trị là quan hệ 1-n hay n-n . Nếu n-n thì phải chuyển sang B5.
-- giả sử 1 địa chỉ chỉ có 1 học sinh -> quan hệ 1-n.
ma_dia_chi int primary key auto_increment,
dia_chi varchar(255),
-- đặt khóa ngoại vào trong table mới :
ma_hoc_vien int,
foreign key(ma_hoc_vien) references hoc_vien(ma_hoc_vien)
);
create table giang_vien_day_lop_hoc(
-- Mối quan hệ n-n: có khóa chính là tập hợp của 2 khóa
-- Tạo khóa chính ở 2 bảng
ma_giang_vien int,
ma_lop_hoc int,
primary key(ma_giang_vien,ma_lop_hoc), -- khóa phức hợp
foreign key(ma_giang_vien) references giang_vien(ma_giang_vien),
foreign key(ma_lop_hoc) references lop_hoc(ma_lop_hoc)
);