package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Integer> {


}
