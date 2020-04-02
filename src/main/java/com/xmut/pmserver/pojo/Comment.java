package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {

  private int id;
  private int userid;
  private int articleId;
  private String content;
  private int replyTotal;
  private int like;
  private String time;
  private boolean status;

  public Comment(int userid, int articleId, String content) {
    this.userid = userid;
    this.articleId = articleId;
    this.content = content;
  }
}
