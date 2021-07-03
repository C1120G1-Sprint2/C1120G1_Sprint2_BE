package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.TransactionHistory;
import com.c1120g1.cinema.repository.TransactionHistoryRepository;
import com.c1120g1.cinema.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public List<TransactionHistory> findByTransaction(String username) {
        return transactionHistoryRepository.findByUsernameOfTransaction(username);
    }


    @Override
    public List<TransactionHistory> searchByNameMovie(String username, String keySearch) {
        return transactionHistoryRepository.searchByNameMovie(username,keySearch);
    }
}
