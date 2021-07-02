package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {


    ShowTime findById(Integer id);


    List<ShowTime> getAllShowTimeByDate(String date);

    List<ShowTime> getAllShowTimeByDateAndMovie(String date, Integer movieId);


    /**
     * Author: ViNTT
     */
    List<ShowTime> findAll();

}
