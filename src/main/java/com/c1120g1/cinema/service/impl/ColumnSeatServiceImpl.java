package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.ColumnSeat;
import com.c1120g1.cinema.repository.ColumnSeatRepository;
import com.c1120g1.cinema.service.ColumnSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnSeatServiceImpl implements ColumnSeatService {

    @Autowired
    private ColumnSeatRepository columnRepository;

    @Override
    public List<ColumnSeat> findAllColumn() {
        return columnRepository.findAll();
    }
}
