package Repository.phong_tro;

import Model.LoaiKhach;
import Model.ThanhToan;

import java.util.List;

public interface HinhThucRepository {
    List<ThanhToan> findAll();
    ThanhToan findById(int ma_thanhtoan);
}
