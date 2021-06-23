package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.User;

public interface UserService {
    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    User getUserByUsername(String username);
}
