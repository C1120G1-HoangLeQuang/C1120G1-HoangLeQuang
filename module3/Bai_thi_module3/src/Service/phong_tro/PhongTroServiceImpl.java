package Service.phong_tro;

import Model.PhongTro;
import Repository.phong_tro.PhongTroRepository;
import Repository.phong_tro.PhongTroRepositoryImpl;

import java.util.List;

public class PhongTroServiceImpl implements PhongTroService {

    PhongTroRepository phongTroRepository = new PhongTroRepositoryImpl();

    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }

    @Override
    public void save(PhongTro phongTro) {
        phongTroRepository.save(phongTro);
    }

    @Override
    public PhongTro findById(String ma_phongtro) {
        return phongTroRepository.findById(ma_phongtro);
    }

    @Override
    public boolean update(PhongTro phongTro) {
        return phongTroRepository.update(phongTro);
    }

    @Override
    public boolean delete(String ma_phongtro) {
        return phongTroRepository.delete(ma_phongtro);
    }

    @Override
    public List<PhongTro> findByEverything(String search) {
        return phongTroRepository.findByEverything(search);
    }
}
