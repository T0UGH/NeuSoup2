package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.Likes;

import java.sql.SQLException;
import java.util.List;

public interface LikeService {
    public Likes getLike(int likeId);
    public int insertLike(Likes likes) throws SQLException;
    public int deleteLike(Likes likes) throws SQLException;
    public List<Likes> findLikeByUserId(int userId);
    public List<Likes> findLikeByArticleId(int articleId);
}
