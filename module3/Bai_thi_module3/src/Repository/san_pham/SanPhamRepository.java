package Repository.san_pham;

import Model.PhongTro;
import Model.SanPham;
import Model.ThanhToan;

import java.sql.Date;
import java.util.List;

public interface SanPhamRepository {
    List<SanPham> findAll();
    void save(SanPham sanPham);
    SanPham findById(int id_sanpham);
    boolean update(SanPham sanPham);
    boolean delete(int id_sanpham);
    List<SanPham> findByEverything(String search);
    List<SanPham> findTop3510(int top);
    List<SanPham> findDateOrder(java.sql.Date start, Date end);
}
