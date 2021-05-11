package Repository.nhan_vien;

import Model.TrinhDo;

import java.util.List;

public interface TrinhDoRepository {
    List<TrinhDo> findAll();
    TrinhDo findById(int id);
}
