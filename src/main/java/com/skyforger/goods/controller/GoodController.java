 package com.skyforger.goods.controller;

 import org.springframework.beans.factory.annotation.Autowired;
 import com.skyforger.goods.model.Good;
 import org.springframework.web.bind.annotation.*;

 import com.skyforger.goods.service.GoodService;

 import java.util.List;

 @RestController
 @RequestMapping("/goods")
 @CrossOrigin
 public class GoodController {
     @Autowired
     private GoodService goodService;

      @PostMapping("/add")
      public String addGood(@RequestBody Good good){
          goodService.saveGood(good);
          return "New good has been added";
      }

      @GetMapping("/view")
     public List<Good> viewAllGoods(){
          return goodService.getAllGoods();
      }

 }
