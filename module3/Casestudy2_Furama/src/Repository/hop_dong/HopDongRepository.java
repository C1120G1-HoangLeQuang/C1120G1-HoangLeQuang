package Repository.hop_dong;

import Model.HopDong;
import Model.Khachhang;

import java.util.List;

public interface HopDongRepository {
    List<HopDong> findAll();
    void save(HopDong hopDong);
    HopDong findById(int id);
    boolean update(HopDong hopDong);
    boolean delete(int id);
}
