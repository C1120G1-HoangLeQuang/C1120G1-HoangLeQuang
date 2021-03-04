create database Casestudy;

use Casestudy;

create table vi_tri(
id_vitri int not null auto_increment primary key, 
ten_vitri varchar(45) not null
);

create table trinh_do(
id_trinhdo int not null auto_increment primary key,
trinh_do varchar(45) not null
);

create table bo_phan(
id_bophan int not null auto_increment primary key,
ten_bophan varchar(45) not null
);

create table loai_khach(
id_loaikhach int not null auto_increment primary key,
ten_loaikhach varchar(45) not null
);

create table kieu_thue(
id_kieuthue int not null auto_increment primary key,
ten_kieuthue varchar(45) not null,
gia int
);

create table loai_dich_vu(
id_loaidichvu int not null auto_increment primary key,
ten_loaidichvu varchar(45) not null
);

create table dich_vu_di_kem(
id_dichvudikem int not null auto_increment primary key,
ten_dichvudikem varchar(45) not null,
gia int not null,
don_vi int not null,
trangthai_khadung varchar(45) not null
);

create table nhan_vien(
id_nhanvien int not null auto_increment primary key,
ho_ten varchar(45) not null,
id_vitri int not null,
foreign key(id_vitri) references vi_tri(id_vitri) on update cascade on delete cascade,
id_trinhdo int not null,
foreign key(id_trinhdo) references trinh_do(id_trinhdo) on update cascade on delete cascade,
id_bophan int not null,
foreign key(id_bophan) references bo_phan(id_bophan) on update cascade on delete cascade,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong varchar(45) not null,
sdt varchar(45) not null,
email varchar(45) not null,
dia_chi varchar(45) not null
);

create table khach_hang(
id_khachhang int not null auto_increment primary key,
id_loaikhach int not null,
foreign key(id_loaikhach) references loai_khach(id_loaikhach) on update cascade on delete cascade,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
sdt varchar(45) not null,
email varchar(45) not null,
dia_chi varchar(45) not null
);

create table dich_vu(
id_dichvu int not null auto_increment primary key,
ten_dich_vu varchar(45) not null,
dien_tich int not null,
so_tang int not null,
songuoi_toida int not null,
chi_phi_thue int not null,
id_kieuthue int not null,
foreign key(id_kieuthue) references kieu_thue(id_kieuthue) on update cascade on delete cascade,
id_loaidichvu int not null,
foreign key(id_loaidichvu) references loai_dich_vu(id_loaidichvu) on update cascade on delete cascade,
trang_thai varchar(45) not null
);


create table hop_dong(
id_hopdong int not null auto_increment primary key,
id_nhanvien int not null,
foreign key(id_nhanvien) references nhan_vien(id_nhanvien) on update cascade on delete cascade,
id_khachhang int not null,
foreign key(id_khachhang) references khach_hang(id_khachhang) on update cascade on delete cascade,
id_dichvu int not null,
foreign key(id_dichvu) references dich_vu(id_dichvu) on update cascade on delete cascade,
ngaylam_hopdong date not null,
ngay_ketthuc date not null, 
tien_datcoc int not null,
tong_tien int not null
);


create table hop_dong_chi_tiet(
id_hopdongchitiet int not null auto_increment primary key,
id_hopdong int not null,
foreign key(id_hopdong) references hop_dong(id_hopdong) on update cascade on delete cascade,
id_dichvudikem int not null,
foreign key(id_dichvudikem) references dich_vu_di_kem(id_dichvudikem) on update cascade on delete cascade,
so_luong int not null
);











