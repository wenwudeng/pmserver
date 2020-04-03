package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentItem {
    private int id;
    private String nickName;
    private String userLogo;
    private String content;
    private String imgId;
    private String replyTotal;
    private String createDate;

    private List<ReplyItem> replyList;
}
