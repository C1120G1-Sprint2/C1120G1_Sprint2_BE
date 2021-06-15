package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.AccountStatusRepository;
import com.c1120g1.cinema.service.AccountStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountStatusServiceImpl implements AccountStatusService {

    @Autowired
    private AccountStatusRepository accountStatusRepository;
}
