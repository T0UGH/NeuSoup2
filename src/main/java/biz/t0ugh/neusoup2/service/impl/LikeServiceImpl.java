package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.ArticleMapper;
import biz.t0ugh.neusoup2.mapper.LikeMapper;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.pojo.Like;
import biz.t0ugh.neusoup2.service.LikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Resource
    private LikeMapper likeMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Like getLike(int likeId) {
        return likeMapper.getLike(likeId);
    }

    @Override
    public int insertLike(Like like) throws SQLException {
        Article article = articleMapper.getArticle(like.getArticleId());
        if(article == null){
            throw new SQLException("article[" + like.getArticleId() +"] not found");
        }
        article.setArticleLike(article.getArticleLike() + 1);
        articleMapper.updateArticle(article);
        return likeMapper.insertLike(like);
    }

    @Override
    public int deleteLike(Like like) throws SQLException {
        Article article = articleMapper.getArticle(like.getArticleId());
        if(article == null){
            throw new SQLException("article[" + like.getArticleId() +"] not found");
        }
        article.setArticleLike(article.getArticleLike() - 1);
        articleMapper.updateArticle(article);
        return likeMapper.deleteLike(like);
    }

    @Override
    public List<Like> findLikeByUserId(int userId) {
        return likeMapper.findLikeByUserId(userId);
    }

    @Override
    public List<Like> findLikeByArticleId(int articleId) {
        return likeMapper.findLikeByArticleId(articleId);
    }
}
