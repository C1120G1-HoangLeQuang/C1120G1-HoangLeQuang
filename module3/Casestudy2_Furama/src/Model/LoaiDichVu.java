package Model;

public class LoaiDichVu {
    private int id_loaidichvu;
    private String ten_loaidichvu;

    public LoaiDichVu() {
    }

    public LoaiDichVu(int id_loaidichvu, String ten_loaidichvu) {
        this.id_loaidichvu = id_loaidichvu;
        this.ten_loaidichvu = ten_loaidichvu;
    }

    public int getId_loaidichvu() {
        return id_loaidichvu;
    }

    public void setId_loaidichvu(int id_loaidichvu) {
        this.id_loaidichvu = id_loaidichvu;
    }

    public String getTen_loaidichvu() {
        return ten_loaidichvu;
    }

    public void setTen_loaidichvu(String ten_loaidichvu) {
        this.ten_loaidichvu = ten_loaidichvu;
    }
}
