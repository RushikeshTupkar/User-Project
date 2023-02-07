package com.example.user.Project.controller;

import com.example.user.Project.model.User;
import com.example.user.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }

    @GetMapping("/get-allUsers")
    public HashMap<String,User> getAllUsers(){
        return userService.getAllUser();
    }


    @PostMapping("/addUser/{userId}")
    public String addUserIn(@PathVariable String userId, @RequestBody User user ){
        return userService.addUser(userId, user);
    }

    @PutMapping("/updateUser/{userId}")
    public String updateUser(@RequestBody User user, @PathVariable String userId){
        return userService.updateUserInDatabase(user, userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUserFromDatabase(userId);
    }


}
