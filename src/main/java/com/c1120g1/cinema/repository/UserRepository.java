package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from `user`", nativeQuery = true)
    List<User> getAllUser();


    @Query(value = "select * from `user` where user_id = ?1", nativeQuery = true)
    User findUserById(Integer userId);

    @Modifying
    @Query(value = "update User u" +
            " set u.name = ?2, " +
            "u.email =?3, " +
            "u.phone =?4, " +
            "u.ward =?5, " +
            "u.avatarUrl =?6, " +
            "u.gender = ?7" +
            " where u.userId = ?1")
    void updateUser(Integer userId, String name, String email, String phone, Ward ward, String avatarUrl,int gender);
}
