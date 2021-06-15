package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.DistrictRepository;
import com.c1120g1.cinema.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
}
