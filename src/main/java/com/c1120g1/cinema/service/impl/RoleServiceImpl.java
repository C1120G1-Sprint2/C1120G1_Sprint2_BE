package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.RoleRepository;
import com.c1120g1.cinema.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
}
