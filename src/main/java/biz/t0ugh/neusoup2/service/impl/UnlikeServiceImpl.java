package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.ArticleMapper;
import biz.t0ugh.neusoup2.mapper.UnlikeMapper;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.pojo.Unlikes;
import biz.t0ugh.neusoup2.service.UnlikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class UnlikeServiceImpl implements UnlikeService {

    @Resource
    private UnlikeMapper unlikeMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Unlikes getUnlike(int unlikeId) {
        return unlikeMapper.getUnike(unlikeId);
    }

    @Override
    public int insertUnlike(Unlikes unlikes) throws SQLException {
        Article article = articleMapper.getArticle(unlikes.getArticleId());
        if(article == null){
            throw new SQLException("article[" + unlikes.getArticleId() +"] not found");
        }
        article.setArticleUnlike(article.getArticleUnlike() + 1);
        articleMapper.updateArticle(article);
        return unlikeMapper.insertUnlike(unlikes);
    }

    @Override
    public int deleteUnlike(Unlikes unlikes) throws SQLException {
        Article article = articleMapper.getArticle(unlikes.getArticleId());
        if(article == null){
            throw new SQLException("article[" + unlikes.getArticleId() +"] not found");
        }
        article.setArticleUnlike(article.getArticleUnlike() - 1);
        articleMapper.updateArticle(article);
        return unlikeMapper.deleteUnlike(unlikes);
    }

    @Override
    public List<Unlikes> findUnlikeByUserId(int userId) {
        return unlikeMapper.findUnlikeByUserId(userId);
    }

    @Override
    public List<Unlikes> findUnlikeByArticleId(int articleId) {
        return unlikeMapper.findUnlikeByArticleId(articleId);
    }
}
