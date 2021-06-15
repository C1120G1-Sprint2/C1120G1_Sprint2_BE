package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
