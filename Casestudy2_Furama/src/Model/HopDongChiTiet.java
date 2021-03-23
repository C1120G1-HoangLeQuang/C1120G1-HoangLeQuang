package Model;

public class HopDongChiTiet {
    private int id_hopdongchitiet;
    private HopDong id_hopdong;
    private DichVuDiKem id_dichvudikem;
    private int so_luong;

    public HopDongChiTiet() {
    }

    public HopDongChiTiet(int id_hopdongchitiet, HopDong id_hopdong, DichVuDiKem id_dichvudikem, int so_luong) {
        this.id_hopdongchitiet = id_hopdongchitiet;
        this.id_hopdong = id_hopdong;
        this.id_dichvudikem = id_dichvudikem;
        this.so_luong = so_luong;
    }

    public int getId_hopdongchitiet() {
        return id_hopdongchitiet;
    }

    public void setId_hopdongchitiet(int id_hopdongchitiet) {
        this.id_hopdongchitiet = id_hopdongchitiet;
    }

    public HopDong getId_hopdong() {
        return id_hopdong;
    }

    public void setId_hopdong(HopDong id_hopdong) {
        this.id_hopdong = id_hopdong;
    }

    public DichVuDiKem getId_dichvudikem() {
        return id_dichvudikem;
    }

    public void setId_dichvudikem(DichVuDiKem id_dichvudikem) {
        this.id_dichvudikem = id_dichvudikem;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
