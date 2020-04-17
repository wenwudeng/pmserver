package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.AllFollowSInfo;
import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FollowAndFansMapper {
    /*关注*/
    @Insert("insert into follow values(null,#{follow.userId},#{follow.fId},#{follow.status})")
     int follow(@Param("follow") Follow follow);

 @Delete("delete from follow  where userId = #{follow.userId} and fId = #{follow.fId}")
    int unFollow(@Param("follow") Follow follow);

    @Select("select status from follow where userId = #{userId} and fId = #{fId}")
    Object isFollow(@Param("userId")int userId,@Param("fId") int fId);

    @Select("select count(id) from follow where userId = #{userId} and fId <> 0 and status = 1")
    int getFollowCount(int userId);

    @Select("select u.id,u.user_name userName,u.photo ,f.status from user u,follow f where u.id = f.fId and f.userId = #{userId} and f.status = 1;")
    List<AllFollowSInfo> getAllFollowInfo(int userId);

    /*粉丝*/
    @Insert("insert into fans values(null,#{fans.userId},#{fans.fId},#{fans.status})")
    int fans(@Param("fans") Fans fans);

    @Delete("delete from fans  where userId = #{fans.userId} and fId = #{fans.fId}")
    int unFans(@Param("fans")Fans fans);

    @Select("select status from fans where userId = #{userId} and fId = #{fId}")
    Object isFans(@Param("userId")int userId,@Param("fId") int fId);

    @Select("select count(id) from fans where userId = #{userId} and status = 1")
    int getFansCount(int userId);
/*
    @Select("select u.id,u.user_name userName,u.photo ,f.status from user u,follow f where u.id = f.id and f.status = 1;")
    List<AllFollowSInfo> getAllFollowInfo();*/

}
