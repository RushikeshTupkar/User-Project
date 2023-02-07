package com.example.user.Project.service;

import com.example.user.Project.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.user.Project.model.User.isValidMobileNo;

@Component
public class UserService {

    static HashMap<String, User> userBase = new HashMap<>();

    public String addUser(String userId, User Newuser) {
        String username = Newuser.getUserName();
        for (Map.Entry<String, User> ele : userBase.entrySet()) {
            User user = ele.getValue();
            if (user.getUserName().equals(username)) {
                return "User name already exists " + username;
            }
        }
        if (userBase.containsKey(userId)) {
            return "User already exists " + userId;
        }
        if(!User.isValidMobileNo(Newuser.getNumber())){
            return "Invalid Mobile number "+ Newuser.getNumber();
        }
        userBase.put(userId, Newuser);
        return "User added - " + Newuser.getFirstName() + " " + Newuser.getLastName();
    }

    public User getUser(String userId) {
        User user = null;
        if (userBase.containsKey(userId)) {
            user = userBase.get(userId);
            return user;
        } else {
            user.setUserName("User Not Found");
            return user;
        }
    }

    public String updateUserInDatabase(User newUser, String userId) {
        userBase.put(userId, newUser);
        return "User updated";
    }

    public String deleteUserFromDatabase(String userId) {
        if (userBase.containsKey(userId)) {
            userBase.remove(userId);
            return "User deleted having userId " + userId;
        } else {
            return "Wrong userId " + userId;
        }
    }

    public HashMap<String, User> getAllUser() {
        return userBase;
    }
}



