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

SELECT 
    khach_hang.id_khachhang,
    ho_ten,
    COUNT(hop_dong.id_khachhang) AS So_lan_dat_phong
FROM
    khach_hang
        INNER JOIN
    hop_dong ON hop_dong.id_khachhang = khach_hang.id_khachhang
        INNER JOIN
    loai_khach ON khach_hang.id_loaikhach = loai_khach.id_loaikhach
WHERE
    loai_khach.ten_loaikhach = 'Diamond'
GROUP BY hop_dong.id_khachhang;

/* Task 5 Case study */
/* Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). */



SELECT 
    khach_hang.id_khachhang,
    khach_hang.ho_ten,
    loai_khach.ten_loaikhach,
    dich_vu.ten_dich_vu,
    hop_dong.id_hopdong,
    ngaylam_hopdong,
    ngay_ketthuc,
    (dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)) AS total
FROM
    hop_dong
        RIGHT JOIN
    khach_hang ON khach_hang.id_khachhang = hop_dong.id_khachhang
        LEFT JOIN
    loai_khach ON khach_hang.id_loaikhach = loai_khach.id_loaikhach
        LEFT JOIN
    dich_vu ON dich_vu.id_dichvu = hop_dong.id_dichvu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem;

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

SELECT 
    COUNT(id_hopdong),
    hop_dong.id_khachhang,
    MONTH(ngaylam_hopdong) AS thang
FROM
    hop_dong
        INNER JOIN
    khach_hang ON hop_dong.id_khachhang = khach_hang.id_khachhang
WHERE
    ngaylam_hopdong BETWEEN '2019/01/01' AND '2019/12/31'
GROUP BY id_hopdong;

/* Task 10 Case study */
/* 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet) */

SELECT 
    hop_dong.id_hopdong,
    hop_dong.ngaylam_hopdong,
    hop_dong.ngay_ketthuc,
    hop_dong.tien_datcoc,
    COUNT(id_hopdongchitiet) AS soluong_dichvudikem
FROM
    hop_dong_chi_tiet
        LEFT JOIN
    hop_dong ON hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
GROUP BY hop_dong.id_hopdong;

/* Task 11 Case study */
/* Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Gold” 
và có địa chỉ là “Vinh” hoặc “Quảng Tri” */

SELECT 
    dich_vu_di_kem.id_dichvudikem,
    dich_vu_di_kem.ten_dichvudikem,
    dich_vu_di_kem.gia,
    dich_vu_di_kem.don_vi,
    dich_vu_di_kem.trangthai_khadung
FROM
    hop_dong_chi_tiet
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem
        LEFT JOIN
    hop_dong ON hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
        LEFT JOIN
    khach_hang ON khach_hang.id_khachhang = hop_dong.id_khachhang
        LEFT JOIN
    loai_khach ON loai_khach.id_loaikhach = khach_hang.id_loaikhach
WHERE
    loai_khach.ten_loaikhach = 'Gold'
        AND khach_hang.dia_chi = 'Quảng Trị'; 

/* Task 12 Case study */
/* Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019 */

use Casestudy;
SELECT 
    hop_dong.id_hopdong,
    nhan_vien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.sdt,
    dich_vu.ten_dich_vu,
    COUNT(hop_dong_chi_tiet.id_hopdongchitiet) AS soluong_dichvudikem,
    tien_datcoc
FROM
    hop_dong
        INNER JOIN
    nhan_vien ON nhan_vien.id_nhanvien = hop_dong.id_nhanvien
        INNER JOIN
    khach_hang ON khach_hang.id_khachhang = hop_dong.id_khachhang
        INNER JOIN
    dich_vu ON dich_vu.id_dichvu = hop_dong.id_dichvu
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
WHERE
    hop_dong.ngaylam_hopdong BETWEEN '2019/10/01' AND '2019/12/31'
GROUP BY hop_dong_chi_tiet.id_hopdongchitiet;

/* Task 13 Case study */
/* Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau) */
 
