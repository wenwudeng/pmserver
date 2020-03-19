package com.xmut.pmserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private int userId;
  private String city;
  private String gender;
  private String photo;
  private String password;
  private String phone;
  private String userName;
  private int follow;
  private Date time;
  private int collectLike;
  private int fans;
  private String profile;
  private String pet;

  public User(int userId, String city, String gender, String photo, String userName, String profile,String pet) {
    this.userId = userId;
    this.city = city;
    this.gender = gender;
    this.photo = photo;
    this.userName = userName;
    this.pet = pet;
    this.profile = profile;
  }


  @Override
  public String toString() {
    return "User{" +
            "city='" + city + '\'' +
            ", gender='" + gender + '\'' +
            ", photo='" + photo + '\'' +
            ", userName='" + userName + '\'' +
            ", follow=" + follow +
            ", time=" + time +
            ", collectLike=" + collectLike +
            ", fans=" + fans +
            ", profile='" + profile + '\'' +
            ", pet='" + pet + '\'' +
            '}';
  }
}
