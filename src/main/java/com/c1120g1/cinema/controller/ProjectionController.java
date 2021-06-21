package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.ProjectionType;
import com.c1120g1.cinema.service.ProjectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectionController {

    @Autowired
    private ProjectionTypeService projectionTypeService;

    @GetMapping("/api/admin/projection-type")
    public ResponseEntity<?> getAllProjectionType() {
        try {
            List<ProjectionType> projectionTypeList = this.projectionTypeService.findAll();
            return new ResponseEntity<>(projectionTypeList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
