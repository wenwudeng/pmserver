package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.Comment;
import com.xmut.pmserver.pojo.CommentList;

import java.util.List;

public interface CommentService {
    /*评论*/
    int add(Comment comment);

    /*按文章id 查询所有评论*/
    List<Comment> getOneArticleComments(int article_id);

    /*按用户id查询用户的所有评论*/
    List<Comment> getUserAllComment(int user_id);

    /*删除评论*/
    int delete(int id);

    /*查询所有评论、回复评论的评论的信息*/
    CommentList getAllComments();

}
