package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Category;
import com.c1120g1.cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{movieId}")
    public ResponseEntity<List<Category>> getListMovieCategoryByIdMovie(@PathVariable Integer movieId) {
        try {
            List<Category> movieCategoryList1 = this.categoryService.getMovieCategoryById(movieId);
            return new ResponseEntity<>(movieCategoryList1, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
