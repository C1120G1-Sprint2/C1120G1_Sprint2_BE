package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Account;
import com.c1120g1.cinema.repository.AccountRepository;
import com.c1120g1.cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
