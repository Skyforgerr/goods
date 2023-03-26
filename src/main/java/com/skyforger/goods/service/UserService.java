package com.skyforger.goods.service;

import com.skyforger.goods.model.User;

import java.util.List;

/**
 * @author Ivan 18.03.2023
 */
public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}