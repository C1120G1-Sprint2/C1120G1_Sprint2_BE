package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends JpaRepository<TicketStatus,Integer> {
}
