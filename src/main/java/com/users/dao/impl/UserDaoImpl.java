package com.users.dao.impl;

import com.users.dao.UserDao;
import com.users.domain.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class UserDaoImpl implements UserDao {

    private ArrayList<User> usersDataBase = new ArrayList<User>();

    public ArrayList<User> getAllUsers() {
        return usersDataBase;
    }

    public User getUserById(String userId) {
        User user = null;
        for (int i = 0; i < usersDataBase.size(); i++)
        {
            if (usersDataBase.get(i).getId() == Integer.parseInt(userId)) {
                user = usersDataBase.get(i);
            }
        }
        return user;
    }

    public int create(User user) {
        usersDataBase.add(user);
        return user.getId();
    }

    public Boolean updateUserById(String userId, User newUser) {
        Boolean foundUserById=false;
        User user = null;
        for (int i = 0; i < usersDataBase.size(); i++)
            if (usersDataBase.get(i).getId() == Integer.parseInt(userId)) {
                user = usersDataBase.get(i);
                user.setFirstName(newUser.getFirstName());
                user.setLastName(newUser.getLastName());
                user.setUserRole(newUser.getUserRole());
                foundUserById = true;
            }
        return foundUserById;
    }

    public Boolean deleteUserById(String userId) {
        Boolean deleteUserById=false;
        for (int i = 0; i < usersDataBase.size(); i++) {
            if (usersDataBase.get(i).getId() == Integer.parseInt(userId)) {
                usersDataBase.remove(i);
                deleteUserById=true;
               }
        }
        return deleteUserById;
    }
}
