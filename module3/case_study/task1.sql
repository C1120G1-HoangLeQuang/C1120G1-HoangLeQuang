/* Task 1 Case study*/

use Casestudy;


insert into vi_tri(ten_vitri)
values('Le Tan'), ('Phuc Vu'), ('Chuyen Vien'), ('Giam Sat'), ('Quan Ly'), ('Giam Doc');

insert into trinh_do(trinh_do)
values('Trung Cap'), ('Cao Dang'), ('Dai Hoc'), ('Sau Dai Hoc');

insert into bo_phan(ten_bophan)
values('Sale_Marketing'), ('Hanh Chinh'), ('Phuc Vu'), ('Quan Ly');

insert into loai_khach(ten_loaikhach)
values('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Members');

insert into kieu_thue(ten_kieuthue, gia)
values('Year', 140000), ('Month', 15000), ('Day', 500), ('Hour', 100);

insert into loai_dich_vu(ten_loaidichvu)
values('Villa'), ('House'), ('Room');

insert into dich_vu_di_kem(ten_dichvudikem, gia, don_vi, trangthai_khadung)
values 	('Massage', 35, 1, 'Co'),
		('Karaoke', 10, 1, 'Co'),
        ('Food', 25, 1, 'Co'),
        ('Drink', 10, 1, 'Co'),
        ('Rental', 40, 1, 'Co');
        
insert into nhan_vien(ho_ten, id_vitri, id_trinhdo, id_bophan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi)  
values	('Trần Quốc Hoàng', 1, 2, 2, '1995/12/12', '123123123', '300000', '0909123111', 'hoangtq@gmail.com', 'Quảng Nam'),
		('Ngọc Thuần', 5, 2, 1, '2000/10/05', '123123444', 400000, '0909123121', 'thuanng@gmail.com', 'TP HCM'),
		('Lê Quang',  6, 3, 4, '1998/02/11', '123123555', 900000, '0909123345', 'quangle@gmail.com', 'Huế'),
		('Trần Hoàng Sang',  1, 2, 3, '1995/04/04', '123123777', '300000', '0909123333', 'sangth@gmail.com', 'Quảng Bình'),
		('Bùi Khoa',  2, 3, 2, '1999/04/25', '123123999', '250000', '0909123222', 'khoa@gmail.com', 'Quảng Trị');
        
insert into khach_hang(id_loaikhach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi)
values	(3, 'Thanh Tùng','1995/04/05','345345345', 0908111222, 'tungth@gmail.com','Đà Nẵng'),
		(3, 'Bảo Ngọc', '2000/03/05', '111222333', 0908111333, 'ngoc@gmail.com', 'Quảng Trị'),
		(2, 'Cẩm Vân', '2001/11/11', '343444555', 0908111444, 'tungth@gmail.com', 'Quảng Bình'),
		(1, 'Ngọc Đông', '2001/04/05', '111111111', 0908111545, 'tungth@gmail.com', 'Đà Nẵng'),
		(2, 'Lươn Sang', '1994/12/12', '020202021', 0908111666,'tungth@gmail.com','Đà Nẵng');
        
insert into dich_vu(ten_dich_vu, dien_tich, so_tang, songuoi_toida, chi_phi_thue, id_kieuthue, id_loaidichvu, trang_thai)
values  ("Villa 1",100,3,10,500,3,1,"Available"),
		("House 1",60,2,6,300,2,2,"Available"),
		("Room 1",40,2,3,250,1,3,"Not available"),
		("Villa 2",80,2,8,400,2,1,"Available"),
		("Room 2",30,1,2,200,4,3,"Not available");
        
insert into hop_dong(id_nhanvien, id_khachhang, id_dichvu, ngaylam_hopdong, ngay_ketthuc, tien_datcoc, tong_tien)
values 	(1,2,2,"2018-12-12","2019-03-12",100,0),
		(1,1,5,"2019-01-12","2019-08-12",100,0),
		(2,5,4,"2020-01-12","2020-10-12",100,0),
		(5,1,5,"2021-01-12","2020-10-12",100,0),
		(4,3,3,"2019-05-01","2021-05-01",100,0);

insert into hop_dong_chi_tiet(id_hopdong, id_dichvudikem, so_luong)
values 	(1,1,3),
		(2,3,3),
		(2,4,5);








