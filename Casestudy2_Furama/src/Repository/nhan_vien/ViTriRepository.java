package Repository.nhan_vien;

import Model.ViTri;

import java.util.List;

public interface ViTriRepository {
    List<ViTri> findAll();
    ViTri findById(int id);
}
