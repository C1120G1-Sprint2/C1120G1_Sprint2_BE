package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.service.RoomService;
import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    /**
     * HoangTQ
     * getAllSeat()
     * @param roomId : id of Room
     * @return listSeat
     */

    @GetMapping("/getAllSeat/{roomId}")
    public ResponseEntity<List<Seat>> getAllSeat(@PathVariable(name = "roomId") Integer roomId) {
        List<Seat> listSeat = seatService.findAllByRoomId(roomId);
        if (listSeat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listSeat, HttpStatus.OK);
    }
}
