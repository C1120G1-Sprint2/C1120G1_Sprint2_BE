package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.service.RoomService;
import com.c1120g1.cinema.service.SeatService;
import com.c1120g1.cinema.service.StatusRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private StatusRoomService statusRoomService;

    @Autowired
    private SeatService seatService;

    @GetMapping("/api/admin/room")
    public ResponseEntity<?> getAllRoom() {
        try {
            List<Room> roomList = this.roomService.findAll();
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
