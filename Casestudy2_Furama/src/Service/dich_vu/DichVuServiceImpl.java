package Service.dich_vu;

import Model.DichVu;
import Repository.dich_vu.DichVuRepository;
import Repository.dich_vu.DichVuRepositoryImpl;

import java.util.List;

public class DichVuServiceImpl implements DichVuService {

    DichVuRepository dichVuRepository = new DichVuRepositoryImpl();
    @Override
    public List<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public void save(DichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    @Override
    public DichVu findById(String id) {
        return dichVuRepository.findById(id);
    }

    @Override
    public boolean update(DichVu dichVu) {
        return dichVuRepository.update(dichVu);
    }

    @Override
    public boolean delete(String id) {
        return dichVuRepository.delete(id);
    }
}
