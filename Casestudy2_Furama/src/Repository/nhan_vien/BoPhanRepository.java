package Repository.nhan_vien;

import Model.BoPhan;

import java.util.List;

public interface BoPhanRepository {
    List<BoPhan> findAll();
    BoPhan findById(int id);
}
