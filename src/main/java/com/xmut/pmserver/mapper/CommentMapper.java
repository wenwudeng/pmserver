package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.Comment;
import com.xmut.pmserver.pojo.CommentItem;
import com.xmut.pmserver.pojo.ReplyComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment values(null,#{comment.userid},#{comment.articleId},#{comment.content}," +
            "#{comment.replyTotal},#{comment.like},#{comment.time},#{comment.status})")
   int add(@Param("comment") Comment comment);

    @Select("select * from comment where articleId = #{articleId}")
    List<Comment> getOneArticleComments(@Param("articleId") int articleId);

    @Select("select * from comment where userid = #{userid}")
    List<Comment> getUserAllComment(@Param("userid") int userid);

    @Delete("delete from comment where id = #{id}")
    int deleteById(@Param("id") int id);




 /*   select u.id,u.user_name nickName,u.photo userLogo,
    c.content,c.replyTotal,c.time createDate
    from user u,comment c
    where u.id = c.id;*/

    /**
     * 查找所有评论者的信息
     * @return 返回评论着头像，昵称，评论内容，回复评论数
     */
    @Select("select u.id,u.user_name nickName,u.photo userLogo,\n" +
            "    c.content,c.replyTotal,c.time createDate\n" +
            "    from user u,comment c\n" +
            "    where u.id = c.userid")
   List<CommentItem> getComments();

    /*select u.user_name nickName,u.photo userLogo,
			 r.id,r.commentId,r.content,r.time createDate
			 from user u,replycomment r
					 where u.id = r.userid;		*/

 /**
  * 查找所有回复评论用户的信息

  * @return
  */
 @Select("select u.user_name nickName,u.photo userLogo,u.id\n" +
            ",r.commentId,r.content,r.time createDate\n" +
            "from user u,replycomment r \n" +
            "where u.id = r.userid ")
    List<ReplyComment> getReplyComments();

}
