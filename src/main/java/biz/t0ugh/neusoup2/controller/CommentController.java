package biz.t0ugh.neusoup2.controller;

import biz.t0ugh.neusoup2.pojo.Comment;
import biz.t0ugh.neusoup2.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class CommentController {

    @Resource
    CommentService commentService;

    @GetMapping("/comment")
    public Comment getComment(int commentId){
        return commentService.getComment(commentId);
    }

    @PostMapping("/comment")
    public Comment insertComment(Comment comment){
        commentService.insertComment(comment);
        return comment;
    }

    @PutMapping("/comment")
    public Comment updateCommentContent(Comment comment) throws SQLException {
        commentService.updateCommentContent(comment);
        return comment;
    }

    @DeleteMapping("/comment")
    public Comment deleteComment(Comment comment){
        commentService.deleteComment(comment);
        return comment;
    }

    @GetMapping("/comments/comment/count/{commentRef}")
    public int countCommentByCommentRef(@PathVariable("commentRef") int commentRef){
        return commentService.countCommentByCommentRef(commentRef);
    }

    @GetMapping("/comments/comment/{commentRef}")
    public List<Comment> findCommentByCommentRef(@PathVariable("commentRef") int commentRef){
        return commentService.findCommentByCommentRef(commentRef);
    }

    @GetMapping("/comments/user/{userId}")
    public List<Comment> findCommentByUserId(@PathVariable("userId") int userId){
        return commentService.findCommentByUserId(userId);
    }

    @GetMapping("/comments/article/{articleId}")
    public List<Comment> findCommentByArticleId(@PathVariable("articleId") int articleId){
        return commentService.findCommentByArticleId(articleId);
    }
}
