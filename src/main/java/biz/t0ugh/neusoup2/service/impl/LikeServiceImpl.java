package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.ArticleMapper;
import biz.t0ugh.neusoup2.mapper.LikeMapper;
import biz.t0ugh.neusoup2.pojo.Article;
import biz.t0ugh.neusoup2.pojo.Likes;
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
    public Likes getLike(int likeId) {
        return likeMapper.getLike(likeId);
    }

    @Override
    public int insertLike(Likes likes) throws SQLException {
        Article article = articleMapper.getArticle(likes.getArticleId());
        if(article == null){
            throw new SQLException("article[" + likes.getArticleId() +"] not found");
        }
        article.setArticleLike(article.getArticleLike() + 1);
        articleMapper.updateArticle(article);
        return likeMapper.insertLike(likes);
    }

    @Override
    public int deleteLike(Likes likes) throws SQLException {
        Article article = articleMapper.getArticle(likes.getArticleId());
        if(article == null){
            throw new SQLException("article[" + likes.getArticleId() +"] not found");
        }
        article.setArticleLike(article.getArticleLike() - 1);
        articleMapper.updateArticle(article);
        return likeMapper.deleteLike(likes);
    }

    @Override
    public List<Likes> findLikeByUserId(int userId) {
        return likeMapper.findLikeByUserId(userId);
    }

    @Override
    public List<Likes> findLikeByArticleId(int articleId) {
        return likeMapper.findLikeByArticleId(articleId);
    }
}
