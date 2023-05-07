 package com.skyforger.goods.repository;

 import com.skyforger.goods.model.Good;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public interface GoodRepository extends JpaRepository<Good, Integer>{
    
 }
