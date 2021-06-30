package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusRepository extends JpaRepository<AccountStatus,Integer> {
}
