package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.User;

import java.util.List;

public interface UserService {
    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    User findById(Integer id);

    User findByUsername(String username);

    void updateUser(User user,String username);


    void updateUser1(User user);
}
