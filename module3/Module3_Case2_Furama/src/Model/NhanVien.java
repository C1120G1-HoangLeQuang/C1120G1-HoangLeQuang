package Model;

public class NhanVien {
    private int id_nhanvien;
    private String ho_ten;
    private ViTri id_vitri;
    private TrinhDo id_trinhdo;
    private BoPhan id_bophan;
    private NguoiDung ten_nguoidung;
    private String ngay_sinh;
    private String so_cmnd;
    private double luong;
    private String sdt;
    private String email;
    private String dia_chi;

    public NhanVien() {
    }

    public NhanVien(int id_nhanvien, String ho_ten, ViTri id_vitri, TrinhDo id_trinhdo, BoPhan id_bophan,
                    NguoiDung ten_nguoidung, String ngay_sinh, String so_cmnd, double luong, String sdt,
                    String email, String dia_chi) {
        this.id_nhanvien = id_nhanvien;
        this.ho_ten = ho_ten;
        this.id_vitri = id_vitri;
        this.id_trinhdo = id_trinhdo;
        this.id_bophan = id_bophan;
        this.ten_nguoidung = ten_nguoidung;
        this.ngay_sinh = ngay_sinh;
        this.so_cmnd = so_cmnd;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.dia_chi = dia_chi;
    }

    public int getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public ViTri getId_vitri() {
        return id_vitri;
    }

    public void setId_vitri(ViTri id_vitri) {
        this.id_vitri = id_vitri;
    }

    public TrinhDo getId_trinhdo() {
        return id_trinhdo;
    }

    public void setId_trinhdo(TrinhDo id_trinhdo) {
        this.id_trinhdo = id_trinhdo;
    }

    public BoPhan getId_bophan() {
        return id_bophan;
    }

    public void setId_bophan(BoPhan id_bophan) {
        this.id_bophan = id_bophan;
    }

    public NguoiDung getTen_nguoidung() {
        return ten_nguoidung;
    }

    public void setTen_nguoidung(NguoiDung ten_nguoidung) {
        this.ten_nguoidung = ten_nguoidung;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSo_cmnd() {
        return so_cmnd;
    }

    public void setSo_cmnd(String so_cmnd) {
        this.so_cmnd = so_cmnd;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
