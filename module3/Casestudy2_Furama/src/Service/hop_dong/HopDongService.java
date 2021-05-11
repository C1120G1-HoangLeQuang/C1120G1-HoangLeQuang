package Service.hop_dong;

import Model.HopDong;

import java.util.List;

public interface HopDongService {
    List<HopDong> findAll();
    void save(HopDong hopDong);
    HopDong findById(int id);
    boolean update(HopDong hopDong);
    boolean delete(int id);
}
