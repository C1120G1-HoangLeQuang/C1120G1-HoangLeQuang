create database bai_anh_trung;
use bai_anh_trung;

create table phong_ban(
ma_bp varchar(50) not null primary key,
ten_bp varchar(50) not null
);

create table cong_trinh(
ma_ct varchar(50) not null primary key,
ten_ct varchar(50) not null,
dia_diem varchar(50) not null,
ngay_cap date not null,
ngay_kc date not null,
ngay_ht date not null
);

create table nhan_vien(
ma_nv varchar(50) not null primary key,
ho_ten varchar(50) not null,
ngay_sinh date not null,
gioi_tinh varchar(50) not null,
dia_chi varchar(50) not null,
ma_bp varchar(50) not null,
foreign key(ma_bp) references phong_ban(ma_bp)
);     

create table bao_hiem(
ma_bh varchar(50) not null primary key,
ngay_cap date not null,
thoi_han date not null,
ma_nv varchar(50) not null,
foreign key(ma_nv) references nhan_vien(ma_nv)
);

create table ngay_cong(
ma_ct varchar(50) not null,
ma_nv varchar(50) not null,
primary key(ma_ct, ma_nv),
sl_ngay_cong int not null,
foreign key(ma_ct) references cong_trinh(ma_ct),
foreign key(ma_nv) references nhan_vien(ma_nv)
);
