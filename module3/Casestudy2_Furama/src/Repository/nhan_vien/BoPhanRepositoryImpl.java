package Repository.nhan_vien;

import Model.BoPhan;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoPhanRepositoryImpl implements BoPhanRepository {
    private static final String SELECT_FROM_BOPHAN = "select * from bo_phan;";
    private static final String SELECT_BOPHAN_BY_ID = "select ten_bophan from bo_phan where id_bophan = ?;";

    @Override
    public List<BoPhan> findAll() {
        List<BoPhan> boPhanList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_BOPHAN);
                resultSet = statement.executeQuery();
                BoPhan boPhan = null;
                while ( resultSet.next()) {
                    int id_bophan = resultSet.getInt("id_bophan");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    boPhan = new BoPhan(id_bophan, ten_bophan);
                    boPhanList.add(boPhan);
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
        return boPhanList;
    }

    @Override
    public BoPhan findById(int id) {
        BoPhan boPhan = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
           try {
               statement = open.prepareStatement(SELECT_BOPHAN_BY_ID);
               statement.setInt(1, id);
               resultSet = statement.executeQuery();
               while (resultSet.next()) {
                    String ten_bophan = resultSet.getString("ten_bophan");
                    boPhan = new BoPhan(id, ten_bophan);
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
        return boPhan;
    }
}
