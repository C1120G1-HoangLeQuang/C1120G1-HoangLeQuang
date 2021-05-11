package Model;

import java.sql.Date;

public class DonHang {
    private int id_donhang;
    private String phuongthuc_thanhtoan;
    private SanPham id_sanpham;
    private KhachDat id_khachhang;
    private NhanVien id_nhanvien;
    private java.sql.Date ngay_dathang;
    private java.sql.Date ngay_giaohang;
    private String diachi_giaohang;

    public DonHang() {
    }

    public DonHang(String phuongthuc_thanhtoan, SanPham id_sanpham, KhachDat id_khachhang, NhanVien id_nhanvien, java.sql.Date ngay_dathang, java.sql.Date ngay_giaohang, String diachi_giaohang) {
        this.phuongthuc_thanhtoan = phuongthuc_thanhtoan;
        this.id_sanpham = id_sanpham;
        this.id_khachhang = id_khachhang;
        this.id_nhanvien = id_nhanvien;
        this.ngay_dathang = ngay_dathang;
        this.ngay_giaohang = ngay_giaohang;
        this.diachi_giaohang = diachi_giaohang;
    }

    public DonHang(int id_donhang, String phuongthuc_thanhtoan, SanPham id_sanpham, KhachDat id_khachhang, NhanVien id_nhanvien, java.sql.Date ngay_dathang, java.sql.Date ngay_giaohang, String diachi_giaohang) {
        this.id_donhang = id_donhang;
        this.phuongthuc_thanhtoan = phuongthuc_thanhtoan;
        this.id_sanpham = id_sanpham;
        this.id_khachhang = id_khachhang;
        this.id_nhanvien = id_nhanvien;
        this.ngay_dathang = ngay_dathang;
        this.ngay_giaohang = ngay_giaohang;
        this.diachi_giaohang = diachi_giaohang;
    }

    public int getId_donhang() {
        return id_donhang;
    }

    public void setId_donhang(int id_donhang) {
        this.id_donhang = id_donhang;
    }

    public String getPhuongthuc_thanhtoan() {
        return phuongthuc_thanhtoan;
    }

    public void setPhuongthuc_thanhtoan(String phuongthuc_thanhtoan) {
        this.phuongthuc_thanhtoan = phuongthuc_thanhtoan;
    }

    public SanPham getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(SanPham id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public KhachDat getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(KhachDat id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public NhanVien getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(NhanVien id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public java.sql.Date getNgay_dathang() {
        return ngay_dathang;
    }

    public void setNgay_dathang(java.sql.Date ngay_dathang) {
        this.ngay_dathang = ngay_dathang;
    }

    public java.sql.Date getNgay_giaohang() {
        return ngay_giaohang;
    }

    public void setNgay_giaohang(Date ngay_giaohang) {
        this.ngay_giaohang = ngay_giaohang;
    }

    public String getDiachi_giaohang() {
        return diachi_giaohang;
    }

    public void setDiachi_giaohang(String diachi_giaohang) {
        this.diachi_giaohang = diachi_giaohang;
    }
}
