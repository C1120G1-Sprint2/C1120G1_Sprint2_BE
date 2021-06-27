package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.entity.SeatType;
import com.c1120g1.cinema.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin")
public class SeatTypeController {

    @Autowired
    private SeatTypeService seatTypeService;

    @GetMapping("/seat-type")
    public ResponseEntity<List<SeatType>> getListSeatType() {
        List<SeatType> seatTypeList = seatTypeService.findAllSeatType();
        if (seatTypeList.isEmpty()) {
            return new ResponseEntity<List<SeatType>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SeatType>>(seatTypeList, HttpStatus.OK);
    }

}
