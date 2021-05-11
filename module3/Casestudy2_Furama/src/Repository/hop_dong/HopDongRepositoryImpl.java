package Repository.hop_dong;

import Model.*;
import Repository.DBConnection;
import Repository.dich_vu.DichVuRepositoryImpl;
import Repository.khach_hang.KhachHangRepositoryImpl;
import Repository.nhan_vien.NhanvienRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HopDongRepositoryImpl implements HopDongRepository {

    public static final String SELECT_FROM_HOPDONG = "select * from hop_dong;";

    NhanvienRepositoryImpl nhanvienRepository = new NhanvienRepositoryImpl();
    KhachHangRepositoryImpl khachHangRepository = new KhachHangRepositoryImpl();
    DichVuRepositoryImpl dichVuRepository = new DichVuRepositoryImpl();

    @Override
    public List<HopDong> findAll() {
        List<HopDong> hopDongList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_HOPDONG);
                resultSet = statement.executeQuery();
                HopDong hopDong = null;
                while (resultSet.next()) {
                    int id_hopdong = resultSet.getInt("id_hopdong");
                    NhanVien id_nhanvien = nhanvienRepository.findById(resultSet.getInt("id_nhanvien"));
                    Khachhang id_khachhang = khachHangRepository.findById(resultSet.getString("id_khachhang"));
                    DichVu id_dichvu = dichVuRepository.findById(resultSet.getString("id_dichvu"));
                    String ngaylam_hopdong = resultSet.getString("ngaylam_hopdong");
                    String ngay_ketthuc = resultSet.getString("ngay_ketthuc");
                    double tien_datcoc = resultSet.getDouble("tien_datcoc");
                    double tong_tien = resultSet.getDouble("tong_tien");
                    hopDong = new HopDong(id_hopdong, id_nhanvien, id_khachhang, id_dichvu, ngaylam_hopdong, ngay_ketthuc, tien_datcoc, tong_tien);
                    hopDongList.add(hopDong);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return hopDongList;
    }

    @Override
    public void save(HopDong hopDong) {

    }

    @Override
    public HopDong findById(int id) {
        return null;
    }

    @Override
    public boolean update(HopDong hopDong) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
