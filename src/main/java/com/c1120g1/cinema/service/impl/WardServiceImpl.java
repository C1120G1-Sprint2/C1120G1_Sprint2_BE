package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Ward;
import com.c1120g1.cinema.repository.WardRepository;
import com.c1120g1.cinema.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<Ward> getAllWard() {
        return wardRepository.findAll();
    }

    @Override
    public List<Ward> findAllByDistrictId(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }
    @Override
    public List<Ward> findAllByDistrictId(Integer districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }

    @Override
    public List<Ward> findWardByDistrictId(Integer wardId) {
        return wardRepository.findByDistrictId(wardId);
    }
}
