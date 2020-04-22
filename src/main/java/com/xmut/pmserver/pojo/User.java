package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class User {


  private int id;
  private String city;
  private String gender;
  private String photo;
  private String password;
  private String phone;
  private String userName;
  private String time;
  private String profile;
  private String pet;
  private boolean status;

  //private List<Article> articleList;


  public User(int id, String city, String gender, String photo, String userName, String profile,String pet) {
    this.id = id;
    this.city = city;
    this.gender = gender;
    this.photo = photo;
    this.userName = userName;
    this.pet = pet;
    this.profile = profile;
  }

  public User(int id, String city, String gender, String photo,  String userName, String profile, String pet, boolean status) {
    this.id = id;
    this.city = city;
    this.gender = gender;
    this.photo = photo;
    this.userName = userName;
    this.time = time;
    this.profile = profile;
    this.pet = pet;
    this.status = status;
  }
}
