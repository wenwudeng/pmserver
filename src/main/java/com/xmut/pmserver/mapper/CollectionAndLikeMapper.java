package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.CollectionLike;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CollectionAndLikeMapper {
    /*赞*/
    @Insert("insert into like_collect values(null,#{articleStatus.userId},#{articleStatus.oId},#{articleStatus.articleId},#{articleStatus.support},1) ")
    int support(@Param("articleStatus") CollectionLike articleStatus);

    /*取消赞*/
    @Update("update like_collect set support = 0 where userId=#{articleStatus.userId} and articleId=#{articleStatus.articleId} and oId =#{articleStatus.oId}")
    int unSupport(@Param("articleStatus") CollectionLike articleStatus );

/*    *//*收藏*//*
    @Insert("insert into like_collect values(null,#{articleStatus.userId},#{articleStatus.oId},#{articleStatus.articleId},1,#{articleStatus.collection})")
    int collection(@Param("articleStatus")CollectionLike articleStatus);*/

    /*取消收藏*/
    @Update("update like_collect set collection = 0 where userId=#{articleStatus.userId} and articleId=#{articleStatus.articleId} and oId = #{articleStatus.oId} ")
    int unCollection(@Param("articleStatus") CollectionLike articleStatus );

    /*指定文章查询id赞和收藏查询*/
    @Select("select count(support) supportCount,count(collection) collectionCount, support,collection \n" +
            "from like_collect  where articleId = #{articleId} GROUP BY support,collection;")
    CollectionLike getLikeCollectionStatus(@Param("articleId") int articleId);

}
