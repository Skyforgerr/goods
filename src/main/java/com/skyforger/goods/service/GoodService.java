 package com.skyforger.goods.service;

 import com.skyforger.goods.model.Good;

 import java.util.List;

 public interface GoodService {
     public Good saveGood(Good good);
     public List<Good> getAllGoods();

 }
