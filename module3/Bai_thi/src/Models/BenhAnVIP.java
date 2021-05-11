package Models;

public class BenhAnVIP extends BenhAn {
    String loaiVIP;
    String thoihanVIP;

    public BenhAnVIP(String[] benhAnVIPInfor) {
    }

    public BenhAnVIP(int stt, String maBA, String maBN, String ten, String ngayNhapVien, String ngayRavien, String lyDonhap, String loaiVIP, String thoihanVIP) {
        super(stt, maBA, maBN, ten, ngayNhapVien, ngayRavien, lyDonhap);
        this.loaiVIP = loaiVIP;
        this.thoihanVIP = thoihanVIP;
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public String getThoihanVIP() {
        return thoihanVIP;
    }

    public void setThoihanVIP(String thoihanVIP) {
        this.thoihanVIP = thoihanVIP;
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiVIP + "," +
                thoihanVIP;
    }

    @Override
    public void hienThi() {
        System.out.println("BenhAnVIP {" + "Stt: " + super.getStt()
                + "Ma BA: " + super.getMaBA()
                + "Ma BN: " + super.getMaBN()
                + "Ten: " + super.getTen()
                + "Ngay Nhap: " + super.getNgayNhapVien()
                + "Ngay Ra: " + super.getNgayRavien()
                + "Ly do: " + super.getLyDonhap()
                + "Goi: " + loaiVIP
                + "Thoi Han Vip: " + thoihanVIP + "}");
    }
}
