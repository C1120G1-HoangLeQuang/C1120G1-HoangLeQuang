create database BaiThiModule3;
use BaiThiModule3;

create table hinhthuc_thanhtoan(
ma_thanhtoan int not null auto_increment primary key,
hinhthuc_thanhtoan varchar(45) not null
);

create table phong_tro(
ma_phongtro varchar(45) not null primary key,
ten_khachthue varchar(45) not null,
sdt  varchar(45) not null,
ngay_thue  varchar(45) not null,
ma_thanhtoan int not null, 
foreign key(ma_thanhtoan) references hinhthuc_thanhtoan(ma_thanhtoan) on update cascade on delete cascade,
ghi_chu  varchar(45) not null
);

insert into hinhthuc_thanhtoan(hinhthuc_thanhtoan)
values 	('Theo Thang'),
		('Theo Quy'),
        ('Theo Nam');

insert into phong_tro(ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu)
values 	('PT-001', 'Tran Quoc Hoang', '0905123456', '21/12/2021', 1, 'Phong co dieu hoa'), 
		('PT-002', 'Hoang Le Quang', '0905123457', '20/08/2022', 2, 'Phong co dieu hoa'), 
        ('PT-003', 'Nguyen Ngoc Dong', '0905123222', '12/09/2021', 3, 'Phong co dieu hoa'), 
        ('PT-004', 'Bui Van Khoa', '0905123456', '09/09/2023', 1, 'Phong co dieu hoa'), 
        ('PT-005', 'Nguyen Thi Tuong Vi', '0905124444', '21/10/2024', 2, 'Phong co dieu hoa'), 
        ('PT-006', 'Tran Hoang Sang', '0905128888', '10/10/2021', 3, 'Phong co dieu hoa'), 
        ('PT-007', 'Nguyen Huu Nghia', '0905123453', '12/12/2021', 1, 'Phong co dieu hoa'); 

