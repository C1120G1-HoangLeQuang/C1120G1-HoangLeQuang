package Repository.dich_vu;

import Model.KieuThue;
import Model.LoaiKhach;

import java.util.List;

public interface KieuThueRepository {
    List<KieuThue> findAll();
    KieuThue findById(int id);

}
