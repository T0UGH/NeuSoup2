package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from article where article_id = #{articleId}")
    public Article getArticle(int articleId);

    @Insert("insert into article(user_id, article_time, article_content, article_like, article_unlike, article_tags) " +
            "value(#{userId}, #{articleTime}, #{articleContent}, #{articleLike}, #{articleUnlike}, #{articleTags})")
    @Options(useGeneratedKeys=true, keyProperty = "articleId", keyColumn = "article_id")
    public int insertArticle(Article article);


    @Update("update article set " +
            "user_id = #{userId}," +
            "article_time = #{articleTime}," +
            "article_content = #{articleContent}," +
            "article_like = #{articleLike}," +
            "article_unlike = #{articleUnlike}," +
            "article_tags = #{articleTags}" +
            "where article_id = #{articleId}")
    public int updateArticle(Article article);

    @Delete("delete from article where article_id = #{articleId}")
    public int deleteArticle(Article article);

    @Select("select * from article order by article_like desc")
    public List<Article> rankArticleByLike();

    @Select("select * from article order by article_time desc")
    public List<Article> rankArticleByTime();
}
