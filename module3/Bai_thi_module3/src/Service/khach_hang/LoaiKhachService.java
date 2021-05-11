package Service.khach_hang;

import Model.LoaiKhach;

import java.util.List;

public interface LoaiKhachService {
    List<LoaiKhach> findAll();
    LoaiKhach findById(int id);
}
