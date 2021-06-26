package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM cinema_db.user WHERE user.id_card = ?1",nativeQuery = true)
    User findUserByCardId(String cardId);
}
