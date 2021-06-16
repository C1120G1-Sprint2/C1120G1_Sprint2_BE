package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer userId);

    void updateUser(User user);
}
