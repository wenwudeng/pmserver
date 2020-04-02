package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/*回复评论*/
@Data
@NoArgsConstructor
public class ReplyComment {
    private String nickName;
    private String userLogo;
    private int id;
    private int commentId;
    private String content;
    private String CreateDate;
}
