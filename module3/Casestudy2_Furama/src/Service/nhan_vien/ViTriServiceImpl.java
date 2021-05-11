package Service.nhan_vien;

import Model.ViTri;
import Repository.nhan_vien.ViTriRepository;
import Repository.nhan_vien.ViTriRepositoryImpl;

import java.util.List;

public class ViTriServiceImpl implements ViTriService {
    ViTriRepository viTriRepository = new ViTriRepositoryImpl();

    @Override
    public List<ViTri> findAll() {
        return viTriRepository.findAll();
    }

    @Override
    public ViTri findById(int id) {
        return viTriRepository.findById(id);
    }
}
