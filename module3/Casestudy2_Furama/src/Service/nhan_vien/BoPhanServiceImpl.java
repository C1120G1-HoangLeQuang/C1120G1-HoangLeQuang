package Service.nhan_vien;

import Model.BoPhan;
import Repository.nhan_vien.BoPhanRepository;
import Repository.nhan_vien.BoPhanRepositoryImpl;

import java.util.List;

public class BoPhanServiceImpl implements BoPhanService{
    BoPhanRepository boPhanRepository = new BoPhanRepositoryImpl();

    @Override
    public List<BoPhan> findAll() {
        return boPhanRepository.findAll();
    }

    @Override
    public BoPhan findById(int id) {
       return boPhanRepository.findById(id);
    }
}
