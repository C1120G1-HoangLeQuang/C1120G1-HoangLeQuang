package Model;

public class BoPhan {
    private int id_bophan;
    private String ten_bophan;

    public BoPhan() {
    }

    public BoPhan(int id_bophan, String ten_bophan) {
        this.id_bophan = id_bophan;
        this.ten_bophan = ten_bophan;
    }

    public int getId_bophan() {
        return id_bophan;
    }

    public void setId_bophan(int id_bophan) {
        this.id_bophan = id_bophan;
    }

    public String getTen_bophan() {
        return ten_bophan;
    }

    public void setTen_bophan(String ten_bophan) {
        this.ten_bophan = ten_bophan;
    }
}
