package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowArticle {

   private int articleId;
   private int userId;
   private String userName;
   private String userPhoto;
   private String title;
   private String content;
   private String img;
   private String location;
   private int like;
   private int collect;
}
