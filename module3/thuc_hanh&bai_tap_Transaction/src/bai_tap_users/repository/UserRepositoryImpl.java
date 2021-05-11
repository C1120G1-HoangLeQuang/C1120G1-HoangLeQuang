package bai_tap_users.repository;

import bai_tap_users.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String SELECT_FROM_USERS = "select * from users;";
    public static final String INSERT_USER_VALUE = "INSERT INTO users(name, email, country) value(?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_USERS_BY_CT = "select * from users where country = ?;";
    private static final String SORT_USERS_BY_ASC = "select * from users order by `name`;";
    private static final String SORT_USERS_BY_DESC = "select * from users order by `name` desc;";

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

    public List<User> getUserByCountry(String country_user) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        User user = null;
        if (open != null) {
            try {
                statement = open.prepareStatement(SEARCH_USERS_BY_CT);
                statement.setString(1, country_user);
                System.out.println(statement);
                resultSet = statement.executeQuery();
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
    public List<User> sortByName(List<User> userListIn, String sortBy) {
        Connection open = DBConnection.getOpen();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        userListIn = new ArrayList<>();
        User user = null;
        if (open != null) {
            try {
                if (sortBy.equals("DESC")) {
                    statement = open.prepareStatement(SORT_USERS_BY_DESC);
                }
                if (sortBy.equals("ASC")) {
                    statement = open.prepareStatement(SORT_USERS_BY_ASC);
                }
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userListIn.add(user);
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
        return userListIn;
    }

    @Override
    public User getUserById(int id) {  //tìm user theo id
        Connection open = DBConnection.getOpen();
        CallableStatement callableStatement = null;
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try {
            callableStatement = open.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) {  //thêm mới user
        Connection open = DBConnection.getOpen();
        CallableStatement callableStatement = null;
        String query = "{CALL insert_user(?,?,?)}";
        try {
            callableStatement = open.prepareCall(query);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection open = null;
        // for insert a new user
        PreparedStatement statement = null;
        // for assign permision to user
        PreparedStatement preparedStatement = null;
        // for getting user id
        ResultSet rs = null;
        try {
            open = DBConnection.getOpen();
            // set auto commit to false
            open.setAutoCommit(false);
            // Insert user
            statement = open.prepareStatement(INSERT_USER_VALUE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            int rowAffected = statement.executeUpdate();
            // get user id
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                preparedStatement = open.prepareStatement(sqlPivot);
                for (int permisionId : permision) {
                    preparedStatement.setInt(1, userId);
                    preparedStatement.setInt(2, permisionId);
                    preparedStatement.executeUpdate();
                }
                open.commit();
            } else {
                open.rollback();
            }
        } catch (SQLException ex) {
            // roll back the transaction
            try {
                if (open != null)
                    open.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (open != null) open.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
