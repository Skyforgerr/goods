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
@RequestMapping("/api/v1/managment/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public List<User> viewAllUsers(){
        return userService.getAllUsers();
    }

}
