package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.ArticleMapper;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article getArticle(int articleId) {
        return articleMapper.getArticle(articleId);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(Article article) {
        return articleMapper.deleteArticle(article);
    }

    @Override
    public List<Article> rankArticleByLike(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return rankArticleByLike(pageNum, pageSize);
    }

    @Override
    public List<Article> rankArticleByTime(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return rankArticleByTime(pageNum, pageSize);
    }
}
