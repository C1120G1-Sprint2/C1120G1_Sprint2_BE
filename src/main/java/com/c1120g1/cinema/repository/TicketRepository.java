package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
