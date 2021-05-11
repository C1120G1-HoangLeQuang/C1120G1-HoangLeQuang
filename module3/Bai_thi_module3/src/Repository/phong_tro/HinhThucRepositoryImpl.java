package Repository.phong_tro;

import Model.LoaiKhach;
import Model.ThanhToan;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhThucRepositoryImpl implements HinhThucRepository {
    private static final String SELECT_FROM_THANHTOAN = "select * from hinhthuc_thanhtoan;";
    private static final String SELECT_THANHTOAN_BY_ID = "select hinhthuc_thanhtoan from hinhthuc_thanhtoan where ma_thanhtoan = ?;";



    @Override
    public List<ThanhToan> findAll() {
        List<ThanhToan> thanhToanList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_THANHTOAN);
                resultSet = statement.executeQuery();
                ThanhToan thanhToan = null;
                while ( resultSet.next()) {
                    int ma_thanhtoan = resultSet.getInt(" ma_thanhtoan");
                    String hinhthuc_thanhtoan = resultSet.getString("hinhthuc_thanhtoan");
                    thanhToan = new ThanhToan(ma_thanhtoan, hinhthuc_thanhtoan);
                    thanhToanList.add(thanhToan);
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
        return thanhToanList;
    }

    @Override
    public ThanhToan findById(int ma_thanhtoan) {
        ThanhToan thanhToan = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_THANHTOAN_BY_ID);
                statement.setInt(1, ma_thanhtoan);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String hinhthuc_thanhtoan = resultSet.getString("hinhthuc_thanhtoan");
                    thanhToan = new ThanhToan(ma_thanhtoan, hinhthuc_thanhtoan);
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
        return thanhToan;
    }
}
