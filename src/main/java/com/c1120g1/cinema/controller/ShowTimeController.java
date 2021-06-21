package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.ShowTime;
import com.c1120g1.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShowTimeController {
    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/api/admin/showTime")
    public ResponseEntity<?> getAllShowTime() {
        try {
            List<ShowTime> showTimeList = this.showTimeService.findAll();
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
