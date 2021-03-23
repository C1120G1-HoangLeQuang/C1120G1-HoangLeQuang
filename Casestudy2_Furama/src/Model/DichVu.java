package Model;

public class DichVu {
    private String id_dichvu;
    private String ten_dich_vu;
    private int dien_tich;
    private int songuoi_toida;
    private double chi_phi_thue;
    private KieuThue id_kieuthue;
    private LoaiDichVu id_loaidichvu;
    private String tieu_chuan_phong;
    private String mota_tiennghi_khac;
    private double dientich_hoboi;
    private int so_tang;

    public DichVu() {
    }

    public DichVu(String ten_dich_vu, int dien_tich, int songuoi_toida, double chi_phi_thue, KieuThue id_kieuthue, LoaiDichVu id_loaidichvu, String tieu_chuan_phong, String mota_tiennghi_khac, double dientich_hoboi, int so_tang) {
        this.ten_dich_vu = ten_dich_vu;
        this.dien_tich = dien_tich;
        this.songuoi_toida = songuoi_toida;
        this.chi_phi_thue = chi_phi_thue;
        this.id_kieuthue = id_kieuthue;
        this.id_loaidichvu = id_loaidichvu;
        this.tieu_chuan_phong = tieu_chuan_phong;
        this.mota_tiennghi_khac = mota_tiennghi_khac;
        this.dientich_hoboi = dientich_hoboi;
        this.so_tang = so_tang;
    }

    public DichVu(String id_dichvu, String ten_dich_vu, int dien_tich, int songuoi_toida,
                  double chi_phi_thue, KieuThue id_kieuthue, LoaiDichVu id_loaidichvu, String tieu_chuan_phong,
                  String mota_tiennghi_khac, double dientich_hoboi, int so_tang) {
        this.id_dichvu = id_dichvu;
        this.ten_dich_vu = ten_dich_vu;
        this.dien_tich = dien_tich;
        this.songuoi_toida = songuoi_toida;
        this.chi_phi_thue = chi_phi_thue;
        this.id_kieuthue = id_kieuthue;
        this.id_loaidichvu = id_loaidichvu;
        this.tieu_chuan_phong = tieu_chuan_phong;
        this.mota_tiennghi_khac = mota_tiennghi_khac;
        this.dientich_hoboi = dientich_hoboi;
        this.so_tang = so_tang;
    }

    public String getId_dichvu() {
        return id_dichvu;
    }

    public void setId_dichvu(String id_dichvu) {
        this.id_dichvu = id_dichvu;
    }

    public String getTen_dich_vu() {
        return ten_dich_vu;
    }

    public void setTen_dich_vu(String ten_dich_vu) {
        this.ten_dich_vu = ten_dich_vu;
    }

    public int getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(int dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getSonguoi_toida() {
        return songuoi_toida;
    }

    public void setSonguoi_toida(int songuoi_toida) {
        this.songuoi_toida = songuoi_toida;
    }

    public double getChi_phi_thue() {
        return chi_phi_thue;
    }

    public void setChi_phi_thue(double chi_phi_thue) {
        this.chi_phi_thue = chi_phi_thue;
    }

    public KieuThue getId_kieuthue() {
        return id_kieuthue;
    }

    public void setId_kieuthue(KieuThue id_kieuthue) {
        this.id_kieuthue = id_kieuthue;
    }

    public LoaiDichVu getId_loaidichvu() {
        return id_loaidichvu;
    }

    public void setId_loaidichvu(LoaiDichVu id_loaidichvu) {
        this.id_loaidichvu = id_loaidichvu;
    }

    public String getTieu_chuan_phong() {
        return tieu_chuan_phong;
    }

    public void setTieu_chuan_phong(String tieu_chuan_phong) {
        this.tieu_chuan_phong = tieu_chuan_phong;
    }

    public String getMota_tiennghi_khac() {
        return mota_tiennghi_khac;
    }

    public void setMota_tiennghi_khac(String mota_tiennghi_khac) {
        this.mota_tiennghi_khac = mota_tiennghi_khac;
    }

    public double getDientich_hoboi() {
        return dientich_hoboi;
    }

    public void setDientich_hoboi(double dientich_hoboi) {
        this.dientich_hoboi = dientich_hoboi;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }
}
