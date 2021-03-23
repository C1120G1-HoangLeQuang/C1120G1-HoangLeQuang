package Repository.dich_vu;

import Model.DichVu;
import Model.Khachhang;

import java.util.List;

public interface DichVuRepository {
    List<DichVu> findAll();
    void save(DichVu dichVu);
    DichVu findById(String id);
    boolean update(DichVu dichVu);
    boolean delete(String id);
}
