package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.Comment;
import com.xmut.pmserver.pojo.CommentList;
import com.xmut.pmserver.pojo.GetCommentArticle;
import com.xmut.pmserver.pojo.Replycomment;

import java.util.List;

public interface CommentService {
    /*评论*/
    int add(Comment comment);

    /*回复评论*/
    int addReply(Replycomment replycomment);

    /*按文章id 查询所有评论*/
    List<Comment> getOneArticleComments(int article_id);

    /*按用户id查询用户的所有评论*/
    List<Comment> getUserAllComment(int user_id);

    /*删除评论*/
    int delete(int id);

    /*查询所有评论、回复评论的评论的信息*/
    CommentList getAllComments(int articleId);

    /*指定用户id获取所有评及评论文章内容*/
    List<GetCommentArticle> getCommentAndArticle(int userid);
}
