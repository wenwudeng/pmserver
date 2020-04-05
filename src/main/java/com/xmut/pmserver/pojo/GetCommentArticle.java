package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCommentArticle {
    private String cContent;
    private int cLike;
    private int aid;
    private String title;
    private String content;
    private String img;
    private String location;
    private int aLike;
    private int collect;
    private String cTime;
}
