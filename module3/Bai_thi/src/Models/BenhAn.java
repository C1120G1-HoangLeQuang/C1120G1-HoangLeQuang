package Models;

public abstract class BenhAn {
    int stt;
    String maBA;
    String maBN;
    String ten;
    String ngayNhapVien;
    String ngayRavien;
    String lyDonhap;

    public BenhAn() {
    }

    public BenhAn(int stt, String maBA, String maBN, String ten, String ngayNhapVien, String ngayRavien, String lyDonhap) {
        this.stt = stt;
        this.maBA = maBA;
        this.maBN = maBN;
        this.ten = ten;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRavien = ngayRavien;
        this.lyDonhap = lyDonhap;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaBA() {
        return maBA;
    }

    public void setMaBA(String maBA) {
        this.maBA = maBA;
    }

    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRavien() {
        return ngayRavien;
    }

    public void setNgayRavien(String ngayRavien) {
        this.ngayRavien = ngayRavien;
    }

    public String getLyDonhap() {
        return lyDonhap;
    }

    public void setLyDonhap(String lyDonhap) {
        this.lyDonhap = lyDonhap;
    }

    @Override
    public String toString() {
        return  stt + "," +
                maBA + "," +
                maBN + "," +
                ten + "," +
                ngayNhapVien + "," +
                ngayRavien + "," +
                lyDonhap;
    }

    public abstract void hienThi();
}
