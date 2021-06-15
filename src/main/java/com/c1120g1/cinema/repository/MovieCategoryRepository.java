package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Integer> {
}
