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

    @Transactional
    @Modifying
    @Query(value = "update movie set movie_name = ?1, poster_movie = ?2, start_date = ?3, end_date = ?4, " +
            "movie_studio = ?5, actor = ?6, director = ?7, movie_length = ?8, trailer = ?9 where movie_id = ?10", nativeQuery = true)
    void editMovie(String movieName, String posterMovie, String startDate, String endDate, String studio,
                   String actor, String director, String length, String trailer, Integer movieId);


    /**
     * Author : ThinhTHB
     * function to get movie by id
     */
    @Query(value = "select * from movie where movie_id = :idMovie", nativeQuery = true)
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
    @Query(value = "select * from movie where movie_status_id = 1", nativeQuery = true)
    Page<Movie> getAllMovieAvailable(Pageable pageable);

    /**
     * Author : ThinhTHB
     * function to get movie by id
     */
    @Transactional
    @Modifying
    @Query(value = "update movie set movie_status_id = 2 where movie_id = :movieId", nativeQuery = true)
    void setMovieStatusById(@Param(value = "movieId") Integer movieId);

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT * FROM movie " +
            "WHERE start_date <= now() " +
            "AND end_date >= now() " +
            "ORDER BY start_date DESC", nativeQuery = true)
    Page<Movie> findOnShowingMovies(Pageable pageable);

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT * FROM movie " +
            "WHERE start_date > now() " +
            "ORDER BY start_date", nativeQuery = true)
    Page<Movie> findUpComingMovies(Pageable pageable);

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT m.*, SUM(mt.ticket_price) AS sales " +
            "FROM movie m " +
            "INNER JOIN movie_ticket mt ON m.movie_id = mt.movie_id " +
            "INNER JOIN ticket t ON mt.movie_ticket_id = t.movie_ticket_id " +
            "WHERE t.ticket_status_id = 2 " +
            "AND m.start_date <= now() " +
            "AND m.end_date >= now() " +
            "GROUP BY m.movie_id " +
            "ORDER BY sales DESC " +
            "LIMIT 3", nativeQuery = true)
    List<Movie> findTop3BySales();

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT * " +
            "FROM movie " +
            "WHERE promote = 1 " +
            "AND end_date >= now()", nativeQuery = true)
    List<Movie> findPromotingMovies();

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT * " +
            "FROM movie " +
            "WHERE end_date >= now() " +
            "AND movie_name LIKE CONCAT('%', ?1, '%') " +
            "ORDER BY movie_name", nativeQuery = true)
    Page<Movie> findByTitleContaining(String keySearch, Pageable pageable);

    /**
     * Author: ViNTT
     */
    @Query(value = "SELECT * FROM movie m " +
            "INNER JOIN movie_category mc ON m.movie_id = mc.movie_id " +
            "INNER JOIN movie_ticket mt ON m.movie_id = mt.movie_id " +
            "WHERE m.end_date >= now() " +
            "AND m.movie_name LIKE CONCAT('%', ?1, '%') " +
            "AND mc.category_id LIKE ?2 " +
            "AND mt.show_date LIKE ?3 " +
            "AND mt.show_time_id LIKE ?4 " +
            "GROUP BY m.movie_id " +
            "ORDER BY m.movie_name", nativeQuery = true)
    Page<Movie> findByTitleAndCategoryAndDateAndShowTime(String keySearch, String categoryIdSearch,
                                                         String dateSearch, String showTimeIdSearch, Pageable pageable);



}
