package Service.nhan_vien;

import Model.TrinhDo;
import Repository.nhan_vien.TrinhDoRepository;
import Repository.nhan_vien.TrinhDoRepositoryImpl;

import java.util.List;

public class TrinhDoServiceImpl implements TrinhDoService {

    TrinhDoRepository trinhDoRepository = new TrinhDoRepositoryImpl();
    @Override
    public List<TrinhDo> findAll() {
        return trinhDoRepository.findAll();
    }

    @Override
    public TrinhDo findById(int id) {
        return trinhDoRepository.findById(id);
    }
}
