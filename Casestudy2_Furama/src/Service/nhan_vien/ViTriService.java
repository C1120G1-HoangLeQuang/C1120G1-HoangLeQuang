package Service.nhan_vien;

import Model.ViTri;

import java.util.List;

public interface ViTriService {
    List<ViTri> findAll();
    ViTri findById(int id);
}
