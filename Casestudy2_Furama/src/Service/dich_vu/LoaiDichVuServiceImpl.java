package Service.dich_vu;

import Model.LoaiDichVu;
import Repository.dich_vu.LoaiDichVuRepository;
import Repository.dich_vu.LoaiDichVuRepositoryImpl;

import java.util.List;

public class LoaiDichVuServiceImpl implements LoaiDichVuService {

    LoaiDichVuRepository loaiDichVuRepository = new LoaiDichVuRepositoryImpl();

    @Override
    public List<LoaiDichVu> findAll() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public LoaiDichVu findById(int id) {
        return loaiDichVuRepository.findById(id);
    }
}
