package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.ShowTime;
import com.c1120g1.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin/showTime")
public class ShowTimeController {
    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("")
    public ResponseEntity<List<ShowTime>> getAllShowTime() {
        try {
            List<ShowTime> showTimeList = this.showTimeService.findAll();
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowTime> getShowTimeById(@PathVariable("id") Integer id) {
        ShowTime showTime = this.showTimeService.findById(id);
        if (showTime == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(showTime,HttpStatus.OK);
    }
}
