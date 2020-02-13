package biz.t0ugh.neusoup2.pojo;

import java.sql.Timestamp;

public class Unlikes {
    private int unlikeId;
    private Timestamp unlikeTime;
    private int userId;
    private int articleId;

    public Unlikes() {
    }

    public int getUnlikeId() {
        return unlikeId;
    }

    public void setUnlikeId(int unlikeId) {
        this.unlikeId = unlikeId;
    }

    public Timestamp getUnlikeTime() {
        return unlikeTime;
    }

    public void setUnlikeTime(Timestamp unlikeTime) {
        this.unlikeTime = unlikeTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
