package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "select * from `account` where username = ?1", nativeQuery = true)
    Account findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update `account` set `account`.account_status_id = 3 where `account`.username = ?1", nativeQuery = true)
    void deleteUserAccount(String username);

    @Modifying
    @Query(value = "insert into `account` (username, password, point, register_date, account_status_id ) " +
            "values (:username, :password, 0, :register_date, 1) ",
            nativeQuery = true)
    @Transactional
    void saveUserAccount(@Param("username") String username,
                         @Param("password") String password,
                         @Param("register_date") LocalDate register_date);

    @Query(value = "select * from `account`" ,nativeQuery = true)
    List<Account> getListAccount();
}
