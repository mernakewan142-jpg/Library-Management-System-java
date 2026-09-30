package Com.Library.service;

import Com.Library.model.User;
import Com.Library.repository.UserRepository;

import java.util.ArrayList;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public ArrayList<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}