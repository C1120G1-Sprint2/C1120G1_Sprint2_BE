package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /**
     * Author : ThinhTHB
     * function to get movie by id
     */
    @Query(value = "select * from movie where id_movie = :idMovie", nativeQuery = true)
    Movie getMovieById(Integer idMovie);

    /**
     * Author : ThinhTHB
     * function to get all movie have been add
     */
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> getAllMovie();

    /**
     * Author : ThinhTHB
     * function to get all movie have status = "Đang chiếu"
     */
    @Query(value = "select * from movie where `status` = 1", nativeQuery = true)
    Page<Movie> getAllMovieAvailable(Pageable pageable);

    /**
     * Author : ThinhTHB
     * function to get movie by id
     */
    @Transactional
    @Modifying
    @Query(value = "update movie set status = 2 where movie_id = :movieId", nativeQuery = true)
    void setMovieStatusById(@Param(value = "movieId") Integer movieId);

}
