create database baitap_ngay4;

use baitap_ngay4;
create table hoc_sinh(
id_hocsinh int not null auto_increment primary key,
ten varchar(45) not null,
tuoi int not null, 
khoa_hoc varchar(45) not null,
so_tien int not null
);

insert into hoc_sinh(ten, tuoi, khoa_hoc, so_tien)
values 	('Hoang', 21, 'CNTT', 400000),
		('Viet', 19, 'DTVT', 320000),
        ('Thanh', 18, 'KTDN', 400000),
        ('Nhan', 19, 'CK', 450000),
        ('Huong', 20, 'TCNH', 500000),
        ('Huong', 20, 'TCNH', 200000);

/* Viết câu lệnh hiện thị tất cả các dòng có tên là Huong */
select id_hocsinh, ten, tuoi, khoa_hoc, so_tien from hoc_sinh
where ten = "Huong";

/* Viết câu lệnh lấy ra tổng số tiền của Huong */
select sum(so_tien) as tong_tien from hoc_sinh
where ten = "Huong";

/* Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp */
select distinct ten from hoc_sinh;














