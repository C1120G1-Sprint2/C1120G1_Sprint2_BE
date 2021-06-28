package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Modifying
    @Query(value = "select c.category_id, c.category_name " +
            "from movie_category mc " +
            "inner join category c on mc.category_id = c.category_id " +
            "where mc.movie_id = ?1", nativeQuery = true)
    List<Category> getMovieCategoryByMovieId(Integer id);

    @Query(value = "select * from category", nativeQuery = true)
    List<Category> getCategory();


}
