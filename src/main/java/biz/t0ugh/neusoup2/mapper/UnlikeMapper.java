package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.Likes;
import biz.t0ugh.neusoup2.pojo.Unlikes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UnlikeMapper {

    @Select("select * from unlikes where unlike_id = #{unlikeId}")
    public Unlikes getUnike(int unlikeId);

    @Insert("insert into unlikes(unlike_time, user_id, article_id)" +
            "values(#{unlikeTime}, #{userId}, #{articleId})")
    @Options(useGeneratedKeys=true, keyProperty = "unlikeId", keyColumn = "unlike_id")
    public int insertUnlike(Unlikes unlikes);

    @Delete("delete from unlikes where unlike_id = #{unlikeId}")
    public int deleteUnlike(Unlikes unlikes);

    @Select("select * from unlikes where user_id = #{userId}")
    public List<Unlikes> findUnlikeByUserId(int userId);

    @Select("select * from unlikes where article_id = #{articleId}")
    public List<Unlikes> findUnlikeByArticleId(int articleId);
}
