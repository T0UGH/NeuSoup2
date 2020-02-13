package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.Like;

import java.sql.SQLException;
import java.util.List;

public interface LikeService {
    public Like getLike(int likeId);
    public int insertLike(Like like) throws SQLException;
    public int deleteLike(Like like) throws SQLException;
    public List<Like> findLikeByUserId(int userId);
    public List<Like> findLikeByArticleId(int articleId);
}
