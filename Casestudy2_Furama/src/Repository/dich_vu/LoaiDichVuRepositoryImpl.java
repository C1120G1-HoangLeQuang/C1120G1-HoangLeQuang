package Repository.dich_vu;

import Model.KieuThue;
import Model.LoaiDichVu;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiDichVuRepositoryImpl implements LoaiDichVuRepository {

    private static final String SELECT_FROM_LOAIDICHVU = "select * from loai_dich_vu;";
    private static final String SELECT_LOAIDICHVU_BY_ID = "select ten_loaidichvu from loai_dich_vu where id_loaidichvu = ?;";

    @Override
    public List<LoaiDichVu> findAll() {
        List<LoaiDichVu> loaiDichVuList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_LOAIDICHVU);
                resultSet = statement.executeQuery();
                LoaiDichVu loaiDichVu = null;
                while ( resultSet.next()) {
                    int id_loaidichvu = resultSet.getInt("id_loaidichvu");
                    String ten_loaidichvu = resultSet.getString("ten_loaidichvu");
                    loaiDichVu = new LoaiDichVu(id_loaidichvu, ten_loaidichvu);
                    loaiDichVuList.add(loaiDichVu);
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
        return loaiDichVuList;
    }

    @Override
    public LoaiDichVu findById(int id) {
        LoaiDichVu loaiDichVu = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_LOAIDICHVU_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_loaidichvu = resultSet.getString("ten_loaidichvu");
                    loaiDichVu = new LoaiDichVu(id, ten_loaidichvu);
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
        return loaiDichVu;
    }
}
