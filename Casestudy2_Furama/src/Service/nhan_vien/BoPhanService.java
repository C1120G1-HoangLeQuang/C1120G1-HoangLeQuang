package Service.nhan_vien;

import Model.BoPhan;

import java.util.List;

public interface BoPhanService {
    List<BoPhan> findAll();
    BoPhan findById(int id);
}
