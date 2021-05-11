package Service.phong_tro;

import Model.ThanhToan;
import Repository.phong_tro.HinhThucRepository;
import Repository.phong_tro.HinhThucRepositoryImpl;

import java.util.List;

public class HinhThucServiceImpl implements HinhThucService {

    HinhThucRepository hinhThucRepository = new HinhThucRepositoryImpl();
    @Override
    public List<ThanhToan> findAll() {
        return hinhThucRepository.findAll();
    }

    @Override
    public ThanhToan findById(int ma_thanhtoan) {
        return hinhThucRepository.findById(ma_thanhtoan);
    }
}
