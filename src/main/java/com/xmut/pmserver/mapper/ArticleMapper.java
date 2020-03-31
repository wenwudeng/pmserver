package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /*按用户id查找所有文章文章*/
    @Select("select * from article where userid = #{userid}")
    List<Article> findByuserId(@Param("userid") int userid);


}
