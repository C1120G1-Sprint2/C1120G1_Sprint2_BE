package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.RowRepository;
import com.c1120g1.cinema.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RowServiceImpl implements RowService {
    @Autowired
    private RowRepository rowRepository;
}
