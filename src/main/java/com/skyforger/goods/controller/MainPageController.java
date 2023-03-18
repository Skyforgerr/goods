package com.skyforger.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ivan 05.03.2023
 */

@Controller
public class MainPageController {
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
