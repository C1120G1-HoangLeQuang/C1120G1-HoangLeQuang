package Repository.nhan_vien;

import Model.BoPhan;
import Model.NguoiDung;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungRepositoryImpl implements  NguoiDungRepository {
    private static final String SELECT_FROM_NGUOIDUNG = "select * from nguoi_dung;";
    private static final String SELECT_NGUOIDUNG_BY_ID = "select mat_khau from nguoi_dung where ten_nguoidung = ?;";

    @Override
    public List<NguoiDung> findAll() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_NGUOIDUNG);
                resultSet = statement.executeQuery();
                NguoiDung nguoiDung = null;
                while ( resultSet.next()) {
                    String ten_nguoidung = resultSet.getString("ten_nguoidung");
                    String mat_khau = resultSet.getString("mat_khau");
                    nguoiDung = new NguoiDung(ten_nguoidung, mat_khau);
                    nguoiDungList.add(nguoiDung);
                }
            }catch (SQLException throwables) {
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
        return nguoiDungList;
    }

    @Override
    public NguoiDung findById(String ten_nguoidung) {
        NguoiDung nguoiDung = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_NGUOIDUNG_BY_ID);
                statement.setString(1, ten_nguoidung);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String mat_khau = resultSet.getString("mat_khau");
                    nguoiDung = new NguoiDung(ten_nguoidung, mat_khau);
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
        return nguoiDung;
    }
}
