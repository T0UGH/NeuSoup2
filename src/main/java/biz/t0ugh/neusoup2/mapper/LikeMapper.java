package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.Likes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LikeMapper {

    @Select("select * from likes where like_id = #{likeId}")
    public Likes getLike(int likeId);

    @Insert("insert into likes(like_time, user_id, article_id)" +
            "values(#{likeTime}, #{userId}, #{articleId})")
    @Options(useGeneratedKeys=true, keyProperty = "likeId", keyColumn = "like_id")
    public int insertLike(Likes likes);

    @Delete("delete from likes where like_id = #{likeId}")
    public int deleteLike(Likes likes);

    @Select("select * from likes where user_id = #{userId}")
    public List<Likes> findLikeByUserId(int userId);

    @Select("select * from likes where article_id = #{articleId}")
    public List<Likes> findLikeByArticleId(int articleId);
}
