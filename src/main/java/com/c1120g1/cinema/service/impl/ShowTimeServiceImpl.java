package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.ShowTimeRepository;
import com.c1120g1.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    private ShowTimeRepository showTimeRepository;
}
