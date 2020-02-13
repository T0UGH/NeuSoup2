package biz.t0ugh.neusoup2.mapper;

import biz.t0ugh.neusoup2.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_id = #{userId}")
    User getUser(int userId);

    @Insert("insert into user(user_name, user_password, user_avator, user_sex, user_note) " +
            "value(#{userName}, #{userPassword}, #{userAvator}, #{userSex}, #{userNote}")
    int insertUser(User user);

    @Delete("delete from user where user_id = #{userId}")
    int deleteUser(User user);

    @Update("update user set" +
            "user_name = #{userName}" +
            "user_password = #{userPassword}" +
            "user_avator = #{userAvator}" +
            "user_sex = #{userSex}" +
            "user_note = #{userNote}" +
            "where user_id = #{userId}")
    int updateUser(User user);
}
