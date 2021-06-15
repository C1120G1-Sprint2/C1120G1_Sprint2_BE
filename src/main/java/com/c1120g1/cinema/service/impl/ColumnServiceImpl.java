package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.ColumnRepository;
import com.c1120g1.cinema.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnRepository columnRepository;
}
