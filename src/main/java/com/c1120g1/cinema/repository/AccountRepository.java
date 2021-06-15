package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
