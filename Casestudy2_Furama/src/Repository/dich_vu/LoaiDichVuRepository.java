package Repository.dich_vu;

import Model.LoaiDichVu;
import Model.LoaiKhach;

import java.util.List;

public interface LoaiDichVuRepository {
    List<LoaiDichVu> findAll();
    LoaiDichVu findById(int id);
}
