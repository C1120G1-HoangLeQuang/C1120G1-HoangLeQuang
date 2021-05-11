package Service.khach_hang;

import Model.LoaiKhach;
import Repository.khach_hang.LoaiKhachRepository;
import Repository.khach_hang.LoaiKhachRepositoryImpl;

import java.util.List;

public class LoaiKhachServiceImpl implements LoaiKhachService {

    LoaiKhachRepository loaiKhachRepository = new LoaiKhachRepositoryImpl();

    @Override
    public List<LoaiKhach> findAll() {
        return loaiKhachRepository.findAll();
    }

    @Override
    public LoaiKhach findById(int id) {
        return loaiKhachRepository.findById(id);
    }
}
