package Models;

public class BenhAnThuong extends BenhAn{
    double chiPhi;

    public BenhAnThuong(String[] benhAnThuongInfor) {
    }

    public BenhAnThuong(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public BenhAnThuong(int stt, String maBA, String maBN, String ten, String ngayNhapVien, String ngayRavien, String lyDonhap, double chiPhi) {
        super(stt, maBA, maBN, ten, ngayNhapVien, ngayRavien, lyDonhap);
        this.chiPhi = chiPhi;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    @Override
    public String toString() {
        return super.toString() + "," + chiPhi;
    }

    @Override
    public void hienThi() {
        System.out.println("BenhAnThuong {" + "Stt: " + super.getStt()
                                            + "Ma BA: " + super.getMaBA()
                                            + "Ma BN: " + super.getMaBN()
                                            + "Ten: " + super.getTen()
                                            + "Ngay Nhap: " + super.getNgayNhapVien()
                                            + "Ngay Ra: " + super.getNgayRavien()
                                            + "Ly do: " + super.getLyDonhap()
                                            + "Chi phi: " + chiPhi + "}");
    }
}
