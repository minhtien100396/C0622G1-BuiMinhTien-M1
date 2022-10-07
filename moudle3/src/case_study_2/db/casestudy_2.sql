DROP DATABASE IF EXISTS furuma_management;
CREATE DATABASE furuma_management;
USE furuma_management;

-- Vị trí 
CREATE TABLE position (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Trình độ học vấn
CREATE TABLE education_degree (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Bộ phận
CREATE TABLE division (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Loại khách
CREATE TABLE customer_type (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Loại dich vụ
CREATE TABLE facility_type (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Kiểu thuê
CREATE TABLE rent_type (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

-- Dịch vụ đi kèm
CREATE TABLE attach_facility (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    cost DOUBLE NOT NULL,
    unit VARCHAR(45) NOT NULL,
    `status` VARCHAR(45)
);

-- Vai trò
CREATE TABLE `role` (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255)
);

-- Tài khoản
CREATE TABLE `user` (
    username VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255)
);

-- Nhân Viên
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    date_of_birth DATE NOT NULL,
    id_card VARCHAR(45) NOT NULL,
    salary DOUBLE NOT NULL,
    phone_number VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    position_id INT NOT NULL,
    education_degree_id INT NOT NULL,
    division_id INT NOT NULL,
    username VARCHAR(255),
    FOREIGN KEY (position_id)
        REFERENCES position (id)
        ON DELETE CASCADE,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id)
        ON DELETE CASCADE,
    FOREIGN KEY (division_id)
        REFERENCES division (id)
        ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON DELETE CASCADE
);

-- Khách hàng
CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_id INT NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender BIT(1) NOT NULL,
    id_card VARCHAR(45) NOT NULL,
    phone_number VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id)
        ON DELETE CASCADE
);


-- Dịch vụ (standard room: loại phòng)
CREATE TABLE facility (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    area INT,
    cost DOUBLE NOT NULL,
    max_people INT,
    rent_type_id INT NOT NULL,
    facility_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Hợp đồng (deposit : tiền cọc)
CREATE TABLE contract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    deposit DOUBLE NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    facility_id INT NOT NULL,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id)
        ON DELETE CASCADE,
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        ON DELETE CASCADE,
    FOREIGN KEY (facility_id)
        REFERENCES facility (id)
        ON DELETE CASCADE
);

-- Dịch vụ chi tiết
CREATE TABLE contract_detail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    contract_id INT NOT NULL,
    attach_facility_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (contract_id)
        REFERENCES contract (id)
        ON DELETE CASCADE,
    FOREIGN KEY (attach_facility_id)
        REFERENCES attach_facility (id)
        ON DELETE CASCADE
);

-- Khóa phức hợp user_role
CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(45),
    FOREIGN KEY (role_id)
        REFERENCES `role` (role_id)
        ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON DELETE CASCADE,
    PRIMARY KEY (role_id , username)
);


-- Thêm thông tin vị trí - position
INSERT INTO position (`name`) 
VALUES ('Lễ tân'),
	   ('Phục vụ'),
	   ('Chuyên viên'),
	   ('Giám sát'),
	   ('Quản lý'),
	   ('Giám đốc');

-- Thêm thông tin cho trình độ học vấn - education_degree
INSERT INTO education_degree (`name`) 
VALUES ('Trung Cấp'),
	   ('Cao Đẳng'),
	   ('Đại Học'),
	   ('Sau Đại Học');

-- Thêm thông tin cho bộ phận - division
INSERT INTO division (`name`) 
VALUES ('Sale-Marketing'),
	   ('Hành chính'),
	   ('Phục vụ'),
	   ('Quản lý');
       
-- Thêm thông tin cho loại khách hàng - customer_type
INSERT INTO customer_type (`name`) 
VALUES ('Diamond'),
	   ('Platinium'),
	   ('Gold'),
	   ('Silver'),
	   ('Member');
       
-- Thêm thông tin cho loại dich vụ - facility_type
INSERT INTO facility_type (`name`) 
VALUES ('Villa'),
	   ('House'),
	   ('Room');
       
-- Thêm thông tin cho kiểu thuê - rent_type
INSERT INTO rent_type (`name`) 
VALUES ('year'),
	   ('month'),
	   ('day'),
	   ('hour');
       
-- Thêm thông tin cho dịch vụ đi kèm - attach_facility
INSERT INTO attach_facility (`name`,cost, unit,`status`) 
VALUES ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
	   ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
	   ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
	   ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	   ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	   ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
       
-- Thêm thông tin cho vai trò - role
INSERT INTO `role` (role_name) 
VALUES ('Admin'),
	   ('User');
       
-- Thêm thông tin cho người dùng - user
INSERT INTO `user` (username, `password`) 
VALUES ('minhtien123','minhtien123'),
	   ('annguyen123','annguyen123'),
	   ('binhle123','binhle123'),
	   ('yenho123','yenho123'),
	   ('toanvo123','toanvo123'),
	   ('phatnguyen123','phatnguyen123'),
	   ('nghikhuc123','nghikhuc123'),
	   ('hanguyen123','hanguyen123'),
	   ('hadong123','hadong123'),
	   ('tonghoang123','tonghoang123');
       
-- Thêm thông tin cho role_user

