package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    Comment findById(Integer id);

    void delete(Integer id);

    List<Comment> findAllByMovieId(Integer id);

    List<Comment> findAll();

    boolean editComment(Comment comment);


}
