package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    @Query(value = "SELECT * FROM `user` " +
            "WHERE username = ?1", nativeQuery = true)
    User findByUsername(String username);

    @Modifying
    @Query(value ="update `user`" +
            " set `name` = ?2, " +
            "birthday =?3, " +
            "gender =?4, " +
            "email =?5, " +
            "idCard =?6, " +
            "phone =?7" +
            " where username = ?1",nativeQuery = true)
    void updateUser(String username,String name, String birthday, Integer gender, String email, String idCard, String phone);

    @Modifying
    @Query(value ="update `user`" +
            " set `name` = ?2, " +
            "birthday =?3, " +
            "gender =?4, " +
            "email =?5, " +
            "idCard =?6, " +
            "phone =?7" +
            " where user_id = ?1",nativeQuery = true)
    void updateUser1(String name, String birthday, Integer gender, String email, String idCard, String phone);
}
