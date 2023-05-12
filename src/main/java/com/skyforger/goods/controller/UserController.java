package com.skyforger.goods.controller;

import com.skyforger.goods.model.User;
import com.skyforger.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ivan 18.03.2023
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.saveUser(user);
        return "New user has been added";
    }

    @GetMapping("/view")
    public List<User> viewAllUsers(){
        return userService.getAllUsers();
    }

}
