package Model;

public class VaiTroNguoiDung {
    private VaiTro id_vaitro;
    private NguoiDung ten_nguoidung;

    public VaiTroNguoiDung() {
    }

    public VaiTroNguoiDung(VaiTro id_vaitro, NguoiDung ten_nguoidung) {
        this.id_vaitro = id_vaitro;
        this.ten_nguoidung = ten_nguoidung;
    }

    public VaiTro getId_vaitro() {
        return id_vaitro;
    }

    public void setId_vaitro(VaiTro id_vaitro) {
        this.id_vaitro = id_vaitro;
    }

    public NguoiDung getTen_nguoidung() {
        return ten_nguoidung;
    }

    public void setTen_nguoidung(NguoiDung ten_nguoidung) {
        this.ten_nguoidung = ten_nguoidung;
    }
}
