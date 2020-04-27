package com.xmut.pmserver.contorller;

import com.xmut.pmserver.pojo.Comment;
import com.xmut.pmserver.pojo.Replycomment;
import com.xmut.pmserver.wrapper.ResponseWrapper;
import com.xmut.pmserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /*评论*/
    @RequestMapping("/add")
    public ResponseWrapper add(@RequestParam int userid, @RequestParam int articleId, @RequestParam String content) {
        return ResponseWrapper.markCustom(true, "3009", "评论成功", commentService.add(new Comment(userid, articleId, content)));
    }

    /*回复评论*/
    @RequestMapping("/reply")
    public ResponseWrapper reply(@RequestParam int userid, @RequestParam int commentId, @RequestParam String content) {
        return ResponseWrapper.markCustom(true, "3009", "回复评论成功", commentService.addReply(new Replycomment(userid, commentId, content)));
    }

    /*指定文章id获取所有评论*/
    @RequestMapping("/articleId")
    public ResponseWrapper getOneArticleComments(@RequestParam int articleId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", commentService.getOneArticleComments(articleId));
    }

    /*根据用户id查询用户的所有评论*/
    @RequestMapping("/userId")
    public ResponseWrapper getUserAllComments(@RequestParam int userid) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", commentService.getOneArticleComments(userid));
    }

    /*删除评论*/
    @RequestMapping("/delete")
    public ResponseWrapper delete(@RequestParam int id) {
        if (commentService.delete(id) != 1)
            return ResponseWrapper.markCustom(true, "3008", "无此条评论", null);
        return ResponseWrapper.markCustom(true, "3008", "删除成功", null);
    }

    /*获取所有一级评论二级评论*/
    @RequestMapping("/getAll")
    public ResponseWrapper getAllComments(@RequestParam(required = true) int articleId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", commentService.getAllComments(articleId));
    }

    /*指定用户id查询所有评论及评论文章的内容*/
    @RequestMapping("/getCommentsArt")
    public ResponseWrapper getCommentsAndArticles(@RequestParam int userid) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", commentService.getCommentAndArticle(userid));
    }
}
