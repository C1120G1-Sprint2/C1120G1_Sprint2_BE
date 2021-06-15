package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.NotificationRepository;
import com.c1120g1.cinema.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
}
