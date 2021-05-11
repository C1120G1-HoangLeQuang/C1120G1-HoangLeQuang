package Repository.khach_hang;

import Model.LoaiKhach;

import java.util.List;

public interface LoaiKhachRepository {
    List<LoaiKhach> findAll();
    LoaiKhach findById(int id);
}
