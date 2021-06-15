package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.RowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<RowSeat,Integer> {
}
