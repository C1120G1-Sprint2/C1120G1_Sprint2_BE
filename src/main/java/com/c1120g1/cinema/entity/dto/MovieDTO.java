package com.c1120g1.cinema.entity.dto;


import com.c1120g1.cinema.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    private Movie movie;
    private Integer categoryId;
}
