package Service.dich_vu;

import Model.LoaiDichVu;
import Model.LoaiKhach;

import java.util.List;

public interface LoaiDichVuService {
    List<LoaiDichVu> findAll();
    LoaiDichVu findById(int id);
}
