package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
}
