package biz.t0ugh.neusoup2.pojo;

import java.sql.Date;

public class Comment {
    private int commentId;
    private int articleId;
    private int userId;
    private Date commentTime;
    private int commentRef;
    private int commentContent;

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

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getCommentRef() {
        return commentRef;
    }

    public void setCommentRef(int commentRef) {
        this.commentRef = commentRef;
    }

    public int getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(int commentContent) {
        this.commentContent = commentContent;
    }
}