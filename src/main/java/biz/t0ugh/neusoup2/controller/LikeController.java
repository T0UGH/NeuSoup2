package biz.t0ugh.neusoup2.controller;

import biz.t0ugh.neusoup2.pojo.Likes;
import biz.t0ugh.neusoup2.service.LikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/like")
    public Likes insertLike(@RequestBody Likes likes) throws SQLException {
        likeService.insertLike(likes);
        return likes;
    }

    @DeleteMapping("/like")
    public Likes deleteLike(@RequestBody Likes likes) throws SQLException {
        likeService.deleteLike(likes);
        return likes;
    }

    @GetMapping("/likes/user/{userId}")
    public List<Likes> findLikesByUserId(@PathVariable("userId") int userId){
        return likeService.findLikeByUserId(userId);
    }

    @GetMapping("/likes/article/{articleId}")
    public List<Likes> findLikesByArticleId(@PathVariable("articleId") int articleId){
        return likeService.findLikeByArticleId(articleId);
    }
}
