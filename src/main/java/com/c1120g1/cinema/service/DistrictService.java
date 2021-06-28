package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.District;

import java.util.List;

public interface DistrictService {

    List<District> findAllDistrictByProvinceId(Integer provinceId);
}
