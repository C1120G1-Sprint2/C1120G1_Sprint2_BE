package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.TransactionHistory;

import java.util.List;

public interface TransactionHistoryService {
  List<TransactionHistory> findByTransaction(String username);

  List<TransactionHistory> searchByNameMovie(String username, String keySearch);
}
