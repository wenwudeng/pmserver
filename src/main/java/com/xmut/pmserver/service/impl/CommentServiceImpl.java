package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.CommentMapper;
import com.xmut.pmserver.pojo.Comment;
import com.xmut.pmserver.pojo.CommentItem;
import com.xmut.pmserver.pojo.CommentList;
import com.xmut.pmserver.pojo.ReplyComment;
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
    public CommentList getAllComments() {
        CommentList list = new CommentList();
        //list.setTotal(commentMapper.TotalComment(article_id));
        List<CommentItem> itemList = new ArrayList<>();
        //评论集合
        List<CommentItem> commentItemList = commentMapper.getComments();
        //回复评论集合
        List<ReplyComment> replyCommentList = commentMapper.getReplyComments();
        for (CommentItem item : commentItemList) {
            item.setReplyList(replyCommentList);
            itemList.add(item);
        }
        list.setList(itemList);
        return list;
    }
}
