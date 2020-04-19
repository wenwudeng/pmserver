package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*用户的收藏列表*/
@Data
@NoArgsConstructor
@ToString
public class UserCollections {
    private int authorId;
    private String authorName;
    private String authorPhoto;
    private int aId;
    private String title;
    private String content;
    private String img;
    private int like;
    private int comment;
}
