create database quan_ly_diem_thi;
use quan_ly_diem_thi;

create table hoc_sinh(
ma_hoc_sinh int primary key,
ten_hoc_sinh varchar(50),
ngay_sinh date,
lop varchar(50),
gioi_tinh varchar(50)
);



create table mon_hoc(
ma_mon_hoc int primary key,
ten_mon_hoc varchar(50)
);

create table giao_vien(
ma_giao_vien int primary key,
ten_giao_vien varchar(50),
so_dien_thoai varchar(50)
);

alter table mon_hoc add ma_giao_vien int;
alter table mon_hoc add foreign key (ma_giao_vien) references giao_vien(ma_giao_vien); 

create table bang_diem(
diem_thi double,
ngay_kiem_tra date,
ma_hoc_sinh int,
ma_mon_hoc int,
primary key (ma_hoc_sinh,ma_mon_hoc),
foreign key(ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
foreign key(ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);