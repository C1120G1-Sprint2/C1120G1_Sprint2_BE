package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.MemberStatisticalDTO;
import com.c1120g1.cinema.dto.MovieCategoryStatisticalDTO;
import com.c1120g1.cinema.dto.MovieStatisticalDTO;
import com.c1120g1.cinema.dto.ShowtimeStatisticalDTO;

import java.util.List;

public interface StatisticalService {

    List<MovieStatisticalDTO> getMovieStatisticsByDate(String startDate, String endDate);

    List<MovieStatisticalDTO> getMovieStatisticsByMonth(int month, int year);

    List<MovieStatisticalDTO> getMovieStatisticsByYear(int year);

    List<MovieStatisticalDTO> getTopMovie(int limit);

    List<MemberStatisticalDTO> getTopMember(int limit);

    List<MovieCategoryStatisticalDTO> getTopMovieCategory(int limit);

    List<ShowtimeStatisticalDTO> getTopShowTime(int limit);
}
