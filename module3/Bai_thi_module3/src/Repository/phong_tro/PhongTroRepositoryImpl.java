package Repository.phong_tro;

import Model.Khachhang;
import Model.LoaiKhach;
import Model.PhongTro;
import Model.ThanhToan;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepositoryImpl implements PhongTroRepository {
    public static final String SELECT_FROM_PHONGTRO = "select * from phong_tro;";
    private static final String SELECT_PHONGTRO_BY_ID = "select ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu from phong_tro where ma_phongtro = ?;";
    public static final String INSERT_PHONGTRO_VALUE = "INSERT INTO phong_tro(ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu) value(?, ?, ?, ?, ?, ?);";
    private static final String DELETE_PHONGTRO_SQL = "delete from phong_tro where ma_phongtro = ?;";
    private static final String UPDATE_PHONGTRO_SQL = "update phong_tro set ten_khachthue = ?,  sdt = ?, ngay_thue = ?, ma_thanhtoan = ?, ghi_chu = ? where ma_phongtro = ?;";
    private static final String SEARCH_PHONGTRO_BY_EVERYTHING = "select * from phong_tro where ma_phongtro like ?\n" +
            "union\n" +
            "select * from phong_tro where ten_khachthue like ?\n" +
            "union\n" +
            "select * from phong_tro where sdt like ?;";


    HinhThucRepositoryImpl hinhThucRepository = new HinhThucRepositoryImpl();

    @Override
    public List<PhongTro> findAll() {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_PHONGTRO);
                resultSet = statement.executeQuery();
                PhongTro phongTro = null;
                while (resultSet.next()) {
                    String ma_phongtro = resultSet.getString("ma_phongtro");
                    String ten_khachthue = resultSet.getString("ten_khachthue");
                    String sdt = resultSet.getString("sdt");
                    String ngay_thue = resultSet.getString("ngay_thue");
                    ThanhToan ma_thanhtoan = hinhThucRepository.findById(resultSet.getInt("ma_thanhtoan"));
                    String ghi_chu = resultSet.getString("ghi_chu");
                    phongTro = new PhongTro(ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu);
                    phongTroList.add(phongTro);
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
        return phongTroList;
    }

    @Override
    public void save(PhongTro phongTro) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(INSERT_PHONGTRO_VALUE);
                statement.setString(1, phongTro.getMa_phongtro());
                statement.setString(2, phongTro.getTen_khachthue());
                statement.setString(3, phongTro.getSdt());
                statement.setString(4, phongTro.getNgay_thue());
                statement.setInt(5, phongTro.getMa_thanhtoan().getMa_thanhtoan());
                statement.setString(6, phongTro.getGhi_chu());
                statement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public PhongTro findById(String ma_phongtro) {
        PhongTro phongTro = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_PHONGTRO_BY_ID);
                statement.setString(1, ma_phongtro);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_khachthue = resultSet.getString("ten_khachthue");
                    String sdt = resultSet.getString("sdt");
                    String ngay_thue = resultSet.getString("ngay_thue");
                    ThanhToan ma_thanhtoan = hinhThucRepository.findById(resultSet.getInt("ma_thanhtoan"));
                    String ghi_chu = resultSet.getString("ghi_chu");
                    phongTro = new PhongTro(ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu);
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
        return phongTro;
    }

    @Override
    public boolean update(PhongTro phongTro) {
        boolean rowUpdated = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(UPDATE_PHONGTRO_SQL);
                statement.setString(2, phongTro.getTen_khachthue());
                statement.setString(3, phongTro.getSdt());
                statement.setString(4, phongTro.getNgay_thue());
                statement.setInt(5, phongTro.getMa_thanhtoan().getMa_thanhtoan());
                statement.setString(6, phongTro.getGhi_chu());
                statement.setString(1, phongTro.getMa_phongtro());
                rowUpdated = statement.executeUpdate() > 0;
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(String ma_phongtro) {
        boolean rowDelete = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                open = DBConnection.getOpen();
                statement = open.prepareStatement(DELETE_PHONGTRO_SQL);
                statement.setString(1, ma_phongtro);
                rowDelete = statement.executeUpdate() > 0;
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public List<PhongTro> findByEverything(String search) {
        return null;
    }
}
