package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
