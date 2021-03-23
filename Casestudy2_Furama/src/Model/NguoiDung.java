package Model;

public class NguoiDung {
    private String ten_nguoidung;
    private String mat_khau;

    public NguoiDung() {
    }

    public NguoiDung(String ten_nguoidung, String mat_khau) {
        this.ten_nguoidung = ten_nguoidung;
        this.mat_khau = mat_khau;
    }

    public String getTen_nguoidung() {
        return ten_nguoidung;
    }

    public void setTen_nguoidung(String ten_nguoidung) {
        this.ten_nguoidung = ten_nguoidung;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }
}
