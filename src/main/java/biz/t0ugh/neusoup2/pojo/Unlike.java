package biz.t0ugh.neusoup2.pojo;

import java.sql.Timestamp;

public class Unlike {
    private int unlikeId;
    private Timestamp unlikeDate;
    private int userId;
    private int articleId;

    public Unlike() {
    }

    public int getUnlikeId() {
        return unlikeId;
    }

    public void setUnlikeId(int unlikeId) {
        this.unlikeId = unlikeId;
    }

    public Timestamp getUnlikeDate() {
        return unlikeDate;
    }

    public void setUnlikeDate(Timestamp unlikeDate) {
        this.unlikeDate = unlikeDate;
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
