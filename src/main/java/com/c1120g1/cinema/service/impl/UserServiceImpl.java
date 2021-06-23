package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.repository.UserRepository;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    /**
     * ThuanNN
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }
}