SELECT 
    dich_vu_di_kem.id_dichvudikem,
    dich_vu_di_kem.ten_dichvudikem,
    dich_vu_di_kem.gia,
    dich_vu_di_kem.don_vi,
    dich_vu_di_kem.trangthai_khadung,
    COUNT(hop_dong_chi_tiet.id_dichvudikem) AS soluong_dichvudikem
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
GROUP BY hop_dong_chi_tiet.id_dichvudikem
HAVING COUNT(hop_dong_chi_tiet.id_dichvudikem) = (SELECT 
        MAX(soluong_dichvudikem)
    FROM
        (SELECT 
            COUNT(id_dichvudikem) AS soluong_dichvudikem
        FROM
            hop_dong_chi_tiet
        GROUP BY id_dichvudikem) AS solan_sudung); 


/* Task 14 Case study */
/* Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung */

SELECT 
    hop_dong.id_hopdong,
    loai_dich_vu.ten_loaidichvu,
    ten_dichvudikem,
    hop_dong_chi_tiet.so_luong,
    dich_vu_di_kem.id_dichvudikem,
    ten_dichvudikem,
    gia,
    don_vi,
    trangthai_khadung
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
        INNER JOIN
    hop_dong ON hop_dong.id_hopdong = hop_dong_chi_tiet.id_hopdong
        INNER JOIN
    dich_vu ON dich_vu.id_dichvu = hop_dong.id_dichvu
        INNER JOIN
    loai_dich_vu ON loai_dich_vu.id_loaidichvu = dich_vu.id_loaidichvu
WHERE
    hop_dong_chi_tiet.so_luong = 1;

/* Task 15 Case study */
/* Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019 */

SELECT 
    nhan_vien.id_nhanvien,
    nhan_vien.ho_ten,
    trinh_do.trinh_do,
    bo_phan.ten_bophan,
    nhan_vien.sdt,
    nhan_vien.dia_chi,
    COUNT(hop_dong.id_nhanvien) AS so_lan
FROM
    nhan_vien
        INNER JOIN
    trinh_do ON trinh_do.id_trinhdo = nhan_vien.id_trinhdo
        INNER JOIN
    bo_phan ON bo_phan.id_bophan = nhan_vien.id_bophan
        INNER JOIN
    hop_dong ON hop_dong.id_nhanvien = nhan_vien.id_nhanvien
WHERE
    (hop_dong.ngaylam_hopdong BETWEEN '2018/01/01' AND '2019/12/31')
GROUP BY nhan_vien.id_nhanvien
HAVING COUNT(hop_dong.id_nhanvien) <= 3;

/* Task 16 Case study */
/* Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2021 */

DELETE FROM nhan_vien 
WHERE
    id_nhanvien NOT IN (SELECT 
        hop_dong.id_nhanvien
    FROM
        hop_dong
    
    WHERE
        YEAR(ngaylam_hopdong) BETWEEN 2017 AND 2021);

/* Task 17 Case study */
/* Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Gold lên Platinum, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 200 USD */

CREATE OR REPLACE VIEW task172 AS
    SELECT 
        khach_hang.id_loaikhach,
        SUM(dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)) AS total
    FROM
        hop_dong
            INNER JOIN
        khach_hang ON khach_hang.id_khachhang = hop_dong.id_khachhang
            INNER JOIN
        loai_khach ON khach_hang.id_loaikhach = loai_khach.id_loaikhach
            INNER JOIN
        dich_vu ON dich_vu.id_dichvu = hop_dong.id_dichvu
            INNER JOIN
        hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hopdong = hop_dong.id_hopdong
            INNER JOIN
        dich_vu_di_kem ON dich_vu_di_kem.id_dichvudikem = hop_dong_chi_tiet.id_dichvudikem
    WHERE
        hop_dong.ngaylam_hopdong BETWEEN '2019/01/01' AND '2019/12/31'
    GROUP BY hop_dong.id_khachhang
    HAVING SUM((dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia))) > 200;

UPDATE khach_hang 
SET 
    id_loaikhach = 2
WHERE
    (id_loaikhach = 3)
        AND (id_loaikhach IN (SELECT 
            id_loaikhach
        FROM
            task172));

/* Task 18 Case study */
/* Xóa những khách hàng có hợp đồng trước năm 2019 (chú ý ràngbuộc giữa các bảng) */

DELETE FROM khach_hang 
WHERE
    id_khachhang IN (SELECT 
        hop_dong.id_khachhang
    FROM
        hop_dong
    
    WHERE
        YEAR(ngaylam_hopdong) < 2018);

