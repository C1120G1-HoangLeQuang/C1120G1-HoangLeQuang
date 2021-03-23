package Model;

public class VaiTro {
    private int id_vaitro;
    private String ten_vaitro;

    public VaiTro() {
    }

    public VaiTro(int id_vaitro, String ten_vaitro) {
        this.id_vaitro = id_vaitro;
        this.ten_vaitro = ten_vaitro;
    }

    public int getId_vaitro() {
        return id_vaitro;
    }

    public void setId_vaitro(int id_vaitro) {
        this.id_vaitro = id_vaitro;
    }

    public String getTen_vaitro() {
        return ten_vaitro;
    }

    public void setTen_vaitro(String ten_vaitro) {
        this.ten_vaitro = ten_vaitro;
    }
}
