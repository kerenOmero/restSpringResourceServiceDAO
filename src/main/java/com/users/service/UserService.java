package com.users.service;

import com.users.domain.User;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    ArrayList<User> getAllUsers();
    User getUserById(String userId);
    List<User> getUsersByRole(String userId);
    int create(User user);
    Boolean updateUserById(String userId, User newUser);
    Boolean deleteUserById(String userId);
}