package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.dto.MemberStatisticalDTO;
import com.c1120g1.cinema.dto.MovieCategoryStatisticalDTO;
import com.c1120g1.cinema.dto.MovieStatisticalDTO;
import com.c1120g1.cinema.dto.ShowtimeStatisticalDTO;
import com.c1120g1.cinema.repository.StatisticalRepository;
import com.c1120g1.cinema.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalServiceImpl implements StatisticalService {

    @Autowired
    StatisticalRepository statisticalRepository;

    @Override
    public List<MovieStatisticalDTO> getMovieStatisticsByDate(String startDate, String endDate) {
        return statisticalRepository.getMovieStatisticsByDate(startDate, endDate);
    }

    @Override
    public List<MovieStatisticalDTO> getMovieStatisticsByMonth(int month, int year) {
        return statisticalRepository.getMovieStatisticsByMonth(month, year);
    }

    @Override
    public List<MovieStatisticalDTO> getMovieStatisticsByYear(int year) {
        return statisticalRepository.getMovieStatisticsByYear(year);
    }

    @Override
    public List<MovieStatisticalDTO> getTopMovie(int limit) {
        return statisticalRepository.getTopMovie(limit);
    }

    @Override
    public List<MemberStatisticalDTO> getTopMember(int limit) {
        return statisticalRepository.getTopMember(limit);
    }

    @Override
    public List<MovieCategoryStatisticalDTO> getTopMovieCategory(int limit) {
        return statisticalRepository.getTopMovieCategory(limit);
    }

    @Override
    public List<ShowtimeStatisticalDTO> getTopShowTime(int limit) {
        return statisticalRepository.getTopShowTime(limit);
    }
}
