package Repository.khach_hang;

import Model.LoaiKhach;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiKhachRepositoryImpl implements LoaiKhachRepository{
    private static final String SELECT_FROM_LOAIKHACH = "select * from loai_khach;";
    private static final String SELECT_LOAIKHACH_BY_ID = "select ten_loaikhach from loai_khach where id_loaikhach = ?;";

    @Override
    public List<LoaiKhach> findAll() {
        List<LoaiKhach> loaiKhachList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_LOAIKHACH);
                resultSet = statement.executeQuery();
                LoaiKhach loaiKhach = null;
                while ( resultSet.next()) {
                    int id_loaikhach = resultSet.getInt("id_loaikhach");
                    String ten_loaikhach = resultSet.getString("ten_loaikhach");
                    loaiKhach = new LoaiKhach(id_loaikhach, ten_loaikhach);
                    loaiKhachList.add(loaiKhach);
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
        return loaiKhachList;
    }

    @Override
    public LoaiKhach findById(int id) {
        LoaiKhach loaiKhach = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_LOAIKHACH_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_loaikhach = resultSet.getString("ten_loaikhach");
                    loaiKhach = new LoaiKhach(id, ten_loaikhach);
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
        return loaiKhach;
    }
}
