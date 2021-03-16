package bai_tap_users.repository;

import bai_tap_users.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String SELECT_FROM_USERS = "select * from users";
    public static final String INSERT_USER_VALUE = "INSERT INTO users(name, email, country) value(?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (open != null) {
            try {
                statement = open.prepareStatement(SELECT_FROM_USERS);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public void save(User user) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(INSERT_USER_VALUE);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
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
    public User findById(int id) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (open != null) {
            try {
                // Step 1: Establishing a Connection
                statement = open.prepareStatement(SELECT_USER_BY_ID);  // Step 2:Create a statement using connection object
                statement.setInt(1, id);
                System.out.println(statement);
                resultSet = statement.executeQuery();   // Step 3: Execute the query or update query
                while (resultSet.next()) {                              // Step 4: Process the ResultSet object.
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(name, email, country);
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
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean rowUpdated = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(UPDATE_USERS_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());
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
    public boolean remove(int id) {
        boolean rowDelete = false;
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (open != null) {
            try {
                open = DBConnection.getOpen();
                statement = open.prepareStatement(DELETE_USERS_SQL);
                statement.setInt(1, id);
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
}
