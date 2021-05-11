package Service.hop_dong;

import Model.HopDong;
import Repository.hop_dong.HopDongRepository;
import Repository.hop_dong.HopDongRepositoryImpl;

import java.util.List;

public class HopDongServiceImpl implements HopDongService {

    HopDongRepository hopDongRepository = new HopDongRepositoryImpl();
    @Override
    public List<HopDong> findAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public void save(HopDong hopDong) {
        hopDongRepository.save(hopDong);
    }

    @Override
    public HopDong findById(int id) {
        return hopDongRepository.findById(id);
    }

    @Override
    public boolean update(HopDong hopDong) {
        return hopDongRepository.update(hopDong);
    }

    @Override
    public boolean delete(int id) {
        return hopDongRepository.delete(id);
    }
}
