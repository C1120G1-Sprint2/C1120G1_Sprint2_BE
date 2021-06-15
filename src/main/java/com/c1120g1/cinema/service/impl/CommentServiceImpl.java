package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.CommentRepository;
import com.c1120g1.cinema.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
}
