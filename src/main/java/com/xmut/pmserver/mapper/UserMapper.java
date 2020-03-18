package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /*指定id查询显示个人资料*/
    @Select("select * from user where user_id = #{id}")
    User getInfo(int id);

    /*按号码查询*/
    @Select("select * from user where phone = #{phone} ")
    User loginByPhone(String phone);

    /*注册*/
    @Options(useGeneratedKeys = true, keyProperty = "user.userId",keyColumn = "user_id")
    @Insert("insert into user values (null,null,#{user.phone},#{user.password},null,null,null,null,null,null,null,null)")
    void register(@Param("user") User user);

    /*修改个人资料*/
    @UpdateProvider(type = UserDynaSqlProvider.class,method = "update")
    int editInfo(User user);
}
