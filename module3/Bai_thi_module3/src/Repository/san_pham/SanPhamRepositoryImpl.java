package Repository.san_pham;

import Model.PhongTro;
import Model.SanPham;
import Model.ThanhToan;
import Repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepositoryImpl implements SanPhamRepository {

    public static final String SELECT_FROM_SANPHAM = "select * from san_pham;";
    private static final String SELECT_SANPHAM_BY_ID = "select id_sanpham, ten_sanpham, gia, muc_giamgia, ton_kho from san_pham where id_sanpham = ?;";
    public static final String INSERT_SANPHAM_VALUE = "INSERT INTO san_pham(ten_sanpham, gia, muc_giamgia, ton_kho) value(?, ?, ?, ?);";
    private static final String DELETE_SANPHAM_SQL = "delete from san_pham where id_sanpham= ?;";
    private static final String UPDATE_SANPHAM_SQL = "update san_pham set ten_sanpham = ?,  gia = ?, muc_giamgia = ?, ton_kho = ? where id_sanpham = ?;";
    private static final String SEARCH_SANPHAM_BY_EVERYTHING = "select * from phong_tro where ma_phongtro like ?\n" +
            "union\n" +
            "select * from phong_tro where ten_khachthue like ?\n" +
            "union\n" +
            "select * from phong_tro where sdt like ?;";
    private static final String SEARCH_TOP_3510 = "SELECT san_pham.id_sanpham, san_pham.ten_sanpham, san_pham.gia, san_pham.muc_giamgia, san_pham.ton_kho, count(don_hang.id_sanpham) as tong\n" +
            "from san_pham\n" +
            "inner join don_hang on don_hang.id_sanpham = san_pham.id_sanpham\n" +
            "group by don_hang.id_sanpham\n" +
            "order by tong desc\n" +
            "limit ?;";

    private static final String SEARCH_DATEORDER = "SELECT san_pham.id_sanpham, san_pham.ten_sanpham, san_pham.gia, san_pham.muc_giamgia, san_pham.ton_kho\n" +
            "from san_pham\n" +
            "inner join don_hang on don_hang.id_sanpham = san_pham.id_sanpham\n" +
            "where don_hang.ngay_dathang between ? and ?;";

    @Override
    public List<SanPham> findAll() {
        List<SanPham> sanPhamList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_SANPHAM);
                resultSet = statement.executeQuery();
                SanPham sanPham = null;
                while (resultSet.next()) {
                    int id_sanpham = Integer.parseInt(resultSet.getString("id_sanpham"));
                    String ten_sanpham = resultSet.getString("ten_sanpham");
                    double gia = Double.parseDouble(resultSet.getString("gia"));
                    double muc_giamgia = Double.parseDouble(resultSet.getString("muc_giamgia"));
                    int ton_kho = Integer.parseInt(resultSet.getString("ton_kho"));
                    sanPham = new SanPham(id_sanpham, ten_sanpham, gia, muc_giamgia, ton_kho);
                    sanPhamList.add(sanPham);
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
        return sanPhamList;
    }

    @Override
    public void save(SanPham sanPham) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(INSERT_SANPHAM_VALUE);
//                statement.setInt(1, sanPham.getId_sanpham());
                statement.setString(1, sanPham.getTen_sanpham());
                statement.setDouble(2, sanPham.getGia());
                statement.setDouble(3, sanPham.getMuc_giamgia());
                statement.setInt(4, sanPham.getTon_kho());
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
    public List<SanPham> findTop3510(int top) {
        List<SanPham> sanPhamList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SEARCH_TOP_3510);
                statement.setInt(1, top);
                resultSet = statement.executeQuery();
                SanPham sanPham = null;
                while (resultSet.next()) {
                    int id_sanpham = Integer.parseInt(resultSet.getString("id_sanpham"));
                    String ten_sanpham = resultSet.getString("ten_sanpham");
                    double gia = Double.parseDouble(resultSet.getString("gia"));
                    double muc_giamgia = Double.parseDouble(resultSet.getString("muc_giamgia"));
                    int ton_kho = Integer.parseInt(resultSet.getString("ton_kho"));
                    sanPham = new SanPham(id_sanpham, ten_sanpham, gia, muc_giamgia, ton_kho);
                    sanPhamList.add(sanPham);
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
        return sanPhamList;
    }

    @Override
    public List<SanPham> findDateOrder(java.sql.Date start, Date end) {
        List<SanPham> sanPhamList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SEARCH_DATEORDER);
                statement.setDate(1, start);
                statement.setDate(2, end);
                resultSet = statement.executeQuery();
                SanPham sanPham = null;
                while (resultSet.next()) {
                    int id_sanpham = Integer.parseInt(resultSet.getString("id_sanpham"));
                    String ten_sanpham = resultSet.getString("ten_sanpham");
                    double gia = Double.parseDouble(resultSet.getString("gia"));
                    double muc_giamgia = Double.parseDouble(resultSet.getString("muc_giamgia"));
                    int ton_kho = Integer.parseInt(resultSet.getString("ton_kho"));
                    sanPham = new SanPham(id_sanpham, ten_sanpham, gia, muc_giamgia, ton_kho);
                    sanPhamList.add(sanPham);
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
        return sanPhamList;
    }

    @Override
    public SanPham findById(int id_sanpham) {
        return null;
    }

    @Override
    public boolean update(SanPham sanPham) {
        return false;
    }

    @Override
    public boolean delete(int id_sanpham) {
        return false;
    }

    @Override
    public List<SanPham> findByEverything(String search) {
        return null;
    }
}
