package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.ProjectionType;

import java.util.List;

public interface ProjectionTypeService {
    List<ProjectionType> findAll();

    ProjectionType findById(Integer id);
}
