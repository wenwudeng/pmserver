package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.BeSupportInfo;
import com.xmut.pmserver.pojo.CollectionLike;
import com.xmut.pmserver.pojo.UserCollections;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionAndLikeMapper {
    /*插入赞*/
    @Insert("insert into like_collect values(null,#{articleStatus.userId},#{articleStatus.oId},#{articleStatus.articleId},#{articleStatus.support},1) ")
    int support(@Param("articleStatus") CollectionLike articleStatus);

    /*取消赞*/
    @Update("update like_collect set support = 0 where userId=#{articleStatus.userId} and articleId=#{articleStatus.articleId} and oId =#{articleStatus.oId}")
    int unSupport(@Param("articleStatus") CollectionLike articleStatus);


    /*取消收藏*/
    @Update("update like_collect set collection = 0 where userId=#{articleStatus.userId} and articleId=#{articleStatus.articleId} and oId = #{articleStatus.oId} ")
    int unCollection(@Param("articleStatus") CollectionLike articleStatus);

    /*指定文章查询id赞和收藏查询*/
    @Select("select count(support) supportCount,count(collection) collectionCount, support,collection \n" +
            "from like_collect  where articleId = #{articleId} GROUP BY support,collection;")
    CollectionLike getLikeCollectionStatus(@Param("articleId") int articleId);


    /*指定用户id获取获赞数*/
    @Select("select count(support) from like_collect where oId=#{oId} and support = 1;")
    int getCollectionByUserId(int oId);


    /*查询获赞列表及文章信息*/
    @Select("select u.id sId,u.photo sPhoto,u.user_name sName,a.id aId,a.userId auId,a.title,a.content,a.img \n" +
            "\t\tfrom user u,article a,like_collect l\n" +
            "\t\twhere l.oId=1 and l.userId =u.id\tand l.articleId = a.id and l.support = 1;\n")
    List<BeSupportInfo> getBeSupportInfo(int oId);

    /*指定用户id查询当前用户收藏的文章列表信息*/
    @Select("select u.id authorId,u.user_name authorName,u.photo authorPhoto,a.id aId,a.title,a.content,a.img ,a.like,a.collect comment\n" +
            "from user u,article a,like_collect l \n" +
            "where l.userId = #{userId} and l.oId = u.id and  l.articleId = a.id and l.collection = 1;")
    List<UserCollections> getUserCollections(int userId);

}
