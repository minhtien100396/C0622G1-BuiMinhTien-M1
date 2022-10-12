-- Yêu cầu 1: Tạo Database	
-- Tên bảng, thuộc tính, database tất cả đều phải theo quy tắc snake_case
-- Tạo database
create database demo_c06;
-- Sử dụng database demo_c06 để thực hiện truy vấn.
use demo_c06;

-- Yêu cầu 2: Tạo Table sinh viên có các thuộc tính: mã sinh viên, tên sinh viên, ngày sinh.
create table sinh_vien(
ma_sinh_vien int,
ten_sinh_vien varchar(70), -- 70 là số lượng phần tử tối đa.
ngay_sinh date,
primary key(ma_sinh_vien)
);

-- Hiển thị table sinh viên có dữ liệu như thế nào.
-- * : hiển thị tất cả thông tin
-- from: từ bảng nào?
-- Nếu muốn hiển thị một số thông tin thôi. Thì thay dấu *  bằng thuộc tính
-- Ví dụ: select ma_sinh_vien from sinh_vien;
select * from sinh_vien;

-- Yêu cầu 3: Xóa table , database
drop table sinh_vien;
drop database demo_c06;

-- Yêu cầu 4: Thêm dữ liệu;
-- Khi thêm bắt buộc phải có giá trị của khóa chính mới thêm được.
-- Nếu khóa chính tự động tăng thì không cần phải thêm cũng được
-- Thêm đầy đủ thông tin.
insert into sinh_vien values(1, "Bùi Minh Tiến", "1996-03-10");
-- Thêm thiếu thông tin
insert into sinh_vien(ma_sinh_vien,ten_sinh_vien) values (2, "Bùi Quang");

-- Thêm liên tục
insert into sinh_vien(ma_sinh_vien,ten_sinh_vien) values (3,"Viết Huy"),(4,"Thanh Hải"),(5,"Hoàng Duy");


-- Yêu cầu 5: Thay đổi cấu trúc của table.
-- first: nếu muốn thêm cột trước cột nào đó
-- after: nếu muốn thêm cột sau cột nào đó
alter table sinh_vien add mo_ta text after ngay_sinh;


-- Yêu cầu 6: cập nhật/xóa thông tin của Bùi Minh Tiến -> ngày sinh.
-- Lỗi phát sinh khi cập nhật 1 bản ghi dựa theo 1 điều kiện mà không phải là khóa chính -> phát sinh ra lỗi không cập nhật được
set SQL_SAFE_UPDATES = 0 ; -- Tắt chế độ an toàn
update sinh_vien set ngay_sinh = "1995-10-03" where ten_sinh_vien = "Bùi Minh Tiến"; -- Cập nhật
set SQL_SAFE_UPDATES = 1 ; -- Bật chế độ an toàn lại

delete from sinh_vien where ten_sinh_vien = "Bùi Minh Tiến";

-- Truncate: nằm trong nhóm DDL -> Xóa toàn bộ dữ liệu -> reset.
truncate table sinh_vien;
