package Model;

public class LoaiKhach {
    private int id_loaikhach;
    private String ten_loaikhach;

    public LoaiKhach() {
    }

    public LoaiKhach(int id_loaikhach, String ten_loaikhach) {
        this.id_loaikhach = id_loaikhach;
        this.ten_loaikhach = ten_loaikhach;
    }

    public int getId_loaikhach() {
        return id_loaikhach;
    }

    public void setId_loaikhach(int id_loaikhach) {
        this.id_loaikhach = id_loaikhach;
    }

    public String getTen_loaikhach() {
        return ten_loaikhach;
    }

    public void setTen_loaikhach(String ten_loaikhach) {
        this.ten_loaikhach = ten_loaikhach;
    }
}
