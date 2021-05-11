package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String HOST = "localhost";
    private static final String DATABASE = "ThiLaiModule3";
    private static final String PORT = "3306";

    private static Connection open;

    public static Connection getOpen() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            open = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?useSSL=false", USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return open;
    }

    public static void close() {
        try {
            if (open != null) {
                open.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