/* Task 19 Case study */
/* Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi */

create temporary table table19
select dich_vu_di_kem.id_dichvudikem, ten_dichvudikem, gia , don_vi,
trangthai_khadung, sum(hop_dong_chi_tiet.so_luong) as soluong_dichvudikem from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dichvudikem = dich_vu_di_kem.id_dichvudikem
group by hop_dong_chi_tiet.id_dichvudikem
having sum(hop_dong_chi_tiet.so_luong) > 10;

UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    id_dichvudikem IN (SELECT 
            id_dichvudikem
        FROM
            table19)
;

/* Task 20 Case study */
/* Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi */

SELECT 
    id_nhanvien AS id,
    ho_ten,
    email,
    sdt,
    ngay_sinh,
    dia_chi,
    'Nhan vien' AS vi_tri
FROM
    nhan_vien 
UNION ALL SELECT 
    id_khachhang AS id,
    ho_ten,
    email,
    sdt,
    ngay_sinh,
    dia_chi,
    'Khach hang' AS vi_tri
FROM
    khach_hang;

/* Task 21 Case study */
/* Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ 
là “Quảng Nam” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/01/2019” */

CREATE OR REPLACE VIEW V_NHANVIEN AS
    SELECT 
        nhan_vien.id_nhanvien,
        nhan_vien.ho_ten,
        nhan_vien.dia_chi,
        id_hopdong,
        ngaylam_hopdong
    FROM
        hop_dong
            INNER JOIN
        nhan_vien ON nhan_vien.id_nhanvien = hop_dong.id_nhanvien
    WHERE
        nhan_vien.dia_chi = 'Quảng Nam'
            AND hop_dong.ngaylam_hopdong = '2019/01/12';

/* Task 22 Case study */
/* Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này. */

CREATE OR REPLACE VIEW V_NHANVIEN2 AS
    SELECT 
        nhan_vien.id_nhanvien AS ID,
        nhan_vien.ho_ten,
        nhan_vien.dia_chi AS dia_chi_update,
        hop_dong.id_hopdong,
        hop_dong.ngaylam_hopdong
    FROM
        nhan_vien
            INNER JOIN
        hop_dong ON nhan_vien.id_nhanvien = hop_dong.id_nhanvien
    WHERE
        nhan_vien.dia_chi = 'Quảng Nam'
            AND hop_dong.ngaylam_hopdong = '2019/01/12';

UPDATE v_nhanvien2 
SET 
    dia_chi_update = 'Liên Chiểu';
-- where nhan_vien.id_nhanvien in (
-- 	select ID from v_nhanvien2);

/*select table_name, is_updatable
from information_schema.views
where table_schema = 'Casestudy';*/

/* Task 23 Case study */
/* Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng 
được truyền vào như là 1 tham số của Sp_1 */

delimiter //
create procedure Sp_1(in idDelete int)
begin 
delete from khach_hang
where khach_hang.id_khachhang = idDelete;
end //
delimiter ;

call Sp_1(5);

/* Task 24 Case study */
/* Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và 
đảm bảo toàn vẹn tham chiếu đến các bảng liên quan */

delimiter //
create procedure Sp_4(
	in new_idNhanvien int,
	in new_idKhachhang int,
	in new_idDichvu int,
	in new_ngaylamhopdong date,
	in new_ngayketthuc date,
	in new_tiendatcoc int,
	in new_tongtien int
)
begin 
	if 
		new_idNhanvien in(select id_nhanvien from nhan_vien) and
        new_idKhachhang  in(select id_khachhang from khach_hang) and
        new_idDichvu  in(select id_dichvu from dich_vu) 
    then    
		insert into hop_dong(id_nhanvien, id_khachhang, id_dichvu, ngaylam_hopdong, ngay_ketthuc, tien_datcoc, tong_tien)
	values (
		new_idNhanvien,
		new_idKhachhang,
		new_idDichvu,
		new_ngaylamhopdong,
		new_ngayketthuc,
		new_tiendatcoc,
		new_tongtien);
    end if;
end //
delimiter ;

call Sp_4(3, 4, 2, "2019-11-26", "2019-12-28", 700, 0);















 
 
















