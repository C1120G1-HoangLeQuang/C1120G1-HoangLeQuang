package Repository.nhan_vien;

import Model.NhanVien;

import java.util.List;

public interface NhanVienRepository {
    List<NhanVien> findAll();
    void save(NhanVien nhanVien);
    NhanVien findById(int id);
    boolean update(NhanVien nhanVien);
    boolean delete(int id);
}
