package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Province;
import com.c1120g1.cinema.repository.ProvinceRepository;
import com.c1120g1.cinema.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

}
