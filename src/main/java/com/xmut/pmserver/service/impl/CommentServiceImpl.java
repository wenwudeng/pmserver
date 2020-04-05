package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.CommentMapper;
import com.xmut.pmserver.pojo.*;
import com.xmut.pmserver.service.CommentService;
import com.xmut.pmserver.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    CommentMapper commentMapper;

    /*评论*/
    @Override
    public int add(Comment comment) {
        comment.setLike(0);
        comment.setReplyTotal(0);
        comment.setStatus(true);
        comment.setTime(Utils.getDate());
      return commentMapper.add(comment);
    }

    /*回复评论*/
    @Override
    public int addReply(Replycomment replycomment) {
        replycomment.setTime(Utils.getDate());
        replycomment.setStatus(true);
        return commentMapper.addReply(replycomment);
    }
    /*根据文章id返回一篇文章的所有评论信息*/
    @Override
    public List<Comment> getOneArticleComments(int articleId) {

        return commentMapper.getOneArticleComments(articleId);
    }

    /**/
    @Override
    public List<Comment> getUserAllComment(int user_id) {

        return commentMapper.getUserAllComment(user_id);
    }

    @Override
    public int delete(int id) {
        if (commentMapper.deleteById(id) == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public CommentList getAllComments(int articleId) {
        CommentList list = new CommentList();

        List<CommentItem> itemList = new ArrayList<>();

        //评论集合
        List<CommentItem> commentItemList = commentMapper.getComments(articleId);
        //回复评论集合
        List<ReplyItem> replyItemList = commentMapper.getReplyComments();

        //for循环遍历
        for (CommentItem item : commentItemList) {
            List<ReplyItem> replyItems = new ArrayList<>();
            for (ReplyItem reply : replyItemList) {
                if (item.getId() == reply.getCommentId()) {
                    replyItems.add(reply);
                }

            }
            item.setReplyList(replyItems);
            itemList.add(item);
        }
        list.setList(itemList);
        list.setTotal(commentItemList.size());
        return list;
    }

    @Override
    public List<GetCommentArticle> getCommentAndArticle(int userid) {
        return commentMapper.getCommentAndArticle(userid);
    }
}
