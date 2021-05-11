package Model;

public class ViTri {
    private int id_vitri;
    private String ten_vitri;

    public ViTri() {
    }

    public ViTri(int id_vitri, String ten_vitri) {
        this.id_vitri = id_vitri;
        this.ten_vitri = ten_vitri;
    }

    public int getId_vitri() {
        return id_vitri;
    }

    public void setId_vitri(int id_vitri) {
        this.id_vitri = id_vitri;
    }

    public String getTen_vitri() {
        return ten_vitri;
    }

    public void setTen_vitri(String ten_vitri) {
        this.ten_vitri = ten_vitri;
    }
}

