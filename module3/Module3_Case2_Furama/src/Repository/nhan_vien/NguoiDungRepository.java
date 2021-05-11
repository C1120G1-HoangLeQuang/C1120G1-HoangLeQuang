package Repository.nhan_vien;

import Model.BoPhan;
import Model.NguoiDung;

import java.util.List;

public interface NguoiDungRepository {
    List<NguoiDung> findAll();
    NguoiDung findById(String ten_nguoidung);
}
