package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.ColumnSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<ColumnSeat,Integer> {
}
