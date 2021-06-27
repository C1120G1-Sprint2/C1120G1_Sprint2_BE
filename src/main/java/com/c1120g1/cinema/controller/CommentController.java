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
    @PostMapping("/detail-movie/{id}/create")
    public ResponseEntity<Void> createComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        try {
            commentService.save(comment, id);
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



//    @PostMapping("/create")
//    public ResponseEntity<Comment> createComment (@RequestBody Comment comment,
//                                            @RequestParam("userId") Integer userId,
//                                            @RequestParam("movieId") Integer movieId) {
//        try {
//            User user = this.userService.findById(userId);
//            Movie movie = this.movieService.findById(movieId);
//            comment.setMovie(movie);
//            comment.setUser(user);
//            commentService.save(comment);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//  tao comment con
//    @PostMapping("/api/comment/create-parent")
//    public ResponseEntity<Comment> createParentComment (@RequestBody Comment comment,
//                                                  @RequestParam(value = "movieId") Integer movieId,
//                                                  @RequestParam(value = "userId") Integer userId,
//                                                  @RequestParam(value = "commentId") Integer commentId) {
//        try {
//            User user = this.userService.findById(userId);
//            Movie movie = this.movieService.findById(movieId);
//            Comment comment1 = commentService.findById(commentId);
//            comment.setMovie(movie);
//            comment.setUser(user);
//            comment.setComment(comment1);
//            commentService.save(comment);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //    Xoa comment
//    @DeleteMapping("/delete/{id}")
//    public void deleteComment(@PathVariable("id") Integer id){
//        commentService.delete(id);
//    }


//    Sua comment
//    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Comment> editComment(@RequestBody Comment comment,@RequestParam(value = "idMovie") Integer idMovie,
//                                         @RequestParam(value = "idUser") Integer idUser){
//        try {
//            User user = userService.findById(idUser);
//            Movie movie = movieService.findById(idMovie);
//            comment.setMovie(movie);
//            comment.setUser(user);
//            commentService.save(comment);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


////    Sua comment con
//    @PutMapping("/api/comment/edit_parent/{id}")
//    public ResponseEntity<Comment> editCommentParent(@RequestBody Comment comment,@RequestParam(value = "idMovie") Integer idMovie,
//                                               @RequestParam(value = "idUser") Integer idUser,
//                                               @RequestParam(value = "idComment") Integer idComment){
//        try {
//            User user = userService.findById(idUser);
//            Movie movie = movieService.findById(idMovie);
//            Comment comment1 = commentService.findById(idComment);
//            comment.setMovie(movie);
//            comment.setUser(user);
//            comment.setComment(comment1);
//            commentService.save(comment);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    Lay id comment
//    @GetMapping("/{id}")
//    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") Integer id){
//        Comment comment = commentService.findById(id);
//        return ResponseEntity.ok().body(comment);
//    }

//    lay comment theo id movie
//    @GetMapping("/detail-movie/{idMovie}")
//    public ResponseEntity<List<Comment>> getCommentByMovieId(@PathVariable(value = "idMovie") Integer idMovie) {
//        try {
//            List<Comment> commentList = this.commentService.findAllByMovieId(idMovie);
//            return new ResponseEntity<>(commentList,HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    lay all comment
//    @GetMapping("")
//    public ResponseEntity<?> getAllComment() {
//        try {
//            List<Comment> commentList1 = this.commentService.findAll();
//            return new ResponseEntity<>(commentList1, HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
