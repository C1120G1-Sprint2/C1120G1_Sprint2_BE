package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.repository.UserRepository;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
