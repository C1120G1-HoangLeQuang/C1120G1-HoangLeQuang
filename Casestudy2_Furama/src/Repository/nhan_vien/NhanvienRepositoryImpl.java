package Repository.nhan_vien;

import Model.*;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanvienRepositoryImpl implements NhanVienRepository {

    public static final String SELECT_FROM_NHANVIEN = "select * from nhan_vien;";
    public static final String INSERT_NHANVIEN_VALUE = "INSERT INTO nhan_vien(ho_ten, id_vitri, id_trinhdo, id_bophan, ten_nguoidung, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_NHANVIEN_BY_ID = "select id_nhanvien, ho_ten, id_vitri, id_trinhdo, id_bophan, ten_nguoidung, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi from nhan_vien where id_nhanvien = ?;";
    private static final String DELETE_NHANVIEN_SQL = "delete from nhan_vien where id_nhanvien = ?;";
    private static final String UPDATE_NHANVIEN_SQL = "update nhan_vien set ho_ten = ?,id_vitri= ?, id_trinhdo = ?, id_bophan = ?, ten_nguoidung = ?, ngay_sinh = ?, so_cmnd = ?, luong = ?, sdt = ?, email = ?, dia_chi = ? where id_nhanvien = ?;";

    BoPhanRepositoryImpl boPhanRepository = new BoPhanRepositoryImpl();
    TrinhDoRepositoryImpl trinhDoRepository = new TrinhDoRepositoryImpl();
    ViTriRepositoryImpl viTriRepository = new ViTriRepositoryImpl();
    NguoiDungRepositoryImpl nguoiDungRepository = new NguoiDungRepositoryImpl();
    @Override
    public List<NhanVien> findAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_NHANVIEN);
                resultSet = statement.executeQuery();
                NhanVien nhanVien = null;
                while (resultSet.next()) {
                    int id_nhanvien = resultSet.getInt("id_nhanvien");
                    String ho_ten = resultSet.getString("ho_ten");
                    ViTri id_vitri =  viTriRepository.findById(resultSet.getInt("id_vitri"));
                    TrinhDo id_trinhdo = trinhDoRepository.findById(resultSet.getInt("id_trinhdo"));
                    BoPhan id_bophan = boPhanRepository.findById(resultSet.getInt("id_bophan"));
                    NguoiDung ten_nguoidung = nguoiDungRepository.findById(resultSet.getString("ten_nguoidung"));
                    String ngay_sinh = resultSet.getString("ngay_sinh");
                    String so_cmnd = resultSet.getString("so_cmnd");
                    double luong = resultSet.getDouble("luong");
                    String sdt = resultSet.getString("sdt");
                    String email = resultSet.getString("email");
                    String dia_chi = resultSet.getString("dia_chi");
                    nhanVien = new NhanVien(id_nhanvien, ho_ten, id_vitri, id_trinhdo, id_bophan, ten_nguoidung, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi);
                    nhanVienList.add(nhanVien);
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
        return nhanVienList;
    }

    @Override
    public void save(NhanVien nhanVien) {

    }

    @Override
    public NhanVien findById(int id) {
        NhanVien nhanVien = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_NHANVIEN_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ho_ten = resultSet.getString("ho_ten");
                    ViTri id_vitri =  viTriRepository.findById(resultSet.getInt("id_vitri"));
                    TrinhDo id_trinhdo = trinhDoRepository.findById(resultSet.getInt("id_trinhdo"));
                    BoPhan id_bophan = boPhanRepository.findById(resultSet.getInt("id_bophan"));
                    NguoiDung ten_nguoidung = nguoiDungRepository.findById(resultSet.getString("ten_nguoidung"));
                    String ngay_sinh = resultSet.getString("ngay_sinh");
                    String so_cmnd = resultSet.getString("so_cmnd");
                    double luong = resultSet.getDouble("luong");
                    String sdt = resultSet.getString("sdt");
                    String email = resultSet.getString("email");
                    String dia_chi = resultSet.getString("dia_chi");
                    nhanVien = new NhanVien(ho_ten, id_vitri, id_trinhdo, id_bophan, ten_nguoidung, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi);
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
        return nhanVien;
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
