package Model;

public class Khachhang {
    private String id_khachhang;
    private LoaiKhach id_loaikhach;
    private String ho_ten;
    private String ngay_sinh;
    private boolean gioi_tinh;
    private String so_cmnd;
    private String sdt;
    private String email;
    private String dia_chi;

    public Khachhang() {
    }

    public Khachhang(LoaiKhach id_loaikhach, String ho_ten, String ngay_sinh, boolean gioi_tinh, String so_cmnd, String sdt, String email, String dia_chi) {
        this.id_loaikhach = id_loaikhach;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.so_cmnd = so_cmnd;
        this.sdt = sdt;
        this.email = email;
        this.dia_chi = dia_chi;
    }

    public Khachhang(String id_khachhang, LoaiKhach id_loaikhach, String ho_ten, String ngay_sinh,
                     boolean gioi_tinh, String so_cmnd, String sdt, String email, String dia_chi) {
        this.id_khachhang = id_khachhang;
        this.id_loaikhach = id_loaikhach;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.so_cmnd = so_cmnd;
        this.sdt = sdt;
        this.email = email;
        this.dia_chi = dia_chi;
    }

    public String getId_khachhang() {
        return id_khachhang;
    }


    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public LoaiKhach getId_loaikhach() {
        return id_loaikhach;
    }

    public void setId_loaikhach(LoaiKhach id_loaikhach) {
        this.id_loaikhach = id_loaikhach;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSo_cmnd() {
        return so_cmnd;
    }

    public void setSo_cmnd(String so_cmnd) {
        this.so_cmnd = so_cmnd;
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
