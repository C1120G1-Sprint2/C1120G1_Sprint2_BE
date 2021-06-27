package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query (value = "select * from comment " +
            "where movie_id = ?1", nativeQuery = true)
    List<Comment> getAllCommentByIdMovie(Integer idMovie);


    @Modifying
    @Query(value = "delete from comment where comment.user_id = ?1", nativeQuery = true)
    void deleteByUserId(Integer id);
}
