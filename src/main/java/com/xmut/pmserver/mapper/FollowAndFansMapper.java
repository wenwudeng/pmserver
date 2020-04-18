package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.AllFollowSInfo;
import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FollowAndFansMapper {
    /*关注/粉丝*/
    @Insert("insert into follow values(null,#{follow.userId},#{follow.fId},#{follow.status})")
     int follow(@Param("follow") Follow follow);

    /*取关/取粉*/
 @Delete("delete from follow  where userId = #{follow.userId} and fId = #{follow.fId}")
    int unFollow(@Param("follow") Follow follow);

   /*判断是否关注*/
    @Select("select status from follow where userId = #{userId} and fId = #{fId}")
    Object isFollow(@Param("userId")int userId,@Param("fId") int fId);


    /*关注数量*/
    @Select("select count(id) from follow where userId = #{userId} and fId <> 0 and status = 1")
    int getFollowCount(int userId);

   /*关注用户的信息*/
    @Select("select u.id,u.user_name userName,u.photo ,f.status from user u,follow f where u.id = f.fId and f.userId = #{userId} and f.status = 1;")
    List<AllFollowSInfo> getAllFollowInfo(int userId);


   /*粉丝的信息*/
   @Select("select u.id,u.user_name userName,u.photo ,f.status from user u,follow f where u.id = f.userId and f.fId = #{fId} and f.status = 1;")
   List<AllFollowSInfo> getAllFansInfo(int fId);

   /*粉丝数量*/
   @Select("select count(userId) from follow where fId = #{fId} and status = 1;")
   int getFansCount(int fId);



   /*
    */
/*粉丝*//*

    @Insert("insert into fans values(null,#{fans.userId},#{fans.fId},#{fans.status})")
    int fans(@Param("fans") Fans fans);

    @Delete("delete from fans  where userId = #{fans.userId} and fId = #{fans.fId}")
    int unFans(@Param("fans")Fans fans);

    @Select("select status from fans where userId = #{userId} and fId = #{fId}")
    Object isFans(@Param("userId")int userId,@Param("fId") int fId);
*/


/*
    @Select("select u.id,u.user_name userName,u.photo ,f.status from user u,follow f where u.id = f.id and f.status = 1;")
    List<AllFollowSInfo> getAllFollowInfo();*/

}
