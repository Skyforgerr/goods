 package com.skyforger.goods.controller;

 import com.skyforger.goods.requests.GoodRequest;
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
      public String addGood(@RequestBody GoodRequest request){
          Good good = Good.builder()
                  .name(request.getName())
                  .cost(request.getCost())
                  .description(request.getDescription())
                  .amount(request.getAmount())
                  .build();
          goodService.saveGood(good);
          return "redirect:goods/view";
      }

      @GetMapping("/view")
     public List<Good> viewAllGoods(){
          return goodService.getAllGoods();
      }


 }
