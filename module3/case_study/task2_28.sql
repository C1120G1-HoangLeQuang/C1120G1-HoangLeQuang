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

/* Task 5 Case study */
/* Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). */



select khach_hang.id_khachhang, khach_hang.ho_ten, loai_khach.ten_loaikhach, dich_vu.ten_dich_vu, hop_dong.id_hopdong, ngaylam_hopdong, ngay_ketthuc, 
(dich_vu.chi_phi_thue+(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia)) as total 
from hop_dong
right join khach_hang on khach_hang.id_khachhang = hop_dong.id_khachhang
left join loai_khach on khach_hang.id_loaikhach = loai_khach.id_loaikhach
left join dich_vu on dich_vu.id_dichvu = hop_dong.id_dichvu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
left join dich_vu_di_kem on dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem;

/* Task 6 Case study */
/* Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại 
Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3) */ 

SELECT 
    dich_vu.id_dichvu,
    ten_dich_vu,
    dien_tich,
    chi_phi_thue,
    loai_dich_vu.ten_loaidichvu
FROM
    dich_vu
        INNER JOIN
    loai_dich_vu
WHERE
    dich_vu.id_dichvu IN (SELECT 
            hop_dong.id_dichvu
        FROM
            hop_dong
        WHERE
            hop_dong.ngaylam_hopdong BETWEEN '2019/01/01' AND '2019/03/31');
            
/* Task 7 Case study */
/* Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng trong năm 2019 */ 

SELECT 
    dich_vu.id_dichvu,
    ten_dich_vu,
    dien_tich,
    chi_phi_thue,
    loai_dich_vu.ten_loaidichvu
FROM
    dich_vu
        INNER JOIN
    loai_dich_vu
WHERE
    dich_vu.id_dichvu IN (SELECT 
            hop_dong.id_dichvu
        FROM
            hop_dong
        WHERE
            hop_dong.ngaylam_hopdong BETWEEN '2018/01/01' AND '2018/12/31');
            
/* Task 8 Case study */
/* Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên */

select distinct ho_ten from khach_hang;

/* Task 9 Case study */
/* Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng */ 

select count(id_hopdong), hop_dong.id_khachhang, ngaylam_hopdong from hop_dong
inner join khach_hang on hop_dong.id_khachhang = khach_hang.id_khachhang
where ngaylam_hopdong between '2019/01/01' AND '2019/12/31'
group by id_hopdong;

/* Task 10 Case study */
/* 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet) */

select hop_dong.id_hopdong, hop_dong.ngaylam_hopdong, hop_dong.ngay_ketthuc, hop_dong.tien_datcoc, 
count(id_hopdongchitiet) as soluong_dichvudikem  from hop_dong_chi_tiet
left join hop_dong on hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
group by hop_dong.id_hopdong;

/* Task 11 Case study */
/* Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Gold” 
và có địa chỉ là “Vinh” hoặc “Quảng Tri” */

select dich_vu_di_kem.id_dichvudikem, dich_vu_di_kem.ten_dichvudikem,
dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trangthai_khadung from hop_dong_chi_tiet
left join dich_vu_di_kem on dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem
left join hop_dong on hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
left join khach_hang on khach_hang.id_khachhang = hop_dong.id_khachhang
left join loai_khach on loai_khach.id_loaikhach = khach_hang.id_loaikhach
where loai_khach.ten_loaikhach = "Gold" and khach_hang.dia_chi = "Quảng Trị"; 

/* Task 12 Case study */
/* Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019 */





 
 
















