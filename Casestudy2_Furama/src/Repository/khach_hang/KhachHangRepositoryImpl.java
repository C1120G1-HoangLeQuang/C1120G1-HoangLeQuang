package Repository.khach_hang;

import Model.*;
import Repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepositoryImpl implements KhachHangRepository {

    public static final String SELECT_FROM_KHACHHANG = "select * from khach_hang;";
    private static final String SELECT_KHACHHANG_BY_ID = "select id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi from khach_hang where id_khachhang = ?;";
    public static final String INSERT_KHACHHANG_VALUE = "INSERT INTO khach_hang(id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi) value(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_KHACHHANG_SQL = "delete from khach_hang where id_khachhang = ?;";
    private static final String UPDATE_KHACHHANG_SQL = "update khach_hang set id_loaikhach = ?, ho_ten = ?, ngay_sinh = ?, gioi_tinh = ?, so_cmnd = ?, sdt = ?, email = ?, dia_chi = ? where id_khachhang = ?;";
    private static final String SEARCH_KHACHHANG_BY_EVERYTHING = "select * from khach_hang where id_khachhang like ?\n" +
                                                                "union\n" +
                                                                "select id_khachhang, khach_hang.id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi from khach_hang inner join loai_khach on loai_khach.id_loaikhach = khach_hang.id_loaikhach \n" +
                                                                "where ten_loaikhach like ?" +
                                                                "union\n" +
                                                                "select * from khach_hang where ho_ten like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where ngay_sinh like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where gioi_tinh like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where so_cmnd like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where sdt like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where email like ?\n" +
                                                                "union\n" +
                                                                "select * from khach_hang where dia_chi like ?;";

    LoaiKhachRepositoryImpl loaiKhachRepository = new LoaiKhachRepositoryImpl();
    @Override
    public List<Khachhang> findAll() {
        List<Khachhang> khachhangList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_KHACHHANG);
                resultSet = statement.executeQuery();
                Khachhang khachHang = null;
                while (resultSet.next()) {
                    String id_khachhang = resultSet.getString("id_khachhang");
                    LoaiKhach id_loaikhach = loaiKhachRepository.findById(resultSet.getInt("id_loaikhach"));
                    String ho_ten = resultSet.getString("ho_ten");
                    String ngay_sinh = resultSet.getString("ngay_sinh");
                    boolean gioi_tinh = resultSet.getInt("gioi_tinh") == 1;
                    String so_cmnd = resultSet.getString("so_cmnd");
                    String sdt = resultSet.getString("sdt");
                    String email = resultSet.getString("email");
                    String dia_chi = resultSet.getString("dia_chi");
                    khachHang = new Khachhang(id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi);
                    khachhangList.add(khachHang);
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
        return khachhangList;
    }

    @Override
    public void save(Khachhang khachhang) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(INSERT_KHACHHANG_VALUE);
                statement.setString(1, khachhang.getId_khachhang());
                statement.setInt(2, khachhang.getId_loaikhach().getId_loaikhach());
                statement.setString(3, khachhang.getHo_ten());
                statement.setString(4, khachhang.getNgay_sinh());
                statement.setBoolean(5, khachhang.isGioi_tinh());
                statement.setString(6, khachhang.getSo_cmnd());
                statement.setString(7, khachhang.getSdt());
                statement.setString(8, khachhang.getEmail());
                statement.setString(9, khachhang.getDia_chi());
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
    public Khachhang findById(String id) {
        Khachhang khachHang = null;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_KHACHHANG_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    LoaiKhach id_loaikhach = loaiKhachRepository.findById(resultSet.getInt("id_loaikhach"));
                    String ho_ten = resultSet.getString("ho_ten");
                    String ngay_sinh = resultSet.getString("ngay_sinh");
                    boolean gioi_tinh = resultSet.getInt("gioi_tinh") == 1;
                    String so_cmnd = resultSet.getString("so_cmnd");
                    String sdt = resultSet.getString("sdt");
                    String email = resultSet.getString("email");
                    String dia_chi = resultSet.getString("dia_chi");
                    khachHang = new Khachhang(id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi);
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
        return khachHang;
    }

    @Override
    public boolean update(Khachhang khachhang) {
        boolean rowUpdated = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(UPDATE_KHACHHANG_SQL);
                statement.setInt(1, khachhang.getId_loaikhach().getId_loaikhach());
                statement.setString(2, khachhang.getHo_ten());
                statement.setString(3, khachhang.getNgay_sinh());
                statement.setBoolean(4, khachhang.isGioi_tinh());
                statement.setString(5, khachhang.getSo_cmnd());
                statement.setString(6, khachhang.getSdt());
                statement.setString(7, khachhang.getEmail());
                statement.setString(8, khachhang.getDia_chi());
                statement.setString(9, khachhang.getId_khachhang());
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
    public boolean delete(String id) {
        boolean rowDelete = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                open = DBConnection.getOpen();
                statement = open.prepareStatement(DELETE_KHACHHANG_SQL);
                statement.setString(1, id);
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

    public List<Khachhang> findByEverything(String search) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Khachhang> khachHangList = new ArrayList<>();
        Khachhang khachHang = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SEARCH_KHACHHANG_BY_EVERYTHING);
                statement.setString(1, "%" + search + "%");
                statement.setString(2, "%" + search + "%");
                statement.setString(3, "%" + search + "%");
                statement.setString(4, "%" + search + "%");
                statement.setString(5, "%" + search + "%");
                statement.setString(6, "%" + search + "%");
                statement.setString(7, "%" + search + "%");
                statement.setString(8, "%" + search + "%");
                statement.setString(9, "%" + search + "%");
                System.out.println(statement);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String id_khachhang = resultSet.getString("id_khachhang");
                    LoaiKhach id_loaikhach = loaiKhachRepository.findById(resultSet.getInt("id_loaikhach"));
                    String ho_ten = resultSet.getString("ho_ten");
                    String ngay_sinh = resultSet.getString("ngay_sinh");
                    boolean gioi_tinh = resultSet.getInt("gioi_tinh") == 1;
                    String so_cmnd = resultSet.getString("so_cmnd");
                    String sdt = resultSet.getString("sdt");
                    String email = resultSet.getString("email");
                    String dia_chi = resultSet.getString("dia_chi");
                    khachHang = new Khachhang(id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi);
                    khachHangList.add(khachHang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return khachHangList;
    }
}
