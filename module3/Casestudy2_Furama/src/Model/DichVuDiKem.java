package Model;

public class DichVuDiKem {
    private int id_dichvudikem;
    private String ten_dichvudikem;
    private int gia;
    private int don_vi;
    private String trangthai_khadung;

    public DichVuDiKem() {
    }

    public DichVuDiKem(int id_dichvudikem, String ten_dichvudikem, int gia, int don_vi, String trangthai_khadung) {
        this.id_dichvudikem = id_dichvudikem;
        this.ten_dichvudikem = ten_dichvudikem;
        this.gia = gia;
        this.don_vi = don_vi;
        this.trangthai_khadung = trangthai_khadung;
    }

    public int getId_dichvudikem() {
        return id_dichvudikem;
    }

    public void setId_dichvudikem(int id_dichvudikem) {
        this.id_dichvudikem = id_dichvudikem;
    }

    public String getTen_dichvudikem() {
        return ten_dichvudikem;
    }

    public void setTen_dichvudikem(String ten_dichvudikem) {
        this.ten_dichvudikem = ten_dichvudikem;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDon_vi() {
        return don_vi;
    }

    public void setDon_vi(int don_vi) {
        this.don_vi = don_vi;
    }

    public String getTrangthai_khadung() {
        return trangthai_khadung;
    }

    public void setTrangthai_khadung(String trangthai_khadung) {
        this.trangthai_khadung = trangthai_khadung;
    }
}
