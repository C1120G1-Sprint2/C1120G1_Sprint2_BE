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
     *
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void updateUser(User user, String username) {
        User user1 = this.findByUsername(username);
        if (user1 != null) {
//            repository.updateUser(username, user.getName(), user.getBirthday(), user.getGender(), user.getEmail(), user.getIdCard(), user.getPhone());
       user.setAccount(user1.getAccount());
       user.setWard(user1.getWard());
       user.setAvatarUrl(user1.getAvatarUrl());
       user.setUserId(user1.getUserId());

       repository.save(user);

        }
    }

    @Override
    public void updateUser1(User user) {
        repository.updateUser1(user.getName(), user.getBirthday(), user.getGender(), user.getEmail(),
                user.getIdCard(), user.getPhone());

    }
}
