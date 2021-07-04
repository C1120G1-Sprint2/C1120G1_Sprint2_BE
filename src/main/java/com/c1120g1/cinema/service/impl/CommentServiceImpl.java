package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Comment;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.repository.CommentRepository;
import com.c1120g1.cinema.repository.MovieRepository;
import com.c1120g1.cinema.service.CommentService;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;


    @Override
    public void save(Comment comment) {
        String localDt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());

        commentRepository.createComment(
                comment.getContent(),
                comment.getMovie().getMovieId(),
                comment.getUser().getUserId(),
                "sang ga",
                localDt);

    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       Comment comment = this.commentRepository.findById(id).orElse(null);
       commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAllByMovieId(Integer id) {
        return commentRepository.getAllCommentByIdMovie(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public boolean editComment(Comment comment) {
        Comment temp = commentRepository.findById(comment.getCommentId()).orElse(null);
        if (comment.getCommentId() == null || temp == null) {
            return false;
        }else {
            temp.setContent(comment.getContent());
            commentRepository.save(temp);
            return true;
        }
    }
}
