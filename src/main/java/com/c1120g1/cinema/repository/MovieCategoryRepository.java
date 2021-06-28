package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into movie_category (movie_id, category_id) values (:movieId, :categoryId)", nativeQuery = true)
    void createMovieCategory(@Param("movieId") Integer movieId, @Param("categoryId") Integer categoryId);


}
