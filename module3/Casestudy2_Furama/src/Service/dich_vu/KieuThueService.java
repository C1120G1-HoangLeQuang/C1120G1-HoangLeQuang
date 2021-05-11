package Service.dich_vu;

import Model.KieuThue;
import Model.LoaiKhach;

import java.util.List;

public interface KieuThueService {
    List<KieuThue> findAll();
    KieuThue findById(int id);
}
