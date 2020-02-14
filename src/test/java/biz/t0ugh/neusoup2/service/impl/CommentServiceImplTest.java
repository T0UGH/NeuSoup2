package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.pojo.Comment;
import biz.t0ugh.neusoup2.service.CommentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class CommentServiceImplTest extends Neusoup2ApplicationTests {

    Comment comment;

    @Resource
    CommentService commentService;

    @BeforeEach
    void setUp() {
        comment = new Comment();
        comment.setArticleId(1);
        comment.setUserId(1);
        comment.setCommentContent("1111");
        comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
        comment.setCommentRef(8);
    }


    @Test
    void insertCommentAndDeleteComment() {
        try {
            commentService.insertComment(comment);
            Comment dbComment = commentService.getComment(comment.getCommentId());
            assertNotNull(dbComment);

            comment.setCommentContent("2222");
            commentService.updateCommentContent(comment);
            dbComment = commentService.getComment(comment.getCommentId());
            assertEquals("2222", dbComment.getCommentContent());
            comment.setCommentContent("1111");
            commentService.updateCommentContent(comment);

            commentService.deleteComment(comment);
            dbComment = commentService.getComment(comment.getCommentId());
            assertNull(dbComment);
        } catch (SQLException e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    void countCommentByCommentRefAndFindComment() {
        commentService.insertComment(comment);
        Comment dbComment = commentService.getComment(comment.getCommentId());
        assertNotNull(dbComment);

        List<Comment> commentList = commentService.findCommentByCommentRef(comment.getCommentRef());
        assertNotEquals(0, commentList.size());
        assertEquals(comment.getCommentRef(), commentList.get(0).getCommentRef());

        commentList = commentService.findCommentByUserId(comment.getUserId());
        assertNotEquals(0, commentList.size());
        assertEquals(comment.getUserId(), commentList.get(0).getUserId());

        commentList = commentService.findCommentByArticleId((comment.getArticleId()));
        assertNotEquals(0, commentList.size());
        assertEquals(comment.getArticleId(), commentList.get(0).getArticleId());

        commentService.deleteComment(comment);
        dbComment = commentService.getComment(comment.getCommentId());
        assertNull(dbComment);

    }

}