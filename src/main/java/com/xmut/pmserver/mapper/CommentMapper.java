package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment values(null,#{comment.userid},#{comment.articleId},#{comment.content}," +
            "#{comment.replayTotal},#{comment.like},#{comment.time},#{comment.status})")
   void add(@Param("comment") Comment comment);

}
