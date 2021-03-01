/* Task 2 Case study */
/* Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
và có tối đa 15 ký tự. */

use Casestudy;
select ho_ten, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi from nhan_vien
where (ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%") and length(ho_ten) <= 30; 

/* Task 3 Case study */
/* Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”. */

select ho_ten, timestampdiff(YEAR, ngay_sinh, curdate()) as tuoi, so_cmnd, email, dia_chi from khach_hang
where dia_chi = "Đà Nẵng" or dia_chi = "Quảng Trị";

/* Task 4 Case study */
/* Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”. */

select khach_hang.id_khachhang, ho_ten, count(hop_dong.id_khachhang) as So_lan_dat_phong from khach_hang
inner join hop_dong on hop_dong.id_khachhang = khach_hang.id_khachhang
inner join loai_khach on khach_hang.id_loaikhach = loai_khach.id_loaikhach
where loai_khach.ten_loaikhach = 'Diamond'
group by hop_dong.id_khachhang;










