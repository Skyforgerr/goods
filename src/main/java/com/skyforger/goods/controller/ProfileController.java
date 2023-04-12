package com.skyforger.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyforger.goods.service.UserService;

@RequestMapping("/profile")
@RestController
public class ProfileController {
    @Autowired
    private UserService userService;
    @GetMapping("/profile")
    public String viewProfile(Model model){
        return "The output of the profile page";
    }
    
}
