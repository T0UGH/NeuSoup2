package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.Unlikes;

import java.sql.SQLException;
import java.util.List;

public interface UnlikeService {
    public Unlikes getUnlike(int unlikeId);
    public int insertUnlike(Unlikes unlikes) throws SQLException;
    public int deleteUnlike(Unlikes unlikes) throws SQLException;
    public List<Unlikes> findUnlikeByUserId(int userId);
    public List<Unlikes> findUnlikeByArticleId(int articleId);

}
