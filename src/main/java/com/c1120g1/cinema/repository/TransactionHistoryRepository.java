package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer> {
}
