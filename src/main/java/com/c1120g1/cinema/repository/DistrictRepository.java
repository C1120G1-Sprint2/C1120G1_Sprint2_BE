package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {

    @Query(value = "select d from District d join Province p on p.provinceId = d.province.provinceId where p.provinceId =?1")
    List<District> findAllDistrictByProvinceId(Integer provinceId);
}
