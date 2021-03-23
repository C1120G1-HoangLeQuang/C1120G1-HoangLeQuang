package bai_tap_users.service;

import bai_tap_users.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    boolean update(User user);

    boolean remove(int id);

    List<User> getUserByCountry(String country_user);

    List<User> sortByName(List<User> userList, String sortBy);

    public User getUserById(int id);

    public void insertUserStore(User user);

    public void addUserTransaction(User user, int[] permision);

}