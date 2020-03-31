package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Article {

  private int id;
  private int userid;
  private String title;
  private String content;
  private String img;
  private int like;
  private int collect;
  private String time;
  private boolean status;
  private String location;


  public Article(int userid, String title, String content, String img, int like, int collect, String time, boolean status, String location) {
    this.userid = userid;
    this.title = title;
    this.content = content;
    this.img = img;
    this.like = like;
    this.collect = collect;
    this.time = time;
    this.status = status;
    this.location = location;
  }
}
