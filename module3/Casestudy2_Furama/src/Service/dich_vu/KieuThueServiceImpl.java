package Service.dich_vu;

import Model.KieuThue;
import Repository.dich_vu.KieuThueRepository;
import Repository.dich_vu.KieuThueRepositoryImpl;

import java.util.List;

public class KieuThueServiceImpl implements KieuThueService {

    KieuThueRepository kieuThueRepository = new KieuThueRepositoryImpl();
    @Override
    public List<KieuThue> findAll() {
        return kieuThueRepository.findAll();
    }

    @Override
    public KieuThue findById(int id) {
        return kieuThueRepository.findById(id);
    }
}
