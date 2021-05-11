package Model;

public class KhachDat {
    private String id_khachhang;
    private String ten_khachhang;
    private String ngay_sinh;
    private String sdt;
    private String dia_chi;
    private String email;

    public KhachDat() {
    }

    public KhachDat(String ten_khachhang, String ngay_sinh, String sdt, String dia_chi, String email) {
        this.ten_khachhang = ten_khachhang;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.email = email;
    }

    public KhachDat(String id_khachhang, String ten_khachhang, String ngay_sinh, String sdt, String dia_chi, String email) {
        this.id_khachhang = id_khachhang;
        this.ten_khachhang = ten_khachhang;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.email = email;
    }

    public String getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getTen_khachhang() {
        return ten_khachhang;
    }

    public void setTen_khachhang(String ten_khachhang) {
        this.ten_khachhang = ten_khachhang;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
