package biz.t0ugh.neusoup2.pojo;

import java.sql.Timestamp;

public class Article {
    private int articleId;
    private int userId;
    private Timestamp articleTime;
    private String articleContent;
    private int articleLike;
    private int articleUnlike;
    private String articleTags;

    public Article() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(int articleLike) {
        this.articleLike = articleLike;
    }

    public int getArticleUnlike() {
        return articleUnlike;
    }

    public void setArticleUnlike(int articleUnlike) {
        this.articleUnlike = articleUnlike;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }
}
