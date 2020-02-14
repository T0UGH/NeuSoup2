package biz.t0ugh.neusoup2.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Comment {
    private int commentId;
    private int articleId;
    private int userId;
    private Timestamp commentTime;
    private int commentRef;
    private String commentContent;

    public Comment() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentRef() {
        return commentRef;
    }

    public void setCommentRef(int commentRef) {
        this.commentRef = commentRef;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
