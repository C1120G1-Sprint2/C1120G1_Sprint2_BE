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

    User findByIdCard(String username);

    void saveUserCus(UserDTO userDTO);

    void deleteUserById(Integer id);

    List<User> searchAllUserAttribute(String key);
    List<User> findAllUser( );

    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    User getUserByUsername(String username);


    User createUserNoAccount(User user);


     User findByUsername1(String username);

    void updateUser1(User user);

}
