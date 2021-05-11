package Model;

public class TrinhDo {
    private int id_trinhdo;
    private String trinh_do;

    public TrinhDo() {
    }

    public TrinhDo(int id_trinhdo, String trinh_do) {
        this.id_trinhdo = id_trinhdo;
        this.trinh_do = trinh_do;
    }

    public int getId_trinhdo() {
        return id_trinhdo;
    }

    public void setId_trinhdo(int id_trinhdo) {
        this.id_trinhdo = id_trinhdo;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }
}
