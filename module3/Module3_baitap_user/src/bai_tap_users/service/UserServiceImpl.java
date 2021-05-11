package bai_tap_users.service;

import bai_tap_users.model.User;
import bai_tap_users.repository.UserRepository;
import bai_tap_users.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean update(User user) {
         return userRepository.update (user);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public List<User> getUserByCountry(String country_user) {
        return userRepository.getUserByCountry(country_user);
    }

    @Override
    public List<User> sortByName(List<User> userList, String sortBy) {
        return userRepository.sortByName(userList, sortBy);
    }
}
