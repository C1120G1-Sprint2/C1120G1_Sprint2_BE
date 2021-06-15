package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.ProjectionTypeRepository;
import com.c1120g1.cinema.service.ProjectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionTypeServiceImpl implements ProjectionTypeService {

    @Autowired
    private ProjectionTypeRepository projectionTypeRepository;
}
