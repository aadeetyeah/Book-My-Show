package com.procrastinator.bmsmicroservice.bookmyshow.controller;


import com.procrastinator.bmsmicroservice.bookmyshow.constant.RequestConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(RequestConstants.ADD_USER_URI)
    public UserResponse addUser(@RequestBody User user){

        return  userService.addUser(user);
    }

    @DeleteMapping(RequestConstants.DELETE_USER_BY_ID_URI)
    public UserResponse deleteUserById(@RequestParam int id){
         return userService.deleteUser(id);
    }

    @GetMapping(RequestConstants.GET_ALL_USER_URI)
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }
}
