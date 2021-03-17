package bai_tap_users.repository;

import bai_tap_users.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    boolean update(User user);

    boolean remove(int id);

    List<User> getUserByCountry(String country_user);

    List<User> sortByName(List<User> userList, String sortBy);
}
