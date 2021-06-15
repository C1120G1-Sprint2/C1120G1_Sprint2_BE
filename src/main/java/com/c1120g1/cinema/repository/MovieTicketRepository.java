package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {
}
