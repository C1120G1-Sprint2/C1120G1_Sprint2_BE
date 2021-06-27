package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    List<ShowTime> findAll();

    ShowTime findById(Integer id);
}
