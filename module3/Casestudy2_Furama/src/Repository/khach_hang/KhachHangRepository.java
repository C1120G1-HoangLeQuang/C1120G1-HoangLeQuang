package Repository.khach_hang;

import Model.Khachhang;
import Model.NhanVien;

import java.util.List;

public interface KhachHangRepository {
    List<Khachhang> findAll();
    void save(Khachhang khachhang);
    Khachhang findById(String id);
    boolean update(Khachhang khachhang);
    boolean delete(String id);
    List<Khachhang> findByEverything(String search);
}
