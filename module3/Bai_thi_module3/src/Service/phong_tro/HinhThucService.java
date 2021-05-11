package Service.phong_tro;

import Model.ThanhToan;

import java.util.List;

public interface HinhThucService {
    List<ThanhToan> findAll();
    ThanhToan findById(int ma_thanhtoan);
}
