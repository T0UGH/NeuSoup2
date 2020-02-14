package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.CommentMapper;
import biz.t0ugh.neusoup2.pojo.Comment;
import biz.t0ugh.neusoup2.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Comment getComment(int commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int updateCommentContent(Comment comment) throws SQLException {
        Comment dbComment = commentMapper.getComment(comment.getCommentId());
        if(dbComment == null){
            throw new SQLException("comment [" + comment.getCommentId() +"] not found");
        }
        dbComment.setCommentContent(comment.getCommentContent());
        commentMapper.updateComment(dbComment);
        return 0;
    }

    @Override
    public int deleteComment(Comment comment) {
        return commentMapper.deleteComment(comment);
    }

    @Override
    public int countCommentByCommentRef(int commentRef) {
        return commentMapper.countCommentByCommentRef(commentRef);
    }

    @Override
    public List<Comment> findCommentByCommentRef(int commentRef) {
        return commentMapper.findCommentByCommentRef(commentRef);
    }

    @Override
    public List<Comment> findCommentByUserId(int userId) {
        return commentMapper.findCommentByUserId(userId);
    }

    @Override
    public List<Comment> findCommentByArticleId(int articleId) {
        return commentMapper.findCommentByArticleId(articleId);
    }
}
