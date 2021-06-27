package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin")
public class RoomSeatController {

    @Autowired
    private RoomSeatService roomSeatService;

    @GetMapping(value = "/roomSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getListRoom(@PathVariable Integer roomId) {
        List<RoomSeat> roomList = roomSeatService.showAllSeatByRoomId(roomId);
        if (roomList.isEmpty()) {
            return new ResponseEntity<List<RoomSeat>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<RoomSeat>>(roomList, HttpStatus.OK);
    }


    /**
     * Method: delete seat
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping(value = "/seat/delete-seat/{id}")
    public ResponseEntity<RoomSeat> deleteRoom(@PathVariable("id") Integer id) {

        RoomSeat roomSeat = roomSeatService.findById(id);
        if (roomSeat.getRoomSeatId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomSeatService.deleteSeat(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
