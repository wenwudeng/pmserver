package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Question {

  private int id;
  private int userid;
  private String title;
  private String content;
  private String img;
  private String location;
  private int like;
  private int collect;
  private int answer;
  private String time;
  private boolean status;

  private List<Question> questions;


  public Question(int userid, String title, String content, String img,
                  int like, int collect,int answer, String time, boolean status,String location) {
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
