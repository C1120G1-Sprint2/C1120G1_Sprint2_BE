package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Comment;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.User;
import com.c1120g1.cinema.service.CommentService;
import com.c1120g1.cinema.service.MovieService;
import com.c1120g1.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

//    Tao comment
    @PostMapping("/detail-movie/{id}/{idUser}/create")
    public ResponseEntity<Void> createComment(@PathVariable("id") Integer id,
                                              @PathVariable("idUser") Integer idUser,
                                              @RequestBody Comment comment) {
            try {
                Movie movie = this.movieService.findById(id);
                User user = this.userService.findById(idUser);
                if (movie == null || user == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                comment.setMovie(movie);
                comment.setUser(user);
                commentService.save(comment);
                System.out.println(comment);
                return new ResponseEntity<>(HttpStatus.OK);


        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    xoa comment
    @DeleteMapping("/comment/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id) {
        try {
            Comment comment = commentService.findById(id);
            commentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    edit comment
    @PutMapping(value = "/comment/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editComment(@RequestBody Comment comment) {
        try {
            commentService.editComment(comment);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/comment/detail-movie/{id}")
    public ResponseEntity<List<Comment>> getAllCommentByMovieId(@PathVariable("id") Integer id) {
        try {
            List<Comment> commentList = this.commentService.findAllByMovieId(id);
            return new ResponseEntity<>(commentList,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
