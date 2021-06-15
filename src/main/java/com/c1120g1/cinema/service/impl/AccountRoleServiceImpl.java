package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.AccountRoleRepository;
import com.c1120g1.cinema.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;

}
