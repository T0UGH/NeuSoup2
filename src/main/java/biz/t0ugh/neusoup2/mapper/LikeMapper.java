package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LikeMapper {

    @Select("select * from like where like_id = #{likeId}")
    public Like getLike(int likeId);

    @Insert("insert into like(like_time, user_id, article_id)" +
            "values(#{likeTime}, #{userId}, #{articleId})")
    public int insertLike(Like like);

    @Delete("delete from like where like_id = #{likeId}")
    public int deleteLike(Like like);

    @Select("select * from like where user_id = #{userId}")
    public List<Like> findLikeByUserId(int userId);

    @Select("select * from like where article_id = #{articleId}")
    public List<Like> findLikeByArticleId(int articleId);
}
