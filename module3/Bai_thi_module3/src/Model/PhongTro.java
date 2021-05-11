package Model;

public class PhongTro {
    private String ma_phongtro;
    private String ten_khachthue;
    private String sdt;
    private String ngay_thue;
    private ThanhToan ma_thanhtoan;
    private String ghi_chu;

    public PhongTro() {
    }

    public PhongTro(String ten_khachthue, String sdt, String ngay_thue, ThanhToan ma_thanhtoan, String ghi_chu) {
        this.ten_khachthue = ten_khachthue;
        this.sdt = sdt;
        this.ngay_thue = ngay_thue;
        this.ma_thanhtoan = ma_thanhtoan;
        this.ghi_chu = ghi_chu;
    }

    public PhongTro(String ma_phongtro, String ten_khachthue, String sdt, String ngay_thue, ThanhToan ma_thanhtoan, String ghi_chu) {
        this.ma_phongtro = ma_phongtro;
        this.ten_khachthue = ten_khachthue;
        this.sdt = sdt;
        this.ngay_thue = ngay_thue;
        this.ma_thanhtoan = ma_thanhtoan;
        this.ghi_chu = ghi_chu;
    }

    public String getMa_phongtro() {
        return ma_phongtro;
    }

    public void setMa_phongtro(String ma_phongtro) {
        this.ma_phongtro = ma_phongtro;
    }

    public String getTen_khachthue() {
        return ten_khachthue;
    }

    public void setTen_khachthue(String ten_khachthue) {
        this.ten_khachthue = ten_khachthue;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgay_thue() {
        return ngay_thue;
    }

    public void setNgay_thue(String ngay_thue) {
        this.ngay_thue = ngay_thue;
    }

    public ThanhToan getMa_thanhtoan() {
        return ma_thanhtoan;
    }

    public void setMa_thanhtoan(ThanhToan ma_thanhtoan) {
        this.ma_thanhtoan = ma_thanhtoan;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
