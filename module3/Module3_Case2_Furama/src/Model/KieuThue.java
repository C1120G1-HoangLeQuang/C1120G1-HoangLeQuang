package Model;

public class KieuThue {
    private int id_kieuthue;
    private String ten_kieuthue;
    private int gia;

    public KieuThue() {
    }

    public KieuThue(int id_kieuthue, String ten_kieuthue, int gia) {
        this.id_kieuthue = id_kieuthue;
        this.ten_kieuthue = ten_kieuthue;
        this.gia = gia;
    }

    public int getId_kieuthue() {
        return id_kieuthue;
    }

    public void setId_kieuthue(int id_kieuthue) {
        this.id_kieuthue = id_kieuthue;
    }

    public String getTen_kieuthue() {
        return ten_kieuthue;
    }

    public void setTen_kieuthue(String ten_kieuthue) {
        this.ten_kieuthue = ten_kieuthue;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
