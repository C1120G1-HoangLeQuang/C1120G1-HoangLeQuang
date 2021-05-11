package Service.nhan_vien;

import Model.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> findAll();
    NguoiDung findById(String ten_nguoidung);
}
