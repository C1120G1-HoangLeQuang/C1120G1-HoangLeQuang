package Service.nhan_vien;

import Model.NguoiDung;
import Repository.nhan_vien.NguoiDungRepository;
import Repository.nhan_vien.NguoiDungRepositoryImpl;

import java.util.List;

public class NguoiDungServiceImpl implements NguoiDungService {
    NguoiDungRepository nguoiDungRepository = new NguoiDungRepositoryImpl();

    @Override
    public List<NguoiDung> findAll() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDung findById(String ten_nguoidung) {
        return nguoiDungRepository.findById(ten_nguoidung);
    }
}
