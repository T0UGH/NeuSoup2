package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.pojo.Unlikes;
import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.ArticleService;
import biz.t0ugh.neusoup2.service.UnlikeService;
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
class UnlikeServiceImplTest extends Neusoup2ApplicationTests {

    @Resource
    UserService userService;

    @Resource
    ArticleService articleService;

    @Resource
    UnlikeService unlikeService;

    private User user;

    private Article article;

    private Unlikes unlikes;

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

        unlikes = new Unlikes();
        unlikes.setArticleId(article.getArticleId());
        unlikes.setUserId(article.getUserId());
        unlikes.setUnlikeTime(new Timestamp(System.currentTimeMillis()));
    }

    @AfterEach
    void tearDown() {
        userService.deleteUser(user);
        articleService.deleteArticle(article);
    }

    @Test
    void insertUnlikeAndDeleteUnlike() {
        try {
            int unlikeNum = article.getArticleUnlike();
            unlikeService.insertUnlike(unlikes);
            Unlikes dbUnlikes = unlikeService.getUnlike(unlikes.getUnlikeId());
            assertNotNull(dbUnlikes);

            article = articleService.getArticle(article.getArticleId());
            assertEquals(article.getArticleUnlike(), unlikeNum + 1);

            unlikeNum = article.getArticleUnlike();
            unlikeService.deleteUnlike(unlikes);
            dbUnlikes = unlikeService.getUnlike(unlikes.getUnlikeId());
            assertNull(dbUnlikes);
            article = articleService.getArticle(article.getArticleId());
            assertEquals(article.getArticleUnlike(), unlikeNum - 1);
        } catch (SQLException e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    void findUnlikeByUserIdAndFindUnlikeByArticleId() {
        try {
            unlikeService.insertUnlike(unlikes);

            List<Unlikes> unlikesList = unlikeService.findUnlikeByArticleId(unlikes.getArticleId());
            assertNotEquals(0, unlikesList.size());

            unlikesList = unlikeService.findUnlikeByUserId(unlikes.getUserId());
            assertNotEquals(0, unlikesList.size());

            unlikeService.deleteUnlike(unlikes);
        } catch (SQLException e) {
            fail("Exception: " + e.getMessage());
        }
    }
}