package Service.nhan_vien;

import Model.NhanVien;
import Repository.nhan_vien.NhanVienRepository;
import Repository.nhan_vien.NhanvienRepositoryImpl;

import java.util.List;

public class NhanVienServiceImpl implements NhanVienSerVice{

    NhanVienRepository nhanVienRepository = new NhanvienRepositoryImpl();
    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien findById(int id) {
        return nhanVienRepository.findById(id);
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return nhanVienRepository.update(nhanVien);
    }

    @Override
    public boolean delete(int id) {
        return nhanVienRepository.delete(id);
    }
}
