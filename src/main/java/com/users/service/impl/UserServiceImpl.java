package com.users.service.impl;

import com.users.dao.UserDao;
import com.users.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements com.users.service.UserService {

    @Autowired
    private UserDao userDao;

    public ArrayList<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public List<User> getUsersByRole(String userId) {
        User user = userDao.getUserById(userId);
        List<User> listUsersByRole = null;
        Character userRole = user.getUserRole();
        switch (userRole) {
            case    'A':
                listUsersByRole = userDao.getAllUsers();
                break;
            case    'P':
                listUsersByRole = getPrivilegeUsers();
                break;
            case    'S':
                listUsersByRole = Collections.singletonList(user);
                break;
            default:
                listUsersByRole = Collections.singletonList(user);
                break;
        }
        return listUsersByRole;
    }

    public List<User> getPrivilegeUsers() {
        List<User> listAllUsers=userDao.getAllUsers();
        List<User> listUsersByRole=null;
        int size = listAllUsers.size();
        for(int i = 0; i < size; i++){
          if(!listAllUsers.get(i).getUserRole().equals('A')) {
              listUsersByRole.add(listAllUsers.get(i));
          }
       }
        return listUsersByRole;
    }

    public int create(User user) {
        return userDao.create(user);
    }

    public Boolean updateUserById(String userId, User newUser){
        return userDao.updateUserById(userId, newUser);
    }
    public Boolean deleteUserById(String userId) {
        return userDao.deleteUserById(userId);
    }
}
