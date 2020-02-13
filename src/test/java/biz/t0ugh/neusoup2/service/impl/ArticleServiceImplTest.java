package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class ArticleServiceImplTest extends Neusoup2ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImplTest.class);

    List<Article> articleList = new ArrayList<>();

    @Resource
    ArticleService articleService;

    @BeforeEach
    void setUp() {
        for(int i = 0; i < 15; i++){
            Article article = new Article();
            article.setArticleLike(i);
            article.setArticleTime(new Timestamp(System.currentTimeMillis() + i * 1000000));
            article.setArticleContent(""+i);
            article.setUserId(1);
            article.setArticleTags(""+i);
            article.setArticleUnlike(i);
            articleList.add(article);
        }
    }

    @Test
    void getArticle() {
        Article article = articleList.get(0);
        articleService.insertArticle(article);
        assertNotEquals(0, article.getArticleId());

        Article dbArticle = articleService.getArticle(article.getArticleId());
        assertNotNull(dbArticle);

        String updateContent = "noteAndNote";
        article.setArticleContent(updateContent);
        articleService.updateArticle(article);
        assertEquals(updateContent, article.getArticleContent());

        articleService.deleteArticle(article);
        dbArticle = articleService.getArticle(article.getArticleId());
        assertNull(dbArticle);
    }

    @Test
    void rankArticleByLike() {

        for (Article article:articleList) {
            articleService.insertArticle(article);
        }

        List<Article> articleListRankedByLike = articleService.rankArticleByLike(1,10);
        assertEquals(10, articleListRankedByLike.size());

        Article maxArticle = Collections.max(articleListRankedByLike, Comparator.comparingInt(Article::getArticleLike));
        assertEquals(maxArticle, articleListRankedByLike.get(0));

        for (Article article:articleList) {
            articleService.deleteArticle(article);
        }
    }

    @Test
    void rankArticleByTime() {

        for (Article article:articleList) {
            logger.info(article.getArticleTime().toString());
            articleService.insertArticle(article);
        }

        List<Article> articleListRankedByTime = articleService.rankArticleByTime(1,10);
        assertEquals(10, articleListRankedByTime.size());

        Article maxArticle = Collections.max(articleListRankedByTime, Comparator.comparingInt(Article::getArticleLike));
        assertEquals(maxArticle.getArticleId(), articleListRankedByTime.get(0).getArticleId());

        for (Article article:articleList) {
            articleService.deleteArticle(article);
        }
    }
}