package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.UserDTO;
import com.c1120g1.cinema.dto.UserNoAccountDTO;
import com.c1120g1.cinema.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    List<User> findAll(int index);

    Optional<User> findById1(Integer userId);

    void updateUser(UserDTO userDTO);

    User findByUsername1(String username);

    User findByIdCard(String username);

    void saveUserCus(UserDTO userDTO);

    void deleteUserById(Integer id);

    List<User> searchAllUserAttribute(String key);

    List<User> findAllUser( );

    User findByEmail(String email);

    User findById(Integer id);

    User findByUsername(String username);

    void updateUser(User user,String username);

    void updateUser1(User user);

    User getUserByUsername(String username);

    User createUserNoAccount(User user);

    List<User> searchAllAttributePagination(String q, int index);

    void saveUserCusConfirm(UserDTO userDTO);

    void saveUserSocial(User user);

    /**
     * author : HoangTQ
     */
    void createUserWithNoAccount(UserNoAccountDTO userNoAccountDTO);

    /**
     * author : HoangTQ
     */
    User getUserByUserNoAccountDTO(UserNoAccountDTO userNoAccountDTO);
}
