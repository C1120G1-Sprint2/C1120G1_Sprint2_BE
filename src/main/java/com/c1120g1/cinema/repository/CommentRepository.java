package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query (value = "select * from comment " +
            "where movie_id = ?1", nativeQuery = true)
    List<Comment> getAllCommentByIdMovie(Integer idMovie);

    @Transactional
    @Modifying
    @Query(value = "delete from comment where comment.user_id = ?1", nativeQuery = true)
    void deleteByUserId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into comment (content, movie_id, user_id, img, `date`)" +
    "values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void createComment( String content, Integer movieId, Integer userId, String img, String date);
}
