package Model;

public class NhanVien {
    private int id_nhanvien;
    private String ten_nhanvien;
    private String ngay_sinh;
    private String dia_chi;

    public NhanVien() {
    }

    public NhanVien(String ten_nhanvien, String ngay_sinh, String dia_chi) {
        this.ten_nhanvien = ten_nhanvien;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
    }

    public NhanVien(int id_nhanvien, String ten_nhanvien, String ngay_sinh, String dia_chi) {
        this.id_nhanvien = id_nhanvien;
        this.ten_nhanvien = ten_nhanvien;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
    }

    public int getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public String getTen_nhanvien() {
        return ten_nhanvien;
    }

    public void setTen_nhanvien(String ten_nhanvien) {
        this.ten_nhanvien = ten_nhanvien;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
