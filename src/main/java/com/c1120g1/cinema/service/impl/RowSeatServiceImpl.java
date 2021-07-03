package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.RowSeat;
import com.c1120g1.cinema.repository.RowSeatRepository;
import com.c1120g1.cinema.service.RowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowSeatServiceImpl implements RowSeatService {

    @Autowired
    private RowSeatRepository rowRepository;

    @Override
    public List<RowSeat> findAllRow() {
        return rowRepository.findAll();
    }


}
