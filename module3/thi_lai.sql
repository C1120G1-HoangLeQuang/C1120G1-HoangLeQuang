create database ThiLaiModule3;
drop database ThiLaiModule3;
use ThiLaiModule3;

create table san_pham(
id_sanpham int not null auto_increment primary key,
ten_sanpham varchar(100) not null,
gia double not null, 
muc_giamgia double not null,
ton_kho int not null
);

create table nhan_vien(
id_nhanvien int not null auto_increment primary key,
ten_nhanvien varchar(100) not null,
ngay_sinh varchar(100) not null,
dia_chi varchar(100) not null
);

create table khach_hang(
id_khachhang int not null auto_increment primary key,
ten_khachhang varchar(100) not null,
ngay_sinh varchar(100) not null,
sdt varchar(100) not null,
dia_chi varchar(100) not null,
email varchar(100) not null
);

create table don_hang(
id_donhang int not null auto_increment primary key,
phuongthuc_thanhtoan varchar(100) not null,
id_sanpham int not null, 
foreign key (id_sanpham) references san_pham(id_sanpham) on update cascade on delete cascade,
id_khachhang int not null,
foreign key(id_khachhang) references khach_hang(id_khachhang) on update cascade on delete cascade,
id_nhanvien int not null,
foreign key(id_nhanvien) references nhan_vien(id_nhanvien) on update cascade on delete cascade,
ngay_dathang date not null,
ngay_giaohang date not null,
diachi_giaohang varchar(100) not null
);

insert into san_pham(ten_sanpham, gia, muc_giamgia, ton_kho)
values 	('IPhone', 1000, 10, 10),
		('SamSung', 800, 20, 10),
        ('Viettel', 500, 30, 10);
insert into san_pham(ten_sanpham, gia, muc_giamgia, ton_kho)
values 	('TV', 700, 20, 10),
		('May Giat', 200, 20, 10),
        ('May Tinh', 900, 30, 10),
        ('Chuot', 800, 30, 10), 
        ('Ban Phim', 300, 30, 10), 
        ('Internet', 400, 30, 10), 
        ('Chip', 600, 30, 10);
        
insert into nhan_vien(ten_nhanvien, ngay_sinh, dia_chi)
values 	('Tran Quoc Hoang', '20/12/1995', 'Quang Nam'),
		('Hoang Le Quang', '12/08/1993', 'Da Nang'),
        ('Nguyen Ngoc Thuan', '21/10/1997', 'Quang Tri');
insert into nhan_vien(ten_nhanvien, ngay_sinh, dia_chi)
values 	('Bui Khoa', '20/12/1995', 'Hue'),
		('van Phuc', '12/08/1993', 'Da Nang'),
        ('Tuong Vi', '21/10/1997', 'Quang Tri'),
        ('Hoang Sang', '21/10/1997', 'Quang Tri'),
        ('Ngoc Dong', '21/10/1997', 'Quang Tri'),
        ('Huu Nghia', '21/10/1997', 'Quang Tri'),
        ('Trung Dang', '21/10/1997', 'Quang Tri');
        
insert into khach_hang(ten_khachhang, ngay_sinh, sdt, dia_chi, email)
values	('Ramsey', '12/12/1992', '0905123456', 'England', 'aaron@gmail.com'),
		('Rosicky', '10/10/1982', '0905123654', 'Czech', 'tomas@gmail.com'),
        ('Wilshere', '12/10/1995', '0905123444', 'England', 'jack@gmail.com');
insert into khach_hang(ten_khachhang, ngay_sinh, sdt, dia_chi, email)
values	('Wenger', '12/12/1992', '0905123456', 'England', 'aaron@gmail.com'),
		('Song', '10/10/1982', '0905123654', 'Czech', 'tomas@gmail.com'),
        ('Puyol', '12/10/1995', '0905123444', 'England', 'jack@gmail.com'),   
        ('Ronaldo', '12/10/1995', '0905123444', 'England', 'jack@gmail.com'),   
        ('Messi', '12/10/1995', '0905123444', 'England', 'jack@gmail.com'),   
        ('Lukaku', '12/10/1995', '0905123444', 'England', 'jack@gmail.com'),   
        ('Partey', '12/10/1995', '0905123444', 'England', 'jack@gmail.com');
        
insert into don_hang(phuongthuc_thanhtoan, id_sanpham, id_khachhang, id_nhanvien, ngay_dathang, ngay_giaohang, diachi_giaohang)
values 	('USD', 5, 1, 1, '2020-08-20', '2020-09-20', 'England'),
		('EUR', 6, 2, 2, '2020-10-20', '2020-08-20', 'Czech'),
        ('VND', 9, 3, 3, '2020-02-20', '2020-08-20', 'England');
insert into don_hang(phuongthuc_thanhtoan, id_sanpham, id_khachhang, id_nhanvien, ngay_dathang, ngay_giaohang, diachi_giaohang)
values 	('USD', 1, 1, 1, '2020-09-20', '2020-08-20', 'England'),
		('EUR', 1, 2, 2, '2020-12-12', '2020-08-20', 'Czech'),
        ('USD', 1, 3, 3, '2020-05-20', '2020-08-20', 'England'),
        ('VND', 2, 3, 3, '2020-06-20', '2020-08-20', 'England'),
        ('VND', 2, 3, 3, '2020-01-20', '2020-08-20', 'England'),
        ('VND', 3, 3, 3, '2020-03-20', '2020-08-20', 'England'),
        ('VND', 4, 3, 3, '2020-04-20', '2020-08-20', 'England');










