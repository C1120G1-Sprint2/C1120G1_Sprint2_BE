package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.entity.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    List<User> findAll(int index);

    User findById(Integer userId);

    void updateUser(UserDTO userDTO);

    User findByUsername(String username);

    User findByIdCard(String idCard);

    void saveUserCus(UserDTO userDTO);

    void deleteUserById(Integer id);

    List<User> searchAllUserAttribute(String key);

    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    User getUserByUsername(String username);

    //HanTH
    User findUserByCardId(String cardId);
    //HanTH
}
