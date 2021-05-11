package Repository.nhan_vien;

import Model.ViTri;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViTriRepositoryImpl implements ViTriRepository {

    private static final String SELECT_FROM_VITRI = "select * from vi_tri;";
    private static final String SELECT_VITRI_BY_ID = "select ten_vitri from vi_tri where id_vitri = ?;";

    @Override
    public List<ViTri> findAll() {
        List<ViTri> viTriList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_VITRI);
                resultSet = statement.executeQuery();
                ViTri viTri = null;
                while (resultSet.next()) {
                    int id_vitri = resultSet.getInt("id_vitri");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    viTri = new ViTri(id_vitri, ten_vitri);
                    viTriList.add(viTri);
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
        return viTriList;
    }

    @Override
    public ViTri findById(int id) {
        ViTri viTri = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_VITRI_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_vitri = resultSet.getString("ten_vitri");
                    viTri = new ViTri(id, ten_vitri);
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
        return viTri;
    }
}
