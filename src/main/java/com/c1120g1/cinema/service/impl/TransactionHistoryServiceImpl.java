package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.TransactionHistoryRepository;
import com.c1120g1.cinema.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
}
