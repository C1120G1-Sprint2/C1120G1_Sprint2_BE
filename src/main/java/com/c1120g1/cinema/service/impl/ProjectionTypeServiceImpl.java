package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.ProjectionType;
import com.c1120g1.cinema.repository.ProjectionTypeRepository;
import com.c1120g1.cinema.service.ProjectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionTypeServiceImpl implements ProjectionTypeService {

    @Autowired
    private ProjectionTypeRepository projectionTypeRepository;

    @Override
    public List<ProjectionType> findAll() {
        return projectionTypeRepository.findAll();
    }
}
