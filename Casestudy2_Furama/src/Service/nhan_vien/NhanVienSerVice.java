package Service.nhan_vien;

import Model.NhanVien;

import java.util.List;

public interface NhanVienSerVice {
    List<NhanVien> findAll();
    void save(NhanVien nhanVien);
    NhanVien findById(int id);
    boolean update(NhanVien nhanVien);
    boolean delete(int id);
}
