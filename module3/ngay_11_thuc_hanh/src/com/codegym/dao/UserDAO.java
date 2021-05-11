package com.codegym.dao;

import com.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    public static final String SELECT_FROM_USERS = "select * from users";

    public UserDAO() {
    }
//
//    @Override
//    public List<User> findAll() {
//        Connection open = DBConnection.getOpen();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        List<User> userList = new ArrayList<>();
//
//        if (open != null) {
//            try {
//                statement = open.prepareStatement(SELECT_FROM_USERS);
//                resultSet = statement.executeQuery();
//                User user;
//                while (resultSet.next()) {
//                    int id = resultSet.getInt(1);
//                    String name = resultSet.getString("name");
//                    String email = resultSet.getString("email");
//                    String country = resultSet.getString("country");
//                    user = new User(id, name, email, country);
//                    userList.add(user);
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } finally {
//                try {
//                    resultSet.close();
//                    statement.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                DBConnection.close();
//            }
//        }
//        return userList;
//    }
//
//    @Override
//    public void save(User user) {
//
//    }
//
//    @Override
//    public User findById(int id) {
//        return null;
//    }
//
//    @Override
//    public void update(int id, User user) {
//
//    }
//
//    @Override
//    public void remove(int id) {
//
//    }
private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
        " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

        @Override
    public void insertUser(User user) throws SQLException {
            System.out.println(INSERT_USERS_SQL);
            // try-with-resource statement will auto close the connection.
            try (Connection open = DBConnection.getOpen(); 
                 PreparedStatement preparedStatement = open.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection open = DBConnection.getOpen();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = open.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection open = DBConnection.getOpen();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = open.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection open = DBConnection.getOpen();
             PreparedStatement statement = open.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection open = DBConnection.getOpen();
             PreparedStatement statement = open.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException e) {
        for (Throwable ex : e) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) ex).getSQLState());
                System.err.println("Error Code: " + ((SQLException) ex).getErrorCode());
                System.err.println("Message: " + ex.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
