package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.StatusRoom;
import com.c1120g1.cinema.repository.StatusRoomRepository;
import com.c1120g1.cinema.service.StatusRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusRoomServiceImpl implements StatusRoomService {

    @Autowired
    private StatusRoomRepository statusRoomRepository;

    @Override
    public List<StatusRoom> findAllStatusRoom() {
        return statusRoomRepository.findAll();
    }
}
