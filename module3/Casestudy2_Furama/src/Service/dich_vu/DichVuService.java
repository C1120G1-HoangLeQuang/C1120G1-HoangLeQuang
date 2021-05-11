package Service.dich_vu;

import Model.DichVu;

import java.util.List;

public interface DichVuService {
    List<DichVu> findAll();
    void save(DichVu dichVu);
    DichVu findById(String id);
    boolean update(DichVu dichVu);
    boolean delete(String id);
}
