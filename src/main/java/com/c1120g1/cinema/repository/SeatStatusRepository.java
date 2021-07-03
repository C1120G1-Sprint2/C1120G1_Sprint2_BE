package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SeatStatusRepository extends JpaRepository<SeatStatus,Integer> {
}
