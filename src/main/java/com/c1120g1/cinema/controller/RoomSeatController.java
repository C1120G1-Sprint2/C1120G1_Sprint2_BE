package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/roomSeat")
public class RoomSeatController {

    @Autowired
    private RoomSeatService roomSeatService;

    @GetMapping(value = "/roomSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getListRoom(@PathVariable Integer roomId) {
        List<RoomSeat> roomList = roomSeatService.showAllSeatByRoomId(roomId);
        if (roomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomList, HttpStatus.OK);
    }

    @GetMapping(value = "/getRoomSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getSeatTotal(@PathVariable Integer roomId) {
        List<RoomSeat> roomList = roomSeatService.getSeatTotal(roomId);
        if (roomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomList, HttpStatus.OK);
    }


    /**
     * Method: delete seat
     * Author: TuanLHM
     *
     * @return
     */


    @GetMapping(value = "/seat/delete-seat/{id}")
    public ResponseEntity<RoomSeat> deleteSeat(@PathVariable("id") Integer id) {

        RoomSeat roomSeat = roomSeatService.findById(id);
        if (roomSeat.getRoomSeatId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomSeatService.deleteSeat(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Method: create seat
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping(value = "/seat/create-seat/{id}")
    public ResponseEntity<RoomSeat> createSeat(@PathVariable("id") Integer id) {

        RoomSeat roomSeat = roomSeatService.findById(id);
        if (roomSeat.getRoomSeatId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomSeatService.creatSeat(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping(value = "/showSeatDelete")
    public ResponseEntity<List<RoomSeat>> getSeatDelete() {
        List<RoomSeat> roomSeatList = roomSeatService.showSeatDelete();
        if (roomSeatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomSeatList, HttpStatus.OK);
    }
}
