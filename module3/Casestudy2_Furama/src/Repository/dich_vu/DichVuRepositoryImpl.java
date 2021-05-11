package Repository.dich_vu;

import Model.DichVu;
import Model.KieuThue;
import Model.LoaiDichVu;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuRepositoryImpl implements DichVuRepository {

    public static final String SELECT_FROM_DICHVU = "select * from dich_vu;";
    private static final String SELECT_DICHVU_BY_ID = "select id_dichvu, ten_dich_vu, dien_tich, songuoi_toida, chi_phi_thue, id_kieuthue, id_loaidichvu, tieu_chuan_phong, mota_tiennghi_khac, dientich_hoboi, so_tang from dich_vu where id_dichvu = ?;";
    public static final String INSERT_DICHVU_VALUE = "INSERT INTO dich_vu(id_dichvu, ten_dich_vu, dien_tich, songuoi_toida, chi_phi_thue, id_kieuthue, id_loaidichvu, tieu_chuan_phong, mota_tiennghi_khac, dientich_hoboi, so_tang) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    KieuThueRepositoryImpl kieuThueRepository = new KieuThueRepositoryImpl();
    LoaiDichVuRepositoryImpl loaiDichVuRepository = new LoaiDichVuRepositoryImpl();
    @Override
    public List<DichVu> findAll() {
        List<DichVu> dichVuList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_DICHVU);
                resultSet = statement.executeQuery();
                DichVu dichVu = null;
                while ( resultSet.next()) {
                    String id_dichvu = resultSet.getString("id_dichvu");
                    String ten_dich_vu = resultSet.getString("ten_dich_vu");
                    int dien_tich = resultSet.getInt("dien_tich");
                    int songuoi_toida = resultSet.getInt("songuoi_toida");
                    double chi_phi_thue = resultSet.getDouble("chi_phi_thue");
                    KieuThue id_kieuthue = kieuThueRepository.findById(resultSet.getInt("id_kieuthue"));
                    LoaiDichVu id_loaidichvu = loaiDichVuRepository.findById(resultSet.getInt("id_loaidichvu"));
                    String tieu_chuan_phong = resultSet.getString("tieu_chuan_phong");
                    String mota_tiennghi_khac = resultSet.getString("mota_tiennghi_khac");
                    double dientich_hoboi = resultSet.getDouble("dientich_hoboi");
                    int so_tang = resultSet.getInt("so_tang");
                    dichVu = new DichVu(id_dichvu, ten_dich_vu, dien_tich, songuoi_toida,
                            chi_phi_thue, id_kieuthue, id_loaidichvu, tieu_chuan_phong, mota_tiennghi_khac, dientich_hoboi, so_tang);
                    dichVuList.add(dichVu);
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
        return dichVuList;
    }

    @Override
    public void save(DichVu dichVu) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(INSERT_DICHVU_VALUE);
                statement.setString(1, dichVu.getId_dichvu());
                statement.setString(2, dichVu.getTen_dich_vu());
                statement.setInt(3, dichVu.getDien_tich());
                statement.setInt(4, dichVu.getSonguoi_toida());
                statement.setDouble(5, dichVu.getChi_phi_thue());
                statement.setInt(6, dichVu.getId_kieuthue().getId_kieuthue());
                statement.setInt(7, dichVu.getId_loaidichvu().getId_loaidichvu());
                statement.setString(8, dichVu.getTieu_chuan_phong());
                statement.setString(9, dichVu.getMota_tiennghi_khac());
                statement.setDouble(10, dichVu.getDientich_hoboi());
                statement.setInt(11, dichVu.getSo_tang());
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
    public DichVu findById(String id) {
        DichVu dichVu = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_DICHVU_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String ten_dich_vu = resultSet.getString("ten_dich_vu");
                    int dien_tich = resultSet.getInt("dien_tich");
                    int songuoi_toida = resultSet.getInt("songuoi_toida");
                    double chi_phi_thue = resultSet.getDouble("chi_phi_thue");
                    KieuThue id_kieuthue = kieuThueRepository.findById(resultSet.getInt("id_kieuthue"));
                    LoaiDichVu id_loaidichvu = loaiDichVuRepository.findById(resultSet.getInt("id_loaidichvu"));
                    String tieu_chuan_phong = resultSet.getString("tieu_chuan_phong");
                    String mota_tiennghi_khac = resultSet.getString("mota_tiennghi_khac");
                    double dientich_hoboi = resultSet.getDouble("dientich_hoboi");
                    int so_tang = resultSet.getInt("so_tang");
                    dichVu = new DichVu(ten_dich_vu, dien_tich, songuoi_toida,
                            chi_phi_thue, id_kieuthue, id_loaidichvu, tieu_chuan_phong, mota_tiennghi_khac, dientich_hoboi, so_tang);
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
        return dichVu;
    }

    @Override
    public boolean update(DichVu dichVu) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
