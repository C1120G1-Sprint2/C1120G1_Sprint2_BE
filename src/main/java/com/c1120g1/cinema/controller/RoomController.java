package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.service.RoomService;
import com.c1120g1.cinema.service.SeatService;
import com.c1120g1.cinema.service.StatusRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private StatusRoomService statusRoomService;

    @Autowired
    private SeatService seatService;
}
