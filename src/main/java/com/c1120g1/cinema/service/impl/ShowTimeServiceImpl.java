package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.ShowTime;
import com.c1120g1.cinema.repository.ShowTimeRepository;
import com.c1120g1.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    private ShowTimeRepository showTimeRepository;



    @Override
    public ShowTime findById(Integer id) {
        return showTimeRepository.findById(id).orElse(null);

    }
    @Override
    public List<ShowTime> getAllShowTimeByDate(String date) {
        return showTimeRepository.getAllShowTimeByDate(date);
    }


    @Override
    public List<ShowTime> getAllShowTimeByDateAndMovie(String date, Integer movieId) {
        return showTimeRepository.getAllShowTimeByDateAndMovie(date, movieId);
    }

    /**
     * Author: ViNTT
     */
    @Override
    public List<ShowTime> findAll() {
        return showTimeRepository.findAll();
    }
}
