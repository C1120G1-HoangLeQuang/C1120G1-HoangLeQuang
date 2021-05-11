package Repository.dich_vu;

import Model.KieuThue;
import Model.LoaiKhach;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KieuThueRepositoryImpl implements KieuThueRepository {

    private static final String SELECT_FROM_KIEUTHUE = "select * from kieu_thue;";
    private static final String SELECT_KIEUTHUE_BY_ID = "select ten_kieuthue, gia from kieu_thue where id_kieuthue = ?;";

    @Override
    public List<KieuThue> findAll() {
        List<KieuThue> kieuThueList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_KIEUTHUE);
                resultSet = statement.executeQuery();
                KieuThue kieuThue = null;
                while ( resultSet.next()) {
                    int id_kieuthue = resultSet.getInt("id_kieuthue");
                    String ten_kieuthue = resultSet.getString("ten_kieuthue");
                    int gia = resultSet.getInt("gia");
                    kieuThue = new KieuThue(id_kieuthue, ten_kieuthue, gia);
                    kieuThueList.add(kieuThue);
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
        return kieuThueList;
    }

    @Override
    public KieuThue findById(int id) {
        KieuThue kieuThue = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_KIEUTHUE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_kieuthue = resultSet.getString("ten_kieuthue");
                    int gia = resultSet.getInt("gia");
                    kieuThue = new KieuThue(id, ten_kieuthue, gia);
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
        return kieuThue;
    }
}
