package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.ShowArticle;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.pojo.BackendComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface AdminMapper {
    /*======用户管理=====*/
    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where user_name like '%${value}%'")
    List<User> unclearSearch(String value);

    @Update("update user set password = #{password} where phone = #{name}")
    int reset( String password,String name);

    @Update("update user status = #{stats} where id= #{id}")
    int stopUser(boolean status, int id);

    /*文章管理*/
    /*查询所有文章及作者信息*/
    @Select("select a.id articleId,u.user_name userName,a.title,a.content,a.img,a.like,a.collect,a.time,a.status " +
            "from user u inner join article a on u.id = a.userid " +
            "where title like '%${title}%' and user_name like '%${name}%'" )
    List<ShowArticle> getArticles(String title,String name);


    /*评论*/
    @Select("select c.id,a.title,u.user_name username,c.content,c.time ,c.status\n" +
            "\t\t\t\t\t\t\t\tfrom comment c \n" +
            "\t\t\t\t\t\t\t\tleft join user u on c.userid = u.id\n" +
            "\t\t\t\t\t\t\t\tleft join article a on c.articleId=a.id\n" +
            "\t\t\t\t\t\t\t\twhere u.user_name like '%${name}%' " +
            "and a.title like  '%${title}%'" +
            "and c.content like  '%${content}%'")
    List<BackendComment> getComments(String name, String title, String content);

}
