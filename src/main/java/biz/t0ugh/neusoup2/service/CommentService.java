package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    public Comment getComment(int commentId);
    public int insertComment(Comment comment);
    public int updateCommentContent(Comment comment) throws SQLException;
    public int deleteComment(Comment comment);
    public int countCommentByCommentRef(int commentRef);
    public List<Comment> findCommentByCommentRef(int commentRef);
    public List<Comment> findCommentByUserId(int userId);
    public List<Comment> findCommentByArticleId(int articleId);
}
