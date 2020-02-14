package biz.t0ugh.neusoup2.controller;

import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArticleController {

    @Resource
    ArticleService articleService;

    @GetMapping("/article/{articleId}")
    public Article getArticle(@PathVariable("articleId") int articleId){
        return articleService.getArticle(articleId);
    }

    @DeleteMapping("/article")
    public Article deleteArticle(Article article){
        int d = articleService.deleteArticle(article);
        return article;
    }

    @PostMapping("/article")
    public Article insertArticle(Article article){
        articleService.insertArticle(article);
        return article;
    }

    @PostMapping("/articles/like/{pageNum}/{pageSize}")
    public List<Article> rankArticlesByLike(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return articleService.rankArticleByLike(pageNum, pageSize);
    }

    @PostMapping("/articles/time/{pageNum}/{pageSize}")
    public List<Article> rankArticleByTime(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return articleService.rankArticleByTime(pageNum, pageSize);
    }
}
