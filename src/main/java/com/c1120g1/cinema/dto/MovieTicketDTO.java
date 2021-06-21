package com.c1120g1.cinema.dto;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.entity.ShowTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieTicketDTO {
    private MovieTicket movieTicket;
//    private ShowTime[] showTimeSet;


}
