package com.users.dao;

import com.users.domain.User;
import java.util.ArrayList;

public interface UserDao {
     ArrayList<User> getAllUsers();
     User getUserById(String userId);
     int create(User user);
     Boolean updateUserById(String userId, User newUser);
     Boolean deleteUserById(String userId);
}