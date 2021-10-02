package com.procrastinator.bmsmicroservice.bookmyshow.controller;


import com.procrastinator.bmsmicroservice.bookmyshow.constant.RequestConstants;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;
import com.procrastinator.bmsmicroservice.bookmyshow.response.UserResponse;
import com.procrastinator.bmsmicroservice.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(RequestConstants.ADD_USER_URI)
    public UserResponse addUser(@RequestBody User user){

        return  userService.addUser(user);
    }

    public UserResponse deleteUserById(int id){
        return userService.deleteUser(id);
    }
}
