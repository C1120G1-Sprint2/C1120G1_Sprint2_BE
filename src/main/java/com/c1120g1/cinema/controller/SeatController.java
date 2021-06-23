package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("api/employee/saleTicket/listSeat/{roomId}")
    public ResponseEntity<List<Seat>> showAllSeatByRoomIdAndRowId(@PathVariable Integer roomId){
        try {
            List<Seat> seatList = seatService.showAllSeatByRoomId( roomId);
            if (seatList.isEmpty()){
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            }else {
                return new ResponseEntity<>( seatList, HttpStatus.OK );
            }
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
