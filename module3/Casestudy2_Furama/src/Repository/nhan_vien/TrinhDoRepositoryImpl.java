package Repository.nhan_vien;

import Model.TrinhDo;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoRepositoryImpl implements TrinhDoRepository {

    private static final String SELECT_FROM_TRINHDO = "select * from trinh_do;";
    private static final String SELECT_TRINHDO_BY_ID = "select trinh_do from trinh_do where id_trinhdo = ?;";

    @Override
    public List<TrinhDo> findAll() {
        List<TrinhDo> trinhDoList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_TRINHDO);
                resultSet = statement.executeQuery();
                TrinhDo trinhDo = null;
                while ( resultSet.next()) {
                    int id_trinhdo = resultSet.getInt("id_trinhdo");
                    String trinh_do = resultSet.getString("trinh_do");
                    trinhDo = new TrinhDo(id_trinhdo, trinh_do);
                    trinhDoList.add(trinhDo);
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
        return trinhDoList;
    }

    @Override
    public TrinhDo findById(int id) {
        TrinhDo trinhDo = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_TRINHDO_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String trinh_do = resultSet.getString("trinh_do");
                    trinhDo = new TrinhDo(id, trinh_do);
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
        return trinhDo;
    }
}
