package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 发帖
     * @param article
     */
    @Insert("insert into article values (null,#{article.userid},#{article.title},#{article.content}," +
            "#{article.img},#{article.location},#{article.like},#{article.collect},#{article.time},#{article.status})")
    int addArticle(@Param("article") Article article);


    /*删*/
    @Delete("delete from article where id = #{id}")
    int deleteById(@Param("id") int id);

    /*按用户id查找所有文章*/
    @Select("select * from article where userid = #{userid}")
    List<Article> findByUserId(@Param("userid") int userid);


    /*指定id查询*/
    @Select("select * from article where id = #{id}")
    Article getOne(@Param("id") int id);


}
