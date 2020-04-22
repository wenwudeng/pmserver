package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /*指定id查询显示个人资料*/
    @Select("select id,user_name,photo,gender,city,time,profile,pet from user where id = #{id}")
    User getInfoById(int id);

    /*指定号码查询*/
    @Select("select id,user_name,photo,gender,city,time,profile,pet from user where  phone = #{phone}")
    User getInfoByPhone(@Param("phone") String phone);

    /*登录*/

    @Select("select * from user where phone = #{phone} ")
    User loginByPhone(String phone);

    /*注册*/
    @Options(useGeneratedKeys = true, keyProperty = "user.id",keyColumn = "id")
    @Insert("insert into user values (null,#{user.userName},#{user.phone},#{user.password}," +
            "#{user.photo},#{user.gender},#{user.city},#{user.profile},#{user.pet},#{user.time},1)")
    void register(@Param("user") User user);

    /*修改个人资料*/
    @UpdateProvider(type = UserDynaSqlProvider.class,method = "update")
    int editInfo(User user);
}
