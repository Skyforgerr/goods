package com.skyforger.goods.repository;

import com.skyforger.goods.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan 18.03.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
