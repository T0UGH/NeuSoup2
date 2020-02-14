package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comment where comment_id = #{commentId}")
    public Comment getComment(int commentId);

    @Insert("insert into comment(article_id, user_id, comment_time, comment_ref, comment_content)" +
            "values(#{articleId}, #{userId}, #{commentTime}, #{commentRef}, #{commentContent})")
    @Options(useGeneratedKeys = true, keyProperty = "commentId", keyColumn = "comment_id")
    public int insertComment(Comment comment);

    @Update("update comment set " +
            "comment_content = #{commentContent}, " +
            "user_id = #{userId}, " +
            "article_id = #{articleId}, " +
            "comment_time = #{commentTime}, " +
            "comment_ref = #{commentRef} " +
            "where comment_id = #{commentId}")
    public int updateComment(Comment comment);

    @Delete("delete from comment where comment_id = #{commentId}")
    public int deleteComment(Comment comment);

    @Select("select * from comment where user_id = #{userId}")
    public List<Comment> findCommentByUserId(int userId);

    @Select("select * from comment where article_id = #{articleId}")
    public List<Comment> findCommentByArticleId(int articleId);

    @Select("select * from comment where comment_ref = #{commentRef}")
    public List<Comment> findCommentByCommentRef(int commentRef);

    @Select("select count(*) from comment where comment_ref = #{commentRef}")
    public int countCommentByCommentRef(int commentRef);
}
