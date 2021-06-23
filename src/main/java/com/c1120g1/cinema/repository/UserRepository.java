package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * ThuanNN
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     *ThuanNN
     * @param username
     * @return
     */
    @Query(value = "SELECT * FROM `user` " +
            "INNER JOIN `account` ON `account`.username = `user`.username " +
            "WHERE `account`.username = ?1", nativeQuery= true)
    User getUserByUsername(String username);
}
