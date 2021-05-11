package Model;

public class ThanhToan {
    private int ma_thanhtoan;
    private String hinhthuc_thanhtoan;

    public ThanhToan() {
    }

    public ThanhToan(int ma_thanhtoan, String hinhthuc_thanhtoan) {
        this.ma_thanhtoan = ma_thanhtoan;
        this.hinhthuc_thanhtoan = hinhthuc_thanhtoan;
    }

    public int getMa_thanhtoan() {
        return ma_thanhtoan;
    }

    public void setMa_thanhtoan(int ma_thanhtoan) {
        this.ma_thanhtoan = ma_thanhtoan;
    }

    public String getHinhthuc_thanhtoan() {
        return hinhthuc_thanhtoan;
    }

    public void setHinhthuc_thanhtoan(String hinhthuc_thanhtoan) {
        this.hinhthuc_thanhtoan = hinhthuc_thanhtoan;
    }
}
