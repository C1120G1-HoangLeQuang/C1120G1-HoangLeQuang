package Model;

public class SanPham {
    private int id_sanpham;
    private String ten_sanpham;
    private double gia;
    private double muc_giamgia;
    private int ton_kho;

    public SanPham() {
    }

    public SanPham(String ten_sanpham, double gia, double muc_giamgia, int ton_kho) {
        this.ten_sanpham = ten_sanpham;
        this.gia = gia;
        this.muc_giamgia = muc_giamgia;
        this.ton_kho = ton_kho;
    }

    public SanPham(int id_sanpham, String ten_sanpham, double gia, double muc_giamgia, int ton_kho) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.gia = gia;
        this.muc_giamgia = muc_giamgia;
        this.ton_kho = ton_kho;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public void setTen_sanpham(String ten_sanpham) {
        this.ten_sanpham = ten_sanpham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getMuc_giamgia() {
        return muc_giamgia;
    }

    public void setMuc_giamgia(double muc_giamgia) {
        this.muc_giamgia = muc_giamgia;
    }

    public int getTon_kho() {
        return ton_kho;
    }

    public void setTon_kho(int ton_kho) {
        this.ton_kho = ton_kho;
    }
}
