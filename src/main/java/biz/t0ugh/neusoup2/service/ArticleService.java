package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.Article;

import java.util.List;

public interface ArticleService {
    public Article getArticle(int articleId);
    public int insertArticle(Article article);
    public int updateArticle(Article article);
    public int deleteArticle(Article article);
    public List<Article> rankArticleByLike(int pageNum, int pageSize);
    public List<Article> rankArticleByTime(int pageNum, int pageSize);
}
