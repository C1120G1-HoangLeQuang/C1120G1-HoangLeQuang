package Service.nhan_vien;

import Model.TrinhDo;

import java.util.List;

public interface TrinhDoService {
    List<TrinhDo> findAll();
    TrinhDo findById(int id);
}
