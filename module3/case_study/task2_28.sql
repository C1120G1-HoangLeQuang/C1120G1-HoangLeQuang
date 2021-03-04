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

select count(id_hopdong), hop_dong.id_khachhang, month(ngaylam_hopdong) as thang from hop_dong
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

use Casestudy;
select hop_dong.id_hopdong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.sdt, dich_vu.ten_dich_vu,
count(hop_dong_chi_tiet.id_hopdongchitiet) as soluong_dichvudikem, tien_datcoc from hop_dong
inner join nhan_vien on nhan_vien.id_nhanvien = hop_dong.id_nhanvien
inner join khach_hang on khach_hang.id_khachhang = hop_dong.id_khachhang
inner join dich_vu on dich_vu.id_dichvu = hop_dong.id_dichvu
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
where hop_dong.ngaylam_hopdong between '2019/10/01' and '2019/12/31'
group by hop_dong_chi_tiet.id_hopdongchitiet;

/* Task 13 Case study */
/* Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau) */
 
select dich_vu_di_kem.id_dichvudikem, ten_dichvudikem, gia, don_vi,
trangthai_khadung, count(hop_dong_chi_tiet.so_luong) as soluong_dichvudikem from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
group by hop_dong_chi_tiet.id_dichvudikem
having max(hop_dong_chi_tiet.so_luong);

/* Task 14 Case study */
/* Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung */

select hop_dong.id_hopdong, loai_dich_vu.ten_loaidichvu, ten_dichvudikem, hop_dong_chi_tiet.so_luong, 
dich_vu_di_kem.id_dichvudikem, ten_dichvudikem, gia, don_vi, trangthai_khadung from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
inner join hop_dong on hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
inner join dich_vu on dich_vu.id_dichvu = hop_dong.id_dichvu
inner join loai_dich_vu on loai_dich_vu.id_loaidichvu = dich_vu.id_loaidichvu
where hop_dong_chi_tiet.so_luong = 1;

/* Task 15 Case study */
/* Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019 */

select nhan_vien.id_nhanvien, nhan_vien.ho_ten, trinh_do.trinh_do, bo_phan.ten_bophan,
nhan_vien.sdt, nhan_vien.dia_chi, count(hop_dong.id_nhanvien) as so_lan from nhan_vien
inner join trinh_do on trinh_do.id_trinhdo = nhan_vien.id_trinhdo
inner join bo_phan on bo_phan.id_bophan = nhan_vien.id_bophan
inner join hop_dong on hop_dong.id_nhanvien = nhan_vien.id_nhanvien
where (hop_dong.ngaylam_hopdong between '2018/01/01' and '2019/12/31')
group by nhan_vien.id_nhanvien
having count(hop_dong.id_nhanvien) <= 3;

/* Task 16 Case study */
/* Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2021 */

delete from nhan_vien where id_nhanvien not in
(
	select hop_dong.id_nhanvien
    from hop_dong
    where year(ngaylam_hopdong) between 2017 and 2021
);

/* Task 17 Case study */
/* Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Gold lên Platinum, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 200 USD */

create or replace view task172 as
	select 	khach_hang.id_loaikhach,
			sum(dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia)) as total 
    from hop_dong
	inner join khach_hang on khach_hang.id_khachhang = hop_dong.id_khachhang
	inner join loai_khach on khach_hang.id_loaikhach = loai_khach.id_loaikhach
	inner join dich_vu on dich_vu.id_dichvu = hop_dong.id_dichvu
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
	inner join dich_vu_di_kem on dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem
    where hop_dong.ngaylam_hopdong between '2019/01/01' and '2019/12/31'
	group by hop_dong.id_khachhang
	having sum((dich_vu.chi_phi_thue+(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia))) > 200;

UPDATE khach_hang
set id_loaikhach = 2
where (id_loaikhach = 3) 
and (id_loaikhach in 
	(
		select id_loaikhach from task172
    )
);

/* Task 18 Case study */
/* Xóa những khách hàng có hợp đồng trước năm 2019 (chú ý ràngbuộc giữa các bảng) */

delete from khach_hang
where id_khachhang in
(select hop_dong.id_khachhang from hop_dong
where year(ngaylam_hopdong) < 2018);

/* Task 19 Case study */
/* Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi */

create temporary table table19
select dich_vu_di_kem.id_dichvudikem, ten_dichvudikem, gia , don_vi,
trangthai_khadung, sum(hop_dong_chi_tiet.so_luong) as soluong_dichvudikem from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
group by hop_dong_chi_tiet.id_dichvudikem
having sum(hop_dong_chi_tiet.so_luong) > 10;

update dich_vu_di_kem
set gia = gia * 2
where id_dichvudikem in 
	(
		select id_dichvudikem  from table19
    )
;

/* Task 20 Case study */
/* Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi */

select id_nhanvien as id, ho_ten, email, sdt, ngay_sinh, dia_chi from nhan_vien
union all
select id_khachhang as id, ho_ten, email, sdt, ngay_sinh, dia_chi from khach_hang;

/* Task 21 Case study */
/* Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ 
là “Quảng Nam” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/01/2019” */

create or replace view V_NHANVIEN as
select nhan_vien.id_nhanvien, nhan_vien.ho_ten, nhan_vien.dia_chi, id_hopdong, ngaylam_hopdong from hop_dong
inner join nhan_vien on nhan_vien.id_nhanvien = hop_dong.id_nhanvien
where nhan_vien.dia_chi = "Quảng Nam" and hop_dong.ngaylam_hopdong = "2019/01/12";

/* Task 22 Case study */
/* Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này. */

create or replace view V_NHANVIEN2 as
	select nhan_vien.id_nhanvien as ID, nhan_vien.ho_ten, nhan_vien.dia_chi as dia_chi_update, 
    hop_dong.id_hopdong, hop_dong.ngaylam_hopdong from nhan_vien
	inner join hop_dong on nhan_vien.id_nhanvien = hop_dong.id_nhanvien
	where nhan_vien.dia_chi = "Quảng Nam" and hop_dong.ngaylam_hopdong = "2019/01/12";

update v_nhanvien2
set dia_chi_update = "Liên Chiểu";
-- where nhan_vien.id_nhanvien in (
-- 	select ID from v_nhanvien2);

/*select table_name, is_updatable
from information_schema.views
where table_schema = 'Casestudy';*/

/* Task 23 Case study */
/* Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng 
được truyền vào như là 1 tham số của Sp_1 */

delimiter //
create procedure deleteInforCustomerById(in idDelete int)
begin 
delete from khach_hang
where khach_hang.id_khachhang = idDelete;
end //
delimiter ;

call deleteInforCustomerById(5);
















 
 
















