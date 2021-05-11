package Repository.phong_tro;

import Model.Khachhang;
import Model.PhongTro;

import java.util.List;

public interface PhongTroRepository {
    List<PhongTro> findAll();
    void save(PhongTro phongTro);
    PhongTro findById(String ma_phongtro);
    boolean update(PhongTro phongTro);
    boolean delete(String ma_phongtro);
    List<PhongTro> findByEverything(String search);

}
