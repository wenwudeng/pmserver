package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/*宠友互助JSON*/
public class QuestionHelp {
    private  int qId;
    private int uId;
    private String title;
    private String content;
    private String img;
    private String location;
    private int like;
    private int answer;
    private String time;
    private String photo;
    private String userNam;
}
