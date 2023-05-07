 package com.skyforger.goods.service;

 import org.springframework.beans.factory.annotation.Autowired;
 import com.skyforger.goods.model.Good;

 import com.skyforger.goods.repository.GoodRepository;
 import org.springframework.stereotype.Service;

 import java.util.List;

 @Service
 public class GoodServiceImpl implements GoodService{
     @Autowired
     private GoodRepository goodRepository;

     @Override
     public Good saveGood(Good good) {
         return goodRepository.save(good);
     }
    
     @Override
     public List<Good> getAllGoods() {
         return goodRepository.findAll();
     }
 }