package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.ProjectionType;
import com.c1120g1.cinema.service.ProjectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin/projection-type")
public class ProjectionController {

    @Autowired
    private ProjectionTypeService projectionTypeService;

    @GetMapping("")
    public ResponseEntity<List<ProjectionType>> getAllProjectionType() {
        try {
            List<ProjectionType> projectionTypeList = this.projectionTypeService.findAll();
            return new ResponseEntity<>(projectionTypeList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectionType> getProjectionTypeById(@PathVariable("id") Integer id) {
        ProjectionType projectionType = this.projectionTypeService.findById(id);
        if (projectionType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectionType,HttpStatus.OK);
    }
}
