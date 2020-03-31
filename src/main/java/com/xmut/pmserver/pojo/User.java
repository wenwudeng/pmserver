package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class User {


  private int userid;
  private String city;
  private String gender;
  private String photo;
  private String password;
  private String phone;
  private String userName;
  private int follow;
  private String time;
  private int collect;
  private int fans;
  private String profile;
  private String pet;
  private boolean status;

  private List<Article> articleList;


  public User(int userid, String city, String gender, String photo, String userName, String profile,String pet) {
    this.userid = userid;
    this.city = city;
    this.gender = gender;
    this.photo = photo;
    this.userName = userName;
    this.pet = pet;
    this.profile = profile;
  }

}