INSERT INTO user_role (role_id, username) 
VALUES (1,'minhtien123'),
	   (2,'annguyen123'),
	   (2,'binhle123'),
	   (2,'yenho123'),
	   (2,'toanvo123'),
	   (2,'phatnguyen123'),
	   (2,'nghikhuc123'),
	   (2,'hanguyen123'),
	   (2,'hadong123'),
	   (2,'tonghoang123');

-- Thêm thông tin cho nhân viên - employee

INSERT INTO employee (`id`, `name`, `date_of_birth`, `id_card`, `salary`, `phone_number`, `email`, `address`, `position_id`, `education_degree_id`, `division_id`, `username`) 
VALUES 
(1, 'Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1, 'annguyen123'),
(2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2, 'binhle123'),
(3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, 'yenho123'),
(4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, 'toanvo123'),
(5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1, 'phatnguyen123'),
(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, 'nghikhuc123'),
(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, 'hanguyen123'),
(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4, 'hadong123'),
(9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, 'tonghoang123'),
(10, 'Bùi Minh Tiến', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2, 'minhtien123');


-- Thêm thông tin cho khách hàng - customer
INSERT INTO customer (`id`, `name`, `date_of_birth`,`gender`,`id_card`, `phone_number`, `email`, `address`, `customer_type_id`) 
VALUES 
(1, 'Nguyễn Thị Hào', '1970-11-07',0,  '643431213',  '0945423362',  'thihao07@gmail.com',  '23 Nguyễn Hoàng, Đà Nẵng',  5),
( 2,  'Phạm Xuân Diệu',  '1992-08-08',1,  '865342123',  '0954333333',  'xuandieu92@gmail.com',  'K77/22 Thái Phiên, Quảng Trị',  3),
( 3,  'Trương Đình Nghệ',  '1990-02-27',1,  '488645199',  '0373213122',  'nghenhan2702@gmail.com',  'K323/12 Ông Ích Khiêm, Vinh',  1),
( 4,  'Dương Văn Quan',  '1981-07-08',1,  '543432111',  '0490039241',  'duongquan@gmail.com',  'K453/12 Lê Lợi, Đà Nẵng',  1),
( 5,  'Hoàng Trần Nhi Nhi',  '1995-12-09',0,  '795453345',  '0312345678',  'nhinhi123@gmail.com',  '224 Lý Thái Tổ, Gia Lai',  4),
( 6,  'Tôn Nữ Mộc Châu',  '2005-12-06',0,  '732434215',  '0988888844',  'tonnuchau@gmail.com',  '37 Yên Thế, Đà Nẵng',  4),
( 7,  'Nguyễn Mỹ Kim',  '1984-04-08',0,  '856453123',  '0912345698',  'kimcuong84@gmail.com',  'K123/45 Lê Lợi, Hồ Chí Minh',  1),
( 8,  'Nguyễn Thị Hào',  '1999-04-08',0,  '965656433',  '0763212345',  'haohao99@gmail.com',  '55 Nguyễn Văn Linh, Kon Tum',  3),
( 9,  'Trần Đại Danh',  '1994-07-01',1,  '432341235',  '0643343433',  'danhhai99@gmail.com',  '24 Lý Thường Kiệt, Quảng Ngãi',  1),
( 10,  'Nguyễn Tâm Đắc',  '1989-07-01',1,  '344343432',  '0987654321',  'dactam@gmail.com',  '22 Ngô Quyền, Đà Nẵng',  2);


-- Thêm thông tin cho dịch vu - facility
INSERT INTO facility (`id`, `name`, `area`, `cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `facility_free`, `rent_type_id`, `facility_type_id`) 
VALUES 
(1, 'Villa Beach Front', 25000, 1000000, 10, 'vip', 'Có hồ bơi', 500, '4', null, 3, 1),
(2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, '3', null, 2, 2),
(3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy, 1 Xe đạp', 4, 3),
(4, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, '3', null, 3, 1),
(5, 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, '2', null, 3, 2),
(6, 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy', 4, 3);

-- Thêm thông tin cho hợp đồng
INSERT INTO `contract` (`id`, `start_date`, `end_date`, `deposit`, `employee_id`, `customer_id`, `facility_id`) 
VALUES 
(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);

-- Thêm thông tin cho hợp đồng chi tiết - contract_detail
INSERT INTO contract_detail(`id`,`quantity`,`contract_id`,`attach_facility_id`)
VALUES
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

select * from facility;
select * from employee;
-- set SQL_SAFE_UPDATES = 0 ;
-- set FOREIGN_KEY_CHECKS=0;
update facility set `name`="33",  area = 32, cost = 12, max_people=12, rent_type_id=2,facility_type_id=2,standard_room="1232",
description_other_convenience = "2132", pool_area= 123, number_of_floors=12,facility_free="123" 
where id =1;


	update  employee set  `name` = 'Tiến', `date_of_birth` = '1970-11-07', `id_card` = '456231786', 
	`salary` = 232, `phone_number` ="32323", `email` = "232@gmail.com", `address`= "321321", `position_id`= 1, 
	`education_degree_id`= 2, `division_id`= 2
	where id =1;	
    
    update customer set customer_type_id = 1, name="22", date_of_birth= "1970-11-07" , gender = 0, 
    id_card ="2", phone_number ="22", email = "222", 