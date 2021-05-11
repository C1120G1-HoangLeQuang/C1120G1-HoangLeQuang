package Service.khach_hang;

import Model.Khachhang;

import java.util.List;

public interface KhachHangService {
    List<Khachhang> findAll();
    void save(Khachhang khachhang);
    Khachhang findById(String id);
    boolean update(Khachhang khachhang);
    boolean delete(String id);
    List<Khachhang> findByEverything(String search);
}
