package org.example.repository;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository {
    private HashMap<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public User getUserById(Integer id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public String createUser(User user) {
        users.put(user.getId(), user);
        return "User Created Successfully";
    }
}
