package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.MemberStatisticalDTO;
import com.c1120g1.cinema.dto.MovieStatisticalDTO;
import com.c1120g1.cinema.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistical")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class StatisticalController {

    @Autowired
    StatisticalService statisticalService;

    @GetMapping(value = "/movie-date", params = {"startDate", "endDate"})
    public ResponseEntity<List<MovieStatisticalDTO>> getMovieStatisticsByDate(@RequestParam String startDate, @RequestParam String endDate) {
        try {
            List<MovieStatisticalDTO> movieStatisticalDTOList = statisticalService.getMovieStatisticsByDate(startDate, endDate);
            if (movieStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/movie-month", params = {"month", "year"})
    public ResponseEntity<List<MovieStatisticalDTO>> getMovieStatisticsByMonth(@RequestParam int month, @RequestParam int year) {
        try {
            List<MovieStatisticalDTO> movieStatisticalDTOList = statisticalService.getMovieStatisticsByMonth(month, year);
            if (movieStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/movie-year", params = {"year"})
    public ResponseEntity<List<MovieStatisticalDTO>> getMovieStatisticsByYear(@RequestParam int year) {
        try {
            List<MovieStatisticalDTO> movieStatisticalDTOList = statisticalService.getMovieStatisticsByYear(year);
            if (movieStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "member-top", params = {"limit"})
    public ResponseEntity<List<MemberStatisticalDTO>> getTopMember(@RequestParam int limit) {
        try {
            List<MemberStatisticalDTO> memberStatisticalDTOList = statisticalService.getTopMember(limit);
            if (memberStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(memberStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
