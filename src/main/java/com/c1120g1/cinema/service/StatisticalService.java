package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.MemberStatisticalDTO;
import com.c1120g1.cinema.dto.MovieStatisticalDTO;

import java.util.List;

public interface StatisticalService {

    List<MovieStatisticalDTO> getMovieStatisticsByDate(String startDate, String endDate);

    List<MovieStatisticalDTO> getMovieStatisticsByMonth(int month, int year);

    List<MovieStatisticalDTO> getMovieStatisticsByYear(int year);

    List<MemberStatisticalDTO> getTopMember(int limit);
}
