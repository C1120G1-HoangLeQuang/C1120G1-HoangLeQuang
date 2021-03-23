package Model;

public class HopDong {
    private int id_hopdong;
    private NhanVien id_nhanvien;
    private Khachhang id_khachhang;
    private DichVu id_dichvu;
    private String ngaylam_hopdong;
    private String ngay_ketthuc;
    private double tien_datcoc;
    private double tong_tien;

    public HopDong() {
    }

    public HopDong(int id_hopdong, NhanVien id_nhanvien, Khachhang id_khachhang, DichVu id_dichvu,
                   String ngaylam_hopdong, String ngay_ketthuc, double tien_datcoc, double tong_tien) {
        this.id_hopdong = id_hopdong;
        this.id_nhanvien = id_nhanvien;
        this.id_khachhang = id_khachhang;
        this.id_dichvu = id_dichvu;
        this.ngaylam_hopdong = ngaylam_hopdong;
        this.ngay_ketthuc = ngay_ketthuc;
        this.tien_datcoc = tien_datcoc;
        this.tong_tien = tong_tien;
    }

    public int getId_hopdong() {
        return id_hopdong;
    }

    public void setId_hopdong(int id_hopdong) {
        this.id_hopdong = id_hopdong;
    }

    public NhanVien getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(NhanVien id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public Khachhang getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(Khachhang id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public DichVu getId_dichvu() {
        return id_dichvu;
    }

    public void setId_dichvu(DichVu id_dichvu) {
        this.id_dichvu = id_dichvu;
    }

    public String getNgaylam_hopdong() {
        return ngaylam_hopdong;
    }

    public void setNgaylam_hopdong(String ngaylam_hopdong) {
        this.ngaylam_hopdong = ngaylam_hopdong;
    }

    public String getNgay_ketthuc() {
        return ngay_ketthuc;
    }

    public void setNgay_ketthuc(String ngay_ketthuc) {
        this.ngay_ketthuc = ngay_ketthuc;
    }

    public double getTien_datcoc() {
        return tien_datcoc;
    }

    public void setTien_datcoc(double tien_datcoc) {
        this.tien_datcoc = tien_datcoc;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }
}
