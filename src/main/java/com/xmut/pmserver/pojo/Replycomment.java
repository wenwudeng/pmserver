package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Replycomment {
  private int id;
  private int userid;
  private int commentId;
  private String content;
  private String time;
  private boolean status;


  public Replycomment(int userid, int commentId, String content) {
    this.userid = userid;
    this.commentId = commentId;
    this.content = content;
  }
}
