package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.pojo.Likes;
import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.ArticleService;
import biz.t0ugh.neusoup2.service.LikeService;
import biz.t0ugh.neusoup2.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class LikesServiceImplTest extends Neusoup2ApplicationTests {

    @Resource
    UserService userService;

    @Resource
    ArticleService articleService;

    @Resource
    LikeService likeService;

    private User user;

    private Article article;

    private Likes likes;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserName("小明");
        user.setUserPassword("password");
        user.setUserAvator("avator");
        user.setUserSex(1);
        user.setUserNote("note");
        userService.register(user);

        article = new Article();
        article.setArticleLike(1);
        article.setArticleTime(new Timestamp(System.currentTimeMillis()));
        article.setArticleContent(""+1);
        article.setUserId(1);
        article.setArticleTags(""+1);
        article.setArticleUnlike(1);
        articleService.insertArticle(article);

        likes = new Likes();
        likes.setArticleId(article.getArticleId());
        likes.setUserId(user.getUserId());
        likes.setLikeTime(new Timestamp(System.currentTimeMillis()));
    }

    @AfterEach
    void tearDown(){
        userService.deleteUser(user);
        articleService.deleteArticle(article);
    }

    @Test
    void insertLikeAndDeleteLike() {
        try {
            int likeNum = article.getArticleLike();
            likeService.insertLike(likes);
            Likes dbLikes = likeService.getLike(likes.getLikeId());
            assertNotNull(dbLikes);

            article = articleService.getArticle(article.getArticleId());
            assertEquals(article.getArticleLike(), likeNum + 1);

            likeNum = article.getArticleLike();
            likeService.deleteLike(likes);
            dbLikes = likeService.getLike(likes.getLikeId());
            assertNull(dbLikes);
            article = articleService.getArticle(article.getArticleId());
            assertEquals(article.getArticleLike(), likeNum - 1);

        } catch (SQLException e) {
            fail("Excption: " + e.getMessage());
        }
    }

    @Test
    void findLikeByUserIdAndFindLikeByArticleId() {
        try {
            likeService.insertLike(likes);

            List<Likes> likesList = likeService.findLikeByUserId(likes.getUserId());
            assertNotEquals(0, likesList.size());

            likesList = likeService.findLikeByArticleId(likes.getArticleId());
            assertNotEquals(0, likesList.size());

            likeService.deleteLike(likes);
        } catch (SQLException e) {
            fail("Excption: " + e.getMessage());
        }
    }

}