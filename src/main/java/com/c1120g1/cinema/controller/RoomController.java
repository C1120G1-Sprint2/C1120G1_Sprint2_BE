package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.service.RoomService;
import com.c1120g1.cinema.service.SeatService;
import com.c1120g1.cinema.service.StatusRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private StatusRoomService statusRoomService;

    @Autowired
    private SeatService seatService;

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllRoom() {
        try {
            List<Room> roomList = this.roomService.findAll();
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id){
        Room room = this.roomService.findById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
}
