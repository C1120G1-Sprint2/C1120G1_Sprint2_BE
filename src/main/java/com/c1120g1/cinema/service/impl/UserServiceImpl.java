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
        return userRepository.getAllUser();
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user.getUserId(), standardizeName(user.getName()),
                                  user.getEmail(), user.getPhone(), user.getWard(),
                                  user.getAvatarUrl(),user.getGender());
    }


    // chuẩn hoá tên
    public String standardizeName(String name) {
        name = name.toLowerCase();
        name = name.replaceAll("\\s+", " ");
        name = name.trim();
        String name2 = "";
        String temp = "";
        String[] words = name.split("\\s");
        for (String w : words) {
            temp = w.substring(0, 1).toUpperCase();
            for (int i = 1; i < w.length(); i++) {
                temp += w.charAt(i);
            }
            name2 += temp + " ";
        }
        name = name2.trim();
        return name;
    }
}
