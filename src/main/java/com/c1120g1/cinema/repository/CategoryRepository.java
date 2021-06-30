package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {


    @Query(value = "select * from category", nativeQuery = true)
    List<Category> getCategory();

}
